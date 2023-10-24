package pl.hireme.slavshop.products;

import org.mapstruct.*;
import pl.hireme.slavshop.common.web.PagedResult;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    @Mapping(source = "id", target = "id")
    ProductDTO toProductDTO(Product product);

    PagedResult<ProductDTO> toProductTransferObjectsPage(PagedResult<Product> productsPage);

    @ValueMapping(source = "BOOK", target = "BOOK")
    @ValueMapping(source = "VIDEO", target = "VIDEO")
    @ValueMapping(source = "AUDIO", target = "AUDIO")
    ProductType toProductType(ProductTypeDTO productTypeDTO);
    @InheritInverseConfiguration
    ProductTypeDTO toProductTypeDTO(ProductType productType);

}
