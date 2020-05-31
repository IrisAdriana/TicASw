public interface IGame {

    char[][] getBoard();

    void create();

    boolean isBoardFull();

    boolean markMovie(int row, int column);

    boolean isValidCell(int row, int column);

    void changePlayer();

    char getCurrentPlayer();

    boolean checkRowCol(char firstCell, char secondCell, char thirdCell);

    boolean checkRowsForWin();

    boolean checkColumnsForWin();

    boolean checkDiagonalsForWin();

    boolean checkTicTacToe();

    boolean draw();

}
