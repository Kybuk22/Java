package edu.technischools.java.tic;

import edu.technischools.java.tic.exception.CoordinatesOutOfBoundsException;
import edu.technischools.java.tic.exception.OpponentTurnsException;
import edu.technischools.java.tic.exception.SpotAlreadyTakenException;
import edu.technischools.java.tic.model.Mark;
import org.junit.Assert;
import org.junit.Test;

/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
public class GameTest {

  @Test
  public void startGame() {
      Game game = new Game();
      game.startGame(3);
      Assert.assertNotNull(game.getBoard());
      Assert.assertEquals(3, game.getBoard().getSize());
  }
  
  @Test
  public void placeMark() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 0, 0);
      Assert.assertEquals(Mark.X, game.getBoard().getSpot(0, 0));
  }
  
  @Test(expected = CoordinatesOutOfBoundsException.class)
  public void placeMark_CoordinatesOutOfBoundsException() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 3, 0);
  }
  
  @Test(expected = SpotAlreadyTakenException.class)
  public void placeMark_SpotAlreadyTakenException() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 0, 0);
      game.placeMark(Mark.O, 0, 0);
  }
  
  @Test(expected = OpponentTurnsException.class)
  public void placeMark_OpponentTurnsException() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 0, 0);
      game.placeMark(Mark.X, 0, 1);
  }
  
  @Test
  public void checkWinner() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 1, 1);
      game.placeMark(Mark.O, 0, 1);
      game.placeMark(Mark.X, 0, 0);
      game.placeMark(Mark.O, 0, 2);
      game.placeMark(Mark.X, 2, 2);
      Assert.assertEquals(Mark.X, game.checkWinner());
  }
  
  @Test
  public void isBoardFull() throws CoordinatesOutOfBoundsException, SpotAlreadyTakenException, OpponentTurnsException {
      Game game = new Game();
      game.startGame(3);
      game.placeMark(Mark.X, 0, 0);
      game.placeMark(Mark.O, 0, 1);
      game.placeMark(Mark.X, 0, 2);
      game.placeMark(Mark.O, 1, 0);
      game.placeMark(Mark.X, 1, 1);
      game.placeMark(Mark.O, 1, 2);
      game.placeMark(Mark.X, 2, 0);
      game.placeMark(Mark.O, 2, 1);
      game.placeMark(Mark.X, 2, 2);
      Assert.assertTrue(game.isBoardFull());
  }
  
  @Test
  public void isBoardEmpty() {
      Game game = new Game();
      game.startGame(3);
      Assert.assertTrue(game.isBoardEmpty());
  }
}