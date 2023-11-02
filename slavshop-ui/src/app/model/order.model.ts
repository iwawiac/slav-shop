import {ProductModel} from "./product.model";

export class OrderModel {

  id: number;
  totalPrice: string;
  totalNumberOfProducts: string;
  products: ProductModel[];

}
