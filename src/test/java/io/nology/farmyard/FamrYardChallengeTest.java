package io.nology.farmyard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamrYardChallengeTest {

    private FamrYardChallenge target;

    @BeforeEach
    void setUp() {
        this.target = new FamrYardChallenge();
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
        System.out.println(this.target.getYoungestAnimal());
        System.out.println(this.target.getYoungestAnimals());
    }

    @Test
    void getYoungestAnimals() {
    }

    @Test
    void getOldestAnimal() {
        System.out.println(this.target.getOldestAnimal());
        System.out.println(this.target.getOldestAnimals());
    }

    @Test
    void getOldestAnimals() {
    }

    @Test
    void getAnimalsForType() {
    }

    @Test
    void getCountsOfAnimalsByType() {
    }

    @Test
    void getMapOfAnimalsByType() {
    }
}