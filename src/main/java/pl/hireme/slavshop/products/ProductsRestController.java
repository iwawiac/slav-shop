package pl.hireme.slavshop.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hireme.slavshop.common.PagedResult;
import pl.hireme.slavshop.common.UriBuilder;

@RequestMapping("${apiPrefix}/products")
@RestController
@RequiredArgsConstructor
public class ProductsRestController {

    private final ProductsService productsService;
    private final ProductMapper productMapper;
    private final UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.GET, value = "greetings")
    public String sayHello(){
        return "Hello from api products";
    }

    @GetMapping PagedResult<ProductDTO> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        var products = productsService.getAll(pageNumber, pageSize);
        return productMapper.toProductTransferObjectsPage(products);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        var product = productMapper.toProduct(productDTO);
        var productId = productsService.add(product);
        var locationUri = uriBuilder.requestUriWithId(productId);
        return ResponseEntity.created(locationUri).build();
    }



}
