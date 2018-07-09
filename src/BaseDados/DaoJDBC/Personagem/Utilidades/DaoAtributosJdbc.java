package BaseDados.DaoJDBC.Personagem.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.Utilidades.DaoAtributos;
import BaseDados.Dao.Personagem.Utilidades.DaoCaracteristicas;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Personagem;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoAtributosJdbc extends BancoDadosJdbc implements DaoAtributos {

    private DaoCaracteristicas daoCaracteristicas;

    public DaoAtributosJdbc(DaoCaracteristicas daoCaracteristicas)throws BaseDadosException{
        super();
        this.daoCaracteristicas = daoCaracteristicas;
    }

    @Override
    public FolhaDeAtributos Busca(int codigo) throws BaseDadosException{
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_atributos WHERE id_personagem = ?");

        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar a busca");
        }

        try {
            FolhaDeAtributos atributos = null;
            if(rs.next()){

                FolhaDeCaracteristicas caracteristicas = daoCaracteristicas.Busca(codigo);

                short maxHp = rs.getShort("max_hp");
                short maxMp = rs.getShort("max_mp");
                short hpAtual = rs.getShort("hp_atual");
                short mpAtual = rs.getShort("mp_atual");
                short bonusDano = rs.getShort("bonus_dano");

                atributos = new FolhaDeAtributos(caracteristicas, maxHp, maxMp, hpAtual, mpAtual, bonusDano);
            }
            fechaConexao();
            return atributos;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Folha Atributos");
        }
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException{
        FolhaDeAtributos atributos = personagem.getAtributos();

        abreConexao();
        preparaComandoSQL("INSERT INTO folha_atributos (max_hp, max_mp, hp_atual, mp_atual, bonus_dano, id_personagem)" +
                "VALUES (?, ?, ?, ?, ?, ?)");

        try {
            ps.setShort(1, atributos.getMaxHp());
            ps.setShort(2, atributos.getMaxMp());
            ps.setShort(3, atributos.getHpAtual());
            ps.setShort(4, atributos.getMpAtual());
            ps.setShort(5, atributos.getBonusDeDanoCorporal());

            ps.setInt(6, personagem.getId());

            ps.execute();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel inserir Folha Atributos");
        }

        daoCaracteristicas.Insere(personagem);

    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {
        FolhaDeAtributos atributos = personagem.getAtributos();

        abreConexao();
        preparaComandoSQL("UPDATE folha_atributos SET max_hp = ?, max_mp = ?," +
                " hp_atual = ?, mp_atual = ?, bonus_dano = ? WHERE id_personagem = ?");

        try {
            ps.setShort(1, atributos.getMaxHp());
            ps.setShort(2, atributos.getMaxMp());
            ps.setShort(3, atributos.getHpAtual());
            ps.setShort(4, atributos.getMpAtual());
            ps.setShort(5, atributos.getBonusDeDanoCorporal());

            ps.setInt(6, personagem.getId());

            ps.execute();
            fechaConexao();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel modificar Folha Atributos");
        }

        daoCaracteristicas.Altera(personagem);

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException{

        daoCaracteristicas.Remove(codigo);

        abreConexao();
        preparaComandoSQL("DELETE FROM folha_atributos WHERE id_personagem = ?");
        try{
            ps.setInt(1, codigo);
            ps.execute();
        }catch(SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Não foi possível remover Folha Atributos");
        }
    }
}
