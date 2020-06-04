
import java.util.Scanner;

public class Console {
    Scanner player = new Scanner(System.in);
    Scanner option = new Scanner(System.in);
    //    private IGame game;
    private ITicTacToe game;
    int exit = 6;


    public Console(ITicTacToe game) {
        this.game = game;
    }

    public void run() {
        options();
        play();
    }

    private void play() {
        do {
            int row;
            int column;
            do {
                System.out.println("Start Game");

                System.out.println("Press 6 to end game in any position");
                row = player.nextInt();
                column = player.nextInt();
                if (row == exit || column == exit) {
                    System.out.println("Thanks!!!!");
                    System.exit(0);
                }
            }
            while (!game.markMove(row, column));
            showBoard();

        }
        while (!game.checkTicTacToe() && !game.draw());
        if (game.draw()) {
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

    public void options() {
        showOptions();
        int optionToPlay = option.nextInt();
        switch (optionToPlay) {
            case 5:
                game.create();
                System.out.println("This is current bord");
                showBoard();
//                toPlay();
                break;
            case 6:
                System.out.println("Thanks!!!");
                System.exit(0);
                break;

        }
    }

    private void showOptions() {
        System.out.println("------------------");
        System.out.println("Choose An Option");
        System.out.println("5.- Start New Game");
        System.out.println("6.- Exit");
        System.out.println("------------------");
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
        System.out.println("--------------");
        return board;
    }
}
