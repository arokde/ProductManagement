import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IProduct } from './product';
import { ProductService } from './product.service';

@Component({
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  pageTitle: string;
  product: IProduct;
  errorMessage: string;

  constructor(private route: ActivatedRoute,
    private productService: ProductService,
    private router: Router) {
  }

  ngOnInit(): void {
    // +for converting the string to int
    let id = +this.route.snapshot.paramMap.get('id');
    this.pageTitle = `Product Detail: ${id}`;
    this.productService.getProduct(id).subscribe(
      {
        next: product => {
          this.product = product;
        },
        error: err => this.errorMessage = err
      }
    );
  }


  onBack(): void {
    this.router.navigate(['/products']);
  }




}
