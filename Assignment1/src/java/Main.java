public class Main
{
    public static void main(String[] args)
    {
        final NumberGuessingGame game;
        final Player[] players;
        final Player winner;
        final String winnerName;

        game = new NumberGuessingGame();
        players = new Player[]
                {
                        new ComputerPlayer("A", new SmallestNumberGuesser()),
                        new ComputerPlayer("B", new LargestNumberGuesser()),
                        new ComputerPlayer("C", new BestNumberGuesser()),
                };
        winner = game.play(1, 100, 40, players);
        winnerName = winner.getName();
        System.out.printf("%s is the winner!\n", winnerName);
    }
}
