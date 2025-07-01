import { Component } from "@angular/core";
import { Receita } from "../model/receita"; 
import { ReceitaService } from "../service/receita.service";
import { HttpClientModule } from "@angular/common/http";
import { CommonModule } from "@angular/common";


@Component({
  selector: "app-receita",
  imports: [HttpClientModule, CommonModule],
  templateUrl: "./receita.component.html",
  styleUrls: ["./receita.component.css"],
  providers: [ReceitaService]
})
export class ReceitaComponent {

    public receitas: Receita[] = [];
    constructor
    (private receitaService: ReceitaService) {
    }
ngOnInit() {
    this.receitaService.listarReceitas().subscribe(resposta =>
        this.receitas = resposta
    );
}

