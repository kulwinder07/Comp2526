public class SmallestNumberGuesser implements NumberGuesser {
    public int guess(int min, int max){
        if(!(min <= max)) {
            throw new IllegalArgumentException(
                    "min (" + min + ") " + "must be <= " + "max (" + max + ")");
        }
        return min;
    }
}
