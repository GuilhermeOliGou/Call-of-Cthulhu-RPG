package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoCaracteristicaRequerida;
import BaseDados.Dao.DaoHabilidadeRequerida;
import BaseDados.Dao.DaoItemRequerido;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoAvancado;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoBase;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;

import java.sql.SQLException;

public class DaoEventoAvancadoJdbc extends BancoDadosJdbc implements DaoEventoAvancado {


    private DaoEventoBase daoEventoBase;
    private DaoCaracteristicaRequerida daoCaracteristicaRequerida;
    private DaoItemRequerido daoItemRequerido;
    private DaoHabilidadeRequerida daoHabilidadeRequerida;

    public DaoEventoAvancadoJdbc(DaoEventoBase daoEventoBase, DaoCaracteristicaRequerida daoCaracteristicaRequerida, DaoItemRequerido daoItemRequerido, DaoHabilidadeRequerida daoHabilidadeRequerida) throws BaseDadosException {
        super();

        this.daoEventoBase = daoEventoBase;
        this.daoCaracteristicaRequerida = daoCaracteristicaRequerida;
        this.daoItemRequerido = daoItemRequerido;
        this.daoHabilidadeRequerida = daoHabilidadeRequerida;
    }


    @Override
    public Evento Busca(int codigo) throws BaseDadosException {

        Evento evento = daoEventoBase.Busca(codigo);

        String nome = evento.getNome();
        String descricao = evento.getDescricao();
        int idLocalRetorno = evento.getLocalDeRetorno();
        Resposta resposta = evento.getRespostaDoEvento();
        boolean eventoUnico = evento.isEventoUnico();


        abreConexao();
        preparaComandoSQL("SELECT * FROM evento_avancado WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel Buscar Evento Avancado");
        }

        try{
            EventoAvancado eventoAvancado = null;
            if(rs.next()){
                String falha = rs.getString("descricao_falha");

                Integer[] itemsRequeridos = daoItemRequerido.Busca(codigo);
                FolhaDeCaracteristicas caracteristicas = daoCaracteristicaRequerida.Busca(codigo);
                FolhaDeHabilidades habilidades = daoHabilidadeRequerida.Busca(codigo);

                eventoAvancado = new EventoAvancado(falha, itemsRequeridos, caracteristicas, habilidades, codigo, nome, descricao, idLocalRetorno, resposta, eventoUnico);
            }
            return eventoAvancado;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Evento Avancado");
        }
    }

}
