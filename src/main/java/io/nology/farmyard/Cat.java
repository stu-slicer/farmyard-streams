package io.nology.farmyard;

public class Cat extends Animal {
    public Cat(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.cat;
    }
}
