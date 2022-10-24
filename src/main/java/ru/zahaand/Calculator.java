package ru.zahaand;

import ru.zahaand.exception.IncorrectOperationException;
import ru.zahaand.service.Converter;
import ru.zahaand.service.Reader;

import java.util.Stack;

public class Calculator {
    Reader reader;
    Converter converter;

    public Calculator(Reader reader, Converter converter) {
        this.reader = reader;
        this.converter = converter;
    }

    public double calculate() throws IncorrectOperationException {
        String mathExpression = reader.read();
        String[] mathExpressionElements = converter.convert(mathExpression);
        Stack<Double> stack = new Stack<>();
        /*
        if the element is numeric, push the element to the top of the stack
        else get two numbers from the top of the stack and perform the math operation
        */
        for (String element : mathExpressionElements) {
            if (isNumber(element)) {
                stack.push(Double.valueOf(element));
            } else {
                doCalculate(stack, element);
            }
        }
        return stack.pop();
    }

    private static void doCalculate(Stack<Double> stack, String element) throws IncorrectOperationException {
        double popNumber1 = stack.pop();
        double popNumber2 = stack.pop();
        switch (element) {
            case "+" -> stack.push(popNumber2 + popNumber1);
            case "-" -> stack.push(popNumber2 - popNumber1);
            case "*" -> stack.push(popNumber2 * popNumber1);
            case "/" -> stack.push(popNumber2 / popNumber1);
            case "%" -> stack.push(popNumber2 % popNumber1);
            case "^" -> stack.push(Math.pow(popNumber2, popNumber1));
            default -> throw new IncorrectOperationException("This math operation is not correct");
        }
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
