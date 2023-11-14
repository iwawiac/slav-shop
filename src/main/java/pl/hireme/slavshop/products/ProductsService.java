package pl.hireme.slavshop.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.hireme.slavshop.common.FileSystemUtils;
import pl.hireme.slavshop.common.web.PagedResult;

import java.io.IOException;

@Transactional
@RequiredArgsConstructor
@Log
public class ProductsService {


    private final ProductsRepository productsRepository;
    public Product add(Product product) {
        return productsRepository.save(product);
    }

    public void updateImageUrl(Long id, MultipartFile file) throws IOException {
        FileSystemUtils.downloadFileToProductId(id, file);
        var product = productsRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        product.setImageLocation("https://hire-me.pl/api/products/" + id + "/files"); // TODO: add dynamic link handling
        productsRepository.save(product);
    }

    public Product getById(Long id) {
        return productsRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public PagedResult<Product> getByType(ProductType type, int pageNumber, int pageSize) {
        var productPage = productsRepository.findByType(type, PageRequest.of(pageNumber, pageSize));
        return new PagedResult<>(productPage.getContent(), pageNumber, productPage.getTotalPages());
    }

    public PagedResult<Product> getAll (int pageNumber, int pageSize) {
        Page<Product> productPage = productsRepository.findAll(PageRequest.of(pageNumber,pageSize));
        return new PagedResult<>(productPage.getContent(), pageNumber, productPage.getTotalPages());
    }

}
