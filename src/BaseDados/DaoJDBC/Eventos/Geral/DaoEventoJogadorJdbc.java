package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEventoJogador;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import Utilidades.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEventoJogadorJdbc extends BancoDadosJdbc implements DaoEventoJogador {
    public DaoEventoJogadorJdbc() throws BaseDadosException {
    }

    @Override
    public List<Integer> Busca(int idPersonagem, int idLocal) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT id_evento FROM evento_jogador WHERE id_personagem = ?, id_local = ?");

        try {
            ps.setInt(1, idPersonagem);
            ps.setInt(2, idLocal);

            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Local Jogador");
        }
        try {
            List<Integer> idEventos = new ArrayList<>();

            while (rs.next()){
                int id = rs.getInt("id_evento");
                idEventos.add(id);
            }
            fechaConexao();
            if(idEventos.size() == 0) return null;
            return idEventos;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Local Jogador");
        }
    }

    @Override
    public void Insere(int idPersonagem) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("INSERT INTO evento_jogador (id_personagem, id_evento) SELECT ?, id_evento FROM evento");

        try {
            ps.setInt(1, idPersonagem);
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel gerar Evento Jogador");
        }

    }

    @Override
    public void Remove(int idPersonagem, int idEvento) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM evento_jogador WHERE id_evento = ?, id_personagem = ?");

        try {
            ps.setInt(1, idEvento);
            ps.setInt(2, idPersonagem);

            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel salvar Evento Jogador");
        }
    }

    public void RemoveJogador(int idPersonagem) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("DELETE FROM evento_jogador WHERE id_personagem = ?");

        try {
            ps.setInt(1, idPersonagem);
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel remover Evento Jogador");
        }
    }
}
