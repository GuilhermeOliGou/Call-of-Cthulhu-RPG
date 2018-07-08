package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.Dao.Items.DaoItemGeral;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import Utilidades.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoItemGeralJdbc extends BancoDadosJdbc implements DaoItemGeral {

    private Map<String, DaoItemGeral> listaDao;

    public DaoItemGeralJdbc(DaoItem daoItem, DaoArma daoArma, DaoConsumivel daoConsumivel) throws BaseDadosException {
        super();

        listaDao = new HashMap<>();
        listaDao.put("Item", daoItem);
        listaDao.put("Arma", daoArma);
        listaDao.put("ItemConsumivel", daoConsumivel);

    }

    @Override
    public Item Busca(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT tipo_item FROM item WHERE id_item = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Erro no acesso");
        }
        try{
            Item item = null;
            if(rs.next()) {
                String tipo = rs.getString("tipo_item");
                DaoItemGeral dao = listaDao.get(tipo);
                item = dao.Busca(codigo);

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
