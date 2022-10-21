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
        Mockito.when(reader.read()).thenReturn("3 + 7");
        String[] answer = converter.convert("3 + 7");

        Assert.assertTrue(Arrays.equals(new String[]{"3", "7", "+"}, answer));
    }
}