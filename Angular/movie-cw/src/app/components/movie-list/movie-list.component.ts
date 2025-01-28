import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/Movie.model';
import { MovieService } from 'src/app/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit{

  movies: Movie[] = [];

  constructor( private movieService: MovieService, private router: Router ){ }

  ngOnInit(): void {
    this.movieService.getMovies().subscribe((data) => {
      this.movies = data;
      console.log(this.movies);
    })
  }

  deleteMovie(id: number): void {
    this.movieService.deleteMovie(id).subscribe(()=> {
      this.movies = this.movies.filter(m => m.id !- id );
      console.log("Movie Deleted with having id: ", id);
    })
  }

  editMovie(id: number): void {
    this.router.navigate([`/edit/${id}`]);
  }

}
