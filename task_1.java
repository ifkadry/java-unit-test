import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int mult(int a, int b) {
        return a * b;
    }
}

@RunWith(Parameterized.class)
public class CalculatorTest {
    private final int firstNumber;
    private final int secondNumber;
    private final int expected;

    public CalculatorTest(int firstNumber, int secondNumber, int expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {1, 2, 3},
                {2, 3, 6},
                {-1, 1, 0}
        };
    }

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.sum(firstNumber, secondNumber));
    }

    @Test
    public void testMult() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.mult(firstNumber, secondNumber));
    }
}
