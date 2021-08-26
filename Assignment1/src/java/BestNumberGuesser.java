public class BestNumberGuesser implements NumberGuesser{
    @Override
    public int guess(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("min (" + min + ") must be <= max (" + max + ")");
        }
        return (min+max)/2;
    }
}
