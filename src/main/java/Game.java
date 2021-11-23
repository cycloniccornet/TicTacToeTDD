import java.util.Scanner;

public class Game {

    Board board;
    Turn turn;



    public char[] createNewBoard() {
         board = new Board();
         turn = new Turn();
         char[] startingBoard = board.getStarterBoard();
         return startingBoard;
    }

    public Board getBoard() {
        return board;
    }

    public char[] getCurrentBoard() {
        return board.getCurrentBoardLayout();
    }

    public void createNewGame() {
        createNewBoard();
    }

    public Turn getTurn() {
        return turn;
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Board board = new Board();
        Turn turn = new Turn();
        Scanner scanner = new Scanner(System.in);

        while (board.didSomeoneWin() == 0 ) {

            board.printCurrentBoard();

            boolean whoturn = turn.checkWhosTurnItIs();
            if (whoturn) {
                System.out.println("\nMake a move");
                String playerAction = scanner.nextLine();
                board.makePlayerMove(Integer.parseInt(playerAction));
            } else {
                System.out.println("\nBot is makeing a move");
                board.makeBotMove();
            }

        }

        if (board.didSomeoneWin() == 1) System.out.println("Player won");
        if (board.didSomeoneWin() == 2) System.out.println("Bot won");

    }
}
