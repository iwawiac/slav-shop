import { Component } from '@angular/core';
import {PagedResultModel} from "../../model/paged-result.model";
import {ProductModel} from "../../model/product.model";
import {ProductsService} from "../../service/products.service";
import {CartService} from "../../service/cart.service";

@Component({
  selector: 'app-products-book-list',
  templateUrl: './products-book-list.component.html',
  styleUrls: ['./products-book-list.component.css']
})
export class ProductsBookListComponent {

  pagedResult: PagedResultModel<ProductModel>;
  type: string = "BOOK";

  constructor(private productService: ProductsService, private cartService: CartService) {
    this.reload(0);
  }

  private reload(pageNumber: number) {
    this.productService.getProductsByType(this.type, pageNumber)
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
