package BaseDados.DaoJDBC.Personagem;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.DaoJogador;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.Jogador;

import java.util.List;

public class DaoJogadorJdbc extends BancoDadosJdbc implements DaoJogador {

    public DaoJogadorJdbc() throws Exception{
        super();

    }

    @Override
    public Jogador Busca(int codigo) throws BaseDadosException {

        abreConexao();


        return null;
    }

    @Override
    public void Insere(Jogador jogador) throws BaseDadosException {

    }

    @Override
    public void Altera(Jogador jogador) throws BaseDadosException {

    }

    @Override
    public List<Jogador> Lista() throws BaseDadosException {
        return null;
    }
}
