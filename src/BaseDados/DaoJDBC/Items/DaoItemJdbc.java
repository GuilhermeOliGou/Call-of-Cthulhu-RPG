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

}
