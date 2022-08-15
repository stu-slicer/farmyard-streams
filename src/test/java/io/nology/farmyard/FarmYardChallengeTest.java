package io.nology.farmyard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FarmYardChallengeTest {

    public static final Cow CYBIL_COW = new Cow("Cybil", 6, 4 );
    public static final Cow DAISY_COW = new Cow("Daisy", 5, 4 );
    public static final Cow GEORGIA_COW = new Cow("Georgia", 3, 4 );
    public static final Cow KATE_COW = new Cow("Kate", 8, 4 );
    public static final Cow WENDY_COW = new Cow("Wendy", 4, 4 );

    public static final Chicken KATRINA_CHICKEN = new Chicken("Katrina", 15, 2 );
    public static final Chicken DAISY_CHICKEN = new Chicken("Daisy", 10, 2 );
    public static final Chicken WENDY_CHICKEN = new Chicken("Wendy", 14, 2 );
    public static final Chicken KATE_CHICKEN = new Chicken("Kate", 8, 2 );
    public static final Chicken JILL_CHICKEN = new Chicken("Jill", 8, 2 );
    public static final Chicken JENNY_CHICKEN = new Chicken("Jenny", 7, 2 );

    public static final Duck DAFFY_DUCK = new Duck("Daffy", 5, 2 );
    public static final Duck DONALD_DUCK = new Duck("Donald", 6, 2 );
    public static final Duck GEORGIA_DUCK = new Duck("Georgina", 7, 2 );
    public static final Duck ROGER_DUCK = new Duck("Roger", 4, 2 );
    public static final Duck FREDDIE_DUCK = new Duck("Freddie", 5, 2 );

    public static final Horse BRIAN_HORSE = new Horse("Brian", 15, 4 );
    public static final Horse DAISY_HORSE = new Horse("Daisy", 12, 4 );
    public static final Horse MICHAEL_HORSE = new Horse("Michael", 10, 4 );

    public static final Cat SCOOBY_CAT = new Cat("Scooby", 9, 4 );
    public static final Cat TIDDLES_CAT = new Cat("Tiddles", 12, 3 );

    public static final Dog SHEP_DOG = new Dog("Shep", 8, 4 );

    private FarmYardChallenge target;

    @BeforeEach
    void setUp() {
        this.target = new FarmYardChallenge();
    }

    @Test
    void getAnimalCount() {
        assertEquals(22, this.target.getAnimalCount());
    }

    @Test
    void getCowCount() {
        assertEquals(5, this.target.getCowCount());
    }

    @Test
    void getAnimalCountForType() {
        assertEquals(5, this.target.getAnimalCountForType(AnimalType.cow));
        assertEquals(6, this.target.getAnimalCountForType(AnimalType.chicken));
        assertEquals(5, this.target.getAnimalCountForType(AnimalType.duck));
        assertEquals(3, this.target.getAnimalCountForType(AnimalType.horse));
        assertEquals(2, this.target.getAnimalCountForType(AnimalType.cat));
        assertEquals(1, this.target.getAnimalCountForType(AnimalType.dog));
    }

    @Test
    void getAnimalsWithNameBeginningWith() {
        assertEquals(3, this.target.getAnimalsWithNameBeginningWith("dai") );
        assertEquals(5, this.target.getAnimalsWithNameBeginningWith("d") );
    }

    @Test
    void getYoungestAnimal() {
        assertEquals(GEORGIA_COW, target.getYoungestAnimal() );
    }

    @Test
    void getOldestAnimal() {
        assertEquals(KATRINA_CHICKEN, target.getOldestAnimal() );
        System.out.println(this.target.getOldestAnimals());
    }

    @Test
    void getOldestAnimals() {
        assertEquals( List.of( KATRINA_CHICKEN, BRIAN_HORSE), target.getOldestAnimals() );
    }

    @Test
    void getAnimalsForType() {
        assertEquals( List.of( CYBIL_COW, DAISY_COW, GEORGIA_COW, KATE_COW, WENDY_COW), target.getAnimalsForType(AnimalType.cow) );
        assertEquals( List.of( DAISY_CHICKEN, JENNY_CHICKEN, JILL_CHICKEN, KATE_CHICKEN, KATRINA_CHICKEN, WENDY_CHICKEN), target.getAnimalsForType(AnimalType.chicken) );
        assertEquals( List.of( DAFFY_DUCK, DONALD_DUCK, FREDDIE_DUCK, GEORGIA_DUCK, ROGER_DUCK), target.getAnimalsForType(AnimalType.duck) );
        assertEquals( List.of( SHEP_DOG), target.getAnimalsForType(AnimalType.dog) );
        assertEquals( List.of( SCOOBY_CAT, TIDDLES_CAT), target.getAnimalsForType(AnimalType.cat) );
    }

    @Test
    void getCountsOfAnimalsByType() {
        Map<AnimalType, Long> result = target.getCountsOfAnimalsByType();
        assertEquals( 5, result.get(AnimalType.cow));
        assertEquals( 6, result.get(AnimalType.chicken));
        assertEquals( 5, result.get(AnimalType.duck));
        assertEquals( 3, result.get(AnimalType.horse));
        assertEquals( 1, result.get(AnimalType.dog));
        assertEquals( 2, result.get(AnimalType.cat));
    }

    @Test
    void getMapOfAnimalsByType() {
        Map<AnimalType, List<Animal>> result = target.getMapOfAnimalsByType();
        assertEquals( List.of( CYBIL_COW, DAISY_COW, GEORGIA_COW, KATE_COW, WENDY_COW), result.get(AnimalType.cow) );
        assertEquals( List.of( DAISY_CHICKEN, JENNY_CHICKEN, JILL_CHICKEN, KATE_CHICKEN, KATRINA_CHICKEN, WENDY_CHICKEN), result.get(AnimalType.chicken) );
        assertEquals( List.of( DAFFY_DUCK, DONALD_DUCK, FREDDIE_DUCK, GEORGIA_DUCK, ROGER_DUCK), result.get(AnimalType.duck) );
        assertEquals( List.of( BRIAN_HORSE, DAISY_HORSE, MICHAEL_HORSE), result.get(AnimalType.horse) );
        assertEquals( List.of( SHEP_DOG), result.get(AnimalType.dog) );
        assertEquals( List.of( SCOOBY_CAT, TIDDLES_CAT), result.get(AnimalType.cat) );
    }

}