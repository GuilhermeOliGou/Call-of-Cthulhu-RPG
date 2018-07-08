package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.Dao.Evento.EventoGeral.DaoEvento;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoGeral;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Local;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoLocalJdbc extends BancoDadosJdbc implements DaoLocal {

    private DaoEventoGeral daoEventoGeral;
    private DaoEventoJogador daoEventoJogador;

    public DaoLocalJdbc(DaoEventoGeral daoEventoGeral, DaoEventoJogador daoEventoJogador) throws Exception {
        super();
        this.daoEventoGeral = daoEventoGeral;
        this.daoEventoJogador = daoEventoJogador;

    }

    @Override
    public Local Busca(int idPersonagem, int idLocal) throws BaseDadosException {
        List<Integer> idEventos = daoEventoJogador.Busca(idPersonagem, idLocal);
        try {
            LinkedList<Evento> eventos = null;
            Local local = null;
            for(Integer idEvento : idEventos) {
                Evento evento = daoEventoGeral.Busca(idEvento);

            }

        } catch (SQLException e) {
            throw new BaseDadosException("Nao foi possivel encontrar Local");
        }
        return null;
    }

    @Override
    public void Altera(Local local) throws BaseDadosException {
        int IdLocal = local.getID();
        abreConexao();
        preparaComandoSQL("UPDATE local set nome = ? WHERE id_local = ?");

        try {
            ps.setString(1, local.getNome());
            ps.setInt(2, IdLocal);

            ps.execute();
        } catch (SQLException e) {
            throw new BaseDadosException("Nao foi possivel modificar Local");
        }

        List<Evento> eventos = local.getEventosDisponíveis();

        for (Evento evento : eventos) {
            daoEventoGeral.Altera(evento);
        }
    }
}