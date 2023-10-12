package first.hw.Shop;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
public class ShopTest {
    public static void main(String[] args) {
        Shop ourShop = new Shop( new ArrayList<>());
        Product milk = new Product(50, "Milk");
        Product water = new Product(20, "Water");
        Product bread = new Product(70, "Bread");

        ourShop.getProducts().add(milk);
        ourShop.getProducts().add(water);
        ourShop.getProducts().add(bread);
//        System.out.println(ourShop.getProducts());
//        System.out.println(ourShop.getMostExpensiveProduct(ourShop.getProducts()));
//        System.out.println(ourShop.sortProductsByPrice(ourShop.getProducts()));
        assertThat(ourShop.getProducts()).hasSize(3).contains(new Product(50, "Milk"), bread, water);
        assertThat(ourShop.getMostExpensiveProduct(ourShop.getProducts())).isEqualTo(bread);
        assertThat(ourShop.sortProductsByPrice(ourShop.getProducts())).containsSequence(water, milk, bread);




    }

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

}