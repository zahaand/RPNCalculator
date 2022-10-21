package ru.zahaand;

public class Calculator {
    MathExpressionReader reader;
    MathExpressionConverter converter;

    public Calculator(MathExpressionReader reader, MathExpressionConverter converter) {
        this.reader = reader;
        this.converter = converter;
    }

    public double calculate() {

        return 10.0;
    }
}
