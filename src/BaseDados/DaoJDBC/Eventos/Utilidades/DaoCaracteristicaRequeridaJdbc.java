package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoCaracteristicaRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeCaracteristicas;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoCaracteristicaRequeridaJdbc extends BancoDadosJdbc implements DaoCaracteristicaRequerida{

    public DaoCaracteristicaRequeridaJdbc() throws BaseDadosException {
        super();
    }

    @Override
    public FolhaDeCaracteristicas Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_caracteristicas WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Caracteristicas Evento Avancado");
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
            return caracteristicas;

        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Folha Caracteristicas Evento Avancado");
        }
    }

}
