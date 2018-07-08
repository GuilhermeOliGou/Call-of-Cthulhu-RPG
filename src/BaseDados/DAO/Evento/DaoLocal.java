package BaseDados.Dao.Evento;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Geral.Dao;
import BaseDados.Dao.Geral.DaoBasico;
import DTO.ElementosDeSistema.Local;

public interface DaoLocal {
    public Local Busca(int idPersonagem, int idLocal) throws BaseDadosException;

    public void Altera(Local local, int idPersonagem) throws BaseDadosException;
}
