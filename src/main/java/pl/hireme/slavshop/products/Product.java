package pl.hireme.slavshop.products;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal price;
    private ProductType type;
    private String imageLocation;

}

