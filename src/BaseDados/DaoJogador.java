package BaseDados;

import ElementosDeJogo.Personagens.Jogador;

import java.util.List;

public interface DaoJogador {

    //Busca um Jogador no Banco de Dados e retorna suas informacoes
    public Jogador BuscaJogador(int codigo) throws BaseDadosException;

    //Registra um Jogador no Banco de Dados
    public void EscreveJogador(Jogador jogador) throws BaseDadosException;

    //Modifica um Jogador ja existente no Banco de Dados
    public void AlteraJogador(Jogador jogador) throws BaseDadosException;

    //Lista todos os Jogadores registrados na Base de Dados
    public List<Jogador> ListaJogadores() throws BaseDadosException;

}
