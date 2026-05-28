import java.util.Arrays;
import java.util.Objects;

class Product {
    private int id;
    private String name;
    private int price;
    private String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Товар[артикул=" + id + ", название=" + name + ", цена=" + price + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}

class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Заказ[клиент=" + customer + ", корзина=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (!Objects.equals(customer, order.customer)) return false;
        if (this.basket == order.basket) return true;
        if (this.basket == null || order.basket == null) return false;
        if (this.basket.length != order.basket.length) return false;
        for (int i = 0; i < this.basket.length; i++) {
            Product p1 = this.basket[i];
            Product p2 = order.basket[i];

            if (p1 == null && p2 == null) {
                continue;
            }
            if (p1 == null || !p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";
        System.out.println(blue + "---------- [ ЗАДАЧА 1  ] ----------" + reset);
        Product phone1 = new Product(101, "MacBook Air 13 M4 16/256GB Sky Blue", 95000, "Электроника");
        Product phone2 = new Product(101, "iPhone 17 Pro Max 512GB Sim+eSim Cosmic Orange", 130000, "Электроника");
        Product laptop = new Product(102, "AirPods Max USB-C Midnight", 60000, "Компьютеры");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(laptop);
        System.out.println();
        System.out.println("phone1 равен phone2? (Ожидается true): " + phone1.equals(phone2));
        System.out.println("phone1 равен laptop? (Ожидается false): " + phone1.equals(laptop));
        System.out.println(blue + "------------------------------------------" + reset);
        System.out.println();
        System.out.println(blue + "---------- [ ЗАДАЧА 2  ] ----------" + reset);
        Product[] basketA = {phone1, laptop};
        Product[] basketB = {phone2, laptop};
        Product[] basketC = {laptop, phone1};
        Order order1 = new Order("GIRA", basketA);
        Order order2 = new Order("GIRA", basketB);
        Order order3 = new Order("GIRA", basketC);
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println();
        System.out.println("order1 равен order2? (Ожидается true): " + order1.equals(order2));
        System.out.println("order1 равен order3? (Ожидается false, другой порядок): " + order1.equals(order3));
        System.out.println(blue + "------------------------------------------" + reset);
    }
}