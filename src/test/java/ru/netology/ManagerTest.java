package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
    Book book2 = new Book(22, "Преступление и наказание", 550, "Федор Достоевский");
    Book book3 = new Book(33, "Сборник стихов", 550, "Анна Ахматова");
    Smartphone phone1 = new Smartphone(7, "Galaxy S21", 50000, "Samsung electronics");
    Smartphone phone2 = new Smartphone(15, "Honor 70", 35000, "Huawei");
    Smartphone phone3 = new Smartphone(7, "Galaxy A50", 25000, "Samsung electronics");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
    }

    @Test
    public void shouldSearchProducts() {                                  // Поиск товара работает, товар в наличие

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = {phone1, phone3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchProducts() {                               // Поиск товара не работает, тк нет в наличие

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSearchProductsBorderLow() {                           // Поиск товара, граничное значение

        Product[] actual = manager.searchBy("Преступление");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);

    }

}