package ru.empyros.web;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Decorated matcher for type-safe checking.
 *
 * @param <C> type
 */
public class DecoratedMatcher<C> extends BaseMatcher<C> {

    private Matcher decoratedMatcher;

    public DecoratedMatcher(Matcher decoratedMatcher) {
        this.decoratedMatcher = decoratedMatcher;
    }

    @Override
    public boolean matches(Object item) {
        return decoratedMatcher.matches(item);
    }

    @Override
    public void describeTo(Description description) {
        decoratedMatcher.describeTo(description);
    }
}
