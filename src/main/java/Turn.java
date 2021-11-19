public class Turn {

    Board board;
    boolean isItThePlayersTurn = true;
    public void makePlayerMove(int playerAction) throws Exception {
        board.makePlayerMove(playerAction);
    }

    public Boolean checkWhosTurnItIs() {
        if (isItThePlayersTurn) {
            isItThePlayersTurn = false;
            return true;
        }  else {
            isItThePlayersTurn = true;
            return false;
        }
    }

    public boolean checkWhosTurnItIsTest() {
        isItThePlayersTurn = !isItThePlayersTurn;
        return isItThePlayersTurn;
    }
}
