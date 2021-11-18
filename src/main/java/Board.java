import java.util.Random;

public class Board {

    private char[] starterBoard = { '0', '0', '0', '0', '0', '0', '0', '0', '0' };

    private char[] currentBoard = { '0', '0', '0', '0', '0', '0', '0', '0', '0' };

    Random random = new Random();

    public char[] resetBoard() {
        return starterBoard;
    }

    public char[] getCurrentBoardLayout() {
        return currentBoard;
    }


    public char[] getStarterBoard() {
        return starterBoard;
    }

    public void printCurrentBoard() {
        System.out.println( "\n\n" );
        System.out.println(  "\n\n" );
        System.out.println(  "\n\n\t\t" + currentBoard [0] + "   | " +currentBoard [1]+ "  | " +currentBoard [2]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +currentBoard [3]+ "   | " +currentBoard [4]+ "  | " +currentBoard [5]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +currentBoard [6]+ "   | " +currentBoard [7]+ "  | " +currentBoard [8]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  "\n\n" );
    }


    public void makePlayerMove(int playerAction) throws Exception {
        if (playerAction > 9 || playerAction < 1) throw new Exception("Integer out of bounds");
        //if (playerAction > 9) return "Number to big";
        //if (playerAction < 1) return "Number to small";

        switch (playerAction) {
            case 1: if (currentBoard[0] == '0') currentBoard[0] = 'X'; break;
            case 2: if (currentBoard[1] == '0') currentBoard[1] = 'X'; break;
            case 3: if (currentBoard[2] == '0') currentBoard[2] = 'X'; break;
            case 4: if (currentBoard[3] == '0') currentBoard[3] = 'X'; break;
            case 5: if (currentBoard[4] == '0') currentBoard[4] = 'X'; break;
            case 6: if (currentBoard[5] == '0') currentBoard[5] = 'X'; break;
            case 7: if (currentBoard[6] == '0') currentBoard[6] = 'X'; break;
            case 8: if (currentBoard[7] == '0') currentBoard[7] = 'X'; break;
            case 9: if (currentBoard[8] == '0') currentBoard[8] = 'X'; break;
        }
    }

    public void makeBotMove () {



    }

    public static void main(String[] args) throws Exception {

        Board b = new Board();
        b.makePlayerMove(0);
    }

}
