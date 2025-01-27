import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  
    private apiUrl = 'http://localhost:3000/items';
  
    constructor(private http: HttpClient) { }
  
    getItems(): Observable<any[]> {
      return this.http.get<any[]>(this.apiUrl);
    }
  
    getItem(id: number): Observable<any> {
      return this.http.get<any>(`${this.apiUrl}/${id}`);
    }
  
    addItem(item: any): Observable<any> {
      return this.http.post<any>(this.apiUrl, item);
    }
  
    updateItem(item: any): Observable<any> {
      return this.http.put<any>(`${this.apiUrl}/${item.id}`, item);
    }
  
    deleteItem(id: number): Observable<any> {
      return this.http.delete<any>(`${this.apiUrl}/${id}`);
    }
}
