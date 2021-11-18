import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BordStateTester {

    private Board board;

    @Test
    public void mustMatchBoardObjectWithCurrentBoardObject() {
        board = new Board();

        Board currentBoard = new Board();

        assertEquals(board.getClass(), currentBoard.getClass());
    }

    @Test
    public void checkForNullPointerInBoardObject() {
        board = new Board();

        assertNotNull(board.getClass());
    }

}
