// import { Routes } from '@angular/router';

// export const routes: Routes = [];
// ==================================================
// ==================================================


import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { AddProductComponent } from './add-product/add-product.component';

const routes: Routes = [
  {path : 'products', component : ProductListComponent},
  {path : 'products/view/:productId', component : ViewProductComponent},
  {path : 'products/edit/:productId', component : EditProductComponent},
  {path : 'products/add', component : AddProductComponent},
  {path : '**', component : ProductListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }