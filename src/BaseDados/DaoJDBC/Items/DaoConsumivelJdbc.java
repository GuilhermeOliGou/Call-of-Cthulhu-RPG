package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoConsumivelJdbc extends BancoDadosJdbc implements DaoConsumivel {

    private DaoItem daoItem;


    public DaoConsumivelJdbc(DaoItem daoItem) throws BaseDadosException{
        super();
        this.daoItem = daoItem;
    }

    @Override
    public ItemConsumivel Busca(int codigo) throws BaseDadosException {

        Item item = daoItem.Busca(codigo);

        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item_consumivel WHERE id_item = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            ItemConsumivel consumivel = null;
            if(rs.next()) {

                short hpRecuperada = rs.getShort("hp_recuperada");
                short mpRecuperada = rs.getShort("mp_recuperada");

                consumivel = new ItemConsumivel(item.getId(), item.getNome(), item.getDescricao(),
                        hpRecuperada, mpRecuperada);
            }
            fechaConexao();
            return consumivel;
        }catch (SQLException e ){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Item nao encontrado");
        }
    }
}
