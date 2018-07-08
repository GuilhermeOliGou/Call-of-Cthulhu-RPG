package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoGeral;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Local;
import Utilidades.Log;

import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

public class DaoLocalJdbc extends BancoDadosJdbc implements DaoLocal {

    private DaoEventoGeral daoEventoGeral;
    private DaoEventoJogador daoEventoJogador;

    public DaoLocalJdbc(DaoEventoGeral daoEventoGeral, DaoEventoJogador daoEventoJogador) throws BaseDadosException {
        super();
        this.daoEventoGeral = daoEventoGeral;
        this.daoEventoJogador = daoEventoJogador;

    }

    @Override
    public Local Busca(int idPersonagem, int idLocal) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * local WHERE id_local = ?");
        String nome = "";
        try {
            ps.setInt(1, idLocal);
            rs = ps.executeQuery();

            if(rs.next()){
                nome = rs.getString("nome_local");
            }
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel buscar Local");
        }


        List<Integer> idEventos = daoEventoJogador.Busca(idPersonagem, idLocal);
        LinkedList<Evento> eventos = null;
        Local local = null;
        for(Integer idEvento : idEventos) {
            Evento evento = daoEventoGeral.Busca(idEvento);
            eventos.add(evento);
        }
        local = new Local(nome, eventos, idLocal);
        fechaConexao();
        return local;
    }

    @Override
    public void Altera(Local local, int idPersonagem) throws BaseDadosException {
        int IdLocal = local.getID();
        List<Evento> eventos = local.getEventosDisponíveis();

        for (Evento evento : eventos) {
            if(!evento.isEventoValido()) daoEventoJogador.Remove(idPersonagem, evento.getID());
        }
    }

}