import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'pm-root',
  template: `
            <nav class='navbar navbar-expand navbar-light bg-light'>
            <a class='navbar-brand'>{{pageTitle}}</a>
            <ul class='nav nav-pills'>
              <li><a class='nav-link' [routerLink]="['/login']">Login</a></li>
              <li><a class='nav-link' [routerLink]="['/welcome']">Home</a></li>
              <li *ngIf='authService.isAuthenticated()'><a class='nav-link' [routerLink]="['/products']">Product List</a></li>
              <li><a class='nav-link' [routerLink]="['/logout']">Log Out</a></li>
            </ul>
            </nav>
            <div class='container'>
            <router-outlet></router-outlet>
            </div>
            `
})
export class AppComponent {
  pageTitle = 'Rocket Product Management';

  constructor(public authService: AuthService) {

  }
}