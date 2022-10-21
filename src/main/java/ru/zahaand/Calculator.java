package ru.zahaand;

public class Calculator {
    Reader reader;
    Converter converter;

    public Calculator(Reader reader, Converter converter) {
        this.reader = reader;
        this.converter = converter;
    }

    public double calculate() {
        String mathExpression = reader.read();
        String[] mathExpressionElements = converter.convert(mathExpression);
        return 10.0;
    }
}
