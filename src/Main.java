
public class Main {
    public static void main(String[] arg) {
        int rowBoard = 3;
        int columnBoard = 3;
//        Game game = new Game(rowBoard, columnBoard);
        TicTacToe game = new TicTacToe(rowBoard,columnBoard);
        ConsoleGame console = new ConsoleGame(game);
        console.toPlay();
    }
}
