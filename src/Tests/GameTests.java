package Tests;

import com.company.Domain.Player;
import com.company.Logic.Game;
import com.company.Logic.InvalidMoveException;
import com.company.Logic.State;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Gudmundur Bjarni Kristinsson on 31-Oct-15.
 * gudmundurk14@ru.is
 * kt: 110384-3279
 */

public class GameTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.GameTests");
    }

    @Test
    public void testGameInitialization() {
        Game game = new Game(new Player(), new Player());
        assertEquals(State.RUNNING, game.getGameState());
        assertEquals(null, game.getWinner());
    }

    @Test
    public void testValidMoveOutOfBounds() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(-1, -2);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
        try {
            game.makeMove(3, 3);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
    }

    @Test
    public void testValidMoveCellTaken() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(1, 1);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        try {
            game.makeMove(1, 1);
        } catch (InvalidMoveException e) {
            assertEquals(e.getClass(), InvalidMoveException.class);
        }
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(1, 1);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[][] arr = game.getGameBoard();
        assertEquals(arr[1][1], 'X');

        try {
            game.makeMove(2, 2);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[][] arr2 = game.getGameBoard();
        assertEquals(arr2[2][2], 'O');

        try {
            game.makeMove(0, 0);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        char[][] arr3 = game.getGameBoard();
        assertEquals(arr2[0][0], 'X');
    }

    @Test
    public void testCheckWinnerRow() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(0, 0);
            game.makeMove(1, 1);
            game.makeMove(0, 1);
            game.makeMove(2, 2);
            game.makeMove(0, 2);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());
    }

    @Test
    public void testCheckWinnerColumn() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(0, 0);
            game.makeMove(1, 1);
            game.makeMove(1, 0);
            game.makeMove(2, 2);
            game.makeMove(2, 0);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());
    }
    @Test
    public void testCheckWinnerCross() {
        Game game = new Game(new Player(), new Player());
        try {
            game.makeMove(0, 0);
            game.makeMove(1, 2);
            game.makeMove(1, 1);
            game.makeMove(2, 1);
            game.makeMove(2, 2);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game.getGameState());

        Game game2 = new Game(new Player(), new Player());
        try {
            game2.makeMove(0, 2);
            game2.makeMove(1, 2);
            game2.makeMove(1, 1);
            game2.makeMove(2, 1);
            game2.makeMove(2, 0);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(State.WINNER, game2.getGameState());
    }

    @Test
    public void testGetWinner() {
        Player X = new Player();
        Player O = new Player();
        Game game = new Game(X, O);
        try {
            game.makeMove(0, 2);
            game.makeMove(1, 2);
            game.makeMove(1, 1);
            game.makeMove(2, 1);
            game.makeMove(2, 0);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(X, game.getWinner());

        Game game2 = new Game(X, O);
        try {
            game2.makeMove(0, 0);
            game2.makeMove(1, 1);
            game2.makeMove(1, 2);
            game2.makeMove(0, 1);
            game2.makeMove(2, 2);
            game2.makeMove(2, 1);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        assertEquals(O, game2.getWinner());
    }
}
