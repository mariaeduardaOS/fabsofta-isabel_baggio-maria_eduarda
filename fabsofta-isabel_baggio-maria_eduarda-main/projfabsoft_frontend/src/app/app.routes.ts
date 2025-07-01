import { Routes } from '@angular/router';
import { ListaReceitaComponent } from './receita/lista-receita/lista-receita.component';
import { MinhasReceitasComponent } from './minhas-receitas/minhas-receitas.component';
import { FormReceitaComponent } from './form-receita/form-receita.component';
import { DetalheReceitaComponent } from './receita/detalhe-receita/detalhe-receita.component';
import { HomeComponent } from './home/home.component';


export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'home', component: HomeComponent },
  { path: 'receitas/:id', component: DetalheReceitaComponent },
];
export const receitaRoutes: Routes = [
  { path: '', component: ListaReceitaComponent },
  { path: 'novo', component: FormReceitaComponent },
  { path: 'alterar/:id', component: FormReceitaComponent },
  { path: 'detalhe/:id', component: DetalheReceitaComponent },
];
