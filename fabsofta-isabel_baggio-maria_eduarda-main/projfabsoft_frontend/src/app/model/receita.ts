import { Ingrediente } from "./ingrediente";
import { Usuario } from "./usuario";

export class Receita {
    id: number;
    nome: string;
    modoPreparo: string;
    ingredientes: string[]; // Se for lista simples de nomes, pode deixar string[]
    usuario: string; // ou: usuario: Usuario; se quiser trabalhar com o objeto completo
}
