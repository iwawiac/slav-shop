package pl.hireme.slavshop.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsConfiguration {

    @Bean
    ProductsService productsService(ProductsRepository productsRepository) {
        return new ProductsService(productsRepository);
    }

}
