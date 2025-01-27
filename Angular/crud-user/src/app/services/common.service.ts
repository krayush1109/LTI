import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  readonly url = "http://localhost:3000";

  constructor(private http:HttpClient ) { }

    AddNewUser(data: any): Observable<any>{
      return this.http.post(this.url + "/users", data);
    }

    getAllUsers(): Observable<any>{
      return this.http.get(this.url + "/users");
    }

    getUserById(id : any): Observable<any>{
      // return this.http.get
      return this.http.get(`${this.url}/users/${id}`);
    }

    deleteUserById(id: any): Observable<any> {
      return this.http.delete(this.url + "/users/" + id);
    }

    updateUser(id: any, data: any): Observable<any> {
      return this.http.put(`${this.url}/users/${id}`, data);
    }

}
