package ru.zahaand.service;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
