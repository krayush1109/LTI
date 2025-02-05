import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html'
})
export class CourseFormComponent {
  //reactive form name should be courseForm

  courseForm: FormGroup;
  successMessage: string;
  showAlert: Boolean;

  constructor(private fb: FormBuilder, private service: CourseService) {

    this.courseForm = this.fb.group({
      title: ['', Validators.required],
      instructor: ['', Validators.required],
      description: ['', Validators.required],
      duration: [0, [Validators.required, Validators.min(1), Validators.max(100), Validators.pattern('[0-9]*')  ]],
      difficulty: ['', Validators.required],
      userRating: [0, [Validators.required, Validators.min(1), Validators.max(5)]],
      enrollmentCount: [0, Validators.required],      
    })    
  }
  
  onSubmit(){
    if(this.courseForm.valid){

      this.service.addCourse(this.courseForm.value).subscribe((data) => {        
        this.successMessage = 'Course added successfully!';
        this.showAlert = true;
      }, (error) => console.log(error) )

    }
  }

  closeAlert(){
    this.showAlert = false;
  }

}