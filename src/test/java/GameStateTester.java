
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

public class GameStateTester {

    public char[] expectedStartingBoard = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    private Game game = new Game();
    private Board board = new Board();

    @BeforeEach
    public void init() {
        game.createNewGame();
        board = game.getBoard();
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void mustMatchGameObjectWithCurrentGameObject() {
        Game currentGame = new Game();

        assertEquals(game.getClass(), currentGame.getClass());
    }

    @Test
    public void checkForNullPointerInGameObject() {
        game = new Game();

        assertNotNull(game.getClass());
    }

    @Test
    public void mustCreateANewBoardObjectWhenCreateNewBoard() {
        Board board = new Board();

        assertEquals(board.getClass(), game.getBoard().getClass());
    }

    @Test
    public void mustCreateAStartingBoardWhenCallingCreateNewGame() {
        char[] expectedStartingBoard = { '0', '0', '0', '0', '0', '0', '0', '0', '0' };

        Board currentBoard = game.getBoard();
        char[] actualBoard = currentBoard.getStarterBoard();

        assertArrayEquals(expectedStartingBoard, actualBoard);
    }

    @Test
    public void mustCreateANewTurnObjectWhenCreateNewTurn() {
        Turn turn = new Turn();

        assertEquals(turn.getClass(), game.getTurn().getClass());
    }

    @Test
    public void mustUpdateCurrentBoardWhenMakingAPlacementOnFirstIndexWhenPlayingAsX() throws Exception {
       char[] expectedBoardAfterPlayerAction = { 'X', '0', '0', '0', '0', '0', '0', '0', '0' };

       Board board = game.getBoard();
       board.makePlayerMove(1);
       char[] actualBoard = game.getCurrentBoard();

       assertArrayEquals(expectedBoardAfterPlayerAction, actualBoard);
    }

    @Test
    public void mustUpdateCurrentBoardWhenMakingAPlacementOnThirdIndexWhenPlayingAsX() throws Exception {
        char[] expectedBoardAfterPlayerAction = { '0', '0', 'X', '0', '0', '0', '0', '0', '0' };

        Board board = game.getBoard();
        board.makePlayerMove(3);
        char[] actualBoard = game.getCurrentBoard();

        assertArrayEquals(expectedBoardAfterPlayerAction, actualBoard);
    }

    @Test
    public void mustChangeEntireBoardToXWithoutParmarized() throws Exception {
        char[] expectedBoardAfterPlayerAction = { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' };

        for (int i = 1; i < 10; i++) {
            board.makePlayerMove(i);
        }

        char[] actualBoard = game.getCurrentBoard();
        System.out.println(actualBoard);

        assertArrayEquals(expectedBoardAfterPlayerAction, actualBoard);
    }

    // TODO: Spørg om denne test også skal tage højde for korrekte værdier som ValueSource
    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 12, 101010101}) // six numbers
    public void mustThrowIndexOutOfBounceExceptionWhenIndexIsAbove9(int playerAction) {

        Exception exception = assertThrows(Exception.class, () -> {
            board.makePlayerMove(playerAction);
            // Integer.parseInt("10");
        });

        String expectedMessage = "Integer out of bounds";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void mustBeAbleToReadTheCurrentBoardWhenPlayerHasMadeOneMove() throws Exception {
        board.makePlayerMove(1);
        char[] actualBoard = game.getCurrentBoard();
        char[] expectedBoardAfterPlayerAction = { 'X', '0', '0', '0', '0', '0', '0', '0', '0' };

        assertArrayEquals(expectedBoardAfterPlayerAction, actualBoard);
    }

    //@Test
    @RepeatedTest(50)
    public void mustBeAbleToMakeAMoveWhenPlayerHasMadeOneMove() throws Exception {
        board.makePlayerMove(1);
        char[] expectedBoardAfterPlayerAction = { 'X', '0', '0', '0', '0', '0', '0', '0', '0' };

        board.makeBotMove();
        char[] actualBoard = game.getCurrentBoard();

        assertFalse(Arrays.equals(actualBoard, expectedBoardAfterPlayerAction));
    }

    @Test
    public void botMustPlaceACounterWhenXCanWin() throws Exception {
        board.makePlayerMove(1);
        board.makePlayerMove(2);
        char[] expectedBoardAfterBotMove = { 'X', 'X', 'O', '0', '0', '0', '0', '0', '0' };

        board.makeBotMove();
        char[] actualBoard = game.getCurrentBoard();

        assertArrayEquals(expectedBoardAfterBotMove, actualBoard);
    }

    @Test
    public void mustReturn1IfPlayerWins() throws Exception {
        board.makePlayerMove(1);
        board.makePlayerMove(2);
        board.makePlayerMove(3);
        board.printCurrentBoard();
        assertEquals(1, board.didSomeoneWin());
    }

    @Test
    public void mustReturn0IfNooneWins() throws Exception {
        board.makePlayerMove(1);
        board.makePlayerMove(2);
        board.makePlayerMove(3);
        board.printCurrentBoard();
        assertEquals(1, board.didSomeoneWin());
    }




    /* TODO: Find en måde den ikke reseter arrayet
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9}) // six numbers
    public void mustChangeEntireBoardToX(int playerAction) {
        char[] expectedBoardAfterPlayerAction = { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' };

        board.makePlayerMove(playerAction);

        char[] actualBoard = game.getCurrentBoard();
        System.out.println(actualBoard);

        assertArrayEquals(expectedBoardAfterPlayerAction, actualBoard);
    }
     */

    /* TODO: Find en måde hvorpå 2 strings kan sammenlignes uden line seperators
    @Test
    public void mustPrintTheCurrentLayoutOfTheBoardWhenNoTurnHasBeenMade() {
        game.createNewGame();
        Board currentBoard = game.getBoard();
        currentBoard.printCurrentBoard();


        assertEquals("0   | 0  | 0\n" +
                " \t\t    |    |   \n" +
                " \t\t ___|____|___ \n" +
                "\n" +
                "\n" +
                "\t\t0   | 0  | 0\n" +
                " \t\t    |    |   \n" +
                " \t\t ___|____|___ \n" +
                "\n" +
                "\n" +
                "\t\t0   | 0  | 0\n" +
                " \t\t    |    |   \n" +
                " \t\t    |    |", outputStreamCaptor.toString()
                .trim().);
    }

     */

}
