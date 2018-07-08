package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoBase;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoGeral;
import BaseDados.Dao.Evento.Resposta.DaoResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;

import java.sql.SQLException;
import java.util.LinkedList;

public class DaoEventoBaseJdbc extends BancoDadosJdbc implements DaoEventoBase {

    private DaoResposta daoResposta;

    public DaoEventoBaseJdbc(DaoResposta daoResposta) throws BaseDadosException {
        super();

        this.daoResposta = daoResposta;
    }

    @Override
    public Evento Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM evento WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel Buscar Evento");
        }

        try {
            if(rs.next()){
                String nome = rs.getString("nome_evento");
                String descricao = rs.getString("descricao_evento");
                int idLocalRetorno = rs.getInt("id_local_retorno");
                boolean eventoUnico = rs.getBoolean("evento_unico");

                Resposta resposta = daoResposta.Busca(codigo);

                return new Evento(codigo, nome, descricao, idLocalRetorno, resposta, eventoUnico);
            }
            return null;
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
