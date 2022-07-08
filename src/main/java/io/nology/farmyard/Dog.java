package io.nology.farmyard;

public class Dog extends Animal {
    public Dog(String name, int age, int legs) {
        super(name, age, legs);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.dog;
    }
}
