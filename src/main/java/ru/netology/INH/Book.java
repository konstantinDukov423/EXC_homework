package ru.netology.INH;

public class Book extends Product {

    private String author;

    public Book(int ID, int price, String name, String author) {
        super(ID, name, price);
        this.name = name;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
