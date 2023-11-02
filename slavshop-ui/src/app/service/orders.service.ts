import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Api} from "../api";
import {Observable} from "rxjs";
import {OrderModel} from "../model/order.model";
import {PagedResultModel} from "../model/paged-result.model";

@Injectable()
export class OrdersService {

  constructor(private httpClient: HttpClient, private api: Api) {
  }

  getAllOrders() : Observable<PagedResultModel<OrderModel>> {
    return this.httpClient.get<PagedResultModel<OrderModel>>(this.api.orders)
  }

  placeOrder() : Observable<any> {
    return this.httpClient.post(this.api.orders, null);
  }

}
