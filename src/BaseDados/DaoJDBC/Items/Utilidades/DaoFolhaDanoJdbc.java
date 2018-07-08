package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;

import BaseDados.Dao.Items.Utilidades.DaoFolhaDano;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import Utilidades.Log;

import java.sql.SQLException;
import java.util.List;

public class DaoFolhaDanoJdbc extends BancoDadosJdbc implements DaoFolhaDano {

    public DaoFolhaDanoJdbc() throws BaseDadosException{
        super();
    }

    @Override
    public FolhaDano Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_dano WHERE id_item = ?");
        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Falha no Acesso");
        }
        try {
            FolhaDano folhaDano = null;
            if(rs.next()){
                short rolagens[] = {rs.getShort("rolagem_1"), rs.getShort("rolagem_2"),
                        rs.getShort("rolagem_3"), rs.getShort("rolagem_4"),
                        rs.getShort("rolagem_5"), rs.getShort("rolagem_6")};

                short adicional = rs.getShort("adicional");

                boolean atordoamento = rs.getBoolean("atordoamento");

                folhaDano = new FolhaDano(rolagens, adicional, atordoamento);

            }
            fechaConexao();
            return folhaDano;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Não foi possivel encontrar a Folha Dano");
        }
    }
}
