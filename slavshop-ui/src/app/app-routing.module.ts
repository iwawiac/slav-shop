import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsListComponent} from "./component/products-list/products-list.component";
import {ProductsBookListComponent} from "./component/products-book-list/products-book-list.component";
import {ProductsFoodListComponent} from "./component/products-food-list/products-food-list.component";
import {ProductsOtherListComponent} from "./component/products-other-list/products-other-list.component";
import {ProductsPosterListComponent} from "./component/products-poster-list/products-poster-list.component";
import {ProductsApparelListComponent} from "./component/products-apparel-list/products-apparel-list.component";
import {CartComponent} from "./component/cart/cart.component";
import {OrdersListComponent} from "./component/orders-list/orders-list.component";
import {WelcomePageComponent} from "./component/welcome-page/welcome-page.component";

const routes: Routes = [

  {
    path: "products",
    component: ProductsListComponent
  },

  {
    path: "products-book",
    component: ProductsBookListComponent
  },

  {
    path: "products-food",
    component: ProductsFoodListComponent
  },

  {
    path: "products-other",
    component: ProductsOtherListComponent
  },

  {
    path: "products-poster",
    component: ProductsPosterListComponent
  },

  {
    path: "products-apparel",
    component: ProductsApparelListComponent
  },

  {
    path: "shared-cart",
    component: CartComponent
  },

  {
    path: "orders",
    component: OrdersListComponent
  },

  {
    path: "welcome-page",
    component: WelcomePageComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
