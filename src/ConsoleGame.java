import java.util.Scanner;

public class ConsoleGame {
    Scanner player = new Scanner(System.in);
    //    private IGame game;
    private ITicTacToe game;
    int exit = 5;


    public ConsoleGame(ITicTacToe game) {
        this.game = game;
    }

    public char[][] showBoard() {
        System.out.println("--------------");

        char[][] board = game.getBoard();
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < board.length; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
        return board;
    }

    public void toPlay() {
        game.create();
        System.out.println("This is current bord");
        showBoard();
        play();
    }

    private void play() {

        do {
            int row;
            int column;
            do {
                System.out.println("play");

                System.out.println("Press 5 to end game in any position");
                row = player.nextInt();
                column = player.nextInt();
                if (row == exit || column == exit) {
                    System.out.println("Thanks!!!!");
                    System.exit(0);
                }
            }
            while (!game.markMovie(row, column));
            showBoard();
        }
        while (!game.checkTicTacToe());
        if (game.draw()) {
            showBoard();
            System.out.println("The game was a tie");
        } else {
            if (game.checkTicTacToe()) {
                showBoard();
                System.out.println(game.winner() + "  --> You Win");

            } else {
                showBoard();
                System.out.println(game.winner() + "  --> You Lose");

            }
        }
    }
}
