
public class Main {
    public static void main(String[] arg) {
        TicTacToe game = new TicTacToe();
        Console console = new Console(game);
        console.run();
    }
}
