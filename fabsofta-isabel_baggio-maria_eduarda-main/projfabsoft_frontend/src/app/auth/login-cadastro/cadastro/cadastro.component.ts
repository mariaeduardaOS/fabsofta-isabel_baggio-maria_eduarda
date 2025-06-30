import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterData } from '../../../model/auth/auth.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  imports: [CommonModule, FormsModule],
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  cadastroData: RegisterData = {
    nome: '',
    email: '',
    password: ''
  };

  onCadastroSubmit(): void {
    console.log('Tentando cadastro com:', this.cadastroData);
  }

  constructor(private router: Router) {
    alert('Bem-vindo ao sistema de receitas! Você pode navegar pelas receitas, cadastrar novas e gerenciar suas receitas pessoais.');
    this.router.navigate(['/home']);
  }
}