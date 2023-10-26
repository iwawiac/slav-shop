import { Component } from '@angular/core';
import {PagedResultModel} from "../../model/paged-result.model";
import {ProductModel} from "../../model/product.model";
import {ProductsService} from "../../service/products.service";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent {

  pagedResult: PagedResultModel<ProductModel>;

  constructor(private productService: ProductsService) {
    this.reload(0);
  }

  private reload(pageNumber: number) {
    this.productService.getProducts(pageNumber)
      .subscribe(pagedResult => {
        this.pagedResult = pagedResult;
      }, error => console.log(error));
  }


  previous(){
    this.reload(this.pagedResult.pageNumber - 1);
  }

  next(){
    this.reload(this.pagedResult.pageNumber + 1);
  }

}
