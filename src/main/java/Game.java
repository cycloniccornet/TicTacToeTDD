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

    public static void main(String[] args) {

    }
}
