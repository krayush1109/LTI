import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'template-driven-form';
  
  reactiveForm: any = FormGroup;
  
  ngOnInit() {
    console.log("Hello");
    this.reactiveForm = new FormGroup({
      firstname : new FormControl(null, Validators.required),
      lastname: new FormControl(null, Validators.required),
      email: new FormControl("", [Validators.required, Validators.email])
    });
  }

  onSubmit(){
    console.log(this.reactiveForm);

    if(this.reactiveForm.valid){
      console.log("Form Submitted", this.reactiveForm.value);
    }else{
      console.log("Form is invalid");
    }

  }

} 
