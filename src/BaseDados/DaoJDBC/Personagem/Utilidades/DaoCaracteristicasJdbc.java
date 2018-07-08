package BaseDados.DaoJDBC.Personagem.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.Utilidades.DaoCaracteristicas;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Personagem;

import java.sql.SQLException;

public class DaoCaracteristicasJdbc extends BancoDadosJdbc implements DaoCaracteristicas {

    public DaoCaracteristicasJdbc() throws BaseDadosException{
        super();
    }

    @Override
    public FolhaDeCaracteristicas Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_caracteristicas WHERE id_personagem = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Caracteristicas");
        }

        try {
            short forca = rs.getShort("forca");
            short constituicao = rs.getShort("constituicao");
            short tamanho = rs.getShort("tamanho");
            short destreza = rs.getShort("destreza");
            short poder = rs.getShort("poder");

            return new FolhaDeCaracteristicas(forca, constituicao, tamanho, destreza, poder);
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Folha Caracteristicas");
        }
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException{
        FolhaDeCaracteristicas caracteristicas = personagem.getAtributos().getCaracteristicas();

        abreConexao();
        preparaComandoSQL("INSERT INTO folha_caracteristicas (forca, constituicao, tamanho," +
                "destreza, poder, id_personagem) VALUES (?, ?, ?, ?, ?, ?)");
        try {
            ps.setShort(1, caracteristicas.getForca());
            ps.setShort(2, caracteristicas.getConstituicao());
            ps.setShort(3, caracteristicas.getTamanho());
            ps.setShort(4, caracteristicas.getDestreza());
            ps.setShort(5, caracteristicas.getPoder());

            ps.setInt(6, personagem.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Folha Caracteristicas");
        }
    }


    @Override
    public void Altera(Personagem personagem) throws BaseDadosException{
        FolhaDeCaracteristicas caracteristicas = personagem.getAtributos().getCaracteristicas();

        abreConexao();
        preparaComandoSQL("UPDATE folha_caracteristicas SET forca = ?, constituicao = ?, tamanho = ?," +
                "destreza = ?, poder = ? WHERE id_personagem = ?");
        try {
            ps.setShort(1, caracteristicas.getForca());
            ps.setShort(2, caracteristicas.getConstituicao());
            ps.setShort(3, caracteristicas.getTamanho());
            ps.setShort(4, caracteristicas.getDestreza());
            ps.setShort(5, caracteristicas.getPoder());

            ps.setInt(6, personagem.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Folha Caracteristicas");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("REMOVE * FROM folha_caracteristicas WHERE id_personagem = ?");

        try {
            ps.setInt(1, codigo);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Folha Caracteristicas");
        }
    }
}
