import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/movie.service';

@Component({
  selector: 'app-movie-add',
  templateUrl: './movie-add.component.html',
  styleUrls: ['./movie-add.component.css']
})
export class MovieAddComponent {

  movieForm: FormGroup;  

  newMovie = {
    "id": 5,
    "title": "Avenger",
    "director": "Tony Stark",
    "year": 2020
  };

  constructor(private fb: FormBuilder, private movieService: MovieService, private router: Router ) {
    
    this.movieForm = this.fb.group({
      title: ["", Validators.required],
      director: ["", Validators.required],
      year: ["", [Validators.required, Validators.min(1900), Validators.max(2025)]]
    })
  }

  addMovie(): void {
    // this.movieService.addMovie(this.newMovie).subscribe(() => {
    
    // dynamic form data coming from client
    this.movieService.addMovie(this.movieForm.value).subscribe(() => {
      this.router.navigate(['/']);
    })
  }

}
