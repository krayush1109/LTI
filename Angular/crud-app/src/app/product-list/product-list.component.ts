// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-product-list',
//   imports: [],
//   templateUrl: './product-list.component.html',
//   styleUrl: './product-list.component.css'
// })
// export class ProductListComponent {

// }

// ===============================================
// ===============================================


import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : any[] = [];

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  public getAllProducts() : void{
    this.productService.getAllProducts().subscribe(data=>{
      this.products = data;
    });
  }

  public deleteProduct(productId : number) : void{
    this.productService.deleteProduct(productId).subscribe(data=>{
      this.getAllProducts();
    });
  }

}

