package BaseDados.DaoJDBC.Items.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoHabilidadesLutaItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;

import java.sql.SQLException;

public class HabilidadesLutaItemJdbc extends BancoDadosJdbc implements DaoHabilidadesLutaItem{

    public HabilidadesLutaItemJdbc() throws Exception{
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
            throw new BaseDadosException("Nao foi possivel encontrar Habilidades Luta");
        }
        return null;
    }

    @Override
    public void Insere(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        HabilidadesLuta habilidadesLuta = arma.getHabilidadesUsadasLuta();

        abreConexao();
        preparaComandoSQL("INSERT INTO habilidades_luta (esquiva, luta_machado, luta_livre, luta_lanca, luta_espada, luta_chicote)" +
                "VALUES (?, ?, ?, ?, ?, ?) WHERE id_item = ?");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, arma.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Habilidades Luta");
        }
    }

    @Override
    public void Altera(Item item) throws BaseDadosException {
        Arma arma = (Arma) item;
        HabilidadesLuta habilidadesLuta = arma.getHabilidadesUsadasLuta();

        abreConexao();
        preparaComandoSQL("UPDATE habilidades_luta SET esquiva = ?, luta_machado = ?, luta_livre = ?, " +
                "luta_lanca = ?, luta_espada = ?, luta_chicote = ? WHERE id_item = ?");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, arma.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Habilidades Luta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE * FROM habilidades_luta WHERE id_item = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Luta, verifique se o Item enviado eh valido");
        }
    }
}
