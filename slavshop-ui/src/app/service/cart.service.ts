import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Api} from "../api";
import {Observable} from "rxjs";
import {PagedResultModel} from "../model/paged-result.model";
import {ProductModel} from "../model/product.model";

@Injectable()
export class CartService {

  constructor(private httpClient: HttpClient, private api: Api) {
  }

  getProductsInSharedCart() : Observable<PagedResultModel<ProductModel>> {
    return this.httpClient.get<PagedResultModel<ProductModel>>(this.api.cart)
  }

  addToCart(productId: number): Observable<any> {
    const params = {
      id: productId.toString()
    };

    return this.httpClient.put(this.api.cart, null, {params})

  }

}
