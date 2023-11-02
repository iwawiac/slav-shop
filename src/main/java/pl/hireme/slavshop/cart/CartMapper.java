package pl.hireme.slavshop.cart;

import org.mapstruct.Mapper;
import pl.hireme.slavshop.common.web.PagedResult;
import pl.hireme.slavshop.products.Product;
import pl.hireme.slavshop.products.ProductDTO;

@Mapper(componentModel = "spring")
public interface CartMapper {

    PagedResult<ProductDTO> toProductTransferObjectsPage(PagedResult<Product> productsPage);
    
}
