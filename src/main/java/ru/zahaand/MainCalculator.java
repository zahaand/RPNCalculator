package ru.zahaand;

import ru.zahaand.model.Calculator;
import ru.zahaand.service.ConsoleReader;
import ru.zahaand.service.Converter;
import ru.zahaand.service.RPNConverter;
import ru.zahaand.service.Reader;

public class MainCalculator {
    static Reader reader = new ConsoleReader();
    static Converter converter = new RPNConverter();
    static Calculator calculator = new Calculator(reader, converter);

    public static void main(String[] args) {
        System.out.println("= " + calculator.calculate());
    }
}
