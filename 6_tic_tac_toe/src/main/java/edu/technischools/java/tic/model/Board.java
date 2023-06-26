/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.tic.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

  private int size;
  private Mark marks[][];

  public Board(int size) {
    this.size = size;
    marks = new Mark[this.size][this.size];
  }

  public String show() {
    StringBuilder board = new StringBuilder();

    for (int i = 0; i < marks.length; i++) {
      String placeholder = i == marks.length - 1 ? " " : "_";
      board.append(Arrays.stream(marks[i]).map((Mark m) -> m != null ? m.name() : placeholder).collect(Collectors.joining("|"))).append("\n");
    }

    return board.toString();
  }

  public int getSize() {
    return size;
  }

  public boolean isSpotEmpty(int row, int column) {
    return marks[row][column] == null;
  }

  public void setSpot(int row, int column, Mark mark) {
    marks[row][column] = mark;
  }

  public boolean isRowFilledWithMark(int row, Mark mark) {
    for (int col = 0; col < size; col++) {
      if (marks[row][col] != mark) {
        return false;
      }
    }
    return true;
  }

  public boolean isColumnFilledWithMark(int col, Mark mark) {
    for (int row = 0; row < size; row++) {
      if (marks[row][col] != mark) {
        return false;
      }
    }
    return true;
  }

  public boolean isDiagonalFilledWithMark(Mark mark) {
    boolean leftToRight = true, rightToLeft = true;
    for (int i = 0; i < size; i++) {
      if (marks[i][i] != mark) {
        leftToRight = false;
      }
      if (marks[i][size - 1 - i] != mark) {
        rightToLeft = false;
      }
    }
    return leftToRight || rightToLeft;
  }

  public boolean isFull() {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (marks[row][col] == null) {
          return false;
        }
      }
    }
    return true;
  }
  public Mark getSpot(int row, int column) {
    if (row < 0 || row >= size || column < 0 || column >= size) {
        throw new IllegalArgumentException("Invalid row or column");
    }
    return marks[row][column];
}
  public boolean isEmpty() {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (marks[row][col] != null) {
          return false;
        }
      }
    }
    return true;
  }

}
