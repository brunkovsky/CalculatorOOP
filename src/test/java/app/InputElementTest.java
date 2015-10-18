package app;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class InputElementTest {

    @Test
    public void testInputOperand() {
        String input1 = "5\n";
        String input2 = "3.22\n";
        String input3 = "0\n";
        String input4 = "some invalid string\n-43.5\n";
        String input5 = "\n";

        assertEquals(5.0, new InputElement().inputOperand(12.3, new Scanner(input1)));
        assertEquals(3.22, new InputElement().inputOperand(12.3, new Scanner(input2)));
        assertEquals(0.0, new InputElement().inputOperand(12.3, new Scanner(input3)));
        assertEquals(-43.5, new InputElement().inputOperand(12.3, new Scanner(input4)));
        assertEquals(12.3, new InputElement().inputOperand(12.3, new Scanner(input5)));
    }

    @Test
    public void testInputSign() {
        String inputY = "y\n";
        String inputN = "n\n";
        String inputHY= "h\ny\n";
        String inputHN= "h\nn\n";
        String inputSomeInvalidString= "some invalid string\ny\n";

        Set<Character> set = new HashSet<>();
        Character yCharacter = 'y';
        Character nCharacter = 'n';
        set.add('y');
        set.add('n');

        assertEquals(yCharacter, new InputElement().inputSign(set, new Scanner(inputY)));
        assertEquals(nCharacter, new InputElement().inputSign(set, new Scanner(inputN)));
        assertEquals(yCharacter, new InputElement().inputSign(set, new Scanner(inputHY)));
        assertEquals(nCharacter, new InputElement().inputSign(set, new Scanner(inputHN)));
        assertEquals(yCharacter, new InputElement().inputSign(set, new Scanner(inputSomeInvalidString)));
    }

    @Test
    public void testFillAnswerSet() throws Exception {
        Input testInput = new InputElement();

        assertEquals(false, testInput.fillAnswerSet('y'));
        assertEquals(false, testInput.fillAnswerSet('n'));
        assertEquals(true, testInput.fillAnswerSet('o'));
    }
}
