import { Routes } from '@angular/router';
import { CadastroComponent } from './auth/login-cadastro/cadastro/cadastro.component';
import { LoginCadastroComponent } from './auth/login-cadastro/login-cadastro.component';
import { HomeComponent } from './home/home.component';
import { ListaReceitaComponent } from './receita/lista-receita/lista-receita.component';
import { MinhasReceitasComponent } from './minhas-receitas/minhas-receitas.component';
import { DetalheReceitaComponent } from './receita/detalhe-receita/detalhe-receita.component';

export const routes: Routes = [
  { path: '', component: LoginCadastroComponent, pathMatch: 'full' },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'home', component: HomeComponent },
  { path: 'receitas', component: ListaReceitaComponent },
  { path: 'minhas-receitas', component: MinhasReceitasComponent },
  { path: 'receita/:id', component: DetalheReceitaComponent },
  { path: '**', redirectTo: '' }
];
