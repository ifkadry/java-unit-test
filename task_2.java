import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

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
    public static Collection<Object[]> getMultiplicationData() {
        return Arrays.asList(new Object[][]{
                {2, 1, 2},
                {2, 2, 4},
                {1, 0, 0},
                {0, 0, 0},
                {-1, 0, 0},
                {-1, 2, -2}
        });
    }

    @Test
    public void shouldBeMultiplication() {
        Calculator calculator = new Calculator();
        int actual = calculator.mult(firstNumber, secondNumber);
        assertEquals(expected, actual);
    }
}