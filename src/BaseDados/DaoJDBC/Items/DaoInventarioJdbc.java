package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoItemGeral;
import BaseDados.Dao.Personagem.DaoInventario;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import DTO.Personagens.Personagem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoInventarioJdbc extends BancoDadosJdbc implements DaoInventario {

    private DaoItemGeral daoItemGeral;
    public DaoInventarioJdbc() throws BaseDadosException {
    }

    @Override
    public List<Integer[]> Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM inventario WHERE id_personagem = ?");

        try {
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel buscar Inventario Jogador");
        }

        try {
            List<Integer> items = new ArrayList<>();
            List<Integer> quantidade = new ArrayList<>();
            List<Integer[]> inventario = new ArrayList<>();
            while (rs.next()){
                int idItem = rs.getInt("id_item");
                int qntdItem = rs.getShort("quantidade");
                items.add(idItem);
                quantidade.add(qntdItem);
            }
            if(items.size() == 0) return null;
            Integer vetorItems[] = items.toArray(new Integer[0]);
            Integer vetorQuantidade[] = quantidade.toArray(new Integer[0]);

            inventario.add(vetorItems);
            inventario.add(vetorQuantidade);

            return inventario;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Inventario Jogador");
        }
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException {

    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("UPDATE inventario SET id_item = ?");


    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }
}
