package ru.netology.INH;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTests {

    Book book = new Book(1, 10, "Кот", "Пушкин");
    Book book1 = new Book(3, 15, "Кот", "Онегин");
    Smartphone smartphone = new Smartphone(2, "Xiaomi mi 9T", 10, "Xiaomi");


    @Test
    public void addBookTest() {

        book.setID(1);
        int expectedID = 1;
        int actualID = book.getID();
        Assertions.assertEquals(expectedID, actualID);

        book.setPrice(10);
        int expectedPrice = 10;
        int actualPrice = book.getPrice();
        Assertions.assertEquals(expectedPrice, actualPrice);

        book.setName("Кот");
        String expectedName = "Кот";
        String actualName = book.getName();
        Assertions.assertEquals(expectedName, actualName);

        book.setAuthor("Пушкин");
        String expectedAuthor = "Пушкин";
        String actualAuthor = book.getAuthor();
        Assertions.assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void addSmartphoneTest() {

        smartphone.setID(2);
        int expectedID = 2;
        int actualID = smartphone.getID();
        Assertions.assertEquals(expectedID, actualID);

        smartphone.setName("Xiaomi mi 9T");
        String expectedName = "Xiaomi mi 9T";
        String actualName = smartphone.getName();
        Assertions.assertEquals(expectedName, actualName);

        smartphone.setPrice(10);
        int expectedPrice = 10;
        int actualPrice = smartphone.getPrice();
        Assertions.assertEquals(expectedPrice, actualPrice);

        smartphone.setManufacturer("Xiaomi");
        String expectedManufacturer = "Xiaomi";
        String actualManufacturer = smartphone.getManufacturer();
        Assertions.assertEquals(expectedManufacturer, actualManufacturer);
    }

    @Test
    public void saveBookTest() {

        ProductRepository repository = new ProductRepository();

        repository.save(book);
        repository.save(smartphone);
        Product[] expected = new Product[2];
        expected[0] = book;
        expected[1] = smartphone;
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {

        ProductRepository repository = new ProductRepository();

        repository.save(book);
        repository.save(smartphone);
        repository.removeById(1);
        Product[] expected = new Product[1];
        expected[0] = smartphone;
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFoundExceptionTest() {

        ProductRepository repository = new ProductRepository();

        repository.save(book);
        repository.save(smartphone);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }

    @Test
    public void addTest() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book);
        manager.add(smartphone);
        Product[] expected = new Product[2];
        expected[0] = book;
        expected[1] = smartphone;
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByMoreOneTest() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        Product[] expected = new Product[2];
        expected[0] = book;
        expected[1] = book1;
        Product[] actual = manager.searchBy("Кот");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneTest() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book);
        manager.add(smartphone);
        Product[] expected = new Product[1];
        expected[0] = book;
        Product[] actual = manager.searchBy("Кот");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByZeroTest() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book);
        manager.add(smartphone);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Собака");
        Assertions.assertArrayEquals(expected, actual);
    }


}
