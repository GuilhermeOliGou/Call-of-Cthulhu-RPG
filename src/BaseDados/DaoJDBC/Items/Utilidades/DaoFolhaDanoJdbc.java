package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;

import BaseDados.Dao.Items.DaoFolhaDano;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;

import java.sql.SQLException;

public class DaoFolhaDanoJdbc extends BancoDadosJdbc implements DaoFolhaDano {

    public DaoFolhaDanoJdbc() throws Exception{
        super();
    }

    @Override
    public FolhaDano Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_dano WHERE id_item = ?");
        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Falha no Acesso");
        }
        try {
            if(rs.next()){
                short rolagens[] = {rs.getShort("rolagem_1"), rs.getShort("rolagem_2"),
                        rs.getShort("rolagem_3"), rs.getShort("rolagem_4"),
                        rs.getShort("rolagem_5"), rs.getShort("rolagem_6")};

                short adicional = rs.getShort("adicional");

                boolean atordoamento = rs.getBoolean("atordoamento");

                FolhaDano folhaDano = new FolhaDano(rolagens, adicional, atordoamento);

                return folhaDano;
            }
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Não foi possivel encontrar a Folha Dano");
        }
        return null;
    }

    @Override
    public void Insere(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        FolhaDano folhaDano = arma.getDano();
        abreConexao();
        preparaComandoSQL("INSERT INTO folha_dano (rolagem_1, rolagem_2, rolagem_3, rolagem_4, rolagem_5, rolagem_6, " +
                "adicional, atordoamento, id_item) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        try{
            short rolagens[] = folhaDano.getRolagens();
            ps.setShort(1, rolagens[0]);
            ps.setShort(2, rolagens[1]);
            ps.setShort(3, rolagens[2]);
            ps.setShort(4, rolagens[3]);
            ps.setShort(5, rolagens[4]);
            ps.setShort(6, rolagens[5]);

            ps.setShort(7, folhaDano.getAdicional());
            ps.setBoolean(8, folhaDano.isAtordoamento());
            ps.setInt(9, arma.getId());

            ps.execute();
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Falha na insercao");
        }
        fechaConexao();
    }

    @Override
    public void Altera(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        FolhaDano folhaDano = arma.getDano();

        abreConexao();
        preparaComandoSQL("UPDATE folha_dano SET rolagem_1 = ?, rolagem_2 = ?, rolagem_3 = ?, rolagem_4 = ?, rolagem_5 = ?" +
                "rolagem_6 = ?, adicional = ?, atordoamento = ? WHERE id_item = ?");

        try {
            short rolagens[] = folhaDano.getRolagens();
            ps.setShort(1, rolagens[0]);
            ps.setShort(2, rolagens[1]);
            ps.setShort(3, rolagens[2]);
            ps.setShort(4, rolagens[3]);
            ps.setShort(5, rolagens[4]);
            ps.setShort(6, rolagens[5]);

            ps.setShort(7, folhaDano.getAdicional());
            ps.setBoolean(8, folhaDano.isAtordoamento());

            ps.setInt(9, arma.getId());

            ps.execute();

        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel alterar a Folha Dano");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE * FROM folha_dano WHERE id_item = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover a Folha Dano, verifique se o Item enviado eh valido");
        }
    }
}
