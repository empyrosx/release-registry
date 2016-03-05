package ru.empyros.web;

import org.hamcrest.Matcher;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Utility class for creating custom matchers.
 */
public class Matchers {

    /**
     * Creates custom matcher for comparing objects.
     *
     * @param expected           expected object
     * @param actualConverter    converter for transforming actual result from type A to type of expected object E
     * @param comparingConverter converter for transforming object of source type E to comparing type C
     * @param <E>                generic type for expected result
     * @param <A>                generic type for actual result
     * @param <C>                generic type for comparing type
     * @return matcher for comparing objects
     */
    public static <E, A, C> Matcher<C> matcher(E expected
            , Function<A, E> actualConverter
            , Function<E, C> comparingConverter) {

        return new DecoratedMatcher<>(
                new ObjectMatcher<>(expected
                        , actualConverter
                        , comparingConverter)
        );
    }
    /**
     * Creates custom matcher for comparing list of objects.
     *
     * @param expected           expected list of objects
     * @param actualConverter    converter for transforming actual result from type A to type of expected object E
     * @param comparingConverter converter for transforming one object of source type E to comparing type C
     * @param <E>                generic type for expected result
     * @param <A>                generic type for actual result
     * @param <C>                generic type for comparing type
     * @return matcher for comparing list of objects
     */
    public static <E, A, C> Matcher<C> listMatcher(List<E> expected
            , Function<A, List<E>> actualConverter
            , Function<E, C> comparingConverter) {

        return new DecoratedMatcher<>(
                new ObjectMatcher<>(expected
                        , actualConverter
                        , list -> list.stream().map(comparingConverter).collect(toList()))
        );
    }
}