package com.solidprinciples;

//OPEN - CLOSED -
/*“A class is closed, since it may be compiled, stored in a library, baselined, and used by client classes.
        But it is also open, since any new class may use it as parent, adding new features.
        When a descendant class is defined, there is no need to change the original or to disturb its clients.”
        Refer: https://stackify.com/solid-design-open-closed-principle/
        */

import java.util.List;
import java.util.stream.Stream;

enum Color {
    GREEN, BLUE, ORANGE, BLACK
}
enum Size {
    SMALL, BIG, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}
//Without Design Pattern: More filter requirement will add to more complexity to the code and
class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream()
                .filter(x -> x.color == color);
    }
    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream()
                .filter(x -> x.size == size);
    }
}
public class Demo {
    public static void main(String[] args) {
        Product prod1 = new Product("Mansion", Color.BLUE, Size.HUGE);
        Product prod2 = new Product("Tree", Color.GREEN, Size.LARGE);
        Product prod3 = new Product("Bottle", Color.BLACK, Size.SMALL);

        List<Product> productList = List.of(prod1, prod2, prod3);

        ProductFilter pf = new ProductFilter();
        pf.filterByColor(productList, Color.BLACK).forEach(x ->
                System.out.println("Color: "+x.color+" | Name: "+x.name));
        pf.filterBySize(productList, Size.HUGE)
                .forEach(x ->
                        System.out.println("Color: "+x.size+" | Name: "+x.name));
    }
}
