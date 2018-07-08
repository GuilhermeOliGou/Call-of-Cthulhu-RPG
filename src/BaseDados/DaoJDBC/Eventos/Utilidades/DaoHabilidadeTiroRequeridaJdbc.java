package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoHabilidadeTiroRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;

public class DaoHabilidadeTiroRequeridaJdbc extends BancoDadosJdbc implements DaoHabilidadeTiroRequerida {
    public DaoHabilidadeTiroRequeridaJdbc() throws BaseDadosException {
    }

    @Override
    public HabilidadesTiro Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_tiro WHERE id_evento = ?");

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
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Tiro Resposta");
        }

        return null;
    }
}
