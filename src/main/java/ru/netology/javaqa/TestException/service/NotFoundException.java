package ru.netology.javaqa.TestException.service;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}