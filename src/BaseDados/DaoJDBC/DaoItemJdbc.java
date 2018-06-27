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
            preparaComandoSQL("SELECT * FROM ListaItem WHERE idItem = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            rs.next();
            Item item = new Item(rs.getInt(0), rs.getString(1), rs.getString(2));
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
            preparaComandoSQL("INSERT INTO ListaItem (nome, descricao) VALUES (?, ?)");
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
            preparaComandoSQL("UPDATE ListaItem SET nome = ?, descricao = ? WHERE idItem = ?");
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
            preparaComandoSQL("SELECT * FROM ListaItem");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Item> itens = new ArrayList<>();
        try{
            while(rs.next()){
                Item item = new Item(rs.getInt(0), rs.getString(1),rs.getString(2));
                itens.add(item);
                fechaConexao();
                return itens;
            }
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        return null;
    }

    @Override
    public List<Item> ListaItensPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}