package ru.zahaand.service;

import java.util.Stack;

public class RPNConverter implements Converter {
    @Override
    public String[] convert(String mathExpression) {
        StringBuilder mathExpressionBuilder = new StringBuilder();
        Stack<Character> mathCharactersStack = new Stack<>();
        char[] mathExpressionCharacters = mathExpression.replaceAll("\\s", "").toCharArray();

        for (Character character : mathExpressionCharacters) {
            if (Character.isDigit(character)) {
                mathExpressionBuilder.append(character);
            } else {
                mathExpressionBuilder.append(" ");
                appendCharacterToMathExpression(mathExpressionBuilder, character, mathCharactersStack);
            }
        }
        while (!mathCharactersStack.isEmpty()) {
            mathExpressionBuilder.append(" ").append(mathCharactersStack.pop());
        }
        return mathExpressionBuilder.toString().trim().split(" ");
    }

    private void appendCharacterToMathExpression(StringBuilder builder, Character character, Stack<Character> stack) {
        if (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(character)) {
            builder.append(character).append(" ");
        } else {
            stack.push(character);
        }
    }

    private int getPriority(Character character) {
        switch (character) {
            case '+', '-' -> {
                return 1;
            }
            default -> {
                return 2;
            }
        }
    }
}
