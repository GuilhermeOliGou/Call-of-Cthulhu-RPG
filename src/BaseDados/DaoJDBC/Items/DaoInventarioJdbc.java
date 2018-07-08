package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.DaoInventario;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;
import Utilidades.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoInventarioJdbc extends BancoDadosJdbc implements DaoInventario {

    public DaoInventarioJdbc() throws BaseDadosException {
        super();
    }

    @Override
    public List<Integer[]> Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM inventario WHERE id_personagem = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
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
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Inventario Jogador");
        }
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException {
        Jogador jogador = (Jogador) personagem;
        int id = personagem.getId();
        Integer[] inventario = jogador.getInventario();
        Integer[] quantidade = jogador.getQuantidades();

        if(inventario == null) return;

        abreConexao();
        preparaComandoSQL("INSERT INTO inventario (id_personagem, id_item, quantidade) VALUES (?, ?, ?)");

        try {
            for(int i = 0; i < inventario.length; i++){
                ps.setInt(1, id);
                ps.setInt(2, inventario[i]);
                ps.setInt(3, quantidade[i]);

                ps.execute();
            }
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel atualizar Inventario Jogador");
        }
    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {
        Jogador jogador = (Jogador) personagem;

        Remove(personagem.getId());
        Insere(jogador);

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM inventario WHERE id_personagem = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Não foi possivel remover Inventario Jogador");
        }
    }
}
