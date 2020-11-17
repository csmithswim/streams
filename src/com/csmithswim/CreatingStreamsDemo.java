package com.csmithswim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show() {
        //Creating a stream from an arbitrary number of objects.
        Stream.of(1, 2, 3, 4);

        //One way of generating infinite streams
        //It would generate an infinite stream of random numbers
        //AKA lazy evaluation
        var stream = Stream.generate(() -> Math.random())
        stream.limit(3)
                .forEach(n -> System.out.println(n));

        //Another way to generate infinite streams is using the iterate method
        //Takes two parameter, the first one is a seed or initial value and the next is an unary operator
        Stream.iterate(1, n -> n +1)
                .limit(10)
                .forEach(n -> System.out.println(n));

        //How to access and print entries in an array
        int[] numbers = {1, 2, 3, };
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n));
    }
}
