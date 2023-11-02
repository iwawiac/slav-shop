import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ProductsListComponent} from './component/products-list/products-list.component';
import {ProductsService} from "./service/products.service";
import {Api} from "./api";
import {NgOptimizedImage} from "@angular/common";
import {ProductsBookListComponent} from './component/products-book-list/products-book-list.component';
import {ProductsPosterListComponent} from './component/products-poster-list/products-poster-list.component';
import {ProductsFoodListComponent} from './component/products-food-list/products-food-list.component';
import {ProductsApparelListComponent} from './component/products-apparel-list/products-apparel-list.component';
import {ProductsOtherListComponent} from './component/products-other-list/products-other-list.component';
import {CartComponent} from './component/cart/cart.component';
import {CartService} from "./service/cart.service";
import {AddToCartButtonComponent} from './component/add-to-cart-button/add-to-cart-button.component';
import {OrdersListComponent} from './component/orders-list/orders-list.component';
import {OrdersService} from "./service/orders.service";
import { PlaceOrderButtonComponent } from './component/place-order-button/place-order-button.component';
import { WelcomePageComponent } from './component/welcome-page/welcome-page.component';

@NgModule({
    declarations: [
        AppComponent,
        ProductsListComponent,
        ProductsBookListComponent,
        ProductsPosterListComponent,
        ProductsFoodListComponent,
        ProductsApparelListComponent,
        ProductsOtherListComponent,
        CartComponent,
        AddToCartButtonComponent,
        OrdersListComponent,
        PlaceOrderButtonComponent,
        WelcomePageComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        NgOptimizedImage
    ],
    providers: [
        ProductsService,
        CartService,
        OrdersService,
        Api
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
