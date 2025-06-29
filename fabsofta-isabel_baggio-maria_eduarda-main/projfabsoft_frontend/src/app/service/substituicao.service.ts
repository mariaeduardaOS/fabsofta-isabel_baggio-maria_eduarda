import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Substituicao } from '../model/substituicao';

@Injectable({
  providedIn: 'root'
})
export class SubstituicaoService {
  private apiURL = 'http://localhost:8080/api/v1/substituicoes';

  constructor(private http: HttpClient) { }

  getSubstituicoes() {
    return this.http.get<Substituicao[]>(this.apiURL);
  }

  saveSubstituicao(substituicao: Substituicao) {
    return this.http.post<Substituicao>(this.apiURL, substituicao);
  }

  updateSubstituicao(id: number, substituicao: Substituicao) {
    return this.http.put<Substituicao>(`${this.apiURL}/${id}`, substituicao);
  }

  deleteSubstituicao(id: number) {
    return this.http.delete(`${this.apiURL}/${id}`);
  }
}
