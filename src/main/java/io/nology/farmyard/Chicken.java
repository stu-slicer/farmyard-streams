package io.nology.farmyard;

public class Chicken extends Animal {
    public Chicken(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.chicken;
    }
}
