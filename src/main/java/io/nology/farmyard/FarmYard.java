package io.nology.farmyard;

import java.util.ArrayList;
import java.util.List;

public class FarmYard {

    List<Animal> animals = new ArrayList<>();

    public FarmYard() {
        populateAnimals();
    }

    public List<Animal> getAnimals() {
        return List.copyOf( animals );
    }

    private void populateAnimals() {

        animals.add( new Cow("Daisy", 5, 4 ));
        animals.add( new Cow("Wendy", 4, 4 ));
        animals.add( new Cow("Georgia", 3, 4 ));
        animals.add( new Cow("Cybil", 6, 4 ));
        animals.add( new Cow("Kate", 8, 4 ));

        animals.add( new Chicken("Daisy", 10, 2 ));
        animals.add( new Chicken("Katrina", 15, 2 ));
        animals.add( new Chicken("Wendy", 14, 2 ));
        animals.add( new Chicken("Kate", 8, 2 ));
        animals.add( new Chicken("Jill", 8, 2 ));
        animals.add( new Chicken("Jenny", 7, 2 ));

        animals.add( new Duck("Daffy", 5, 2 ));
        animals.add( new Duck("Donald", 6, 2 ));
        animals.add( new Duck("Georgina", 7, 2 ));
        animals.add( new Duck("Roger", 4, 2 ));
        animals.add( new Duck("Freddie", 5, 2 ));

        animals.add( new Horse("Daisy", 12, 4 ));
        animals.add( new Horse("Brian", 15, 4 ));
        animals.add( new Horse("Michael", 10, 4 ));

        animals.add( new Dog("Shep", 8, 4 ));

        animals.add( new Cat("Scooby", 9, 4 ));
        animals.add( new Cat("Tiddles", 12, 3 ));


    }

}
