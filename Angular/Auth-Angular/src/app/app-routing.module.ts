import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { BookDetailsComponent } from './book-details/book-details.component';
import { LibraryComponent } from './library/library.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', component: LibraryComponent },
  { path: 'book-details/:id', component: BookDetailsComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
