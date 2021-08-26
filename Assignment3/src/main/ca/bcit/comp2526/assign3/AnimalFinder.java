package ca.bcit.comp2526.assign3;
import java.util.function.BiPredicate;

public abstract class AnimalFinder<T> implements BiPredicate<Animal, T> {

    public boolean test(Animal animal, T value)
    {
        return animal.equals(value);
    }

}
