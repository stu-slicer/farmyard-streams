package io.nology.farmyard;

import java.util.stream.Stream;

public class Main {

    private static FarmYard farmYard = new FarmYard();

    public static void main(String[] args) {

        Stream<Integer> ints = Stream.of( 1, 2, 3, 4 );
        Stream<String> strings = Stream.of( "Josie", "Jake" );

        Stream<Integer> lotsOfInts = Stream.iterate( 0, (a) ->  a + 1 );
        Stream<Integer> someInts = Stream.iterate( 0, a -> a < 10, a -> a + 1 );

        Stream<Double> doubles = Stream.generate( () -> Math.random() ); // infinite

    }
}
