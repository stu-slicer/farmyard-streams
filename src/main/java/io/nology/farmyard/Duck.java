package io.nology.farmyard;

public class Duck extends Animal {
    public Duck(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.duck;
    }
}
