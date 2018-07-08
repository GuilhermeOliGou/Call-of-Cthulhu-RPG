package BaseDados.DaoJDBC.Personagem.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.Utilidades.DaoHabilidadesLutaJogador;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;

import java.sql.SQLException;

public class DaoHabilidadesLutaJogadorJdbc extends BancoDadosJdbc implements DaoHabilidadesLutaJogador{

    public DaoHabilidadesLutaJogadorJdbc() throws BaseDadosException{
        super();
    }

    @Override
    public HabilidadesLuta Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM habilidades_luta WHERE id_jogador = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Habilidade Luta");
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
    public void Insere(Personagem personagem) throws BaseDadosException {
        Jogador jogador = (Jogador) personagem;
        HabilidadesLuta habilidadesLuta = jogador.getHabilidades().getLuta();

        abreConexao();
        preparaComandoSQL("INSERT INTO habilidades_luta (esquiva, luta_machado, luta_livre, luta_lanca, luta_espada, luta_chicote)" +
                "VALUES (?, ?, ?, ?, ?, ?) WHERE id_jogador = ?");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, jogador.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Habilidades Luta");
        }
    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {
        Jogador jogador = (Jogador) personagem;
        HabilidadesLuta habilidadesLuta = jogador.getHabilidades().getLuta();

        abreConexao();
        preparaComandoSQL("UPDATE habilidades_luta SET esquiva = ?, luta_machado = ?, luta_livre = ?, " +
                "luta_lanca = ?, luta_espada = ?, luta_chicote = ? WHERE id_jogador = ?");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, jogador.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Habilidades Luta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE * FROM habilidades_luta WHERE id_jogador = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Tiro, verifique se o Jogador enviado eh valido");
        }
    }
}
