import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginCredentials, RegisterData, AuthResponse, RegisterResponse } from '../model/auth/auth.models';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // Altere esta URL para a URL real do seu backend de autenticação
  private apiUrl = 'http://localhost:8080/api/auth'; 

  constructor(private http: HttpClient) { }

  /**
   * Método para fazer o login do usuário.
   * Envia as credenciais para o backend e armazena o token no localStorage.
   * @param credentials O objeto com email e senha do usuário.
   * @returns Um Observable com a resposta da autenticação (geralmente um token).
   */
  login(credentials: LoginCredentials): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/login`, credentials).pipe(
      tap(response => {
        // Armazena o token no localStorage para uso futuro (ex: em um interceptor)
        if (response && response.token) {
          localStorage.setItem('authToken', response.token);
        }
      })
    );
  }

  /**
   * Método para registrar um novo usuário.
   * @param registerData O objeto com os dados de registro do usuário.
   * @returns Um Observable com a resposta do registro.
   */
  register(registerData: RegisterData): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(`${this.apiUrl}/register`, registerData);
  }

  /**
   * Verifica se o usuário está logado, checando a existência do token.
   * @returns true se o token existe, false caso contrário.
   */
  isLoggedIn(): boolean {
    return !!localStorage.getItem('authToken');
  }

  /**
   * Faz o logout do usuário, removendo o token do localStorage.
   */
  logout(): void {
    localStorage.removeItem('authToken');
  }
}