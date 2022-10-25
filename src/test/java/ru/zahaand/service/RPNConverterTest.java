package ru.zahaand.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RPNConverterTest {
    static Reader reader;
    static Converter converter;

    @BeforeAll
    static void setUp() {
        reader = Mockito.mock(Reader.class);
        converter = new RPNConverter();
    }

    @Test
    void returnReversePolishNotationMathExpression() {
        Mockito.when(reader.read()).thenReturn("10 - 7 + 10");
        String[] answer = converter.convert("10 - 7 + 10");

        assertArrayEquals(new String[]{"10", "7", "-", "10", "+"}, answer);
    }

    @Test
    void returnRPNMathExpressionMainOperationFirst() {
        Mockito.when(reader.read()).thenReturn("3 * 7 + 10");
        String[] answer = converter.convert("3 * 7 + 10");

        assertArrayEquals(new String[]{"3", "7", "*", "10", "+"}, answer);
    }

    @Test
    void returnRPNMathExpressionMainOperationSecond() {
        Mockito.when(reader.read()).thenReturn("3 + 7 * 10");
        String[] answer = converter.convert("3 + 7 * 10");

        assertArrayEquals(new String[]{"3", "7", "10", "*", "+"}, answer);
    }

    @Test
    void returnRPNMathExpressionWithBrasses() {
        Mockito.when(reader.read()).thenReturn("(3 + 7) * 5");
        String[] answer = converter.convert("(3 + 7) * 5");

        assertArrayEquals(new String[]{"3", "7", "+", "5", "*"}, answer);
    }

    @Test
    void returnRPNMathExpressionWithNegativeNumbers() {
        Mockito.when(reader.read()).thenReturn("(-3 + 7) + (-5)");
        String[] answer = converter.convert("(-3 + 7) + (-5)");

        assertArrayEquals(new String[]{"0", "3", "-", "7", "+", "0", "5", "-", "+"}, answer);
    }

    @Test
    void returnRPNMathExpressionWithThreeBraces() {
        Mockito.when(reader.read()).thenReturn("(-3 + 7) + (-5) * (2 * 1)");
        String[] answer = converter.convert("(-3 + 7) + (-5) * (2 * 1)");

        assertArrayEquals(new String[]{"0", "3", "-", "7", "+", "0", "5", "-", "2", "1", "*", "*", "+"}, answer);
    }
}