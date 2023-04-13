package ru.croc.course.support.shell.exception;

public class UnsupportedShellCommand extends RuntimeException{
    public UnsupportedShellCommand() {
        super("Данная команда не поддерживается");
    }
}
