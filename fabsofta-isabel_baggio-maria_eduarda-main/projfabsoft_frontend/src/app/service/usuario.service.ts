import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({ providedIn: 'root' })
export class UsuarioService {
  private apiBase = (window as any).env.apiUrl;
  private apiUrl = (this.apiBase ? this.apiBase : 'http://localhost:8080/api/v1') + '/usuarios';

  constructor(private http: HttpClient) {}

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiUrl);
  }

  getUsuarioById(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.apiUrl}/${id}`);
  }

  saveUsuario(usuario: Usuario): Observable<Usuario> {
    if (usuario.id) {
      return this.http.put<Usuario>(`${this.apiUrl}/${usuario.id}`, usuario);
    }
    return this.http.post<Usuario>(this.apiUrl, usuario);
  }

  excluirUsuario(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  login(credentials: { email: string; senha: string }): Observable<any> {
    return this.http.post<any>((this.apiBase ? this.apiBase : 'http://localhost:8080/api/v1') + '/login', credentials);
  }
}
