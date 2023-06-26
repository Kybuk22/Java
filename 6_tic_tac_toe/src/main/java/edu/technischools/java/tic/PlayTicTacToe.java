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

public class PlayTicTacToe {

  public static void main(String[] args) throws SpotAlreadyTakenException, CoordinatesOutOfBoundsException, OpponentTurnsException {
    Game game = new Game();


    game.startGame(3);
    System.out.println(game.getBoard().show());
    /*
       _|_|_
       _|_|_
        | |
     */
    game.placeMark(Mark.X, 1, 1);
    System.out.println(game.getBoard().show());
    /*
       _|_|_
       _|X|_
        | |
     */
    game.placeMark(Mark.O, 0, 1);
    System.out.println(game.getBoard().show());
    /*
       _|O|_
       _|X|_
        | |
     */
    game.placeMark(Mark.X, 0, 0);
    System.out.println(game.getBoard().show());
   /*
       X|O|_
       _|X|_
        | |
     */
    game.placeMark(Mark.O, 0, 2);
    System.out.println(game.getBoard().show());
    /*
       X|O|O
       _|X|_
        | |
     */
    game.placeMark(Mark.X, 2, 2);
    System.out.println(game.getBoard().show());
    /*
       X|O|O
       _|X|_
        | |X
     */
    game.checkWinner(); // -> X
    game.isBoardFull(); // -> false
  }
}
