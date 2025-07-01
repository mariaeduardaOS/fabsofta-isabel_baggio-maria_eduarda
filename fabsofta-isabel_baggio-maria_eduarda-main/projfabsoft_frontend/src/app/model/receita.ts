export interface Receita {
    id?: number;
    nome: string;
    ingredientes: string[];
    modoPreparo: string;
    usuario?: string;
}
