import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Api} from "../api";
import {Observable} from "rxjs";
import {ProductModel} from "../model/product.model";
import {PagedResultModel} from "../model/paged-result.model";

@Injectable()
export class ProductsService {

  constructor(private httpClient: HttpClient, private api: Api) {
  }

  getProducts(pageNumber = 0, pageSize = 5) : Observable<PagedResultModel<ProductModel>> {
    const params = { pageNumber: `${pageNumber}`, pageSize: `${pageSize}` }
    return this.httpClient.get<PagedResultModel<ProductModel>>(this.api.products, {params})
  }

  getProductsByType(type: string, pageNumber = 0, pageSize = 5): Observable<PagedResultModel<ProductModel>> {
    const params = { pageNumber: `${pageNumber}`, pageSize: `${pageSize}` };
    const url = `${this.api.productsByType}${type}`;
    return this.httpClient.get<PagedResultModel<ProductModel>>(url, { params });
  }

}
