package ru.netology.INH;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.removeById(1);
        repo.findById(4);
    }
}