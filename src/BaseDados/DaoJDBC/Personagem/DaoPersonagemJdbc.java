package BaseDados.DaoJDBC.Personagem;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.DaoPersonagem;
import BaseDados.Dao.Personagem.Utilidades.DaoAtributos;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.Personagem;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoPersonagemJdbc extends BancoDadosJdbc implements DaoPersonagem {

    private DaoAtributos daoAtributos;


    public DaoPersonagemJdbc(DaoAtributos daoAtributos) throws BaseDadosException{
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
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar a Busca Personagem");
        }

        try{
            Personagem personagem = null;
            if(rs.next()){
                FolhaDeAtributos atributos = daoAtributos.Busca(codigo);

                short idade = rs.getShort("idade");
                String nome = rs.getString("nome");
                int idLocal = rs.getInt("ultimo_local");

                daoAtributos.Busca(codigo);

                personagem = new Personagem(codigo, atributos, idade, nome, idLocal);
            }
            fechaConexao();
            return personagem;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Personagem");
        }
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("INSERT INTO personagem (idade, nome, ultimo_local) VALUES (?, ?, ?)");

        FolhaDeAtributos atributos = personagem.getAtributos();
        short idade = personagem.getIdade();
        String nome = personagem.getNome();
        int idLocal = 1;

        try {
            ps.setShort(1, idade);
            ps.setString(2, nome);
            ps.setInt(3, idLocal);

            ps.execute();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel inserir Personagem");
        }

        try{
            preparaComandoSQL("SELECT LAST_INSERT_ID()");
            rs = ps.executeQuery();
            if(rs.next()){
                personagem.setId(rs.getInt(1));
            }
            else{
                throw new BaseDadosException();
            }
            fechaConexao();
        }catch (Exception e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Não foi possível receber o ID do Personagem");
        }
        daoAtributos.Insere(personagem);
    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("UPDATE personagem SET idade = ?, nome = ?, ultimo_local = ? WHERE id_personagem = ?");

        FolhaDeAtributos atributos = personagem.getAtributos();
        short idade = personagem.getIdade();
        String nome = personagem.getNome();
        int idLocal = 1;
        int idPersonagem = personagem.getId();

        try {
            ps.setShort(1, idade);
            ps.setString(2, nome);
            ps.setInt(3, idLocal);
            ps.setInt(4, idPersonagem);

            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel modificar Personagem");
        }

        daoAtributos.Altera(personagem);
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        daoAtributos.Remove(codigo);

        abreConexao();
        preparaComandoSQL("DELETE FROM personagem WHERE id_personagem = ?");

        try {
            ps.setInt(1, codigo);
            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel remover Personagem");
        }
    }
}
