Streams - allow us to process a collection of data in a declarative way, similar to SQL queries.

Streams - to process a collection of data in a declarative way.

SQL is an example of a declarative programming paradigm.

You can create streams from collections, from arrays, from an arbitrary number of objects, infinite/finite streams.

map() and flatMap() can transform values in a stream.

Intermediate operations - map() and filter() return a new stream/pipe.

Terminal operations - forEach() methods that start consuming a stream.

Slicing streams has four methods.

limit(n) - limits the number of elements in a stream.

skip(n) - skips the number of elements in a stream, this is useful for pagination.

takeWhile(predicate) - As long as this condition is true, keep taking elements from a stream. It stops immediately when it meets the boolean condition
and will not apply it to other ones on higher indexes. 

dropWhile(predicate) - Opposite of takeWhile method.

Streams come in the same order that they were created, i.e. if you are using a stream of objects in order abc, they come in abc.

You can adjust the order of them using the sorted method.






