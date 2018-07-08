package BaseDados.DaoJDBC.Eventos.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoHabilidadesLutaRequerida;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.FolhaDeHabilidades;
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

    @Override
    public void Insere(Evento evento) throws BaseDadosException {
        EventoAvancado eventoAvancado = (EventoAvancado) evento;

        FolhaDeHabilidades habilidades = eventoAvancado.getHabilidadesNecessarias();

        HabilidadesLuta habilidadesLuta = habilidades.getLuta();

        int id = evento.getID();

        abreConexao();
        preparaComandoSQL("INSERT INTO habilidades_luta (esquiva, luta_machado, luta_livre, luta_lanca, luta_espada, luta_chicote, id_evento)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Habilidades Luta Resposta");
        }
    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {
        EventoAvancado eventoAvancado = (EventoAvancado) evento;

        FolhaDeHabilidades habilidades = eventoAvancado.getHabilidadesNecessarias();

        HabilidadesLuta habilidadesLuta = habilidades.getLuta();

        int id = evento.getID();
        abreConexao();
        preparaComandoSQL("UPDATE habilidades_luta SET esquiva = ?, luta_machado = ?, luta_livre = ?, " +
                "luta_lanca = ?, luta_espada = ?, luta_chicote = ? WHERE id_evento = ?");

        try{
            ps.setShort(1, habilidadesLuta.getEsquiva());
            ps.setShort(2, habilidadesLuta.getLutaMachado());
            ps.setShort(3, habilidadesLuta.getLutaLivre());
            ps.setShort(4, habilidadesLuta.getLutaLanca());
            ps.setShort(5, habilidadesLuta.getLutaEspada());
            ps.setShort(6, habilidadesLuta.getLutaChicote());

            ps.setInt(7, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Habilidades Luta Resposta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM habilidades_luta WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Luta Resposta, verifique se o Evento enviado eh valido");
        }
    }
}
