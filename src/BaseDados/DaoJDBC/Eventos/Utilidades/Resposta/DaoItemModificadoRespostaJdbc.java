package BaseDados.DaoJDBC.Eventos.Utilidades.Resposta;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.Resposta.DaoItemModificadoResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoItemModificadoRespostaJdbc extends BancoDadosJdbc implements DaoItemModificadoResposta {
    public DaoItemModificadoRespostaJdbc() throws BaseDadosException {
    }

    @Override
    public List<Integer[]> Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM item_modificado WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);

            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Item Alterado Resposta");
        }

        try {
            List<Integer[]> itemsModificados = new ArrayList<>();
            List<Integer> itemsAdicionados = new ArrayList<>();
            List<Integer> itemsRemovidos = new ArrayList<>();

            while(rs.next()){
                int idItem = rs.getInt("id_item");
                boolean adiciona = rs.getBoolean("adiciona");

                if(adiciona) itemsAdicionados.add(idItem);

                else itemsRemovidos.add(idItem);
            }
            Integer[] vetorAdicionado = itemsAdicionados.toArray(new Integer[0]);
            Integer[] vetorRemovido = itemsRemovidos.toArray(new Integer[0]);

            itemsModificados.add(vetorAdicionado);
            itemsModificados.add(vetorRemovido);

            return itemsModificados;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Item Modificado Resposta");
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException {
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        int[] itemsAdicionados = resposta.getItensAdicionados();
        int[] itemsRemovidos = resposta.getItensRemovidos();

        abreConexao();
        preparaComandoSQL("INSERT INTO item_modificado (id_item, adiciona, id_evento) VALUES (?, ?, ?)");

        try{
            ps.setInt(3, id);
            for(int i = 0; i < itemsAdicionados.length; i++){
                ps.setInt(1, itemsAdicionados[i]);
                ps.setBoolean(2, true);
                ps.execute();
            }

            for(int i = 0; i < itemsRemovidos.length; i++){
                ps.setInt(1, itemsRemovidos[i]);
                ps.setBoolean(2, false);
                ps.execute();
            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Item Modificado Resposta");
        }

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        int[] itemsAdicionados = resposta.getItensAdicionados();
        int[] itemsRemovidos = resposta.getItensRemovidos();

        abreConexao();
        preparaComandoSQL("UPDATE item_modificado SET id_item = ?, adiciona = ? WHERE id_evento = ?");

        try{
            ps.setInt(3, id);
            for(int i = 0; i < itemsAdicionados.length; i++){
                ps.setInt(1, itemsAdicionados[i]);
                ps.setBoolean(2, true);
                ps.execute();
            }

            for(int i = 0; i < itemsRemovidos.length; i++){
                ps.setInt(1, itemsRemovidos[i]);
                ps.setBoolean(2, false);
                ps.execute();
            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Item Modificado Resposta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM item_modificado WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Item Modificado Resposta");
        }
    }
}
