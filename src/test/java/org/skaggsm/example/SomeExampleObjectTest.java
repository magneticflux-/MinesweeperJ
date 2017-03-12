package org.skaggsm.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class tests {@link SomeExampleObject} and deliberately fails to catch a mutation.
 *
 * @author Mitchell Skaggs
 */
public class SomeExampleObjectTest {
    private SomeExampleObject someExampleObject;

    @Before
    public void setUp() throws Exception {
        someExampleObject = new SomeExampleObject();
    }

    @Test
    public void whenCalledReturnTrue() throws Exception {
        assertTrue(someExampleObject.returnsTrue());
    }

    @Test
    public void whenAGreaterThanBReturnTrue() throws Exception {
        assertTrue(someExampleObject.compareIntegers(10, 5));
    }

    @Test
    public void whenALessThanBReturnTrue() throws Exception {
        assertFalse(someExampleObject.compareIntegers(-3, 4));
    }

    @Test
    public void whenAEqualToBReturnFalse() throws Exception {
        assertFalse(someExampleObject.compareIntegers(7, 7));
    }
}