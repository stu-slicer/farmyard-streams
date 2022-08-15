package io.nology.farmyard;

import java.util.List;

public class Main {

    private static FarmYard farmYard = new FarmYard();

    public static void main(String[] args) {

        List<Animal> animals = farmYard.getAnimals();

        long count = animals.stream()
                .filter( animal -> animal.getLegs() > 2 )
                .count();
    }

}
