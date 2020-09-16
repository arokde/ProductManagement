import { Component, OnInit } from '@angular/core';
import { IProduct } from '../product';
import { ProductService } from '../product.service';

@Component({
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  pageTitle = 'Product List';
  imageWidth = 50;
  imageMargin = 2;
  showImage  = false;
  _listFilter: string;
  products: IProduct[];
  filteredProducts: IProduct[];
  errorMessage: string;

  get listFilter(): string {
    return this._listFilter;
  }

  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredProducts = this.listFilter ? this.peformFilter(this.listFilter):this.products;
  }

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      {
        next: products => {
          this.products = products;
          this.filteredProducts = this.products;
        },
        error: err => this.errorMessage = err
      }
    );
  }

  toggleImage(): void  {
    this.showImage = !this.showImage;
  }
  peformFilter(filteredBy: string) : IProduct[] {
    filteredBy = filteredBy.toLowerCase();
    return this.products.filter((product: IProduct) => product.productName.toLowerCase().indexOf(filteredBy)!== -1)
  }
  onRatingClicked(event: string) : void {
      this.pageTitle = 'Product List:' + event;
  }
}
