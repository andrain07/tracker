package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length - 1; i++) {
            if (products[i] == null) {
                Product swap = products[i];
                products[i] = products[i + 1];
                products[i + 1] = swap;
            }
        }
        return products;
    }
}