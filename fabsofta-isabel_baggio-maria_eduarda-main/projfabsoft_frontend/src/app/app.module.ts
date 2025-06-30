import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ReceitaComponent } from './receita/receita.component';
import { NgModule } from '@angular/core';
import { CadastroComponent } from './auth/login-cadastro/cadastro/cadastro.component';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [ReceitaComponent, CadastroComponent], // aqui
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    FormsModule
  ],
  bootstrap: [AppComponent] 
})
export class AppModule { }
