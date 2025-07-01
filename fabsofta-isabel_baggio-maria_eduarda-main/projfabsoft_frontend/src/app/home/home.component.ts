import { Component, OnInit } from '@angular/core';
import { Receita } from '../models/receita.model';
import { ReceitaService } from '../services/receita.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  receitasRecentes: Receita[] = [];
  receitasBusca: Receita[] = [];
  busca: string = '';

  constructor(private receitaService: ReceitaService) {}

  ngOnInit(): void {
    this.carregarReceitasRecentes();
  }

  carregarReceitasRecentes(): void {
    this.receitaService.getReceitasRecentes().subscribe((data) => {
      this.receitasRecentes = data;
    });
  }

  buscar(): void {
    if (this.busca.trim() === '') {
      this.receitasBusca = [];
      return;
    }
    this.receitaService.buscarPorIngrediente(this.busca).subscribe((data) => {
      this.receitasBusca = data;
    });
  }

  formatarIngrediente(quantidade: number, unidade: string, nome: string): string {
    return `${quantidade} ${unidade} ${nome}`.trim();
  }
}
