package io.nology.farmyard;

import java.util.Comparator;

public class SortByAgeThenName implements Comparator<Animal> {

    @Override
    public int compare(Animal left, Animal right) {
        if( left.getAge() == right.getAge() ) {
            left.getName().compareTo( right.getName() );
        }
        return left.getAge() - right.getAge();
    }

}
