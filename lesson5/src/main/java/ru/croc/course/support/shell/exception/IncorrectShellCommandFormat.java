package ru.croc.course.support.shell.exception;

public class IncorrectShellCommandFormat extends RuntimeException{
    public IncorrectShellCommandFormat() {
        super("не верный формат команды");
    }
}
