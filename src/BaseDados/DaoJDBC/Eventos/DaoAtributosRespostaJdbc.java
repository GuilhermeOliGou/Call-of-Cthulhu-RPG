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

public class DaoAtributosRespostaJdbc extends BancoDadosJdbc implements DaoAtributosResposta {

    private DaoCaracteristicasResposta daoCaracteristicasResposta;

    public DaoAtributosRespostaJdbc(DaoCaracteristicasResposta daoCaracteristicasResposta) throws BaseDadosException {
        super();
        this.daoCaracteristicasResposta = daoCaracteristicasResposta;
    }

    @Override
    public FolhaDeAtributos Busca(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_atributos WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a busca Folha Atributos Resposta");
        }

        try {
            if(rs.next()){

                FolhaDeCaracteristicas caracteristicas = daoCaracteristicasResposta.Busca(codigo);

                short maxHp = rs.getShort("max_hp");
                short maxMp = rs.getShort("max_mp");
                short hpAtual = rs.getShort("hp_atual");
                short mpAtual = rs.getShort("mp_atual");
                short bonusDano = rs.getShort("bonus_dano");

                return new FolhaDeAtributos(caracteristicas, maxHp, maxMp, hpAtual, mpAtual, bonusDano);
            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Folha Atributos Resposta");
        }
        return null;
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException{
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeAtributos atributos = resposta.getAtributosAlterados();

        abreConexao();
        preparaComandoSQL("INSERT INTO folha_atributos (max_hp, max_mp, hp_atual, mp_atual, bonus_dano, id_evento)" +
                "VALUES (?, ?, ?, ?, ?, ?)");

        try {
            ps.setShort(1, atributos.getMaxHp());
            ps.setShort(2, atributos.getMaxMp());
            ps.setShort(3, atributos.getHpAtual());
            ps.setShort(4, atributos.getMpAtual());
            ps.setShort(5, atributos.getBonusDeDanoCorporal());

            ps.setInt(6, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Folha Atributos");
        }

        daoCaracteristicasResposta.Insere(evento);

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeAtributos atributos = resposta.getAtributosAlterados();

        abreConexao();
        preparaComandoSQL("UPDATE folha_atributos SET max_hp = ?, max_mp = ?," +
                " hp_atual = ?, mp_atual = ?, bonus_dano = ? WHERE id_evento = ?");

        try {
            ps.setShort(1, atributos.getMaxHp());
            ps.setShort(2, atributos.getMaxMp());
            ps.setShort(3, atributos.getHpAtual());
            ps.setShort(4, atributos.getMpAtual());
            ps.setShort(5, atributos.getBonusDeDanoCorporal());

            ps.setInt(6, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Folha Atributos Resposta");
        }

        daoCaracteristicasResposta.Altera(evento);

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException{

        daoCaracteristicasResposta.Remove(codigo);

        abreConexao();
        preparaComandoSQL("DELETE FROM folha_atributos WHERE id_evento = ?");
        try{
            ps.setInt(1, codigo);
            ps.execute();
        }catch(SQLException e){
            throw new BaseDadosException("Não foi possível remover Folha Atributos Resposta");
        }
    }
}
