import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {
    @Test
    public void markCellTest_isSuccess() {
        TicTacToe game = new TicTacToe();
        boolean mark = game.markMove(1, 1);
        assertTrue(mark);
    }

    @Test
    public void markCellTest_isFailed() {
        TicTacToe game = new TicTacToe();
        boolean mark = game.markMove(1, 2);
        mark = game.markMove(1, 2);
        assertFalse(mark);
    }

//    @Test
//    public void isValidCellTest_isSuccess() {
//        TicTacToe game = new TicTacToe(3, 3);
//        boolean isValid = game.isValidCell(1, 1);
//        assertTrue(isValid);
//    }

    @Test
    public void markCellTest_X_isSuccess() {
        TicTacToe game = new TicTacToe();
        game.markMove(1, 1);
        char[][] board = game.getBoard();
        char oneMark = board[1][1];
        assertEquals('X', oneMark);
    }

    @Test
    public void markCellTest_O_isSuccess() {
        TicTacToe game = new TicTacToe();
        game.markMove(1, 1);
        game.markMove(0, 2);
        char[][] board = game.getBoard();
        char oneMark = board[0][2];
        assertEquals('O', oneMark);
    }

//    @Test
//    public void isValidCellTest_X_isFailed() {
//        TicTacToe game = new TicTacToe(3, 3);
//        boolean mark = game.markMove(1, 2);
//        mark = game.isValidCell(1, 2);
//        assertFalse(mark);
//    }
//
//    @Test
//    public void isValidCellTest_O_isFailed() {
//        TicTacToe game = new TicTacToe(3, 3);
//        boolean mark = game.markMove(1, 2);
//        mark = game.markMove(1, 1);
//        mark = game.isValidCell(1, 1);
//        assertFalse(mark);
//    }

//    @Test
//    public void checkForWinTest_isSuccess() {
//        TicTacToe game = new TicTacToe(3, 3);
//        game.markMove(0, 0);
//        game.markMove(0, 1);
//        game.markMove(1, 1);
//        game.markMove(2, 1);
//        boolean check = game.checkTicTacToe();
//        assertTrue(check);
//    }

    @Test
    public void draw_isSuccess() {
        TicTacToe game = new TicTacToe();
        game.markMove(1, 1);
        game.markMove(0, 1);
        game.markMove(0, 0);
        game.markMove(1, 0);
        game.markMove(2, 1);
        game.markMove(2, 2);
        game.markMove(2, 0);
        game.markMove(0, 2);
        game.markMove(1, 2);
        boolean check = game.draw();
        assertTrue(check);
    }

}