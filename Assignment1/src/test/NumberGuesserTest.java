import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public abstract class NumberGuesserTest
{
    protected void badGuess(final NumberGuesser guesser)
    {
        badGuess(guesser, 1, 0, "min (1) must be <= max (0)");
        badGuess(guesser, 1, -1, "min (1) must be <= max (-1)");
        badGuess(guesser, 100, 1, "min (100) must be <= max (1)");
        badGuess(guesser, 100, -1, "min (100) must be <= max (-1)");
        badGuess(guesser, 100, 99, "min (100) must be <= max (99)");
        badGuess(guesser, 100, 98, "min (100) must be <= max (98)");
    }

    private void badGuess(final NumberGuesser guesser,
                          final int min,
                          final int max,
                          final String expectedMessage)
    {
        Throwable ex;

        ex = assertThrows(IllegalArgumentException.class, () -> { guesser.guess(min, max); } );
        assertThat(ex.getMessage(), Matchers.equalTo(expectedMessage));
    }
}
