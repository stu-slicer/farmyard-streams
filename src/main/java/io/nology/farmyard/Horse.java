package io.nology.farmyard;

public class Horse extends Animal {
    public Horse(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.horse;
    }
}
