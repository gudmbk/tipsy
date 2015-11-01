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
        char testArr[] = {' ', ' ', ' '};
        for (char[] innerArray : board.getBoard()) {
            assertArrayEquals(testArr, innerArray);
        }
    }

    @Test
    public void testMakeMove() {
        GameBoard board = new GameBoard();
        char testChar = 'X';
        board.makeMove(0, 0, testChar);
        char testArr[][] = board.getBoard();
        assertEquals(testChar, testArr[0][0]);
    }

    @Test
    public void testIsBoardFull() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(2, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 1, 'X');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 2, 'X');
        assertEquals(false, board.isBoardFull());
        board.makeMove(2, 2, 'X');
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testIsCellEmpty() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 0, 'X');
        assertEquals(true, board.isCellEmpty(0, 1));
        assertEquals(false, board.isCellEmpty(0, 0));
    }

    @Test
    public void testGetCell() {
        GameBoard board = new GameBoard();
        board.makeMove(0, 0, 'X');
        assertEquals(' ', board.getCell(1, 0));
        assertEquals('X', board.getCell(0, 0));
    }
}
