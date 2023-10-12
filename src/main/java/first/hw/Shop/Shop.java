package first.hw.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shop implements Iterable<Product> {
    private List<Product> products;
    private int index;

    public Shop(List<Product> products) {
        this.products = products;
        this.index = 0;
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice(List<Product> products) {
        Collections.sort(products);
        // Допишите реализацию метода самостоятельно
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct(List<Product> products) {
        Product max = products.get(0);
        for (int i = 1; i < products.size(); i++) {
            if (max.getCost() < products.get(i).getCost()) {
                max = products.get(i);
            }
        }
        return max;
        // Допишите реализацию метода самостоятельно
    }


    @Override
    public Iterator<Product> iterator() {

        return new Iterator<Product>() {
            @Override
            public boolean hasNext() {
                return index < products.size();
            }

            @Override
            public Product next() {
                return products.get(index++);
            }
        };
    }
}