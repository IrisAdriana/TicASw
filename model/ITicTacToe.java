public interface ITicTacToe {

    void create();                          //ok
// 0 test

    boolean markMove(int row, int column); //markMovie(row,column) vacia el tablero para iniciar un juego
// 3 test true, false, ocupado

    boolean checkTicTacToe();               // boolean checkTicTacToe() despues de una jugada, hay 3 en raya??
// 7 test

    char winner();                          // char winner()  devuelbe 'X' cuando gana X y 'O' cuando gana O
// 2 test

    boolean draw();                         //devuelve true cuando hay empate, false en caso contrario
// 2 test

    char[][] getBoard();                    //devuelve en un arreglo el contenido de una tabla
// 2 test                                    //la tabla puede contener un 'X', un 'O' o ' '

}//15 test
