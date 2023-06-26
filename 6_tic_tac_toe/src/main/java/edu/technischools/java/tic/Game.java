/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.tic;

import java.util.ArrayList;
import java.util.List;

import edu.technischools.java.tic.exception.CoordinatesOutOfBoundsException;
import edu.technischools.java.tic.exception.OpponentTurnsException;
import edu.technischools.java.tic.exception.SpotAlreadyTakenException;
import edu.technischools.java.tic.model.Board;
import edu.technischools.java.tic.model.Mark;
import edu.technischools.java.tic.model.Move;

public class Game implements TicTacToe {

  private Board board;
  private Mark currentPlayer;
  private List<Move> moves;

  public Game() {
  }

  public Game(List<Move> moves) {
    this.moves = moves;
  }

  @Override
  public void startGame(int boardSize) {
    this.board = new Board(boardSize);
    this.currentPlayer = Mark.X;
    this.moves=new ArrayList<>();

  }

  @Override
  public void placeMark(Mark mark, int row, int column) throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
    if (mark != currentPlayer) {
      throw new OpponentTurnsException();
    }
    if (row < 0 || row >= board.getSize() || column < 0 || column >= board.getSize()) {
      throw new CoordinatesOutOfBoundsException();
    }
    if (!board.isSpotEmpty(row, column)) {
      throw new SpotAlreadyTakenException();
    }
    board.setSpot(row, column, mark);
    moves.add(new Move(mark, row, column));
    currentPlayer = currentPlayer == Mark.X ? Mark.O : Mark.X;
  }

 @Override
  public Mark checkWinner() {
    Mark winner = null;
    for (int i = 0; i < board.getSize(); i++) {
      if (board.isRowFilledWithMark(i, Mark.X)) {
        winner = Mark.X;
        break;
      }
      if (board.isRowFilledWithMark(i, Mark.O)) {
        winner = Mark.O;
        break;
      }
      if (board.isColumnFilledWithMark(i, Mark.X)) {
        winner = Mark.X;
        break;
      }
      if (board.isColumnFilledWithMark(i, Mark.O)) {
        winner = Mark.O;
        break;
      }
    }
    if (winner == null && board.isDiagonalFilledWithMark(Mark.X)) {
      winner = Mark.X;
    }
    if (winner == null && board.isDiagonalFilledWithMark(Mark.O)) {
      winner = Mark.O;
    }
    return winner;
  }

  @Override
  public boolean isBoardFull() {
    return board.isFull();
  }

  @Override
  public boolean isBoardEmpty() {
    return board.isEmpty();
  }

  @Override
  public Mark whoIsNext() {
    return currentPlayer;
  }

  public Board getBoard() {
    return board;
  }

  public List<Move> getMoves() {
    return moves;
  }
}
