package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoAtributosResposta;
import BaseDados.Dao.Evento.DaoCaracteristicasResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;

import java.sql.SQLException;

public class DaoCaracteristicasRespostaJdbc extends BancoDadosJdbc implements DaoCaracteristicasResposta {
    public DaoCaracteristicasRespostaJdbc() throws BaseDadosException {
    }
    @Override
    public FolhaDeCaracteristicas Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_caracteristicas WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Caracteristicas");
        }

        try {
            if(rs.next()) {
                short forca = rs.getShort("forca");
                short constituicao = rs.getShort("constituicao");
                short tamanho = rs.getShort("tamanho");
                short destreza = rs.getShort("destreza");
                short poder = rs.getShort("poder");

                return new FolhaDeCaracteristicas(forca, constituicao, tamanho, destreza, poder);
            }
            return null;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Folha Caracteristicas Resposta");
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException{
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeAtributos atributos = resposta.getAtributosAlterados();

        FolhaDeCaracteristicas caracteristicas = atributos.getCaracteristicas();

        abreConexao();
        preparaComandoSQL("INSERT INTO folha_caracteristicas (forca, constituicao, tamanho," +
                "destreza, poder, id_evento) VALUES (?, ?, ?, ?, ?, ?)");
        try {
            ps.setShort(1, caracteristicas.getForca());
            ps.setShort(2, caracteristicas.getConstituicao());
            ps.setShort(3, caracteristicas.getTamanho());
            ps.setShort(4, caracteristicas.getDestreza());
            ps.setShort(5, caracteristicas.getPoder());

            ps.setInt(6, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Folha Caracteristicas Resposta");
        }
    }


    @Override
    public void Altera(Evento evento) throws BaseDadosException{
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeAtributos atributos = resposta.getAtributosAlterados();

        FolhaDeCaracteristicas caracteristicas = atributos.getCaracteristicas();

        abreConexao();
        preparaComandoSQL("UPDATE folha_caracteristicas SET forca = ?, constituicao = ?, tamanho = ?," +
                "destreza = ?, poder = ? WHERE id_evento = ?");
        try {
            ps.setShort(1, caracteristicas.getForca());
            ps.setShort(2, caracteristicas.getConstituicao());
            ps.setShort(3, caracteristicas.getTamanho());
            ps.setShort(4, caracteristicas.getDestreza());
            ps.setShort(5, caracteristicas.getPoder());

            ps.setInt(6, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Folha Caracteristicas Resposta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("REMOVE FROM folha_caracteristicas WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Folha Caracteristicas Resposta");
        }
    }
}
