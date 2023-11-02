import {environment} from "./environments/environment";

export class Api {
  products = `${environment.baseUrl}products`;
  productsByType = `${environment.baseUrl}products/type/`;
  cart = `${environment.baseUrl}cart`
  orders = `${environment.baseUrl}orders`

}
