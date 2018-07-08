package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.EventoGeral.DaoEventoGeral;
import BaseDados.Dao.Evento.DaoLocal;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Local;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoLocalJdbc extends BancoDadosJdbc implements DaoLocal {

    private DaoEventoGeral daoEventoGeral;
    
    public DaoLocalJdbc(DaoEventoGeral daoEventoGeral) throws Exception{
        super();
        this.daoEventoGeral = daoEventoGeral;
        
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
                LinkedList<Evento> eventos = daoEventoGeral.Lista(codigo);
            }
        }
        catch(SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Local");
        }
        return null;
    }

    @Override
    public void Insere(Local local) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("INSERT INTO local (nome) VALUES (?)");

        try{
            ps.setString(1, local.getNome());
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Local");
        }
        int IdLocal;
        try{
            preparaComandoSQL("SELECT LAST_INSERT_ID()");
            rs = ps.executeQuery();
            if(rs.next()){
                IdLocal = rs.getInt("id_local");
                local.setId(IdLocal);
            }
            else{
                throw new BaseDadosException();
            }
        }
        catch (Exception e){
            throw new BaseDadosException("Nao foi possivel receber o ID Local inserido");
        }

        List<Evento> eventos = local.getEventosDisponíveis();

        for(Evento evento : eventos){
            daoEventoGeral.Insere(evento);
        }
    }

    @Override
    public void Altera(Local local) throws BaseDadosException {
        int IdLocal = local.getID();
        abreConexao();
        preparaComandoSQL("UPDATE local set nome = ? WHERE id_local = ?");

        try{
            ps.setString(1, local.getNome());
            ps.setInt(2, IdLocal);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Local");
        }

        List<Evento> eventos = local.getEventosDisponíveis();

        for(Evento evento : eventos){
            daoEventoGeral.Altera(evento);
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        daoEventoGeral.Remove(codigo);

        abreConexao();
        preparaComandoSQL("DELETE FROM local WHERE id_local = ?");

        try {
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Local");
        }
    }

    @Override
    public List<Local> Lista() throws BaseDadosException {
        ArrayList<Local> locais = new ArrayList<>();

        abreConexao();
        preparaComandoSQL("SELECT * FROM local");

        try {
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a requisicao Lista Local");
        }

        try {
            while (rs.next()){
                int id = rs.getInt("id_local");
                String nome = rs.getString("nome_local");

                LinkedList<Evento> eventos = daoEventoGeral.Lista(id);

                Local local = new Local(nome, eventos, id);
                locais.add(local);
            }
            if(locais.size() == 0) return null;
            return locais;
        }
        catch (Exception e){
            throw new BaseDadosException("Nao foi possivel listar Local");
        }
    }


    public List<Local> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
