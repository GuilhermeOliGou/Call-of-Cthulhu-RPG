package BaseDados.DaoJDBC.Items;
import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.ItemConsumivel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DaoConsumivelJdbc extends BancoDadosJdbc implements DaoConsumivel {

    protected DaoItem daoItem;
    public DaoConsumivelJdbc(DaoItem daoItem) throws IOException{
        super();
        this.daoItem = daoItem;
    }
    @Override
    public ItemConsumivel Busca(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item_consumivel LEFT JOIN item ON item_consumivel.id_item = item.id_item WHERE id_item = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            rs.next();
            ItemConsumivel item = new ItemConsumivel(rs.getInt("id_item"),
                    rs.getString("nome_item"), rs.getString("item_descricao"),
                    rs.getShort("hp_recuperada"), rs.getShort("mp_recuperada"));
            fechaConexao();
            return item;
        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
    }

    @Override
    public void Insere(ItemConsumivel itemConsumivel) throws BaseDadosException {
        daoItem.Insere(itemConsumivel);
        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO item_consumivel (hp_recuperada, mp_recuperada, nome) VALUES (?, ?) SELECT nome FROM item WHERE item.id_item = ?");
            ps.setString(1, itemConsumivel.getNome());
            ps.setString(2, itemConsumivel.getDescricao());
            ps.setString(3, itemConsumivel.getNome());

            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Item");
        }
    }

    @Override
    public void Altera(ItemConsumivel itemConsumivel) throws BaseDadosException {
        daoItem.Altera(itemConsumivel);

        abreConexao();
        try{
            preparaComandoSQL("UPDATE item_consumivel SET hp_recuperada = ?, mp_recuperada = ?");
            ps.setShort(1, itemConsumivel.getHpRecuperado());
            ps.setShort(2, itemConsumivel.getMpRecuperado());
            ps.setInt(4, itemConsumivel.getId());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Arma");
        }
    }

    public void Remove(int codigo) throws BaseDadosException{
        daoItem.Remove(codigo);

        abreConexao();
        try {

            preparaComandoSQL("DELETE FROM item_consumivel WHERE id_item = ?");
            ps.setInt(1, codigo);
            ps.execute();
            fechaConexao();
        }
        catch(SQLException e){
            fechaConexao();
            throw new BaseDadosException("Não foi possível remover o Item");
        }
    }

    @Override
    public List<ItemConsumivel> Lista() throws BaseDadosException {
        return null;
    }

    @Override
    public List<ItemConsumivel> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
