import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdreFabricationService {

  private baseUrl = 'http://localhost:8080/api/ordres';

  constructor(private http: HttpClient) { }

  // 🔁 Obtenir tous les ordres
  getAllOrdres(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  // 🔎 Obtenir un ordre par ID
  getOrdreById(id: number | string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // ➕ Créer un nouvel ordre
  createOrdre(ordre: any): Observable<any> {
    return this.http.post<any>(this.baseUrl, ordre);
  }

  // ✏️ Mettre à jour un ordre existant
  updateOrdre(id: number | string, ordre: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${id}`, ordre);
  }

  // ❌ Supprimer un ordre
  deleteOrdre(id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  // 🔁 Récupérer toutes les machines (suppose /api/machines existe)
  getAllMachines(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/machines');
  }

  // 🔁 Récupérer tous les produits (suppose /api/produits existe)
  getAllProduits(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/produits');
  }
}
