package BaseDados.DaoJDBC;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.Dao.Personagem.DaoJogador;
import BaseDados.Dao.Personagem.DaoJogo;
import DTO.ElementosDeSistema.Local;
import DTO.Personagens.Jogador;

import java.util.List;

public class DaoJogoJdbc extends BancoDadosJdbc implements DaoJogo{

    private DaoJogador daoJogador;
    private DaoEventoJogador daoEventoJogador;

    public DaoJogoJdbc(DaoJogador daoJogador, DaoEventoJogador daoEventoJogador) throws BaseDadosException {
        super();
        this.daoJogador = daoJogador;
        this.daoEventoJogador = daoEventoJogador;
    }

    @Override
    public  List<Jogador> ListaJogos() throws BaseDadosException{
        return daoJogador.Lista();
    }
    @Override
    public Jogador CarregaJogo(int codigo) throws BaseDadosException {
        return daoJogador.Busca(codigo);
    }

    @Override
    public void CriaJogo(Jogador jogador) throws BaseDadosException {
        daoJogador.Insere(jogador);
        daoEventoJogador.Insere(jogador.getId());
    }

    @Override
    public void SalvaJogo(List<Local> locais, Jogador jogador) throws BaseDadosException {

    }

    @Override
    public void RemoveJogo(int codigo) throws BaseDadosException {
        daoJogador.Remove(codigo);
    }
}
