package ca.bcit.comp2526.assign3;

import java.util.function.BiPredicate;

public class AgeGreaterThanFinder extends AnimalFinder<Integer> {

    public boolean test(Animal animal, Integer value)
    {
        if(animal == null){
            return false;
        }
        else if(animal.getAge() > value){
            return true;
        }
        return false;
    }
    @Override
    public BiPredicate<Animal, Integer> and(BiPredicate<? super Animal, ? super Integer> other) {
        return null;
    }
}
