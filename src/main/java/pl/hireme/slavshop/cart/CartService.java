package pl.hireme.slavshop.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.hireme.slavshop.common.web.PagedResult;
import pl.hireme.slavshop.products.Product;
import pl.hireme.slavshop.products.ProductNotFoundException;
import pl.hireme.slavshop.products.ProductsRepository;

@Transactional
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;

    public void createSharedCart() {
        var cart = Cart.builder()
                .id("shared_cart")
                .build();
        cartRepository.save(cart);
    }

    public void addProductToSharedCart(Long productId) {
        var product = productsRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        var sharedCart = cartRepository.findById("shared_cart")
                .orElseThrow(CartNotFoundException::new);
        sharedCart.getProducts().add(product);
        cartRepository.save(sharedCart);
    }

    public PagedResult<Product> getSharedCartProducts() {
        var sharedCart = cartRepository.findById("shared_cart")
                .orElseThrow(CartNotFoundException::new);
        var products = sharedCart.getProducts();
        return new PagedResult<>(products, 0, 1);
    }

    public void emptyCart() {
        var sharedCart = cartRepository.findById("shared_cart")
                .orElseThrow(CartNotFoundException::new);

        var products = sharedCart.getProducts();
        products.clear();
        sharedCart.setProducts(products);
    }

    public Cart getSharedCart() {
        return cartRepository.findById("shared_cart")
                .orElseThrow(CartNotFoundException::new);
    }

}
