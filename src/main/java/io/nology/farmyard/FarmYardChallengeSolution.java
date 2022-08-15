package io.nology.farmyard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FarmYardChallengeSolution {

    private FarmYard farmYard;
    private final List<Animal> animals;

    public FarmYardChallengeSolution() {
        this.farmYard = new FarmYard();
        animals = farmYard.getAnimals();
    }

    /**
     * Get the total number of animals in the farm yard
     * @return the total number of animals in the farm yard
     */
    public int getAnimalCount() {
        return (int) this.animals.stream().count();
    }

    /**
     * The total number of cows in the farm yard.
     * @return
     */
    public int getCowCount() {
        return (int) this.animals.stream()
                .filter( animal -> animal.getType() == AnimalType.cow )
                .count();
    }

    /**
     * Get total number of animals for the given type.
     * @param type
     * @return
     */
    public int getAnimalCountForType(AnimalType type) {
        return (int) this.animals.stream()
                .filter( animal -> animal.getType() == type )
                .count();
    }

    /**
     * Get total number of animals whose name begins with the given prefix
     * @param prefix
     * @return
     */
    public int getAnimalsWithNameBeginningWith(String prefix) {
        return (int) this.animals.stream()
                .filter( animal -> animal.getName().toLowerCase().startsWith(prefix.toLowerCase().trim()) )
                .count();
    }

    /**
     * Get the youngest animal, based on age. If more than one is the youngest then just return the first
     * @return
     */
    public Animal getYoungestAnimal() {
        return this.animals.stream()
                .sorted( (a, b) -> a.getAge() - b.getAge() )
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the oldest animal. If more than one is the eldest then just return the first
     * @return
     */
    public Animal getOldestAnimal() {
        return this.animals.stream()
                .sorted( (a, b) -> b.getAge() - a.getAge() )
                .findFirst()
                .orElse(null);
    }

    /**
     * Get the oldest animals, in a List.
     * You will have to do this in two stages, using streams for both!
     * @return
     */
    public List<Animal> getOldestAnimals() {
        int eldestAge = this.animals.stream()
                .mapToInt(animal -> animal.getAge())
                .max().getAsInt();
        return this.animals.stream()
                .filter( animal -> animal.getAge() == eldestAge )
                .collect(Collectors.toList());
    }

    /**
     * Get a list of all animals of the given type.
     * Order the results by name.
     * @param type
     * @return
     */
    public List<Animal> getAnimalsForType(AnimalType type) {
        return this.animals.stream()
                .filter( animal -> animal.getType() == type )
                .sorted( (a,b) -> a.getName().compareTo( b.getName() ) )
                .collect(Collectors.toList());
    }

    public Map<AnimalType, Long> getCountsOfAnimalsByType() {
        return this.animals.stream()
                .collect( Collectors.groupingBy( animal -> animal.getType(),
                        Collectors.counting() ) );
    }

    public Map<AnimalType, List<Animal>> getMapOfAnimalsByType() {
        return this.animals.stream()
                .sorted( (a,b) -> a.getName().compareTo( b.getName() ))
                .collect( Collectors.groupingBy( animal -> animal.getType(),
                        Collectors.toList()
                ) );
    }

}
