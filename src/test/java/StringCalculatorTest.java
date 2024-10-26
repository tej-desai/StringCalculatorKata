import org.example.StringCalculator;
import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringC = new StringCalculator();

    @Test
    public void testEmptyString(){
        assertEquals(0, stringC.add(""));
    }

    @Test
    public void testSingleNumber(){
        assertEquals(5,stringC.add("5"));
    }

    @Test
    public void testCommaSeparatedNumbers(){
        assertEquals(4, stringC.add("3,1"));
    }

    @Test
    public void testNewLineNumbers(){
        assertEquals(9, stringC.add("1,2\n6"));
    }

    @Test
    public void testDifferentDelimiter(){
        assertEquals(3, stringC.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumberException(){
//        exception.expect();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {stringC.add("//:\n1:-6");});
        assertEquals("negative numbers not allowed", exception.getMessage());
    }
}
