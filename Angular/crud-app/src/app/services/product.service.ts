// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class ProductService {

//   constructor() { }
// }

// =========================================
// =========================================


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl : string = "https://ide-ceddaddbdaecae322573671abecbaadaccedone.premiumproject.examly.io/proxy/3001/product";

  constructor(private httpClient : HttpClient) { }

  public getAllProducts() : Observable<Product[]>{
    return this.httpClient.get(this.baseUrl) as Observable<Product[]>; 
  }

  public addProduct(product : Product) : Observable<Product>{
    return this.httpClient.post(this.baseUrl,product) as  Observable<Product>;
  }

  public updateProduct(id : number, product : Product) : Observable<Product>{
    return this.httpClient.put(this.baseUrl+"/"+id,product) as Observable<Product>;
  }

  public deleteProduct(id : number) : Observable<any>{
    return this.httpClient.delete(this.baseUrl+"/"+id) as Observable<any>;
  }

  public getProductById(id : number) : Observable<Product>{
    return this.httpClient.get(this.baseUrl+"/"+id) as Observable<Product>;
  }
}
