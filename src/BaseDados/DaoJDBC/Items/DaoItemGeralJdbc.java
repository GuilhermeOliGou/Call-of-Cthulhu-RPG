package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.Dao.Items.DaoItemGeral;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;

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
            throw new BaseDadosException("Erro no acesso");
        }
        try{
            if(rs.next()) {
                String tipo = rs.getString("tipo_item");
                DaoItemGeral dao = listaDao.get(tipo);
                return dao.Busca(codigo);

            }
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
        return null;

    }
    @Override
    public void Insere(Item item) throws BaseDadosException {
        DaoItemGeral dao = listaDao.get(item.getClass().getSimpleName());
        dao.Insere(item);
    }

    @Override
    public void Altera(Item item) throws BaseDadosException {
        DaoItemGeral dao = listaDao.get(item.getClass().getSimpleName());
        dao.Altera(item);
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT tipo_item FROM item WHERE id_item = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        try{
            if(rs.next()) {
                String tipo = rs.getString("tipo_item");
                DaoItemGeral dao = listaDao.get(tipo);
                dao.Remove(codigo);
            }
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
    }

    @Override
    public List<Item> Lista() throws BaseDadosException {
        return null;
    }
}
