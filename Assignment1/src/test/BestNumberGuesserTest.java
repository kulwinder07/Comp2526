import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class BestNumberGuesserTest
    extends NumberGuesserTest
{
    @Test
    void guess()
    {
        final BestNumberGuesser guesser1;
        final BestNumberGuesser guesser2;

        guesser1 = new BestNumberGuesser();
        guesser2 = new BestNumberGuesser();

        assertThat(guesser1.guess(1, 1), equalTo(1));
        assertThat(guesser1.guess(1, 2), equalTo(1));
        assertThat(guesser1.guess(1, 3), equalTo(2));
        assertThat(guesser2.guess(1, 4), equalTo(2));
        assertThat(guesser1.guess(1, 5), equalTo(3));
        assertThat(guesser1.guess(1, 6), equalTo(3));
        assertThat(guesser2.guess(1, 7), equalTo(4));
        assertThat(guesser1.guess(2, 4), equalTo(3));
        assertThat(guesser2.guess(1, 100), equalTo(50));
        assertThat(guesser2.guess(100, 200), equalTo(150));
        assertThat(guesser2.guess(1, 10000123), equalTo(5000062));
    }

    @Test
    void badGuess()
    {
        badGuess(new BestNumberGuesser());
    }
}