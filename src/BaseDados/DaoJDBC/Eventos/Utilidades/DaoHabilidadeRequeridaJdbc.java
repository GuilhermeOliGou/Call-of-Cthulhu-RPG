package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoHabilidadeRequerida;
import BaseDados.Dao.DaoHabilidadeTiroRequerida;
import BaseDados.Dao.DaoHabilidadesLutaRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;

public class DaoHabilidadeRequeridaJdbc extends BancoDadosJdbc implements DaoHabilidadeRequerida {

    private DaoHabilidadeTiroRequerida daoTiroRequerida;
    private DaoHabilidadesLutaRequerida daoLutaRequerida;

    public DaoHabilidadeRequeridaJdbc(DaoHabilidadesLutaRequerida daoLutaRequerida, DaoHabilidadeTiroRequerida daoTiroRequerida) throws BaseDadosException {
        super();

        this.daoLutaRequerida = daoLutaRequerida;
        this.daoTiroRequerida = daoTiroRequerida;
    }

    @Override
    public FolhaDeHabilidades Busca(int codigo) throws BaseDadosException {
        HabilidadesTiro tiro = daoTiroRequerida.Busca(codigo);
        HabilidadesLuta luta = daoLutaRequerida.Busca(codigo);

        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_habilidades WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Folha Habilidades Resposta");
        }

        try {
            if(rs.next()){
                short mitos = rs.getShort("mitos_cthulhu");
                return new FolhaDeHabilidades(mitos, luta, tiro);
            }
            return null;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Folha Habilidades Resposta");
        }
    }
}
