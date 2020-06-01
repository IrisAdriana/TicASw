public class TicTacToe implements ITicTacToe {
    private static final int SIZE = 3;
    private char[][] board;
    private char currentPlayerMark;
    private boolean validCell;

    public TicTacToe(int row, int column) {
        board = new char[row][column];
        currentPlayerMark = 'X';
        create();
    }

    @Override
    public char[][] getBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = getCell(row, column);
            }
        }
        return board;
    }

    private char getCell(int row, int column) {
        return board[row][column];
    }

    @Override
    public void create() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column] = '_';
            }
        }
    }


    private boolean isBoardFull() {
        boolean isFull = true;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] == '_') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    @Override
    public boolean markMovie(int row, int column) {
        if ((row >= 0) && (row < board.length)) {
            if ((column >= 0) && (column < board.length)) {
                if (board[row][column] == '_') {
                    board[row][column] = currentPlayerMark;
                    changePlayer();
                    return true;
                } else {
                    if (board[row][column] == currentPlayerMark) {
                        return false;
                    }
                }

            }
        }
        return false;
    }

    private boolean isValidCell(int row, int column) {
        if (board[row][column] == '_') {
            validCell = true;
        } else {
            if (board[row][column] == 'X' || board[row][column] == 'O') {
                validCell = false;
            }
        }
        return validCell;
    }

    private void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    private char getCurrentPlayer() {
        return currentPlayerMark;
    }


    private boolean checkRowCol(char firstCell, char secondCell, char thirdCell) {
        if (firstCell == 'X' && secondCell == 'X' && thirdCell == 'X') {
            return true;
        } else {
            return firstCell == 'O' && secondCell == 'O' && thirdCell == 'O';
        }
    }


    private boolean checkRowsForWin() {
        for (int row = 0; row < board.length; row++) {
            if (checkRowCol(board[row][0], board[row][1], board[row][2])) {
                validCell = true;
            }
        }
        return validCell;
    }

    private boolean checkColumnsForWin() {
        for (int column = 0; column < board.length; column++) {
            if (checkRowCol(board[0][column], board[1][column], board[2][column])) {
                validCell = true;
            }
        }
        return validCell;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    @Override
    public boolean checkTicTacToe() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    @Override
    public char winner() {
        char winner = ' ';
        if (checkTicTacToe()) {
            changePlayer();
            winner = getCurrentPlayer();
        }
        return winner;
    }

    @Override
    public boolean draw() {
        boolean response = false;
        if (!checkTicTacToe() && isBoardFull()) {
            response = true;
        }
        return response;
    }
}
