package BaseDados.DaoJDBC;
import BaseDados.BaseDadosException;
import BaseDados.DAO.DaoItem;
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
    public Item BuscaItem(int codigo) throws BaseDadosException {
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
    public void EscreveItem(Item item) throws BaseDadosException {
        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO item (nome, descricao) VALUES (?, ?)");
            ps.setString(1, item.getNome());
            ps.setString(2, item.getDescricao());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Item");
        }
    }

    @Override
    public void AlteraItem(Item item) throws BaseDadosException {
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

    @Override
    public List<Item> ListaItens() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item");
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
    public List<Item> ListaItensPersonagem(int codigo) throws BaseDadosException {
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
