package pl.hireme.slavshop.orders;

import lombok.Data;
import pl.hireme.slavshop.products.ProductDTO;

import java.util.List;

@Data
public class OrderDTO {

    private String id;
    private String totalPrice;
    private String totalNumberOfProducts;
    private List<ProductDTO> products;

}
