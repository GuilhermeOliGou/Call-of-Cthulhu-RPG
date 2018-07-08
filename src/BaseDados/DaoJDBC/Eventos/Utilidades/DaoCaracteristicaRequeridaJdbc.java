package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoCaracteristicaRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.FolhaDeCaracteristicas;

import java.sql.SQLException;

public class DaoCaracteristicaRequeridaJdbc extends BancoDadosJdbc implements DaoCaracteristicaRequerida{

    public DaoCaracteristicaRequeridaJdbc() throws BaseDadosException {
        super();
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
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Caracteristicas Evento Avancado");
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
            throw new BaseDadosException("Nao foi possivel encontrar Folha Caracteristicas Evento Avancado");
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException{
        EventoAvancado eventoAvancado = (EventoAvancado) evento;

        int id = evento.getID();
        FolhaDeCaracteristicas caracteristicas = eventoAvancado.getCaracterísticasNecessarias();

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
            throw new BaseDadosException("Nao foi possivel inserir Folha Caracteristicas Evento Avancado");
        }
    }


    @Override
    public void Altera(Evento evento) throws BaseDadosException{
        EventoAvancado eventoAvancado = (EventoAvancado) evento;

        int id = evento.getID();
        FolhaDeCaracteristicas caracteristicas = eventoAvancado.getCaracterísticasNecessarias();

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
            throw new BaseDadosException("Nao foi possivel modificar Folha Caracteristicas Evento Avancado");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("REMOVE * FROM folha_caracteristicas WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Folha Caracteristicas Evento Avancado");
        }
    }
}
