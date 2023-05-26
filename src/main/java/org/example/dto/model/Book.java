package org.example.dto.model;

public class Book {
    private String name;
    private String avtor;

    public Book(String name, String avtor) {
        this.name = name;
        this.avtor = avtor;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }
}
