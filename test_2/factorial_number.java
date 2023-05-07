import org.junit.Test;
import org.junit.Assert;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialOfZero() {
        FactorialCalculator calc = new FactorialCalculator();
        Assert.assertEquals(1, calc.calculateFactorial(0));
    }

    @Test
    public void testCalculateFactorialOfPositiveNumber() {
        FactorialCalculator calc = new FactorialCalculator();
        Assert.assertEquals(120, calc.calculateFactorial(5));
    }

    @Test
    public void testCalculateFactorialOfNegativeNumber() {
        FactorialCalculator calc = new FactorialCalculator();
        try {
            calc.calculateFactorial(-1);
            Assert.fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

}
