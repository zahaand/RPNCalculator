package ru.zahaand;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatorTest {
    static Reader reader;
    static Converter converter;
    static Calculator calculator;

    @BeforeAll
    static void setUp() {
        reader = Mockito.mock(Reader.class);
        converter = Mockito.mock(Converter.class);
        calculator = new Calculator(reader, converter);
    }

    @Test
    void returnSumOfTwoNumbers() {
        Mockito.when(reader.read()).thenReturn("3+7");
        Mockito.when(converter.convert("3+7")).thenReturn(new String[]{"3", "7", "+"});
        double answer = calculator.calculate();

        Assert.assertEquals(10.0, answer);
    }

    @Test
    void returnDifferenceOfTwoNumbers() {
        Mockito.when(reader.read()).thenReturn("7-3");
        Mockito.when(converter.convert("7-3")).thenReturn(new String[]{"7", "3", "-"});
        double answer = calculator.calculate();

        Assert.assertEquals(4.0, answer);
    }
}
