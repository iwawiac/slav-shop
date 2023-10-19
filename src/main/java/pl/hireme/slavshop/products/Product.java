package pl.hireme.slavshop.products;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "products", indexes = @Index(name = "product_type", columnList = "type"))
@Entity
@EqualsAndHashCode(exclude = "id")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    public static final String SELECT_PRODUCTS = "selectProducts";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String price;
    private String type;

}

