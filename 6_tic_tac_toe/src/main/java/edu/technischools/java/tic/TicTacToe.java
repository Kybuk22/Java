/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.tic;

import edu.technischools.java.tic.exception.CoordinatesOutOfBoundsException;
import edu.technischools.java.tic.exception.OpponentTurnsException;
import edu.technischools.java.tic.exception.SpotAlreadyTakenException;
import edu.technischools.java.tic.model.Mark;

public interface TicTacToe {

  /**
   * Starts a game, creates a new <code>Board</code> with the given size
   * @param boardSize - the size of a board
   */
  void startGame(int boardSize);

  /**
   * Places a new mark on the board in the given coordinates and adds it to the list of past moves
   *
   * @param mark - a <code>Mark</code> to be placed on the board
   * @param row - y coordinate
   * @param column - x coordinate
   * @throws CoordinatesOutOfBoundsException - when <code>row</code or <code>column</code> aut of the board bounds
   * @throws SpotAlreadyTakenException - when the given spot is already taken
   * @throws OpponentTurnsException - when the same mark is being placed two times in a row;
   */
  void placeMark(Mark mark, int row, int column) throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException;

  /**
   * Checks the board for a winner.
   * 
   * @return <code>Mark.X</code> when X wins, <code>Mark.O</code> when O wins, <code>null</code> when draw
   */
  Mark checkWinner();

  /**
   *  Checks if the board is full and another move cannot be make. 
   *  
   * @return <code>true</code> when full, <code>false</code> otherwise
   */
  boolean isBoardFull();

  /**
   * Checks if the board is empty
   * 
   * @return <code>true</code> when empty, <code>false</code> otherwise
   */
  boolean isBoardEmpty();

  /**
   *  Based on the passed moves, checks who should be next
   *  
   * @return <code>Mark.X</code> when X should go next, <code>Mark.O</code> when O 
   */
  Mark whoIsNext();

}
