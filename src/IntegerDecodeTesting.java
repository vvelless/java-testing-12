import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;


public class IntegerDecodeTesting {
    private static Class<?> testingClass;

    @Test
    public void testIsEmpty() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    public void testMinus() {
        Assertions.assertEquals(-1, Integer.decode("-1"));
        Assertions.assertEquals(-2, Integer.decode("-2"));
        Assertions.assertEquals(-3, Integer.decode("-3"));
    }

    @Test
    public void testPlus() {
        Assertions.assertEquals(1, Integer.decode("+1"));
        Assertions.assertEquals(2, Integer.decode("+2"));
        Assertions.assertEquals(3, Integer.decode("+3"));
    }

    @Test
    public void testHexRadix1() {
        Assertions.assertEquals(10, Integer.decode("0xA"));
        Assertions.assertEquals(11, Integer.decode("0xB"));
        Assertions.assertEquals(12, Integer.decode("0xC"));
        Assertions.assertEquals(16, Integer.decode("0X10"));
    }

    @Test
    public void testHexRadix2() {
        Assertions.assertEquals(10, Integer.decode("#A"));
        Assertions.assertEquals(11, Integer.decode("#B"));
        Assertions.assertEquals(12, Integer.decode("#C"));
        Assertions.assertEquals(16, Integer.decode("#10"));
    }

    @Test
    public void testOctalRadix() {
        Assertions.assertEquals(7, Integer.decode("07"));
        Assertions.assertEquals(8, Integer.decode("010"));
        Assertions.assertEquals(9, Integer.decode("011"));
        Assertions.assertEquals(17, Integer.decode("021"));
    }

    @Test
    public void testNumberFormat() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1+2"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("1 2"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("++2"));
    }

    @Test
    public void testConstant() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.toString(Integer.MIN_VALUE)));
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.toString(Integer.MAX_VALUE)));
    }

    @Test
    public void testRandomString() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Hello"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("      "));
    }

    @Test
    public void testNegativeHexValue() {
        Assertions.assertEquals(-10, Integer.decode("-#A"));
        Assertions.assertEquals(-16, Integer.decode("-0x10"));
    }

    @Test
    public void testNegativeOctalValue() {
        Assertions.assertEquals(-10, Integer.decode("-012"));
    }

    @Test
    public void testStartWithZero() {
        Assertions.assertNotEquals(12, Integer.decode("012"));
    }
}
