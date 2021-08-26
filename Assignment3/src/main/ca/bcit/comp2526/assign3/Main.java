package ca.bcit.comp2526.assign3;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.BiPredicate;


public class Main
{
    public static void main(final String[] argv)
    {
        final File file;

        file = new File("animals.txt");

        try(final Reader reader = new FileReader(file))
        {
            final AnimalLoader loader;

            loader = new DefaultAnimalLoader();
            loader.load(reader);
            print(loader, new NameStartsWithFinder(), "ca.bcit.comp2526.assign3.T");
            print(loader, new AgeGreaterThanFinder(), 2);
            print(loader, new TypeFinder(), Mouse.class);
        }
        catch(final IOException ex)
        {
            System.err.println("Can't find file: " + file.getAbsolutePath());
        }
        catch(final UnknownAnimalException ex)
        {
            System.err.println("Unknown animal");
        }
    }

    private static <T> void print(final AnimalLoader loader,
                                  final BiPredicate<Animal, T> predicate,
                                  final T value)
    {
        final List<Animal> animals;

        animals = loader.forEach(predicate, value);

        animals.forEach(
            (animal -> System.out.printf("%s %d %n", animal.getName(), animal.getAge())));
        System.out.println("---");
    }
}
