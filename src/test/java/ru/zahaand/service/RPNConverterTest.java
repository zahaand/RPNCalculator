package ru.zahaand.service;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class RPNConverterTest {
    static Reader reader;
    static Converter converter;

    @BeforeEach
    void setUp() {
        reader = Mockito.mock(Reader.class);
        converter = new RPNConverter();
    }

    @Test
    void returnReversePolishNotationMathExpression() {
        Mockito.when(reader.read()).thenReturn("10 - 7 + 10");
        String[] answer = converter.convert("10 - 7 + 10");

        Assert.assertTrue(Arrays.equals(new String[]{"10", "7", "-", "10", "+"}, answer));
    }

    @Test
    void returnRPNMathExpressionMainOperationFirst() {
        Mockito.when(reader.read()).thenReturn("3 * 7 + 10");
        String[] answer = converter.convert("3 * 7 + 10");

        Assert.assertTrue(Arrays.equals(new String[]{"3", "7", "*", "10", "+"}, answer));
    }

    @Test
    void returnRPNMathExpressionMainOperationSecond() {
        Mockito.when(reader.read()).thenReturn("3 + 7 * 10");
        String[] answer = converter.convert("3 + 7 * 10");

        Assert.assertTrue(Arrays.equals(new String[]{"3", "7", "10", "*", "+"}, answer));
    }

    @Test
    void returnRPNMathExpressionWithBrasses() {
        Mockito.when(reader.read()).thenReturn("(3 + 7) - 5");
        String[] answer = converter.convert("(3 + 7) * 5");

        Assert.assertTrue(Arrays.equals(new String[]{"3", "7", "+", "5", "*"}, answer));
    }

    @Test
    void returnRPNMathExpressionWithNegativeNumbers() {
        Mockito.when(reader.read()).thenReturn("(-3 + 7) + (-5)");
        String[] answer = converter.convert("(-3 + 7) + (-5)");

        Assert.assertTrue(Arrays.equals(new String[]{"0", "3", "-", "7", "+", "0", "5", "-", "+"}, answer));
    }
}