import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Receita } from '../model/receita';
import { ReceitaService } from '../service/receita.service';

@Component({
  selector: 'app-receita',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './receita.component.html',
  styleUrl: './receita.component.css'
})
export class ReceitaComponent {
    listaReceitas: Receita[] = [];

    constructor(private receitaService: ReceitaService, private router: Router) {}

    ngOnInit() {
        this.receitaService.getReceitas().subscribe(receitas => {
            this.listaReceitas = receitas;
        });
    }

    novo() {
        this.router.navigate(['receitas/novo']);
    }

    alterar(receita: Receita) {
        this.router.navigate(['receitas/alterar', receita.id]);
    }
}