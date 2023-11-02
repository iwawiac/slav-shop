package pl.hireme.slavshop.products;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.hireme.slavshop.common.FileSystemUtils;
import pl.hireme.slavshop.common.web.PagedResult;
import pl.hireme.slavshop.common.web.UriBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RequestMapping("${apiPrefix}/products")
@RestController
@RequiredArgsConstructor
public class ProductsRestController {

    private final ProductsService productsService;
    private final ProductMapper productMapper;
    private final UriBuilder uriBuilder = new UriBuilder();

    @GetMapping("greetings")
    public String sayHello() {
        return "Hello from api products";
    }

    @GetMapping("{id}")
    ProductDTO getProductById(@PathVariable long id) {
        var product = productsService.getById(id);
        return productMapper.toProductDTO(product);
    }

    @GetMapping
    PagedResult<ProductDTO> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        var products = productsService.getAll(pageNumber, pageSize);
        return productMapper.toProductTransferObjectsPage(products);
    }

    @GetMapping("/type/{productTypeRequest}")
    PagedResult<ProductDTO> getProductsByType(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @PathVariable ProductTypeDTO productTypeRequest
    ) {
        var productType = productMapper.toProductType(productTypeRequest);
        var productsPagedResult = productsService.getByType(productType, pageNumber, pageSize);
        return productMapper.toProductTransferObjectsPage(productsPagedResult);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        var product = productMapper.toProduct(productDTO);
        var productId = productsService.add(product);
        var locationUri = uriBuilder.requestUriWithId(productId);
        return ResponseEntity.created(locationUri).build();
    }

    @PostMapping("{id}/files")
    public String submit(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        productsService.updateImageUrl(id, file);
        return "File " + file.getOriginalFilename() + " uploaded";
    }

    @GetMapping("{id}/files")
    public ResponseEntity<?> getFile(@PathVariable Long id) {
        Path fileLocation = FileSystemUtils.getFileLocation(id);
        Resource resource = new PathResource(fileLocation);
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg") // Adjust the content type as needed
                .header("Content-Disposition", "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
