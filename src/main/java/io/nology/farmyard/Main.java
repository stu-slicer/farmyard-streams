package io.nology.farmyard;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static FarmYard farmYard = new FarmYard();

    public static void main(String[] args) {

        Stream<Integer> nums = Stream.iterate( 0, a -> a + 1 );

        // forEach
//        Stream.of( 1, 2, 3,4, 5).forEach( (e) -> System.out.println(e) );

//        System.out.println(Stream.of(1, 2, 3, 4, 5).count());

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> min = integerStream.min((a, b) -> a - b);

        long answer = farmYard.getAnimals().stream()   // source
                .filter(animal -> animal.getLegs() > 2)   // intermediate
                .count();// terminal

        System.out.println(answer);

        // how many animals
        long numAnimals = farmYard.getAnimals().stream()
                .count();
        System.out.println("numAnimals = " + numAnimals);

        // age of the oldest animal
        Optional<Integer> maxAgeForAnimal = farmYard.getAnimals().stream()
                .map(animal -> animal.getAge())
                .max((a, b) -> a - b);
        System.out.println("maxAgeForAnimal = " + maxAgeForAnimal);

        // get the oldest animal
        Optional<Animal> oldestAnimal = farmYard.getAnimals().stream()
                .max((a, b) -> a.getAge() - b.getAge());

        System.out.println("oldestAnimal = " + oldestAnimal);

        // get average age of animals
        OptionalDouble averageAge = farmYard.getAnimals().stream()
                .mapToInt(animal -> animal.getAge())
                .average();
        System.out.println("averageAge = " + averageAge.getAsDouble());

        // group animals by type
        Map<AnimalType, List<Animal>> groupedByType = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(animal -> animal.getType()));
        System.out.println("groupedByType = " + mapToString(groupedByType));

        // group animals by name
        Map<String, List<Animal>> groupedByName = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(animal -> animal.getName()));
        System.out.println("groupedByName = " + mapToString(groupedByName));

        // group animals by their number of legs (?)
        Map<Integer, List<Animal>> byLegs = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(animal -> animal.getLegs()));
        System.out.println("byLegs = " + mapToString(byLegs));

        // group animals by their number of legs and then by their name
        Map<Integer, Map<String, List<Animal>>> byLegsCount = farmYard.getAnimals().stream()
                .collect(Collectors.groupingBy(animal -> animal.getLegs(),
                        Collectors.groupingBy(animal -> animal.getName())));
        System.out.println("byLegsCount = " + mapToString(byLegsCount));

        // generate a Map, with Animal as key adn name as value
        Map<Animal, String> mapByAnimalName = farmYard.getAnimals().stream()
                .collect(Collectors.toMap(
                        animal -> animal,  // generates the keys
                        animal -> animal.getName()  // generates the values
                ));
        System.out.println("mapByAnimalName = " + mapToString(mapByAnimalName));

        // generate a Map, with animal type as key and value a concatenated string of namaes
        Map<AnimalType, String> animalTypeStringMap = farmYard.getAnimals().stream()
                .collect(Collectors.toMap(
                        animal -> animal.getType(),
                        animal -> animal.getName(),
                        (prev, name) -> prev + ", " + name
                ));
        System.out.println("animalTypeStringMap = " + mapToString(animalTypeStringMap));

        // find animals of a particular type
        List<Animal> allCows = farmYard.getAnimals().stream()
                .filter(animal -> animal.getType() == AnimalType.cow)
                .collect(Collectors.toList());
        System.out.println("allCows = " + allCows);

        // find 5 eldest animals
        List<Animal> topFiveEldest = farmYard.getAnimals().stream()
                .sorted((a, b) -> b.getAge() - a.getAge())  // reversed sorting - so largest (eldest) first
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("topFiveEldest = " + topFiveEldest);

        // partition animals by ages 10 or older
        // true entry - all animals 10 or older
        // false entry - all those less than 10
        Map<Boolean, List<Animal>> partitionedByAgeOver10 = farmYard.getAnimals().stream()
                .collect(Collectors.partitioningBy(animal -> animal.getAge() >= 10));
        System.out.println("partitionedByAgeOver10 = " + mapToString( partitionedByAgeOver10 ));

        // partition animals by age 10 or older
        // within each group sort animals be name.
        // The mapping allows us to go another level, collectingAndThen takes a collector and then allows further processing using another Function
        // Function.identity() is a basic function that just returns whatever is passed to it - rather like animal -> animal
        // collectingAndThen function then takes the list, and createa another stream where it's sorted.
        Map<Boolean, List<Animal>> parititionByAgeOver10SortedAnimals = farmYard.getAnimals().stream()
                .collect(Collectors.partitioningBy(animal -> animal.getAge() >= 10,
                        Collectors.mapping(Function.identity(),
                                Collectors.collectingAndThen(Collectors.toList(),
                                        s -> s.stream().sorted().collect(Collectors.toList())
                                )
                        )
                ));
        System.out.println("parititionByAgeOver10SortedAnimals = " + mapToString(parititionByAgeOver10SortedAnimals));

        // LAST TWO are a bit CLUNKY - left them in just for reference...

        // partition animals by age 10 or older
        // within each partition convert animal to name and collect to list,
        // and then convert list to a String - could easily write your own method to concatenate nicely
        Map<Boolean, String> partitionedByAgeOver10Listed = farmYard.getAnimals().stream()
                .collect(Collectors.partitioningBy(
                        animal -> animal.getAge() >= 10,
                        Collectors.collectingAndThen( Collectors.mapping( animal -> animal.getName(), Collectors.toList() ),
                                animal -> animal.toString() )
                        ) );
        System.out.println("partitionedByAgeOver10Listed = " + mapToString( partitionedByAgeOver10Listed ));

        // partition animals by age 10 or older
        // does the same as above, but uses the groupingBy with a true/false function to group by - like partitioning.
        // Grouping by allows us to pass in a function to provide the Map used to hold the results, so can pass in a LinkedHashMap - this preserves
        // the order of the elements - so can sort the animals (by name) first and then the resulting Strings will be in name order.
        // A bit messy but shows what can be done...
        LinkedHashMap<Boolean, String> paritionedByAgeOver10SortedAndListed = farmYard.getAnimals().stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .collect(Collectors.groupingBy(animal -> animal.getAge() >= 10,
                        () -> new LinkedHashMap<Boolean, String>(),
                        Collectors.collectingAndThen(Collectors.mapping(animal1 -> animal1.getName(), Collectors.toList()),
                                strings -> strings.toString())
                ));
        System.out.println("paritionedByAgeOver10SortedAndListed = " + mapToString(paritionedByAgeOver10SortedAndListed));

    }

    private static String mapToString(Map<?, ?> map) {
        return map.entrySet().stream()
                .map(es -> es.toString())
                .collect(Collectors.joining("\n\t", "\n\t", ""));
    }

}
