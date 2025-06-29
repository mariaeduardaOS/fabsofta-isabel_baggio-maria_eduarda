import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Receita } from '../model/receita';

@Injectable({
  providedIn: 'root'
})
export class ReceitaService {
  private apiURL = 'http://localhost:8080/api/v1/receitas';

  constructor(private http: HttpClient) { }

  getReceitas() {
    return this.http.get<Receita[]>(this.apiURL);
  }

  saveReceita(receita: Receita) {
    return this.http.post<Receita>(this.apiURL, receita);
  }

  updateReceita(id: number, receita: Receita) {
    return this.http.put<Receita>(`${this.apiURL}/${id}`, receita);
  }

  deleteReceita(id: number) {
    return this.http.delete(`${this.apiURL}/${id}`);
  }
}
