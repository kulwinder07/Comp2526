public class NumberGuessingGame {
    public Player play(int min, int max, int numberToGuess, Player[] players) {
        if (!(min <= max)) {
            throw new IllegalArgumentException("min (" + min + ") " + "must be < " + "max (" + max + ")");
        }
        if (!(numberToGuess >= min)) {
            throw new IllegalArgumentException(
                    "numberToGuess (" + numberToGuess + ") " +
                            "must be >= " +
                            "min (" + min + ")"
            );
        } else if (!(numberToGuess <= max)) {
            throw new IllegalArgumentException(
                    "numberToGuess (" + numberToGuess + ") " +
                            "must be <= " +
                            "max (" + max + ")"
            );
        }
        if (players == null) {
            throw new IllegalArgumentException(
                    "players cannot be null"
            );
        } else if (players.length == 0) {
            throw new IllegalArgumentException(
                    "players cannot be empty"
            );
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                throw new IllegalArgumentException(
                        "players[" + i + "]" + " cannot be null"
                );
            }
        }
        Player winner = null;
        int runningMinimum = min;
        int runningMaximum = max;

        do{
            for (int i = 0; i < players.length; i++) {
                int answer = ( players[i]).takeTurn(runningMinimum, runningMaximum);
                if (answer == numberToGuess) {
                    winner = players[i];
                    break;
                }
                else {

                    if(((ComputerPlayer)players[i]).guesser instanceof SmallestNumberGuesser) {

                        runningMinimum = answer + 1;
                    }
                    else if(((ComputerPlayer)players[i]).guesser instanceof BestNumberGuesser){

                        if(numberToGuess > answer) {
                            runningMinimum = answer + 1;
                        }
                        else {
                            runningMaximum = answer - 1;
                        }
                    }
                    else if(((ComputerPlayer)players[i]).guesser instanceof LargestNumberGuesser){

                        runningMaximum = answer - 1;
                    }

                }
            }
        } while(winner == null);

        return winner;
    }

}