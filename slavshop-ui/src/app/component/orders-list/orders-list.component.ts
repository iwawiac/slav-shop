import { Component } from '@angular/core';
import {OrdersService} from "../../service/orders.service";
import {OrderModel} from "../../model/order.model";
import {PagedResultModel} from "../../model/paged-result.model";

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent {

  pagedResult: PagedResultModel<OrderModel>;

  constructor(private ordersService: OrdersService) {
    this.reload();
  }

  private reload() {
    this.ordersService.getAllOrders()
        .subscribe(pagedResult => {
          // Sort orders by ID in descending order
          pagedResult.data = pagedResult.data.sort((a, b) => b.id - a.id);
          this.pagedResult = pagedResult;
        }, error => console.log(error));
  }
}
