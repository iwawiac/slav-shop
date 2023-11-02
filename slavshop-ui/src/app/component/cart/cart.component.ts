import { Component } from '@angular/core';
import {PagedResultModel} from "../../model/paged-result.model";
import {ProductModel} from "../../model/product.model";
import {CartService} from "../../service/cart.service";
import {OrdersService} from "../../service/orders.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  pagedResult: PagedResultModel<ProductModel>;

  constructor(private cartService: CartService, private ordersService: OrdersService, private router:Router) {
    this.reload();
  }

  private reload() {
    this.cartService.getProductsInSharedCart()
      .subscribe(pagedResult => {
        this.pagedResult = pagedResult;
      }, error => console.log(error));
  }

  calculateTotalPrice(): number {
    if (!this.pagedResult || !this.pagedResult.data) {
      return 0; // Handle the case when there are no products in the cart
    }

    return this.pagedResult.data.reduce((total, product) => {
      // Parse the price string to a floating-point number
      const price = parseFloat(product.price);
      return total + price;
    }, 0);
  }

  placeOrder(){
    this.ordersService.placeOrder().subscribe(()=>{
      console.log("Order placed successfully");
      setTimeout(() => {
        this.reload();
        this.router.navigate(['/orders']); // Navigate to the "orders" page
      }, 2000); // 2000 milliseconds = 2 seconds
    }, error => {
      console.log("Error placing the order");
      setTimeout(() => {
        this.reload();
        this.router.navigate(['/orders']); // Navigate to the "orders" page
      }, 2000); // 2000 milliseconds = 2 seconds
    });
  }

}
