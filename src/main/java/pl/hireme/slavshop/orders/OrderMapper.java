package pl.hireme.slavshop.orders;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.hireme.slavshop.common.web.PagedResult;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "id")
    OrderDTO toOrderDTO(Order order);
    PagedResult<OrderDTO> toOrderTransferObjectsPage(PagedResult<Order> ordersPage);

}
