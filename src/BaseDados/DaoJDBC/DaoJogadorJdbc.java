package BaseDados.DaoJDBC;

import BaseDados.BaseDadosException;
import BaseDados.DAO.DaoJogador;
import DTO.Personagens.Jogador;

import java.util.List;

public class DaoJogadorJdbc implements DaoJogador {
    @Override
    public Jogador BuscaJogador(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveJogador(Jogador jogador) throws BaseDadosException {

    }

    @Override
    public void AlteraJogador(Jogador jogador) throws BaseDadosException {

    }

    @Override
    public List<Jogador> ListaJogadores() throws BaseDadosException {
        return null;
    }
}
