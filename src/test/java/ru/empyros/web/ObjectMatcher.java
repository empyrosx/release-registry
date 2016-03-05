package ru.empyros.web;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.function.Function;

/**
 * Matcher for comparing different type with convenient converters.
 *
 * @param <E> type of expected object
 * @param <A> type of actual object
 * @param <C> type for comparing
 */
public class ObjectMatcher<E, A, C> extends BaseMatcher<C> {

    private E expected;
    private Function<A, E> actualConverter;
    private Function<E, C> comparingConverter;

    /**
     * Constructs matcher with expected value and convertes.
     *
     * @param expected           expected value
     * @param actualConverter    converter for transforming actual result from its type to type of excepted object
     * @param comparingConverter converter for transforming expected and actual objects to type for comparing
     */
    public ObjectMatcher(E expected, Function<A, E> actualConverter, Function<E, C> comparingConverter) {
        this.expected = expected;
        this.actualConverter = actualConverter;
        this.comparingConverter = comparingConverter;
    }

    @Override
    public boolean matches(Object o) {
        E actual = actualConverter.apply((A) o);
        return compare(expected, actual);
    }

    private boolean compare(E expected, E actual) {
        C expectedResult = comparingConverter.apply(expected);
        C actualResult = comparingConverter.apply(actual);
        return expectedResult.equals(actualResult);
    }

    @Override
    public void describeTo(Description description) {
        // some hack to align text in output (4 spaces equals "was ")
        description.appendText("    ").appendValue(JsonUtil.writeValue(expected));
    }
}