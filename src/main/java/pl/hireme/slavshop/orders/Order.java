package pl.hireme.slavshop.orders;

import jakarta.persistence.*;
import lombok.*;
import pl.hireme.slavshop.products.Product;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private long id;

    private BigDecimal totalPrice;
    private int totalNumberOfProducts;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Product> products;

    public static BigDecimal calculateTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static int calculateTotalNumberOfProducts(List<Product> products) {
        return products.size();
    }

}
