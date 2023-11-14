import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class DataService {

  private apiUrl = 'http://localhost:8080/api';  // Replace with your actual backend API URL

  constructor(private http: HttpClient) { }

  getMonsterById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/monsters/${id}`);
  }

  getAllMonsters(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/monsters`);
  }

  getTreasuresForMonster(monsterId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/monsters/${monsterId}/treasures`).pipe(
      catchError((error) => {
        if (error.status === 404) {
          // Handle 404 error (monster doesn't have treasures)
          // Return an empty array or any default value as needed
          return of([]);
        } else {
          // Re-throw the error for other cases
          throw error;
        }
      })
    );
  }

  getTreasureTypeById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/treasure-types/${id}`);
  }

  getAllTreasureTypes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/treasure-types`);
  }
}
