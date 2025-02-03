import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent {

  username: string = '';
  feedback: string = '';

  onFrmSubmit(frm: NgForm): void {
    console.log("Submit bnt clicked");

    // console.log(frm);
    // console.log(frm.form);
    
    // console.log(frm.value.username);
    // console.log(frm.value.feedback);
    // console.log(frm.valid);
    // console.log(frm.invalid);
    console.log(frm.submitted);
    console.log(frm.controls);
    console.log(frm.controls['username']);

    if(frm.valid){
      this.username = frm.value.username;
      this.feedback = frm.value.feedback;

      frm.reset();
    }

  }

  handleReset(frm: NgForm): void {
    console.log("reset btn")
    frm.reset();
  }

}
