package ca.bcit.comp2526.assign3;

import java.io.BufferedReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class DefaultAnimalLoader extends AnimalLoader {

    List<Animal> animalList;

    public DefaultAnimalLoader() {
        super();
        animalList = new ArrayList<>();
    }

    @Override
    public void load(StringReader stringReader) {
        new BufferedReader(stringReader).lines().forEach(line -> {
            String[] parts = line.split(" ");
            try {
                Class animalClass = Class.forName(parts[0]);
                Animal animal = (Animal) animalClass.getDeclaredConstructor(String.class, Integer.class)
                        .newInstance(parts[1], Integer.valueOf(parts[2]));
                animalList.add(animal);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                throw new UnknownAnimalException("Unable to create: " + parts[0], parts[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public <T> List<Animal> forEach(BiPredicate<Animal,T> predicate, T value) {
        ArrayList<Animal> tempAnimals = new ArrayList<>();
        for (Animal animal : animalList) {
            if(predicate.test(animal, value)){
                tempAnimals.add(animal);
            }
        }
        return tempAnimals;
    }
}
