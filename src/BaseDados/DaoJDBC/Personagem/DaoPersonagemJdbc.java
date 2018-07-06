package BaseDados.DaoJDBC.Personagem;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.DaoPersonagem;
import BaseDados.Dao.Personagem.Utilidades.DaoAtributos;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.Personagem;

import java.sql.SQLException;
import java.util.List;

public class DaoPersonagemJdbc extends BancoDadosJdbc implements DaoPersonagem {

    private DaoAtributos daoAtributos;


    public DaoPersonagemJdbc(DaoAtributos daoAtributos) throws Exception{
        super();
        this.daoAtributos = daoAtributos;
    }


    @Override
    public Personagem Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM personagem WHERE id_personagem  = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Personagem");
        }

        try{
            if(rs.next()){
                FolhaDeAtributos atributos = daoAtributos.Busca(codigo);

                short idade = rs.getShort("idade");
                String nome = rs.getString("nome_personagem");
            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Personagem");
        }
        return null;
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException {

    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }

    @Override
    public List<Personagem> Lista() throws BaseDadosException {
        return null;
    }


    public List<Personagem> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
