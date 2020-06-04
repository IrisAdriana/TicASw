
public class Main {
    public static void main(String[] arg) {
//        Game game = new Game(rowBoard, columnBoard);
        TicTacToe game = new TicTacToe();
        Console console = new Console(game);
        console.run();
    }
}
