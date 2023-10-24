package pl.hireme.slavshop.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import pl.hireme.slavshop.common.web.PagedResult;

@Transactional
@RequiredArgsConstructor
@Log
public class ProductsService {

    private final ProductsRepository productsRepository;

    public Product add(Product product) {
        return productsRepository.save(product);
    }

    public Product getById(Long id) {
        return productsRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public PagedResult<Product> getAll (int pageNumber, int pageSize) {
        Page<Product> productPage = productsRepository.findAll(PageRequest.of(pageNumber,pageSize));
        return new PagedResult<>(productPage.getContent(), pageNumber, productPage.getTotalPages());
    }

}
