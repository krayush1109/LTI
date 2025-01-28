import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from 'src/app/movie.service';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})

export class EditMovieComponent implements OnInit {
  
  movieForm : FormGroup;  
  movieId : any;

  constructor( 
    private fb : FormBuilder,
    private movieService: MovieService, 
    private route : ActivatedRoute,
    private router : Router
  ){

    this.movieForm = this.fb.group({
      title: ['', Validators.required],
      director: ['', Validators.required],
      year: [null, [Validators.required, Validators.min(1900), Validators.max(new
      Date().getFullYear())]]
    })

  }

  ngOnInit(): void {
    const movieId = +this.route.snapshot.paramMap.get('id')!;

    this.movieService.getMovie(this.movieId).subscribe((data)=> {
      this.movieForm.patchValue(data);
    })

  }

  updateMovieBtn(): void {

    if(this.movieForm.valid){
      this.movieService.updateMovie({...this.movieForm.value, id: this.movieId})
      
      this.movieService.updateMovie(this.movieForm.value).subscribe((data) => {
        this.router.navigate(['/']);
      })
    }
    
  }

}
