import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { FormsModule } from '@angular/forms';
import { LoginCredentials, RegisterData } from '../../model/auth/auth.models';

@Component({
  selector: 'app-login-cadastro',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login-cadastro.component.html',
  styleUrls: ['./login-cadastro.component.css']
})
export class LoginCadastroComponent {
  // para alternar entre login e cadastro
  isLoginMode = true;

  // dados para login
  loginData: LoginCredentials = {
    email: '',
    password: ''
  };

  // dados para cadastro
  cadastroData: RegisterData = {
    nome: '',
    email: '',
    password: ''
  };

  constructor(
    private router: Router,
    private authService: AuthService
  ) {}

  toggleMode(mode: 'login' | 'cadastro'): void {
    this.isLoginMode = (mode === 'login');
  }

  onLoginSubmit(): void {
    console.log('Tentando login com:', this.loginData);
    this.authService.login(this.loginData).subscribe({
      next: (response) => {
        console.log('Login bem-sucedido!', response);
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Falha no login:', error);
        alert('Falha na autenticação. Verifique suas credenciais.');
      }
    });
  }

  onCadastroSubmit(): void {
    console.log('Tentando cadastro com:', this.cadastroData);
    this.authService.cadastro(this.cadastroData).subscribe({
      next: (response) => {
        console.log('Cadastro bem-sucedido!', response);
        alert('Cadastro realizado com sucesso! Faça login para continuar.');
        this.toggleMode('login');
      },
      error: (error) => {
        console.error('Falha no cadastro:', error);
        alert('Falha ao cadastrar. Tente novamente.');
      }
    });
  }
}
