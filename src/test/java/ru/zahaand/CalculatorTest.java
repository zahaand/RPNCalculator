package ru.zahaand;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatorTest {
    @Test
    void returnSumOfTwoNumbers() {
        Reader reader = Mockito.mock(Reader.class);
        Converter converter = Mockito.mock(Converter.class);
        Calculator calculator = new Calculator(reader, converter);

        Mockito.when(reader.read()).thenReturn("3+7");
        Mockito.when(converter.convert("3+7")).thenReturn(new String[]{"3", "7", "+"});
        double answer = calculator.calculate();

        Assert.assertEquals(10.0, answer);
    }
}
