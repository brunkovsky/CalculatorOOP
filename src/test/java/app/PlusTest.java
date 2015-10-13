package app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlusTest {

    @Test
    public void testOperation() {
        assertEquals(10.0, new Plus().operation(4, 6));
    }
}
