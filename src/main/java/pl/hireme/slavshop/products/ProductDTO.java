package pl.hireme.slavshop.products;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import pl.hireme.slavshop.common.validator.fieldisnumber.FieldIsPositiveNumber;
import pl.hireme.slavshop.common.validator.fieldnotempty.FieldNotEmpty;
import pl.hireme.slavshop.common.validator.producttype.IsProductType;

@Data
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private Long id;
    @FieldNotEmpty
    private String name;
    @FieldNotEmpty
    private String description;
    @FieldIsPositiveNumber
    private String price;
    @IsProductType
    private String type;
    private String imageLocation;

}
