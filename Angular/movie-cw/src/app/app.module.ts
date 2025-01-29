import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MovieAddComponent } from './components/movie-add/movie-add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditMovieComponent } from './components/edit-movie/edit-movie.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    MovieAddComponent,
    EditMovieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    HttpClientModule, // add this manually
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
