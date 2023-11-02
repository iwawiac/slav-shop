import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'slavshop-ui';
  externalImageURL: string = 'https://cdn-icons-png.flaticon.com/512/1413/1413908.png';

  ngOnInit(): void {
    // Fetch the external image URL from your source or set it to an actual URL
    this.externalImageURL = 'https://cdn-icons-png.flaticon.com/512/1413/1413908.png';
  }

}
