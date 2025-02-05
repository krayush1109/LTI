import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  readonly apiUrl = "http://localhost:3000/rooms";

  constructor(private http : HttpClient) {  }

  addMovie(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  getRooms(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getRoomById(id: any) : Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  updateRoom(updatedRoom: any, id: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, updatedRoom);
  }

  deleteRoom(id: any): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

}
