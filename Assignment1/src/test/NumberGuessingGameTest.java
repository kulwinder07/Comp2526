import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class NumberGuessingGameTest
{
    private NumberGuessingGame game;

    @BeforeEach
    void initGame()
    {
        game = new NumberGuessingGame();
    }

    @Test
    void play()
    {
        final Player player1;
        final Player player2;
        final Player player3;
        final Player player4;
        final Player player5;

        player1 = new ComputerPlayer("Player 3", new SmallestNumberGuesser());
        player2 = new ComputerPlayer("Player 1", new LargestNumberGuesser());
        player3 = new ComputerPlayer("Player 2", new BestNumberGuesser());
        player4 = new ComputerPlayer("Player 5", new SmallestNumberGuesser());
        player5 = new ComputerPlayer("Player 4", new SmallestNumberGuesser());

        play(1, 10, 10, player1, player1);
        play(1, 10, 1, player2, player2);
        play(1, 10, 2, player3, player3);
        play(1, 5, 3, player3, player1, player2, player3);
        play(1, 5, 2, player1, player1, player2, player3);
        play(1, 10, 9, player2, player1, player2, player3);
        play(1, 10, 8, player1, player1, player1, player1, player1, player1, player2);
        play(1, 100, 65, player1, player1);
        play(1, 100, 65, player2, player1, player2);
        play(1, 100, 65, player2, player2, player1);
        play(1, 100, 65, player1, player1, player2, player3);
        play(1, 100, 65, player3, player3, player1, player4);
        play(1, 100, 65, player3, player3, player1, player4, player2, player5);
        play(1, 100, 65, player2, player1, player5, player4, player2, player3);
    }

    private void play(final int        min,
                      final int        max,
                      final int        numberToGuess,
                      final Player     expectedWinner,
                      final Player ... players)
    {
        final Player winner;

        winner = game.play(min, max, numberToGuess, players);

        assertThat(winner.getName(), equalTo(expectedWinner.getName()));
    }

    @Test
    void badPlay()
    {
        final Player player1;
        final Player player2;
        final Player player3;

        player1 = new ComputerPlayer("Player 3", new SmallestNumberGuesser());
        player2 = new ComputerPlayer("Player 1", new LargestNumberGuesser());
        player3 = new ComputerPlayer("Player 2", new BestNumberGuesser());

        // min > max
        badPlay(100, 99, 10, "min (100) must be < max (99)");
        badPlay(2, 1, 10, "min (2) must be < max (1)");
        badPlay(100, 1, 10, "min (100) must be < max (1)");

        // number to guess < min
        badPlay(1, 1, 0, "numberToGuess (0) must be >= min (1)");
        badPlay(10, 20, 0, "numberToGuess (0) must be >= min (10)");
        badPlay(10, 20, 9, "numberToGuess (9) must be >= min (10)");

        // number to guess > max
        badPlay(1, 1, 2, "numberToGuess (2) must be <= max (1)");
        badPlay(10, 20, 21, "numberToGuess (21) must be <= max (20)");
        badPlay(10, 20, 200, "numberToGuess (200) must be <= max (20)");

        // players
        badPlay(1, 1, 1, "players cannot be null", null);
        badPlay(1, 1, 1, "players cannot be empty", new Player[]{});
        badPlay(1, 1, 1, "players[0] cannot be null", new Player[] { null });
        badPlay(1, 1, 1, "players[1] cannot be null", new Player[] { player1, null });
        badPlay(1, 1, 1, "players[2] cannot be null", new Player[] { player1, player2, null });
    }

    private void badPlay(final int        min,
                         final int        max,
                         final int        numberToGuess,
                         final String     expectedMessage,
                         final Player ... players)
    {
        Throwable ex;

        ex = assertThrows(IllegalArgumentException.class, () -> { game.play(min, max, numberToGuess, players); } );
        assertThat(ex.getMessage(), Matchers.equalTo(expectedMessage));
    }
}