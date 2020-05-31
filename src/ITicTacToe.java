public interface ITicTacToe {

    void create();//ok 

    boolean markMovie(int row, int column); //markMovie(row,column) vacia el tablero para iniciar un juego

    boolean checkTicTacToe();// boolean checkTicTacToe() despues de una jugada, hay 3 en raya??

    char winner(); // char winner()  devuelbe 'X' cuando gana X y 'O' cuando gana O

    boolean draw();  //devuelve true cuando hay empate, false en caso contrario

    char[][] getBoard();    //devuelve en un arreglo el contenido de una tabla
                            //la tabla puede contener un 'X', un 'O' o ' '

}
