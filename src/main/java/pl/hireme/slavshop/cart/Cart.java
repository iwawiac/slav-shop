package pl.hireme.slavshop.cart;

import jakarta.persistence.*;
import lombok.*;
import pl.hireme.slavshop.products.Product;

import java.util.List;

@Table(name = "cart")
@Entity
@EqualsAndHashCode(exclude = "id")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Cart {

    @Id
    private String id;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // why many to one is not working?
    private List<Product> products;

}
