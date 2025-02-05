import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html'
})
export class CourseListComponent implements OnInit {
 
  courses: Course[];
  searchTerm: string;
  fc: Course[]; // filtered course (fc)
    
  constructor(private courseService: CourseService){}

  ngOnInit(): void {
    
    this.courseService.getCourses().subscribe((data) => {
      this.courses = data;
      this.fc = data;
    }, (error) => {
      console.log(error);
    } )
  }

  get filteredCourses(): Course[] {
    return this.courses.filter( (course) => {
      course.title.toLowerCase().includes(this.searchTerm.toLowerCase())
      || course.instructor.toLowerCase().includes(this.searchTerm.toLowerCase())
    } )
  }
  
}