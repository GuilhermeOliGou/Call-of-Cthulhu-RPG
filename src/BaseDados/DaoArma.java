package BaseDados;

import DTO.Itens.Arma;

import java.util.List;

public interface DaoArma {
    //Busca uma Arma especifica no Banco de Dados e retorna suas descricoes.
    public Arma BuscaArma(int codigo) throws BaseDadosException;

    //Registra uma Arma "generica" no Banco de Dados
    public void EscreveArma(Arma arma) throws BaseDadosException;

    //Modifica uma Arma "generica" ja existente.
    public void AlteraArma(Arma arma) throws BaseDadosException;

    //Lista todos as Armas registradas no Banco de Dados.
    public List<Arma> ListaArma() throws BaseDadosException;

    //Lista as Armas de um dado Personagem (Seja um Jogador ou um NPC)
    public List<Arma> ListaArmaPersonagem(int codigo) throws BaseDadosException;
}
