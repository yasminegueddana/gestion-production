import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MachineService {

  private baseUrl = 'http://localhost:8080/api/machines'; // adapte si besoin

  constructor(private http: HttpClient) { }

  // Obtenir toutes les machines
  getAllMachines(): Observable<any> {
    return this.http.get(this.baseUrl).pipe(
      catchError(this.handleError)
    );
  }

  // Supprimer une machine par ID
  deleteMachine(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  // (Optionnel) Ajouter une machine
  createMachine(machine: any): Observable<any> {
    return this.http.post(this.baseUrl, machine).pipe(
      catchError(this.handleError)
    );
  }

  // (Optionnel) Récupérer une machine par ID
  getMachineById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  // (Optionnel) Modifier une machine
  updateMachine(id: number, machine: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, machine).pipe(
      catchError(this.handleError)
    );
  }

  // Gestion des erreurs
  private handleError(error: HttpErrorResponse) {
    console.error('Erreur côté serveur :', error);
    return throwError(() => new Error('Une erreur est survenue. Veuillez réessayer plus tard.'));
  }
}
