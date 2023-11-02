import {Component, EventEmitter, Input, Output} from "@angular/core";

@Component({
  selector: 'app-place-order-button',
  templateUrl: './place-order-button.component.html',
  styleUrls: ['./place-order-button.component.css']
})

export class PlaceOrderButtonComponent {
  @Input() buttonLabel: string = 'Place order'; // Default button label
  @Output() placeOrderClicked = new EventEmitter<void>();
  orderPlaced: boolean = false; // Flag to track added to cart state

  showOrderPlacedMessage() {
    this.orderPlaced = true; // Apply the CSS class
    this.buttonLabel = 'Order placed'; // Change the button text
    setTimeout(() => {
      this.orderPlaced = false; // Reset the CSS class
      this.buttonLabel = 'Place order'; // Reset the button text
    }, 2000); // Adjust the delay as needed (2000 milliseconds = 2 seconds)
  }

}
