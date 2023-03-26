package ru.netology.javaqa.TestException.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11, "хлеб", 40);
    Product product2 = new Product(22, "булка", 30);
    Product product3 = new Product(30, "картошка", 20);

    @Test
    public void testNotFind() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }


    @Test
    public void testFindId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(30);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}