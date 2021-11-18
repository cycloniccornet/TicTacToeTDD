import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @RepeatedTest(7)
    public void mustCheckForWhoPlayedLastAndReturnOppositePlayer() {
        boolean wasItThePlayerLastTime = false;

        if (!wasItThePlayerLastTime) {
            assertTrue(whosTurn);



    }

}
