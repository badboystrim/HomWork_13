import java.util.Arrays;
import java.util.Objects;

public class Order {
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
        result = 31 * result + Arrays.deepHashCode(basket);
        return result;
    }
}
