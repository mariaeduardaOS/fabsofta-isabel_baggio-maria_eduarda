import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginCredentials, RegisterData, AuthResponse, RegisterResponse } from '../model/auth/auth.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  login(credentials: LoginCredentials): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/login`, credentials);
  }

  cadastro(user: RegisterData): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(`${this.apiUrl}/cadastro`, user);
  }
}