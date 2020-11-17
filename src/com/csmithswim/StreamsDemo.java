package com.csmithswim;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show(){
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );

        movies.stream()
              .sorted(Comparator.comparing(Movie::getTitle).reversed())
              .forEach(m -> System.out.println(m.getTitle()));





        //Using the takeWhile method
//        movies.stream()
//                .takeWhile(m -> m.getLikes() < 30)
//                .forEach(m -> System.out.println(m.getTitle()));

        //This example using skip/limit
//        100 movies
//        10 movies per page
//        3rd page
//        skip(20) = skip( (page - 1) x pageSize )
//        limit(10) = limit(pageSize)

//        movies.stream()
//                //Returns a stream, so it is an intermediate operation
//                //This limits the return to 10 movies
//                //Skip 20 movie objects
//                .skip(20)
//                .limit(10)
//                .forEach(m -> System.out.println(m.getTitle()));

//        Predicate<Movie> isPopular = m -> m.getLikes() > 10;
//
//        movies.stream()
//                .filter(isPopular)
//                .forEach(m -> System.out.println(m.getTitle()));

        //Stream<List<x>> -> Stream<x>
        //Flat map flattens a stream
//        var stream = Stream.of(List.of(1,2,3), List.of(4,5,6));
//        stream
//              .flatMap(list -> list.stream())
//              .forEach(list -> System.out.println(list));

        //Getting a stream of just movie titles using map
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//        movies.stream()
//                //The function that gets passed to the map method gets applied to every object in the stream
//                .map(movie -> movie.getTitle())
//                .forEach(name -> System.out.println(name));

//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//
//        //Imperative programming
//        int count = 0;
//        for (var movie : movies)
//            if (movie.getLikes() > 10)
//                count++;
//
//        //Example of Declarative (Functional) programming
//        //Every collection in java has a method called stream that returns a stream of objects
//        //A stream is a sequence of objects, it doesn't store data.
//        var count2 = movies.stream()
//                //the stream ofject has the filter method
//                .filter(movie -> movie.getLikes() > 10)
//                .count();
    }
}
