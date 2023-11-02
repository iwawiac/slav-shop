package pl.hireme.slavshop.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hireme.slavshop.common.web.PagedResult;

@RequestMapping("${apiPrefix}/orders")
@RestController
@RequiredArgsConstructor
public class OrdersRestController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping()
    public PagedResult<OrderDTO> getAllOrders() {
        var ordersPage = orderService.getAllOrders();
        return orderMapper.toOrderTransferObjectsPage(ordersPage);
    }

    @PostMapping()
    public ResponseEntity<?> placeOrder(){
        orderService.saveOrder();
        return ResponseEntity.ok().build();
    }

}
