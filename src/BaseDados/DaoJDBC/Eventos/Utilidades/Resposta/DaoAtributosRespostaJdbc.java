package BaseDados.DaoJDBC.Eventos.Utilidades.Resposta;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.Resposta.DaoAtributosResposta;
import BaseDados.Dao.Evento.Resposta.DaoCaracteristicasResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoAtributosRespostaJdbc extends BancoDadosJdbc implements DaoAtributosResposta {

    private DaoCaracteristicasResposta daoCaracteristicasResposta;

    public DaoAtributosRespostaJdbc(DaoCaracteristicasResposta daoCaracteristicasResposta) throws BaseDadosException {
        super();
        this.daoCaracteristicasResposta = daoCaracteristicasResposta;
    }

    @Override
    public FolhaDeAtributos Busca(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_atributos WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Atributos Resposta");
        }

        try {
            FolhaDeAtributos atributos = null;
            if(rs.next()){

                FolhaDeCaracteristicas caracteristicas = daoCaracteristicasResposta.Busca(codigo);

                short maxHp = rs.getShort("max_hp");
                short maxMp = rs.getShort("max_mp");
                short hpAtual = rs.getShort("hp_atual");
                short mpAtual = rs.getShort("mp_atual");
                short bonusDano = rs.getShort("bonus_dano");


                atributos = new FolhaDeAtributos(caracteristicas, maxHp, maxMp, hpAtual, mpAtual, bonusDano);
            }
            fechaConexao();
            return atributos;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Folha Atributos Resposta");
        }
    }
}
