package BaseDados.DaoJDBC.Items;
import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoConsumivel;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import DTO.Itens.ItemConsumivel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            if(rs.next()) {

                short hpRecuperada = rs.getShort("hp_recuperada");
                short mpRecuperada = rs.getShort("mp_recuperada");

                fechaConexao();

                return new ItemConsumivel(item.getId(), item.getNome(), item.getDescricao(),
                        hpRecuperada, mpRecuperada);
            }
        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
        return null;
    }

    @Override
    public void Insere(ItemConsumivel itemConsumivel) throws BaseDadosException {

        daoItem.Insere(itemConsumivel);

        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO item_consumivel (hp_recuperada, mp_recuperada, nome, id_item) VALUES (?, ?, ?, ?)");
            ps.setShort(1, itemConsumivel.getHpRecuperado());
            ps.setShort(2, itemConsumivel.getMpRecuperado());
            ps.setString(3, itemConsumivel.getNome());
            ps.setInt(4, itemConsumivel.getId());

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
        daoItem.Remove(codigo);
    }

    @Override
    public List<ItemConsumivel> Lista() throws BaseDadosException {
        List<Integer> items = daoItem.ListaConsumivel();
        List<ItemConsumivel> consumiveis = new ArrayList<>();
        for(Integer item : items)
            consumiveis.add(Busca(item));

        return consumiveis;
    }


    public List<ItemConsumivel> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
