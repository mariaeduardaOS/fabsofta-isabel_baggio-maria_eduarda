import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Receita } from '../model/receita';

@Injectable({ providedIn: 'root' })
export class ReceitaService {
    private apiURL = 'http://localhost:8080/api/v1/receitas';

    constructor(private http: HttpClient) {}

    getReceitas(): Observable<Receita[]> {
        return this.http.get<Receita[]>(this.apiURL);
    }

    getReceitaById(id: number): Observable<Receita> {
        return this.http.get<Receita>(`${this.apiURL}/${id}`);
    }

    saveReceita(receita: Receita): Observable<Receita> {
        if (receita.id) {
            return this.http.put<Receita>(`${this.apiURL}/${receita.id}`, receita);
        }
        return this.http.post<Receita>(this.apiURL, receita);
    }

    excluirReceita(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiURL}/${id}`);
    }
}