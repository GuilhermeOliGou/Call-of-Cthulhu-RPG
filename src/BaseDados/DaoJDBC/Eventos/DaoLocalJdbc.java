package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Local;

import java.util.List;

public class DaoLocalJdbc extends BancoDadosJdbc implements DaoLocal {

    public DaoLocalJdbc() throws Exception{
        super();
    }

    @Override
    public Local Busca(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void Insere(Local local) throws BaseDadosException {

    }

    @Override
    public void Altera(Local local) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }

    @Override
    public List<Local> Lista() throws BaseDadosException {
        return null;
    }


    public List<Local> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
