package ru.zahaand;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CalculatorTest {
    @Test
    void returnAnswerToSimpleMathExpression() {
        Reader reader = Mockito.mock(Reader.class);
        Converter converter = Mockito.mock(Converter.class);
        Calculator calculator = new Calculator(reader, converter);
        double answer = calculator.calculate();
        Assert.assertEquals(10.0, answer);
    }
}
