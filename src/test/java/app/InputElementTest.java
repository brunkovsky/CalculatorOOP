package app;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputElementTest {

    @Test
    public void testMyInputOperand() {
        String input1 = "5\n";
        String input2 = "3.22\n";
        String input3 = "0\n";
        String input4 = "some invalid string\n-43.5\n";
        String input5 = "\n";
        assertEquals(5.0, new InputElement().myInputOperand(12.3, new Scanner(input1)));
        assertEquals(3.22, new InputElement().myInputOperand(12.3, new Scanner(input2)));
        assertEquals(0.0, new InputElement().myInputOperand(12.3, new Scanner(input3)));
        assertEquals(-43.5, new InputElement().myInputOperand(12.3, new Scanner(input4)));
        assertEquals(12.3, new InputElement().myInputOperand(12.3, new Scanner(input5)));
    }

    @Test
    public void testMyInputSign() {
        String inputY = "y\n";
        String inputN = "n\n";
        String inputHY= "h\ny\n";
        String inputHN= "h\nn\n";
        String inputSomeInvalidString= "some invalid string\ny\n";
        Set<Character> set = new HashSet<>();
        set.add('y');
        set.add('n');
        assertThat("must be 'y'", new InputElement().myInputSign(set, new Scanner(inputY)) == 'y');
        assertThat("must be 'n'", new InputElement().myInputSign(set, new Scanner(inputN)) == 'n');
        assertThat("must be 'y'", new InputElement().myInputSign(set, new Scanner(inputHY)) == 'y');
        assertThat("must be 'y'", new InputElement().myInputSign(set, new Scanner(inputHN)) == 'n');
        assertThat("must be 'y'", new InputElement().myInputSign(set, new Scanner(inputSomeInvalidString)) == 'y');
    }
}
