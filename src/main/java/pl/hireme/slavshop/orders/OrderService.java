package pl.hireme.slavshop.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.hireme.slavshop.cart.CartService;
import pl.hireme.slavshop.common.web.PagedResult;

import java.util.ArrayList;

@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final CartService cartService;
    private final OrdersRepository ordersRepository;

    public void saveOrder() {
        var cartProducts = cartService.getSharedCart().getProducts();
        var orderProducts = new ArrayList<>(cartProducts);
        var order = Order.builder()
                .products(orderProducts)
                .totalPrice(Order.calculateTotalPrice(orderProducts))
                .totalNumberOfProducts(Order.calculateTotalNumberOfProducts(orderProducts))
                .build();
        ordersRepository.save(order);
        cartService.emptyCart();
    }

    public PagedResult<Order> getAllOrders() {
        var orders = ordersRepository.findAll();
        return new PagedResult<>(orders, 0,1);
    }

}
