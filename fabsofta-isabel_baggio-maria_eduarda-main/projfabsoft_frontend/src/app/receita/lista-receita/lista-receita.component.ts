import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-receita',
  templateUrl: './lista-receita.component.html',
  styleUrls: ['./lista-receita.component.css']
})
export class ListaReceitaComponent {
  receitas = [
    { id: 1, nome: 'Lasanha de Frango', descricao: 'Deliciosa lasanha caseira' },
    { id: 2, nome: 'Bolo de Chocolate', descricao: 'Bolo fofinho e saboroso' }
  ];

  constructor(private router: Router) {}

  verDetalhes(id: number) {
    this.router.navigate(['/receita', id]);
  }
}