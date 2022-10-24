package ru.zahaand.service;

import java.util.Stack;

public class RPNConverter implements Converter {
    @Override
    public String[] convert(String mathExpression) {
        String formatNegativeNumbers = formatNegativeNumbers(mathExpression);
        char[] mathExpressionCharacters = formatNegativeNumbers.replaceAll("\\s", "").toCharArray();
        return getConvertedExpression(mathExpressionCharacters);
    }

    private String[] getConvertedExpression(char[] mathExpressionCharacters) {
        Stack<Character> mathCharactersStack = new Stack<>();
        StringBuilder mathExpressionBuilder = new StringBuilder();
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
        return mathExpressionBuilder.toString().trim().replace("  ", " ").split(" ");
    }

    /*
    replaces all negative numbers with expression (0 - number)
     */
    private static String formatNegativeNumbers(String mathExpression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mathExpression.length(); i++) {
            char mathExpressionElement = mathExpression.charAt(i);
            if (mathExpressionElement == ('-')) {
                if (i == 0 || mathExpression.charAt(i - 1) == '(') {
                    stringBuilder.append("0-");
                } else {
                    stringBuilder.append(mathExpressionElement);
                }
            } else {
                stringBuilder.append(mathExpressionElement);
            }
        }
        return String.valueOf(stringBuilder);
    }

    private void appendCharacterToMathExpression(StringBuilder builder, Character character, Stack<Character> stack) {
        if (character.equals('(')) {
            stack.push(character);
        } else if (character.equals(')')) {
            while (stack.peek() != '(') {
                builder.append(stack.pop());
            }
            stack.pop();
        } else if (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(character)) {
            builder.append(stack.pop()).append(" ");
            stack.push(character);
        } else {
            stack.push(character);
        }
    }

    private int getPriority(Character character) {
        switch (character) {
            case '(' -> {
                return 0;
            }
            case '+', '-' -> {
                return 1;
            }
            default -> {
                return 2;
            }
        }
    }
}
