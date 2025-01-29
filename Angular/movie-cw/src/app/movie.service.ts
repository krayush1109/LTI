import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';// manually likhna hoga
import { Observable } from 'rxjs';
import { Movie } from './models/Movie.model';

// interface Movie {
//   id:number;
//   title: string;
//   director: string;
//   year: number;
// }


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private apiUrl = "http://localhost:3000/movies";

  constructor(private http : HttpClient  ) { }


  // add/create Movie
  addMovie(data: any): Observable<any>{
    return this.http.post<any>(this.apiUrl, data);
  }

  // get all movies
  getMovies(): Observable<Movie[]> {
    // return this.http.get<any>(this.apiUrl);
    return this.http.get<Movie[]>(this.apiUrl);
  }


  getMovie(id: any): Observable<Movie> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
  
  deleteMovie(id: any): Observable<void> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);   
  }

  updateMovie(movie: Movie): Observable<Movie>{
    return this.http.put<any>(`${this.apiUrl}/${movie.id}`, movie);
  }


}
