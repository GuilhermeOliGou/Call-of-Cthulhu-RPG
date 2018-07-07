package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEvento;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;

import java.util.LinkedList;

public class DaoEventoBaseJdbc extends BancoDadosJdbc implements DaoEvento{
    public DaoEventoBaseJdbc() throws BaseDadosException {
    }

    @Override
    public LinkedList<Evento> Lista(int IdLocal) throws BaseDadosException {
        return null;
    }

    @Override
    public Evento Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM evento WHERE id_evento = ?");
        return null;
    }

    @Override
    public void Insere(Evento evento, int localId) throws BaseDadosException {

    }

    @Override
    public void Altera(Evento evento, int localId) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }
}
