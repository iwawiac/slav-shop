package pl.hireme.slavshop.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.hireme.slavshop.cart.CartService;

@Configuration
public class OrdersConfiguration {

    @Bean
    OrderService orderService(CartService cartService, OrdersRepository ordersRepository) {
        return new OrderService(cartService, ordersRepository);
    }

}
