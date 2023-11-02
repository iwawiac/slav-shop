import { Component } from '@angular/core';
import {PagedResultModel} from "../../model/paged-result.model";
import {ProductModel} from "../../model/product.model";
import {ProductsService} from "../../service/products.service";
import {CartService} from "../../service/cart.service";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent {

  pagedResult: PagedResultModel<ProductModel>;

  constructor(private productService: ProductsService, private cartService: CartService) {
    this.reload(0);
  }

  private reload(pageNumber: number) {
    this.productService.getProducts(pageNumber)
      .subscribe(pagedResult => {
        this.pagedResult = pagedResult;
      }, error => console.log(error));
  }

  addToCart(productId: number) {
    // Call the CartService method to add the product to the cart
    this.cartService.addToCart(productId).subscribe(() => {
      // Handle success, e.g., show a success message
      console.log('Product added to cart successfully.');
    }, error => {
      // Handle error, e.g., display an error message
      console.error('Failed to add the product to the cart:', error);
    });
  }



  previous(){
    this.reload(this.pagedResult.pageNumber - 1);
  }

  next(){
    this.reload(this.pagedResult.pageNumber + 1);
  }

}
