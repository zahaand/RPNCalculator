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

    @Test
    void returnMultiplicationOfTwoNumbers() {
        Mockito.when(reader.read()).thenReturn("3*2");
        Mockito.when(converter.convert("3*2")).thenReturn(new String[]{"3", "2", "*"});
        double answer = calculator.calculate();

        Assert.assertEquals(6.0, answer);
    }

    @Test
    void returnDivisionOfTwoNumbers() {
        Mockito.when(reader.read()).thenReturn("6/3");
        Mockito.when(converter.convert("6/3")).thenReturn(new String[]{"6", "3", "/"});
        double answer = calculator.calculate();

        Assert.assertEquals(2.0, answer);
    }


}
