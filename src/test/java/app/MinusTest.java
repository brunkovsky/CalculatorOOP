package app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinusTest {

    @Test
    public void testOperation() {
        assertEquals(1.0, new Calculator.Minus().operation(5, 4));
    }
}