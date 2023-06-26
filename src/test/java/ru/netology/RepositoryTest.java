package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    Repository repo = new Repository();

    Book book1 = new Book(1, "Мастер и Маргарита", 750, "Михаил Булгаков");
    Book book2 = new Book(22, "Преступление и наказание", 550, "Федор Достоевский");
    Book book3 = new Book(33, "Сборник стихов", 550, "Анна Ахматова");
    Smartphone phone1 = new Smartphone(7, "Galaxy S21", 50000, "Samsung electronics");
    Smartphone phone2 = new Smartphone(15, "Honor 70", 35000, "Huawei");
    Smartphone phone3 = new Smartphone(7, "Galaxy A50", 25000, "Samsung electronics");


    @Test
    public void shouldRemoveByIdWhenProductExist() {                                  // Удаление по idб, когда товар существует

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.removeById(15);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, phone1, phone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdWhenProductDoesNotExist() {                                  // Удаление по idб, когда товар не существует

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(20)
        );

    }

}



