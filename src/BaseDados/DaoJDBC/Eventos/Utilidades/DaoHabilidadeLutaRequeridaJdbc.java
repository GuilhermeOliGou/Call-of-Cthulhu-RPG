package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoHabilidadesLutaRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;

import java.sql.SQLException;

public class DaoHabilidadeLutaRequeridaJdbc extends BancoDadosJdbc implements DaoHabilidadesLutaRequerida {
    public DaoHabilidadeLutaRequeridaJdbc() throws BaseDadosException {
        super();
    }

    @Override
    public HabilidadesLuta Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_luta WHERE id_evento = ?");
        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Falha no Acesso");
        }

        try{
            if(rs.next()){
                short esquiva = rs.getShort("esquiva");
                short lutaMachado = rs.getShort("luta_machado");
                short lutaLivre = rs.getShort("luta_livre");
                short lutaLanca = rs.getShort("luta_lanca");
                short lutaEspada = rs.getShort("luta_espada");
                short lutaChicote = rs.getShort("luta_chicote");

                return new HabilidadesLuta(esquiva, lutaMachado, lutaLivre,
                        lutaLanca, lutaEspada, lutaChicote);

            }
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Luta Resposta");
        }
        return null;
    }
}
