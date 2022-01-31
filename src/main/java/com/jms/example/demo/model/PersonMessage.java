package com.jms.example.demo.model;

public class PersonMessage implements Message {
    int id;
    String message;

    public PersonMessage() {}

    public PersonMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("## ID: %s MESSAGE: %s", getId(), getMessage());
    }
}
