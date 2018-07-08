package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesLutaItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import Utilidades.Log;

import java.sql.SQLException;

public class HabilidadesLutaItemJdbc extends BancoDadosJdbc implements DaoHabilidadesLutaItem{

    public HabilidadesLutaItemJdbc() throws BaseDadosException{
        super();
    }
    @Override
    public HabilidadesLuta Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_luta WHERE id_item = ?");
        try{
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Falha no Acesso");
        }

        try{
            HabilidadesLuta luta = null;
            if(rs.next()){
                short esquiva = rs.getShort("esquiva");
                short lutaMachado = rs.getShort("luta_machado");
                short lutaLivre = rs.getShort("luta_livre");
                short lutaLanca = rs.getShort("luta_lanca");
                short lutaEspada = rs.getShort("luta_espada");
                short lutaChicote = rs.getShort("luta_chicote");

                luta = new HabilidadesLuta(esquiva, lutaMachado, lutaLivre,
                        lutaLanca, lutaEspada, lutaChicote);

            }
            fechaConexao();
            return luta;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Luta");
        }
    }
}
