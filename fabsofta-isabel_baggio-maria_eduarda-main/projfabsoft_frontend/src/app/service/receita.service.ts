import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

export interface Ingrediente {
  quantidade: number;
  unidade: string;
  nome: string;
}

export interface Receita {
  id?: number;
  titulo: string;
  descricao: string;
  ingredientes: Ingrediente[];
  modoPreparo: string;
}

export class ReceitaService {
  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  listarReceitas(): Observable<Receita[]> {
    return this.http.get<Receita[]>(`${this.baseUrl}/receitas`);
  }

  buscarReceitasPorIngrediente(ingredienteNome: string): Observable<Receita[]> {
    return this.listarReceitas().pipe(
      map(receitas =>
        receitas.filter(receita =>
          receita.ingredientes.some(i =>
            i.nome.toLowerCase().includes(ingredienteNome.toLowerCase())
          )
        )
      )
    );
  }
}
