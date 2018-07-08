package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesTiroItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import Utilidades.Log;

import java.sql.SQLException;

public class HabilidadesTiroItemJdbc extends BancoDadosJdbc implements DaoHabilidadesTiroItem {

    public HabilidadesTiroItemJdbc() throws BaseDadosException{
        super();

    }

    @Override
    public HabilidadesTiro Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_tiro WHERE id_item = ?");

        HabilidadesTiro tiro = null;
        try{
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            if(rs.next()){
                short tiroPistola = rs.getShort("tiro_pistola");
                short tiroRifleEscopeta = rs.getShort("tiro_rifle");
                short tiroSubmetralhadora = rs.getShort("tiro_submetralhadora");
                short arremesso = rs.getShort("arremesso");

                tiro = new HabilidadesTiro(tiroPistola, tiroRifleEscopeta, tiroSubmetralhadora, arremesso);
            }
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Tiro");
        }
        fechaConexao();
        return tiro;
    }
}
