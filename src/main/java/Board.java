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
        System.out.println("\t\t" +currentBoard[0]+" | "+ currentBoard[1] +" | "+currentBoard[2]+"\n\t\t"+currentBoard[3]+" | "+currentBoard[4]+" | "+currentBoard[5]+"\n\t\t"+currentBoard[6]+" | "+currentBoard[7]+" | "+currentBoard[8]);
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

    /*
    Nu sidder du nok og tænker... Hold da kæft det er smukt kodet! Det gør jeg også. Har ihvertfald tåre i øjene og ikke nødvendigvis af glæde
     */
    public int checkIfPlayerCanWin() {

        //checks horizontal
        if (currentBoard[0] == 'X' && currentBoard[1] == 'X') return 2;
        if (currentBoard[0] == 'X' && currentBoard[2] == 'X') return 1;
        if (currentBoard[1] == 'X' && currentBoard[2] == 'X') return 0;

        if (currentBoard[3] == 'X' && currentBoard[4] == 'X') return 5;
        if (currentBoard[3] == 'X' && currentBoard[5] == 'X') return 4;
        if (currentBoard[4] == 'X' && currentBoard[5] == 'X') return 3;

        if (currentBoard[6] == 'X' && currentBoard[7] == 'X') return 8;
        if (currentBoard[6] == 'X' && currentBoard[8] == 'X') return 7;
        if (currentBoard[7] == 'X' && currentBoard[8] == 'X') return 6;

        //checks Vertical
        if (currentBoard[0] == 'X' && currentBoard[3] == 'X') return 6;
        if (currentBoard[0] == 'X' && currentBoard[6] == 'X') return 3;
        if (currentBoard[3] == 'X' && currentBoard[6] == 'X') return 0;

        if (currentBoard[1] == 'X' && currentBoard[4] == 'X') return 7;
        if (currentBoard[1] == 'X' && currentBoard[7] == 'X') return 4;
        if (currentBoard[4] == 'X' && currentBoard[7] == 'X') return 1;

        if (currentBoard[2] == 'X' && currentBoard[5] == 'X') return 8;
        if (currentBoard[2] == 'X' && currentBoard[8] == 'X') return 5;
        if (currentBoard[5] == 'X' && currentBoard[8] == 'X') return 2;

        //Checks Skråt #Danglish
        if (currentBoard[0] == 'X' && currentBoard[4] == 'X') return 8;
        if (currentBoard[0] == 'X' && currentBoard[8] == 'X') return 4;
        if (currentBoard[4] == 'X' && currentBoard[8] == 'X') return 0;

        if (currentBoard[2] == 'X' && currentBoard[4] == 'X') return 6;
        if (currentBoard[2] == 'X' && currentBoard[6] == 'X') return 4;
        if (currentBoard[4] == 'X' && currentBoard[6] == 'X') return 2;

        return 10;
    }

    public int didSomeoneWin() {

        //checks x vertical
        if (currentBoard[0] == 'X' && currentBoard[1] == 'X' && currentBoard[2] == 'X') return 1;
        if (currentBoard[3] == 'X' && currentBoard[4] == 'X' && currentBoard[5] == 'X') return 1;
        if (currentBoard[6] == 'X' && currentBoard[7] == 'X' && currentBoard[8] == 'X') return 1;

        //checks o vertical
        if (currentBoard[0] == 'O' && currentBoard[1] == 'O' && currentBoard[2] == 'O') return 2;
        if (currentBoard[3] == 'O' && currentBoard[4] == 'O' && currentBoard[5] == 'O') return 2;
        if (currentBoard[6] == 'O' && currentBoard[7] == 'O' && currentBoard[8] == 'O') return 2;

        //checks x horizontal
        if (currentBoard[0] == 'X' && currentBoard[3] == 'X' && currentBoard[6] == 'X') return 1;
        if (currentBoard[1] == 'X' && currentBoard[4] == 'X' && currentBoard[7] == 'X') return 1;
        if (currentBoard[2] == 'X' && currentBoard[5] == 'X' && currentBoard[8] == 'X') return 1;

        //checks o horizontal
        if (currentBoard[0] == 'O' && currentBoard[3] == 'O' && currentBoard[6] == 'X') return 2;
        if (currentBoard[1] == 'O' && currentBoard[4] == 'O' && currentBoard[7] == 'X') return 2;
        if (currentBoard[2] == 'O' && currentBoard[5] == 'O' && currentBoard[8] == 'X') return 2;

        //checks x obliquely
        if (currentBoard[0] == 'X' && currentBoard[4] == 'X' && currentBoard[8] == 'X') return 1;
        if (currentBoard[2] == 'X' && currentBoard[4] == 'X' && currentBoard[6] == 'X') return 1;

        //checks o obliquely
        if (currentBoard[0] == 'O' && currentBoard[4] == 'O' && currentBoard[8] == 'X') return 2;
        if (currentBoard[2] == 'O' && currentBoard[4] == 'O' && currentBoard[6] == 'X') return 2;

        return 0;
    }

    public void makeBotMove () {


        int canPlayerWin = checkIfPlayerCanWin();

        if (canPlayerWin != 10 ) currentBoard[canPlayerWin] = 'O';

        if (canPlayerWin == 10) {

            int botAction = random.nextInt(10 - 1) + 1;

            switch (botAction) {
                case 1:
                    if ((currentBoard[0] == '0')) {
                        currentBoard[0] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 2:
                    if ((currentBoard[1] == '0')) {
                        currentBoard[1] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 3:
                    if ((currentBoard[2] == '0')) {
                        currentBoard[2] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 4:
                    if ((currentBoard[3] == '0')) {
                        currentBoard[3] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 5:
                    if ((currentBoard[4] == '0')) {
                        currentBoard[4] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 6:
                    if ((currentBoard[5] == '0')) {
                        currentBoard[5] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 7:
                    if ((currentBoard[6] == '0')) {
                        currentBoard[6] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 8:
                    if ((currentBoard[7] == '0')) {
                        currentBoard[7] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
                case 9:
                    if ((currentBoard[8] == '0')) {
                        currentBoard[8] = 'O';
                    } else {
                        makeBotMove();
                    }
                    break;
            }
        }
    }



}
