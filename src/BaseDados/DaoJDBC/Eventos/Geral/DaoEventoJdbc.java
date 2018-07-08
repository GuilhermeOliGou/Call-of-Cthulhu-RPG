package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.EventoGeral.*;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import java.sql.SQLException;
import java.util.*;

public class DaoEventoJdbc extends BancoDadosJdbc implements DaoEventoGeral {

    private Map<String, DaoEvento> listaDao;

    public DaoEventoJdbc(DaoEventoBase daoEventoBase, DaoEventoAvancado daoEventoAvancado, DaoEventoLuta daoEventoLuta) throws BaseDadosException {
        super();

        listaDao = new HashMap<>();
        listaDao.put("base", daoEventoBase);
        listaDao.put("avancado", daoEventoAvancado);
        listaDao.put("luta", daoEventoLuta);
    }


    @Override
    public LinkedList<Evento> Lista(int idLocal) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM evento WHERE id_local = ?");

        try {
            ps.setInt(1, idLocal);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi realizar  Lista Eventos");
        }

        try {
            LinkedList<Evento> eventos = new LinkedList<>();
            while(rs.next()){
                String tipo = rs.getString("tipo_evento");
                int id = rs.getInt("id_evento");

                DaoEvento dao = listaDao.get(tipo);
                Evento evento = dao.Busca(id);

                eventos.add(evento);

            }
            if(eventos.size() == 0) return null;
            return eventos;
        }
        catch (Exception e){
            throw new BaseDadosException("Nao foi possivel listar Eventos");
        }
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
            throw new BaseDadosException("Nao foi possivel realizar Busca Evento");
        }

        try {
            Evento evento = null;
            if(rs.next()) {
                String tipo = rs.getString("tipo_evento");
                DaoEvento dao = listaDao.get(tipo);
                evento = dao.Busca(codigo);
            }
            return evento;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Evento");
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }
}
