package ru.zahaand;

public class Calculator {
    MathExpressionReader reader;
    MathExpressionConverter converter;

    public Calculator(MathExpressionReader reader, MathExpressionConverter converter) {
        this.reader = reader;
        this.converter = converter;
    }

    public double calculate() {
        String mathExpression = reader.read();
        Character[] mathExpressionElements = converter.convert(mathExpression);
        return 10.0;
    }
}
