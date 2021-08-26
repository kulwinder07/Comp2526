package ca.bcit.comp2526.assign3;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.function.BiPredicate;

public class AnimalLoader  implements BiPredicate<Animal, T> {


    public AnimalLoader() {

    }

    public void load(StringReader stringReader) {
    }

    public <T> List<Animal> forEach(BiPredicate<Animal,T> predicate, T value) {

        return null;
    }

    public void load(Reader reader) {
    }

    @Override
    public boolean test(Animal animal, T t) {
        return false;
    }
}
