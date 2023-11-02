package pl.hireme.slavshop.products;

import org.mapstruct.*;
import pl.hireme.slavshop.common.web.PagedResult;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "imageLocation", target = "imageLocation")
    ProductDTO toProductDTO(Product product);

    PagedResult<ProductDTO> toProductTransferObjectsPage(PagedResult<Product> productsPage);

    @ValueMapping(source = "BOOK", target = "BOOK")
    @ValueMapping(source = "POSTER", target = "POSTER")
    @ValueMapping(source = "FOOD", target = "FOOD")
    @ValueMapping(source = "APPAREL", target = "APPAREL")
    @ValueMapping(source = "OTHER", target = "OTHER")
    ProductType toProductType(ProductTypeDTO productTypeDTO);
    @InheritInverseConfiguration
    ProductTypeDTO toProductTypeDTO(ProductType productType);

}
