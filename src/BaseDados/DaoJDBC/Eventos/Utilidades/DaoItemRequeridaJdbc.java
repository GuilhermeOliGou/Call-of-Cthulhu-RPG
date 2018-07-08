package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoItemRequerido;
import BaseDados.Dao.Evento.Utilidades.DaoUtilidadeEvento;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;

import java.sql.SQLException;

public class DaoItemRequeridaJdbc extends BancoDadosJdbc implements DaoItemRequerido {


    @Override
    public Integer[] Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM item_requerido WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel Buscar Item Requerido");
        }

        try {
            List<>
            while(rs.next()){

            }
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }
}
