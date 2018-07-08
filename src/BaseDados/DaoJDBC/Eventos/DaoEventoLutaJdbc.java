package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.EventoGeral.DaoEvento;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoBase;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoLuta;
import BaseDados.Dao.Personagem.DaoPersonagem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoLuta;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.Personagem;

import java.sql.SQLException;

public class DaoEventoLutaJdbc extends BancoDadosJdbc implements DaoEventoLuta{

    private DaoEventoBase daoEventoBase;
    private DaoPersonagem daoPersonagem;

    public DaoEventoLutaJdbc(DaoEventoBase daoEventoBsae, DaoPersonagem daoPersonagem) throws BaseDadosException {
        super();
        this.daoEventoBase = daoEventoBsae;
        this.daoPersonagem = daoPersonagem;

    }

    @Override
    public Evento Busca(int codigo) throws BaseDadosException {
        Evento evento = daoEventoBase.Busca(codigo);

        String nome = evento.getNome();
        String descricao = evento.getDescricao();
        Resposta resposta = evento.getRespostaDoEvento();
        int idLocalRetorno = evento.getLocalDeRetorno();
        boolean eventoUnico = evento.isEventoUnico();


        abreConexao();
        preparaComandoSQL("SELECT * FROM evento_luta WHERE id_evento = ?");
        try{
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e) {
            throw new BaseDadosException("Nao foi possivel Buscar Evento Luta");
        }

        try{
            EventoLuta eventoLuta = null;
            if(rs.next()){
                int idPersonagem = rs.getInt("id_personagem");

                Personagem personagem = daoPersonagem.Busca(idPersonagem);

                eventoLuta = new EventoLuta(codigo, nome, descricao, idLocalRetorno, resposta, eventoUnico, personagem);
            }
            return eventoLuta;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Evento Luta");
        }
    }
}
