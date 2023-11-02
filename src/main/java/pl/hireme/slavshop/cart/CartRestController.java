package pl.hireme.slavshop.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hireme.slavshop.common.web.PagedResult;
import pl.hireme.slavshop.products.ProductDTO;

@RequestMapping("${apiPrefix}/cart")
@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final CartService cartService;

    private final CartMapper cartMapper;

    @GetMapping
    public PagedResult<ProductDTO> getSharedCartProducts() {
        var productsPagedResult = cartService.getSharedCartProducts();
        return cartMapper.toProductTransferObjectsPage(productsPagedResult);
    }

    @PostMapping
    public ResponseEntity<?> addSharedCart() {
        cartService.createSharedCart();
        return ResponseEntity.ok().body("Shared cart created successfully, consider adding functionality with users");
    }

    @PostMapping("/empty_cart")
    public ResponseEntity<?> emptySharedCart() {
        cartService.emptyCart();
        return ResponseEntity.ok("cart emptied");
    }

    @PutMapping
    public ResponseEntity<?> addProductById(@RequestParam Long id) {
        cartService.addProductToSharedCart(id);
        return ResponseEntity.ok().build();
    }

}
