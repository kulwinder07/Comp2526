public class LargestNumberGuesser implements NumberGuesser{
    @Override
    public int guess(int min, int max)  throws IllegalArgumentException{
        if(!(min <= max)) {
            throw new IllegalArgumentException(
                    "min (" + min + ") " + "must be <= " + "max (" + max + ")");
        }
        return max;
    }
}
