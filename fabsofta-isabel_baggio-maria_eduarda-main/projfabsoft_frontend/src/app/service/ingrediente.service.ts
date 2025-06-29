import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ingrediente } from '../model/ingrediente';

@Injectable({
  providedIn: 'root'
})
export class IngredienteService {
  private apiURL = 'http://localhost:8080/api/v1/ingredientes';

  constructor(private http: HttpClient) { }

  getIngredientes() {
    return this.http.get<Ingrediente[]>(this.apiURL);
  }

  saveIngrediente(ingrediente: Ingrediente) {
    return this.http.post<Ingrediente>(this.apiURL, ingrediente);
  }

  updateIngrediente(id: number, ingrediente: Ingrediente) {
    return this.http.put<Ingrediente>(`${this.apiURL}/${id}`, ingrediente);
  }

  deleteIngrediente(id: number) {
    return this.http.delete(`${this.apiURL}/${id}`);
  }
}
