public class Main {
    public static void main(String[] args) {
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";

        System.out.println(blue + "---------- [ ЗАДАЧА 1  ] ----------" + reset);

        Product phone1 = new Product(101, "MacBook Air 13 M4 16/256GB Sky Blue", 95000, "Компьютеры");
        Product phone2 = new Product(101, "iPhone 17 Pro Max 512GB Sim+eSim Cosmic Orange", 130000, "Электроника");
        Product laptop = new Product(102, "AirPods Max USB-C Midnight", 110000, "Электроника");

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
