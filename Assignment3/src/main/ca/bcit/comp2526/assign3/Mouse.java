package ca.bcit.comp2526.assign3;
import java.util.Objects;

public class Mouse  implements Animal {
    String name;
    int age;
    public Mouse(String a, Integer i) {
        if(a == null){
            throw new IllegalArgumentException("name cannot be null");
        }else if(a.trim().isBlank()){
            throw new IllegalArgumentException("name cannot be blank");
        }
        else if(i<0){
            throw new IllegalArgumentException("age must be >= 0, was: " +i );
        }else if(i>100){
            throw new IllegalArgumentException("age must be <= 100, was: " +i );
        }
        this.age=i;
        this.name=a;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mouse)) return true;
        Mouse mouse = (Mouse) o;
        return age == mouse.age && name.equals(mouse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getAge()
    {
        return age;
    }
}
