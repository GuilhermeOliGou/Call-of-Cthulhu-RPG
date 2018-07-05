package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoHabilidadesTiroItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;

public class HabilidadesTiroItemJdbc extends BancoDadosJdbc implements DaoHabilidadesTiroItem {

    public HabilidadesTiroItemJdbc() throws Exception{
        super();

    }

    @Override
    public HabilidadesTiro Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_tiro WHERE id_item = ?");

        try{
            ps.setInt(1, codigo);

            rs = ps.executeQuery();
            if(rs.next()){
                short tiroPistola = rs.getShort("tiro_pistola");
                short tiroRifleEscopeta = rs.getShort("tiro_rifle");
                short tiroSubmetralhadora = rs.getShort("tiro_submetralhadora");
                short arremesso = rs.getShort("arremesso");

                return new HabilidadesTiro(tiroPistola, tiroRifleEscopeta, tiroSubmetralhadora, arremesso);
            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Tiro");
        }

        return null;
    }

    @Override
    public void Insere(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        HabilidadesTiro habilidadesTiro = arma.getHabilidadesUsadasTiro();

        abreConexao();
        preparaComandoSQL("INSERT INTO habilidades_tiro (tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso)" +
                "VALUES (?, ?, ?, ?) WHERE id_item = ?");

        try{
            ps.setShort(1, habilidadesTiro.getTiroPistola());
            ps.setShort(2, habilidadesTiro.getTiroRifleEscopeta());
            ps.setShort(3, habilidadesTiro.getTiroSubmetralhadora());
            ps.setShort(4, habilidadesTiro.getArremesso());

            ps.setInt(5, arma.getId());
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Habilidades Tiro");
        }
    }

    @Override
    public void Altera(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        HabilidadesTiro habilidadesTiro = arma.getHabilidadesUsadasTiro();

        abreConexao();
        preparaComandoSQL("UPDATE habilidades_tiro SET tiro_pistola = ?, tiro_rifle = ?, tiro_submetralhadora = ?, arremesso =?" +
                "WHERE id_item = ?");

        try{
            ps.setShort(1, habilidadesTiro.getTiroPistola());
            ps.setShort(2, habilidadesTiro.getTiroRifleEscopeta());
            ps.setShort(3, habilidadesTiro.getTiroSubmetralhadora());
            ps.setShort(4, habilidadesTiro.getArremesso());

            ps.setInt(5, arma.getId());
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Habilidades Tiro");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE * FROM habilidades_tiro WHERE id_item = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Tiro, verifique se o Item enviado eh valido");
        }
    }
}
