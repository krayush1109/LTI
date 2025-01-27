import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})

export class SurveyFormComponent {
  username: string = ' ';
  feedback: string = ' ';
  submitted: boolean = false;

  onMySubmit(form: NgForm){
    console.log("Form Submitted");
    console.log(form);
    console.log(form.valid);
    console.log(form.value.username1);        

    this.username = form.value.username1;
    this.feedback = form.value.feedback;
    this.submitted = true;

    // alert("Form Submitted");
  }


//todo: complete missing code..
}