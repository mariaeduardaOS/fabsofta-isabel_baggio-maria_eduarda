import { Component, ElementRef, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Receita } from '../model/receita';
import { ReceitaService } from '../service/receita.service';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-receita',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './receita.component.html',
  styleUrls: ['./receita.component.css'],
  providers: [ReceitaService, Router],
 
})
export class ReceitaComponent  {

  public listaReceitas: Receita[] = [];
  
  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  
  public receitaSelecionada: Receita | null = null; // Use 'null' para garantir segurança

  constructor(
    private receitaService: ReceitaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarReceitas();
  }

  ngAfterViewInit(): void {
    // Inicializa o modal apenas uma vez
    if (this.modalElement) {
        this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    }
  }

  // Método para carregar as receitas (melhor para reuso)
  carregarReceitas(): void {
    this.receitaService.getReceitas().subscribe({
      next: (resposta) => { 
        this.listaReceitas = resposta;
      },
      error: (error: HttpErrorResponse) => {
        console.error('Erro ao carregar receitas:', error);
      }
    });
  }

  novo(): void {
    this.router.navigate(['receitas/novo']);
  }

  alterar(receita: Receita): void {
    this.router.navigate(['receitas/alterar', receita.id]);
  }

  abrirConfirmacao(receita: Receita): void {
    this.receitaSelecionada = receita;
    // O modal já está inicializado, apenas o mostre
    if (this.modal) {
      this.modal.show();
    }
  }

  fecharConfirmacao(): void {
    if (this.modal) {
      this.modal.hide();
    }
    this.receitaSelecionada = null; // Limpa a receita selecionada
  }

  confirmarExclusao(): void {
    // A verificação já estava correta, apenas aprimorada
    if (this.receitaSelecionada && this.receitaSelecionada.id) {
      this.receitaService.excluirReceita(this.receitaSelecionada.id).subscribe({
        next: () => {
          this.fecharConfirmacao();
          this.carregarReceitas(); // Recarrega a lista após a exclusão
        },
        error: (error: HttpErrorResponse) => {
          console.error('Erro ao excluir receita:', error);
        }
      });
    } else {
        console.error('Nenhuma receita selecionada para exclusão ou ID ausente.');
        this.fecharConfirmacao();
    }
  }
}