import { Component } from '@angular/core';
import { Receita } from '../model/receita';
import { ReceitaService } from '../service/receita.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-cliente',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-receita.component.html',
  styleUrl: './form-receita.component.css',
  providers: [ReceitaService, Router]
})
export class FormReceitaComponent {
    receita: Receita = new Receita ();

    constructor(
      private receitaService: ReceitaService,
      private router: Router
    ){}

    salvar(){
      this.receitaService.saveReceita(this.receita)
        .subscribe(() => {
            this.router.navigate(['receitas']);
        });
    }
}