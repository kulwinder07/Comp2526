public class Player {
    String name;
    NumberGuesser guesser;
    public String getName() {

        return name;
    }

    public int takeTurn(int i, int i1) {
        return guesser.guess(i, i1);
    }
}
