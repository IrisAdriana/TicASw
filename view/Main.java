
public class Main {
    public static void main(String[] arg) {
        ITicTacToe game = new TicTacToe();
        Console console = new Console(game);
        console.run();
    }
}
