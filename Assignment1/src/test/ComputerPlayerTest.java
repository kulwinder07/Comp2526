import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest
{
    @Test
    void badConstructor()
    {
        badConstructor(null, null, "nm cannot be null");
        badConstructor("",   null, "nm cannot be blank");
        badConstructor(" ",  null, "nm cannot be blank");
        badConstructor("  ",  null, "nm cannot be blank");
        badConstructor("   ",  null, "nm cannot be blank");
        badConstructor("\t    \n \r ",  null, "nm cannot be blank");
        badConstructor("\t", null, "nm cannot be blank");
        badConstructor("\n", null, "nm cannot be blank");
        badConstructor("\r", null, "nm cannot be blank");
        badConstructor("\t\t", null, "nm cannot be blank");
        badConstructor("\n\n", null, "nm cannot be blank");
        badConstructor("\r\n", null, "nm cannot be blank");
        badConstructor("x",  null, "g cannot be null");
        badConstructor("X",  null, "g cannot be null");
    }

    private void badConstructor(final String                name,
                                final NumberGuesser guesser,
                                final String                expectedMessage)
    {
        Throwable ex;

        ex = assertThrows(IllegalArgumentException.class, () -> { new ComputerPlayer(name, guesser); } );
        assertThat(ex.getMessage(), Matchers.equalTo(expectedMessage));
    }

    @Test
    void makeSmallestGuess()
    {
        final Player player1;
        final Player player2;

        player1 = new ComputerPlayer("P2", new SmallestNumberGuesser());
        player2 = new ComputerPlayer("P1", new SmallestNumberGuesser());

        assertThat(player1.getName(), equalTo("P2"));
        assertThat(player2.getName(), equalTo("P1"));

        for(int i = 0; i < 100; i++)
        {
            assertThat(player1.takeTurn(i, 100), equalTo(i));
            assertThat(player2.takeTurn(i + 1, 100), equalTo(i + 1));
        }
    }

    @Test
    void makeLargestGuess()
    {
        final Player player1;
        final Player player2;

        player1 = new ComputerPlayer("P2", new LargestNumberGuesser());
        player2 = new ComputerPlayer("P1", new LargestNumberGuesser());

        assertThat(player1.getName(), equalTo("P2"));
        assertThat(player2.getName(), equalTo("P1"));

        for(int i = 100; i > 0; i--)
        {
            assertThat(player1.takeTurn(0, i), equalTo(i));
            assertThat(player2.takeTurn(0, i - 1), equalTo(i - 1));
        }
    }

    @Test
    void makeBestGuess()
    {
        final Player player1;
        final Player player2;

        player1 = new ComputerPlayer("P2", new BestNumberGuesser());
        player2 = new ComputerPlayer("P1", new BestNumberGuesser());

        assertThat(player1.getName(), equalTo("P2"));
        assertThat(player2.getName(), equalTo("P1"));

        assertThat(player1.takeTurn(0, 10),  equalTo(5));
        assertThat(player2.takeTurn(1, 10),  equalTo(5));
        assertThat(player1.takeTurn(2, 100), equalTo(51));
        assertThat(player2.takeTurn(2, 96),  equalTo(49));
    }

    @Test
    void makeOtherGuess()
    {
        final ComputerPlayer player1;
        final ComputerPlayer player2;

        player1 = new ComputerPlayer("P2", new OtherNumberGuesser());
        player2 = new ComputerPlayer("P1", new OtherNumberGuesser());

        assertThat(player1.getName(), equalTo("P2"));
        assertThat(player2.getName(), equalTo("P1"));

        assertThat(player1.takeTurn(0, 10),  equalTo(1));
        assertThat(player2.takeTurn(1, 10),  equalTo(2));
        assertThat(player1.takeTurn(2, 100), equalTo(3));
        assertThat(player2.takeTurn(2, 96),  equalTo(3));
        assertThat(player1.takeTurn(1, 1),   equalTo(1));
        assertThat(player2.takeTurn(100, 200),   equalTo(101));
    }

    @Test
    void makeAnonymousGuess()
    {
        final ComputerPlayer player1;
        final ComputerPlayer player2;

        player1 = new ComputerPlayer("P2", new NumberGuesser()
        {
            @Override
            public int guess(final int min, final int max)
            {
                final int retVal;

                if(min == max)
                {
                    retVal = min;
                }
                else
                {
                    retVal = min + 2;
                }

                return retVal;
            }
        });
        player2 = new ComputerPlayer("P1", new NumberGuesser()
        {
            @Override
            public int guess(final int min, final int max)
            {
                final int retVal;

                if(min == max)
                {
                    retVal = min;
                }
                else
                {
                    retVal = min + 3;
                }

                return retVal;
            }
        });

        assertThat(player1.getName(), equalTo("P2"));
        assertThat(player2.getName(), equalTo("P1"));

        assertThat(player1.takeTurn(0, 10),  equalTo(2));
        assertThat(player2.takeTurn(1, 10),  equalTo(4));
        assertThat(player1.takeTurn(2, 100), equalTo(4));
        assertThat(player2.takeTurn(2, 96),  equalTo(5));
        assertThat(player1.takeTurn(1, 1),   equalTo(1));
        assertThat(player2.takeTurn(100, 200),   equalTo(103));
    }

    private class OtherNumberGuesser
        implements NumberGuesser
    {

        @Override
        public int guess(int min, int max)
        {
            final int retVal;

            if(min == max)
            {
                retVal = min;
            }
            else
            {
                retVal = min + 1;
            }

            return retVal;
        }
    }
}