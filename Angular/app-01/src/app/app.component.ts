import { Component, NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MovieComponent } from './movie/movie.component';
import { BrowserModule } from '@angular/platform-browser';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'app-01';
}
