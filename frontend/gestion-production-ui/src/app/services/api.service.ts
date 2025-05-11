import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api'; // URL de votre backend

  constructor(private http: HttpClient) {}

  getMachines(): Observable<any> {
    return this.http.get(`${this.baseUrl}/machines`);
  }

  addMachine(machine: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/machines`, machine);
  }

  getTechniciens(): Observable<any> {
    return this.http.get(`${this.baseUrl}/techniciens`);
  }

  addTechnicien(technicien: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/techniciens`, technicien);
  }
}