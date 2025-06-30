import { Component } from '@angular/core';

@Component({
  selector: 'app-minhas-receitas',
  templateUrl: './minhas-receitas.component.html',
  styleUrls: ['./minhas-receitas.component.css']
})
export class MinhasReceitasComponent {
  minhasReceitas = [
    { id: 3, nome: 'Minha Torta', descricao: 'Torta doce feita em casa' }
  ];
}