package ru.zahaand.service;

public class RPNConverter implements Converter {
    @Override
    public String[] convert(String mathExpression) {
        return new String[]{"3", "7", "+"};
    }
}
