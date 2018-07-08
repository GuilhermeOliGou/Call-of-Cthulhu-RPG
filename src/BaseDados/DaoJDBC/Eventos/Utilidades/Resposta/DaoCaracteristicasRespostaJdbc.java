package BaseDados.DaoJDBC.Eventos.Utilidades.Resposta;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.Resposta.DaoCaracteristicasResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeCaracteristicas;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoCaracteristicasRespostaJdbc extends BancoDadosJdbc implements DaoCaracteristicasResposta {
    public DaoCaracteristicasRespostaJdbc() throws BaseDadosException {
    }

    @Override
    public FolhaDeCaracteristicas Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_caracteristicas_resposta WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Caracteristicas");
        }

        try {
            FolhaDeCaracteristicas caracteristicas = null;
            if(rs.next()) {
                short forca = rs.getShort("forca");
                short constituicao = rs.getShort("constituicao");
                short tamanho = rs.getShort("tamanho");
                short destreza = rs.getShort("destreza");
                short poder = rs.getShort("poder");


                caracteristicas = new FolhaDeCaracteristicas(forca, constituicao, tamanho, destreza, poder);
            }
            fechaConexao();
            return caracteristicas;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Folha Caracteristicas Resposta");
        }
    }

}
