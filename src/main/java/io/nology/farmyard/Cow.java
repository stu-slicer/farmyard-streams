package io.nology.farmyard;

public class Cow extends Animal {

    public Cow(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.cow;
    }
}
