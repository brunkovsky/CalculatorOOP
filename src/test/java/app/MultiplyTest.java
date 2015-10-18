package app;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MultiplyTest {

    @Test
    public void testOperation() {
        assertEquals(12.0, new Calculator.Multiply().operation(3, 4));
    }
}