package pl.hireme.slavshop.products;

import org.mapstruct.Mapper;
import pl.hireme.slavshop.common.PagedResult;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);
    ProductDTO toProductDTO(Product product);

    PagedResult<ProductDTO> toProductTransferObjectsPage(PagedResult<Product> productsPage);

}
