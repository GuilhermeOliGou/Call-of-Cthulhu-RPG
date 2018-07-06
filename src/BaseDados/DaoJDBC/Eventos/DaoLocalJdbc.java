package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEvento;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Local;
import java.sql.SQLException;

import java.util.List;

public class DaoLocalJdbc extends BancoDadosJdbc implements DaoLocal {

    DaoEvento daoEvento;
    
    public DaoLocalJdbc() throws Exception{
        super();
        
    }

    @Override
    public Local Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM local WHERE id_local = ?");
        
        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Local");
        }
        
        try{
            if(rs.next()){
                List<Evento> eventos = dao
            }
        }
        catch(SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Local");
        }
        return null;
    }

    @Override
    public void Insere(Local local) throws BaseDadosException {

    }

    @Override
    public void Altera(Local local) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }

    @Override
    public List<Local> Lista() throws BaseDadosException {
        return null;
    }


    public List<Local> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
