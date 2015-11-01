package Tests;

import com.company.Domain.GameBoard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Gudmundur Bjarni Kristinsson on 31-Oct-15.
 * gudmundurk14@ru.is
 * kt: 110384-3279
 */
public class GameBoardTests {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("Tests.GameBoardTests");
    }

    @Test
    public void testBoardCreation() {
        GameBoard board = new GameBoard();
        char emptyTile = ' ';
        for (char tile : board.getBoard()) {
            assertEquals(emptyTile, tile);
        }
    }

    @Test
    public void testMakeMove() {
        GameBoard board = new GameBoard();
        char testChar = 'X';
        board.makeMove(0, testChar);
        char testArr[] = board.getBoard();
        assertEquals(testChar, testArr[0]);
    }

    @Test
    public void testIsBoardFull() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        board.makeMove(1, 'X');
        board.makeMove(2, 'X');
        board.makeMove(3, 'X');
        board.makeMove(4, 'X');
        board.makeMove(5, 'X');
        board.makeMove(6, 'X');
        board.makeMove(7, 'X');
        assertEquals(false, board.isBoardFull());
        board.makeMove(8, 'X');
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testIsCellEmpty() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        assertEquals(true, board.isCellEmpty(1));
        assertEquals(false, board.isCellEmpty(0));
    }

    @Test
    public void testGetCell() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 'X');
        assertEquals(' ', board.getCell(1));
        assertEquals('X', board.getCell(0));
    }
}
