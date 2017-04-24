/*
 * Copyright (C) 2017 Mitchell Skaggs
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.skaggsm.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Optional;

/**
 * @author Mitchell Skaggs
 */
public class ThrowsException extends TypeSafeMatcher<Runnable> {

    private final Class<? extends Throwable> expectedExceptionType;
    private Throwable recievedException;

    public ThrowsException(Class<? extends Throwable> expectedExceptionType) {
        this.expectedExceptionType = expectedExceptionType;
    }

    public static Matcher<Runnable> doesThrow(Class<? extends Throwable> expectedExceptionType) {
        return new ThrowsException(expectedExceptionType);
    }

    @Override
    protected boolean matchesSafely(Runnable item) {
        try {
            item.run();
        } catch (Throwable t) {
            recievedException = t;
            return expectedExceptionType.isInstance(t);
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a runnable throwing \"")
                .appendText(expectedExceptionType.getName())
                .appendText("\"");
    }

    @Override
    protected void describeMismatchSafely(Runnable item, Description mismatchDescription) {
        mismatchDescription.appendText(
                Optional.ofNullable(recievedException)
                        .map(Object::toString)
                        .map(s -> '\"' + s + '\"')
                        .orElse("no exception"))
                .appendText(" thrown");
    }
}
