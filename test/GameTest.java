import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void markCellTest_isSuccess() {
        Game game = new Game(3, 3);
        boolean mark = game.markMove(1, 1);
        assertTrue(mark);
    }

    @Test
    public void markCellTest_isFailed() {
        Game game = new Game(3, 3);
        boolean mark = game.markMove(1, 2);
        game.changePlayer();
        mark = game.markMove(1, 2);
        assertFalse(mark);
    }

    @Test
    public void isValidCellTest_isSuccess() {
        Game game = new Game(3, 3);
        boolean isValid = game.isValidCell(1, 1);
        assertTrue(isValid);
    }

    @Test
    public void markCellTest_X_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(1, 1);
        char[][] board = game.getBoard();
        char oneMark = board[1][1];
        assertEquals('X', oneMark);
    }

    @Test
    public void markCellTest_O_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(1, 1);
        game.changePlayer();
        game.markMove(0, 2);
        char[][] board = game.getBoard();
        char oneMark = board[0][2];
        assertEquals('O', oneMark);
    }

    @Test
    public void isValidCellTest_X_isFailed() {
        Game game = new Game(3, 3);
        boolean mark = game.markMove(1, 2);
        mark = game.isValidCell(1, 2);
        assertFalse(mark);
    }

    @Test
    public void isValidCellTest_O_isFailed() {
        Game game = new Game(3, 3);
        boolean mark = game.markMove(1, 2);
        game.changePlayer();
        mark = game.markMove(1, 1);
        mark = game.isValidCell(1, 1);
        assertFalse(mark);
    }

    @Test
    public void checkRowColTest_isSuccess() {
        Game game = new Game(3, 3);
        boolean check = game.checkRowCol('X', 'X', 'X');
        assertTrue(check);
    }

    @Test
    public void checkRowColTest_isFailed() {
        Game game = new Game(3, 3);
        boolean check = game.checkRowCol('X', '_', 'X');
        assertFalse(check);
    }

    @Test
    public void checkRowColTest_isNotMarked() {
        Game game = new Game(3, 3);
        boolean check = game.checkRowCol('_', '_', '_');
        assertFalse(check);
    }

    @Test
    public void checkRowsForWinTest_row0_X_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(0, 1);
        game.markMove(0, 2);
        boolean check = game.checkRowsForWin();
        assertTrue(check);
    }

    @Test
    public void checkRowsForWinTest_row1_X_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(1, 0);
        game.markMove(1, 1);
        game.markMove(1, 2);
        boolean check = game.checkRowsForWin();
        assertTrue(check);
    }

    @Test
    public void checkRowsForWinTest_row1_O_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.changePlayer();
        game.markMove(1, 0);
        game.markMove(1, 1);
        game.markMove(1, 2);
        boolean check = game.checkRowsForWin();
        assertTrue(check);
    }

    @Test
    public void checkRowsForWinTest_X_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(0, 1);
        game.markMove(1, 2);
        boolean check = game.checkRowsForWin();
        assertFalse(check);
    }

    @Test
    public void checkRowsForWinTest_O_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.changePlayer();
        game.markMove(1, 0);
        game.markMove(2, 1);
        game.markMove(2, 2);
        boolean check = game.checkRowsForWin();
        assertFalse(check);
    }

    @Test
    public void checkColumnsForWinTest_column0_X_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(1, 0);
        game.markMove(2, 0);
        boolean check = game.checkColumnsForWin();
        assertTrue(check);
    }

    @Test
    public void checkColumnsForWinTest_column1_O_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.changePlayer();
        game.markMove(0, 1);
        game.markMove(1, 1);
        game.markMove(2, 1);
        boolean check = game.checkColumnsForWin();
        assertTrue(check);
    }

    @Test
    public void checkColumnsForWinTest_X_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(1, 0);
        game.markMove(2, 1);
        boolean check = game.checkColumnsForWin();
        assertFalse(check);
    }

    @Test
    public void checkColumnsForWinTest_O_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(1, 2);
        game.changePlayer();
        game.markMove(0, 2);
        game.markMove(2, 1);
        game.markMove(2, 2);
        boolean check = game.checkColumnsForWin();
        assertFalse(check);
    }

    @Test
    public void checkDiagonalsForWinTest_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(1, 1);
        game.markMove(2, 2);
        boolean check = game.checkDiagonalsForWin();
        assertTrue(check);
    }

    @Test
    public void checkDiagonalsForWinTest_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(1, 2);
        game.changePlayer();
        game.markMove(0, 2);
        game.markMove(1, 1);
        game.markMove(1, 0);
        game.changePlayer();
        game.markMove(2, 0);
        boolean check = game.checkColumnsForWin();
        assertFalse(check);
    }

    @Test
    public void checkForWinTest_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(0, 0);
        game.markMove(0, 1);
        game.markMove(1, 1);
        game.markMove(2, 1);
        boolean check = game.checkTicTacToe();
        assertTrue(check);
    }

    @Test
    public void checkForTie_isSuccess() {
        Game game = new Game(3, 3);
        game.markMove(1, 1);
        game.changePlayer();
        game.markMove(0, 1);
        game.changePlayer();
        game.markMove(0, 0);
        game.changePlayer();
        game.markMove(1, 0);
        game.changePlayer();
        game.markMove(2, 1);
        game.changePlayer();
        game.markMove(2, 2);
        game.changePlayer();
        game.markMove(2, 0);
        game.changePlayer();
        game.markMove(0, 2);
        game.changePlayer();
        game.markMove(1, 2);
        boolean check = game.draw();
        assertTrue(check);
    }

    @Test
    public void checkForTie_isFailed() {
        Game game = new Game(3, 3);
        game.markMove(1, 1);
        game.changePlayer();
        game.markMove(0, 1);
        game.changePlayer();
        game.markMove(0, 0);
        game.changePlayer();
        game.markMove(1, 0);
        game.changePlayer();
        game.markMove(0, 2);
        game.changePlayer();
        game.markMove(2, 2);
        game.changePlayer();
        game.markMove(2, 0);
        game.changePlayer();
        game.markMove(2, 1);
        game.changePlayer();
        game.markMove(1, 2);
        boolean check = game.draw();
        assertFalse(check);
    }
}