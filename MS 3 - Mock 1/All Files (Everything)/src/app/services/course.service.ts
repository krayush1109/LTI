import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
 private apiUrl = environment.apiUrl + "/courses"; 
//  private apiUrl = environment.apiUrl + "/proxy/5000/courses"; 

  constructor(private http: HttpClient){}

//  getCourses(): Observable<any> {
 getCourses(): Observable<Course[]> {
  // return this.http.get(`${this.apiUrl}`);
  return this.http.get<Course[]>(`${this.apiUrl}`);
 }
 
 addCourse(course: Course): Observable<any> {
  return this.http.post(`${this.apiUrl}`, course);
 }

}