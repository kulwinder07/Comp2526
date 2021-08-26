import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class LargestNumberGuesserTest
    extends NumberGuesserTest
{
    @Test
    void guess()
    {
        final LargestNumberGuesser guesser1;
        final LargestNumberGuesser guesser2;

        guesser1 = new LargestNumberGuesser();
        guesser2 = new LargestNumberGuesser();

        assertThat(guesser1.guess(0, 1000), equalTo(1000));
        assertThat(guesser2.guess(0, 1000), equalTo(1000));
        assertThat(guesser1.guess(1, 1000), equalTo(1000));
        assertThat(guesser2.guess(0, 1000), equalTo(1000));
        assertThat(guesser1.guess(2, 1000), equalTo(1000));
        assertThat(guesser2.guess(999, 1000), equalTo(1000));
        assertThat(guesser1.guess(1000, 1000), equalTo(1000));
        assertThat(guesser2.guess(1000, 1000), equalTo(1000));
        assertThat(guesser1.guess(1, 1), equalTo(1));
        assertThat(guesser2.guess(1, 2), equalTo(2));
        assertThat(guesser1.guess(100, 102), equalTo(102));
        assertThat(guesser2.guess(100, 103), equalTo(103));
    }

    @Test
    void badGuess()
    {
        badGuess(new LargestNumberGuesser());
    }
}