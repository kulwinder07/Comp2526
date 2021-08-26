import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class SmallestNumberGuesserTest
    extends NumberGuesserTest
{
    @Test
    void guess()
    {
        final SmallestNumberGuesser guesser1;
        final SmallestNumberGuesser guesser2;

        guesser1 = new SmallestNumberGuesser();
        guesser2 = new SmallestNumberGuesser();

        assertThat(guesser1.guess(0, 1000), equalTo(0));
        assertThat(guesser2.guess(0, 1000), equalTo(0));
        assertThat(guesser1.guess(1, 1000), equalTo(1));
        assertThat(guesser2.guess(0, 1000), equalTo(0));
        assertThat(guesser1.guess(2, 1000), equalTo(2));
        assertThat(guesser2.guess(999, 1000), equalTo(999));
        assertThat(guesser1.guess(1000, 1000), equalTo(1000));
        assertThat(guesser2.guess(1000, 1000), equalTo(1000));
        assertThat(guesser1.guess(1, 1), equalTo(1));
        assertThat(guesser2.guess(1, 2), equalTo(1));
    }

    @Test
    void badGuess()
    {
        badGuess(new SmallestNumberGuesser());
    }
}