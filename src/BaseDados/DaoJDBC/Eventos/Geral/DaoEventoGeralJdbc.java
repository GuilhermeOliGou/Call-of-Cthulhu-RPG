package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.EventoGeral.*;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import Utilidades.Log;

import java.sql.SQLException;
import java.util.*;

public class DaoEventoGeralJdbc extends BancoDadosJdbc implements DaoEventoGeral {

    private Map<String, DaoEvento> listaDao;

    public DaoEventoGeralJdbc(DaoEventoBase daoEventoBase, DaoEventoAvancado daoEventoAvancado, DaoEventoLuta daoEventoLuta) throws BaseDadosException {
        super();

        listaDao = new HashMap<>();
        listaDao.put("Evento", daoEventoBase);
        listaDao.put("EventoAvancado", daoEventoAvancado);
        listaDao.put("EventoLuta", daoEventoLuta);
    }


    @Override
    public Evento Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT tipo_evento FROM evento WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar Busca Evento");
        }

        try {
            Evento evento = null;
            if(rs.next()) {
                String tipo = rs.getString("tipo_evento");
                DaoEvento dao = listaDao.get(tipo);
                evento = dao.Busca(codigo);
            }
            fechaConexao();
            return evento;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Evento");
        }
    }
}
