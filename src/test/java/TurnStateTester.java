import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TurnStateTester {

    private Game game = new Game();
    private Board board = new Board();
    private Turn turn = new Turn();


    @BeforeEach
    public void init() {
        game.createNewGame();
        board = game.getBoard();
        turn = game.getTurn();
    }

    @Test
    public void mustMatchTurnObjectWithCurrentTurnObject() {
        Turn currentTurn = new Turn();

        assertEquals(turn.getClass(), currentTurn.getClass());
    }

    @Test
    public void checkForNullPointerInTurnObject() {
               assertNotNull(turn.getClass());
    }

    @Test
    public void mustCheckForWhoPlayedLastAndReturnOppositePlayer() {

        Boolean[] boolArray = new Boolean[10];
        Boolean[] boolArray2 = {true, false, true, false, true, false, true, false, true, false};


        for (int i = 0; i < boolArray.length; i++){

            boolArray[i] = turn.checkWhosTurnItIs();
       }
         assertEquals(
                 Arrays.toString(boolArray),
                 Arrays.toString(boolArray2));
    }

}
