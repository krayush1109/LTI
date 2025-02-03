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

  // start ----------- searching sorting ---------------
  searchTxt: string = "";
  filteredMovies: Movie[] = [];

  filterMovies(): void {
    
    if(this.searchTxt){
      this.filteredMovies = this.movies.filter((m) => {
        return m.title.toLowerCase().includes(this.searchTxt.toLowerCase()) || m.director.toLowerCase().includes(this.searchTxt.toLowerCase() );
      })
    } else{
      this.filteredMovies = [...this.movies];
    }

    console.log("inp search is ..." + this.searchTxt);  
    console.log(this.filteredMovies);

  }

  // end ----------- searching sorting ---------------

  constructor( private movieService: MovieService, private router: Router ){ }  

  ngOnInit(): void {
    // 1 ..............
    this.movieService.getMovies().subscribe( (data) => {
      // this.movies = data;
      this.filteredMovies = data;      
    } )

    // 2..............
    // this.reloadMovies();
  }

  reloadMovies(): void {
    this.movieService.getMovies().subscribe((data) => {
      // this.movies = data;
      this.movies = data.map(movie => ({
        ...movie,
        id: movie.id
      }));

      // 💫 filtering ->..->..->..
      this.filteredMovies = [...this.movies];

      console.log(this.movies);
    })
  }

  deleteMovie(id: any): void {
    this.movieService.deleteMovie(id).subscribe(()=> {
      this.movies = this.movies.filter(m => m.id !== id );
      this.reloadMovies();
      //console.log("Movie Deleted with having id: ", id);
    })
  }

  editMovie(id: any): void {
    // this.router.navigate([`/edit/${id}`]);
    this.router.navigateByUrl(`/edit/${id}`);
  }

}
