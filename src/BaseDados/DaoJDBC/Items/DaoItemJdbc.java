package BaseDados.DaoJDBC.Items;
import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoItemJdbc extends BancoDadosJdbc implements DaoItem {

    public DaoItemJdbc() throws IOException {
        super();
    }

    @Override
    public Item Busca(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item WHERE id_item = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            rs.next();
            Item item = new Item(rs.getInt("id_item"), rs.getString("nome_item"), rs.getString("item_descricao"));
            fechaConexao();
            return item;
        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
    }

    @Override
    public void Insere(Item item) throws BaseDadosException {
        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO item (nome, descricao) VALUES (?, ?)");
            ps.setString(1, item.getNome());
            ps.setString(2, item.getDescricao());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Item");
        }
        try{
            preparaComandoSQL("SELECT LAST_INSERT_ID()");
            rs = ps.executeQuery();
            if(rs.next()){
                item.setId(rs.getInt(1));
            }
            else{
                throw new BaseDadosException();
            }
        }catch (Exception e){
            throw new BaseDadosException("Não foi possível receber o ID do Item");
        }
    }

    @Override
    public void Altera(Item item) throws BaseDadosException {
        abreConexao();
        try{
            preparaComandoSQL("UPDATE item SET nome = ?, descricao = ? WHERE idItem = ?");
            ps.setString(1, item.getNome());
            ps.setString(2, item.getDescricao());
            ps.setInt(3, item.getId());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Não foi possivel modificar o Item");
        }
    }

    public void Remove(int codigo) throws BaseDadosException{
        abreConexao();
        try{
            preparaComandoSQL("DELETE FROM item WHERE id.item = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Não foi possivel modificar o Item");
        }
    }

    @Override
    public List<Item> Lista() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item WHERE tipo_item IS NULL");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Item> itens = new ArrayList<>();
        try{
            while(rs.next()){
                Item item = new Item(rs.getInt("id_item"), rs.getString("nome_item"),rs.getString("descricao_item"));
                itens.add(item);
            }
            fechaConexao();
            return itens;
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
    }

    @Override
    public List<Item> ListaDoPersonagem(int codigo) throws BaseDadosException {
        abreConexao();
        try{
            preparaComandoSQL("SELECT * FROM inventario LEFT JOIN item ON inventario.id_item = item.id_item WHERE id_jogador = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Item> inventario = new ArrayList<>();
        try{
            while(rs.next()){
                Item item = new Item(rs.getInt("id_item"), rs.getString("nome_item"), rs.getString("descricao_item"));
                inventario.add(item);
            }
            fechaConexao();
            return inventario;
        }
        catch (SQLException e) {
            fechaConexao();
            return null;
        }
    }
}
