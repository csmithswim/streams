package com.csmithswim;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {
    public static void show(){
        //rangeClosed includes 5 while the range method doesn't include the second argument.
        //All of the methods we learned with objects applies to primitive type streams too
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);

        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.THRILLER)
        );

        //Sometimes we want to partition our stream data based upon two or more conditions
        //i.e. movies that have more than 20 likes and movies that have less than 20 likes

        var result = movies.stream()
                //We use a predicate function with the partitionBy method
                //This returns a map of a boolean to a list of movies
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(", ")));


        //Classifying these movies based on their genre
        //Using the collect method and the Collectors class and the groupingBy method
        //Using another collector called mapping because the joining method only works with strings
        //the mapping collector will map each movie to a string object
        var result = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));

        System.out.println(result);


        //Sometimes we want to store a stream within a data structure such as a list, set or map.
        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                //The joining collector concatenates the titles while the delimiter seperates them with comas
                .collect(Collectors.joining(", "))
                //Adding up all of the likes of the movies
        //summarizingInt gives you statistics related to the values in the stream
                .collect(Collectors.summarizingInt(Movie::getLikes));

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                //Adding up all of the likes of the movies
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println(result);

        //To store the actual movie value as an object
        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                //Or using a method reference
//                .collect(Collectors.toMap(Movie::getTitle, m -> m));
                //Another way of writing line 26
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));


        //This stores the name of the movie as the key and the likes as the value
        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toMap(m -> m.getTitle(), m -> m.getLikes()));
                //Or using a method reference
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));



        //The collect method alters the stream into a data structure.
        //It is overloaded and the second one that takes a collector object is the most popular
        //Collectors.toList() is a static method that converts the stream to a list.
        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toList());









        //Can also use a different parameter within reduce just for Integer objects
        Integer sum = movies.stream()
                .map(m -> m.getLikes())
                .reduce(0, Integer::sum);

        System.out.println(sum);

        //This will add all likes and store them in sum
        //Optional means if there is an empty stream it will not throw an exception
        //The get value gets the value but if there is no value it will throw an exception
        //You can call sum.orElse to supply a default value
        Optional<Integer> sum = movies.stream()
                .map(m -> m.getLikes())
                .reduce((a, b) -> a + b);
        //Line 25 can also be written as .reduce(Integer::sum);

        System.out.println(sum.orElse(0));







        var result = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();


        //This method will find the first object in the stream
        var result = movies.stream()
                //findFirst returns an optional of movie, optional class is something that is helpful to avoid null pointer exceptions
                .findFirst()
                .get();


        //Using some reducer methods
        var result = movies.stream()
                .allMatch(m -> m.getLikes() > 20);

        System.out.println(result);



        //Using the peek method we can observe the output of each operation
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: "+m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);




        //Using the distinct method
         movies.stream()
        .map(Movie::getLikes)
        //The distinct method will only return unique values and Intellij will show which intermediate method types we are using
        .distinct()
        .forEach(System.out::println);

        //One way of sorting them in reverse order
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
