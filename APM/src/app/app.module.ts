import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ConvertToSpacePipe } from './shared/convert-to-spaces.pipe';
import { StarComponent } from './shared/star.componet';
import { ProductDetailComponent } from './products/product-detail.component';
import { WelcomeComponent } from './home/welcome.component';
import { RouterModule } from '@angular/router';
import { ProductDetailGuard } from './products/product-detail.guard';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';




@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ConvertToSpacePipe,
    StarComponent,
    ProductDetailComponent,
    WelcomeComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      [
        { path: 'login', component: LoginComponent },
        { path: 'logout', component: LogoutComponent },
        { path: 'products', component: ProductListComponent },
        { path: 'products/:id', component: ProductDetailComponent, canActivate: [ProductDetailGuard] },
        { path: 'welcome', component: WelcomeComponent },
        { path: '', redirectTo: 'welcome', pathMatch: 'full' },
        { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
      ]
    )
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
