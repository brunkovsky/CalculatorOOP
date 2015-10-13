package app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MultiplyTest {

    @Test
    public void testOperation() {
        assertEquals(12.0, new Multiply().operation(3, 4));
    }
}