package io.nology.farmyard;

import java.util.Objects;
import java.util.StringJoiner;

public abstract class Animal implements Comparable<Animal> {

    private String name;
    private int age;
    private int legs = 4;

    public Animal(String name, int age, int legs) {
        this.name = name;
        this.age = age;
        this.legs = legs;
    }

    public abstract AnimalType getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Animal o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Animal.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("legs=" + legs)
                .toString();
    }
}
