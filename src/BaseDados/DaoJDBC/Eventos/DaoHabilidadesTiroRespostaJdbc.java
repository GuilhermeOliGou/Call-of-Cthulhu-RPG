package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoHabilidadesTiroResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;

public class DaoHabilidadesTiroRespostaJdbc extends BancoDadosJdbc implements DaoHabilidadesTiroResposta {

    public DaoHabilidadesTiroRespostaJdbc() throws BaseDadosException {
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

    @Override
    public void Insere(Evento evento) throws BaseDadosException {
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeHabilidades habilidades = resposta.getHabilidadesAlteradas();

        HabilidadesTiro habilidadesTiro = habilidades.getTiro();

        if(habilidadesTiro == null) return;
        abreConexao();
        preparaComandoSQL("INSERT INTO habilidades_tiro (tiro_pistola, tiro_rifle, tiro_submetralhadora, arremesso, id_evento)" +
                "VALUES (?, ?, ?, ?, ?)");

        try{
            ps.setShort(1, habilidadesTiro.getTiroPistola());
            ps.setShort(2, habilidadesTiro.getTiroRifleEscopeta());
            ps.setShort(3, habilidadesTiro.getTiroSubmetralhadora());
            ps.setShort(4, habilidadesTiro.getArremesso());

            ps.setInt(5, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Habilidades Tiro");
        }
    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {
        int id = evento.getID();

        Resposta resposta = evento.getRespostaDoEvento();

        FolhaDeHabilidades habilidades = resposta.getHabilidadesAlteradas();

        HabilidadesTiro habilidadesTiro = habilidades.getTiro();
        abreConexao();
        preparaComandoSQL("UPDATE habilidades_tiro SET tiro_pistola = ?, tiro_rifle = ?, tiro_submetralhadora = ?, arremesso =?" +
                "WHERE id_evento = ?");

        try{
            ps.setShort(1, habilidadesTiro.getTiroPistola());
            ps.setShort(2, habilidadesTiro.getTiroRifleEscopeta());
            ps.setShort(3, habilidadesTiro.getTiroSubmetralhadora());
            ps.setShort(4, habilidadesTiro.getArremesso());

            ps.setInt(5, id);
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Habilidades Tiro Resposta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("DELETE FROM habilidades_tiro WHERE id_evento = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Tiro, verifique se o Item enviado eh valido");
        }
    }
}
