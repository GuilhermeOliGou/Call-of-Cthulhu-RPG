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
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            if(rs.next()) {

                String nome = rs.getString("nome_item");
                String descricao = rs.getString("descricao_item");

                fechaConexao();

                return new Item(codigo, nome, descricao);

            }
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
        return null;
    }

    @Override
    public void Insere(Item item) throws BaseDadosException {
        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO item (nome_item, descricao_item, tipo_item) VALUES (?, ?, ?)");
            ps.setString(1, item.getNome());
            ps.setString(2, item.getDescricao());
            ps.setString(3, item.getClass().getSimpleName());

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
            preparaComandoSQL("UPDATE item SET nome_item = ?, descricao_item = ? WHERE id_item = ?");
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
            preparaComandoSQL("DELETE FROM item WHERE id_item = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Não foi possivel remover o Item");
        }
    }

    @Override
    public List<Item> Lista() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM item WHERE tipo_item IS NULL");
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Item> itens = new ArrayList<>();
        try{
            while(rs.next()){

                int id = rs.getInt("id_item");
                String nome = rs.getString("nome_item");
                String descricao = rs.getString("descricao_item");

                Item item = new Item(id, nome, descricao);
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
    public List<Integer> ListaArma() throws BaseDadosException{
        abreConexao();
        try {
            preparaComandoSQL("SELECT id_item FROM item WHERE tipo_item = Arma");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Integer> itens = new ArrayList<>();
        try{
            while(rs.next()){

                itens.add(rs.getInt("id_item"));

            }

            fechaConexao();

            return itens;
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
    }

    @Override
    public List<Integer> ListaConsumivel() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT id_item FROM item WHERE tipo_item = Consumivel");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Integer> items = new ArrayList<>();
        try{
            while(rs.next()){

                int id = rs.getInt("id_item");

                items.add(id);
            }

            fechaConexao();

            return items;
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

    }

    @Override
    public List<Integer> ListaTodos() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT id_item FROM item");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Integer> items = new ArrayList<>();
        try{
            while(rs.next()){

                int id = rs.getInt("id_item");

                items.add(id);
            }

            fechaConexao();

            return items;
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

    }


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
