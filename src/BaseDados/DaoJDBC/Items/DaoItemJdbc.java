package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoItemJdbc extends BancoDadosJdbc implements DaoItem {

    public DaoItemJdbc() throws BaseDadosException {
        super();
    }

    @Override
    public Item Busca(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item WHERE id_item = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            Item item = null;
            if(rs.next()) {

                String nome = rs.getString("nome_item");
                String descricao = rs.getString("descricao_item");

                item = new Item(codigo, nome, descricao);

            }
            fechaConexao();
            return item;

        }catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Item nao encontrado");
        }
    }

}
