package io.nology.farmyard;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static FarmYard farmYard = new FarmYard();

    public static void main(String[] args) {

        // how many animals?
        long animalCount = farmYard.getAnimals().stream()
                .count();
        System.out.println("Animal count: " + animalCount);

        // oldest age
        Optional<Integer> oldestAge = farmYard.getAnimals().stream()
                .map(Animal::getAge)
                .max(Comparator.naturalOrder());
        System.out.println("Oldest age: " + oldestAge.orElse(0));

        // youngest animal
        Optional<Integer> youngestAge = farmYard.getAnimals().stream()
                .map(Animal::getAge)
                .min(Comparator.naturalOrder());

        System.out.println("Youngest age: " + youngestAge.orElse(0));

        OptionalInt youngestAge2 = farmYard.getAnimals().stream()
                .map(Animal::getAge)
                .mapToInt( Integer::intValue )
                .min();

        System.out.println("Youngest age 2: " + youngestAge2.orElse(0));

        // oldest animal
        Optional<Animal> oldestAnimal = farmYard.getAnimals().stream()
                .max( (a,b) -> a.getAge() - b.getAge() );
        System.out.println("Oldest animal: " + oldestAnimal.orElse(null));

        // youngest animal
        Optional<Animal> youngestAnimal = farmYard.getAnimals().stream()
                .min( (a,b) -> a.getAge() - b.getAge() );
        System.out.println("Youngest animal: " + youngestAnimal.orElse(null));

        // by type. with a name list
        Map<AnimalType, String> byTypeMap = farmYard.getAnimals().stream()
                .collect(Collectors.toMap(A -> A.getType(), A -> A.getName(), (a, b) -> {
                    return a + ", " + b;
                }));
        System.out.println("Map by type: " + byTypeMap);

        OptionalDouble averageAge = farmYard.getAnimals().stream()
                .mapToInt(Animal::getAge)
                .average();
        System.out.println("Average age: " + averageAge.getAsDouble());

        OptionalDouble averageLegs = farmYard.getAnimals().stream()
                .mapToInt(Animal::getLegs)
                .average();
        System.out.println("Average legs: " + averageLegs.getAsDouble());

        Map<AnimalType, List<Animal>> byTypeGrouping = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(A -> A.getType()));
        System.out.println("Group by type: " + byTypeGrouping);

        Map<String, Long> numberByName = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(Animal::getName, Collectors.counting()));
        System.out.println("Number by name: " + numberByName);

    }
}
