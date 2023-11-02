import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-add-to-cart-button',
  templateUrl: './add-to-cart-button.component.html',
  styleUrls: ['./add-to-cart-button.component.css']
})
export class AddToCartButtonComponent {

  @Input() buttonLabel: string = 'Add to Cart'; // Default button label
  @Output() addToCartClicked = new EventEmitter<void>();
  isAddedToCart: boolean = false; // Flag to track added to cart state

  showAddedToCartMessage() {
    this.isAddedToCart = true; // Apply the CSS class
    this.buttonLabel = 'Added to Cart'; // Change the button text
    setTimeout(() => {
      this.isAddedToCart = false; // Reset the CSS class
      this.buttonLabel = 'Add to Cart'; // Reset the button text
    }, 2000); // Adjust the delay as needed (2000 milliseconds = 2 seconds)
  }


}
