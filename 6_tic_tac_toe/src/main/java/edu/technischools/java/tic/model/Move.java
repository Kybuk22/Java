/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.tic.model;

public class Move {

  private Mark mark;

  private int row;

  private int column;


  public Move(Mark mark, int row, int column) {
    this.mark = mark;
    this.row = row;
    this.column = column;
  }

  public Mark getMark() {
    return mark;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }
}
