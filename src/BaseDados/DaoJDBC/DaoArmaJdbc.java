package BaseDados.DaoJDBC;

import BaseDados.BaseDadosException;
import BaseDados.DAO.DaoArma;
import DTO.Itens.Arma;

import java.sql.SQLException;
import java.util.List;

public class DaoArmaJdbc extends BancoDadosJdbc implements DaoArma{

    public DaoArmaJdbc()throws BaseDadosException{
        super();
    }

    @Override
    public Arma BuscaArma(int codigo) throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM arma LEFT JOIN item ON arma.id_item = item.id_item WHERE arma.id_item = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            rs.next();
            Arma item = new Arma(rs.getInt("id_item"), rs.getString("nome_item"), rs.getString("descricao_item"), );
            fechaConexao();
            return item;
        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Item nao encontrado");
        }
    }

    @Override
    public void EscreveArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public void AlteraArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public List<Arma> ListaArma() throws BaseDadosException {
        return null;
    }

    @Override
    public List<Arma> ListaArmaPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
