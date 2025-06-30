import { Ingrediente } from "./ingrediente";

export class Receita {
  id?: number;
  nome: string;
  ingredientes: Ingrediente[]; // Usando a classe Ingrediente
  modoPreparo: string;
  tempoPreparo: number;
  rendimento: number;
  usuario: string;
}