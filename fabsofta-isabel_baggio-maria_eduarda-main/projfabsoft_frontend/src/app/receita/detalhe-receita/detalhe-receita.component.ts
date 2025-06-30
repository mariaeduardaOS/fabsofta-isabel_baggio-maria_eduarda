import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalhe-receita',
  templateUrl: './detalhe-receita.component.html',
  styleUrls: ['./detalhe-receita.component.css']
})
export class DetalheReceitaComponent implements OnInit {
  receitaId: number;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.receitaId = Number(this.route.snapshot.paramMap.get('id'));
    // Aqui você pode buscar detalhes reais pelo ID
  }
}
