package app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class DivideTest {

    @Test
    public void testOperation() {
        assertEquals(3.0, new Divide().operation(9, 3));
    }
}