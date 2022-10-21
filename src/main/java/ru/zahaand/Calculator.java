package ru.zahaand;

import java.util.Stack;

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
        Stack<Double> stack = new Stack<>();

        for (String element : mathExpressionElements) {
            /*
            if the element is numeric, push the element to the top of the stack
            else get two numbers from the top of the stack and perform the math operation
             */
            if (isNumber(element)) {
                stack.push(Double.valueOf(element));
            } else {
                double popNumber1 = stack.pop();
                double popNumber2 = stack.pop();
                switch (element) {
                    case "+" -> stack.push(popNumber2 + popNumber1);
                    case "-" -> stack.push(popNumber2 - popNumber1);
                    case "*" -> stack.push(popNumber2 * popNumber1);
                    case "/" -> stack.push(popNumber2 / popNumber1);
                    case "%" -> stack.push(popNumber2 % popNumber1);
                    case "^" -> stack.push(Math.pow(popNumber2, popNumber1));
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String mathExpressionElement) {
        try {
            Integer.parseInt(mathExpressionElement);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
