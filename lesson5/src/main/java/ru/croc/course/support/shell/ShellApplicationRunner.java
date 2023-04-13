package ru.croc.course.support.shell;

import java.util.Scanner;

/** Стартер для консольного приложения */
public class ShellApplicationRunner {

    private final ShellCommandDispatcher shellCommandDispatcher;

    public ShellApplicationRunner(ShellCommandDispatcher shellCommandDispatcher) {
        this.shellCommandDispatcher = shellCommandDispatcher;
    }

    /** Запускает консольное приложение.
     * Считывает передваемые строки и делегирует их {@link ShellCommandDispatcher} */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try{
                String line = scanner.nextLine();
                if(!line.isEmpty()) {
                    shellCommandDispatcher.process(line);
                }
            } catch (RuntimeException exception) {
                System.out.println("\u001B[31m" +  exception.getMessage() + "\u001B[0m");
            }
        }
    }
}
