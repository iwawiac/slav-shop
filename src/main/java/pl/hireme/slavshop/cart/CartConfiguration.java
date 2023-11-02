package pl.hireme.slavshop.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.hireme.slavshop.products.ProductsRepository;

@Configuration
public class CartConfiguration {

    @Bean
    CartService cartService(CartRepository cartRepository, ProductsRepository productsRepository) {
        return new CartService(cartRepository, productsRepository);
    }

}
