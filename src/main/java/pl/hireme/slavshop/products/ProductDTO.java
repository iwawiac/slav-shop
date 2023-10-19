package pl.hireme.slavshop.products;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private String name;
    private String description;
    private String price;
    private String type;

}
