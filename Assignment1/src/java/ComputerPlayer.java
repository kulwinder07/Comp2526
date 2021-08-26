public class ComputerPlayer extends Player {
    String name;
    NumberGuesser guesser;

    public ComputerPlayer(String name, NumberGuesser guesser) {

        if(name == null) {
            throw new IllegalArgumentException("nm cannot be null");
        }
        else if(name.isBlank()){
            throw new IllegalArgumentException("nm cannot be blank");
        }

        if(guesser == null) {
            throw new IllegalArgumentException("g cannot be null");
        }
        this.name = name;
        this.guesser = guesser;
    }


    public String getName() {
        return name;
    }

    public int takeTurn(int i, int i1) {
        return guesser.guess(i, i1);
    }
}
