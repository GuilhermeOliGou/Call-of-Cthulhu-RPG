package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoHabilidadesLutaResposta;
import BaseDados.Dao.Evento.DaoHabilidadesResposta;
import BaseDados.Dao.Evento.DaoHabilidadesTiroResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;

public class DaoHabilidadesRespostaJdbc extends BancoDadosJdbc implements DaoHabilidadesResposta{

    private DaoHabilidadesLutaResposta daoLutaResposta;
    private DaoHabilidadesTiroResposta daoTiroResposta;

    public DaoHabilidadesRespostaJdbc(DaoHabilidadesLutaResposta daoLutaResposta, DaoHabilidadesTiroResposta daoTiroResposta) throws BaseDadosException {
        super();
        this.daoLutaResposta = daoLutaResposta;
        this.daoTiroResposta = daoTiroResposta;
    }

    @Override
    public FolhaDeHabilidades Busca(int codigo) throws BaseDadosException {
        HabilidadesTiro tiro = daoTiroResposta.Busca(codigo);
        HabilidadesLuta luta = daoLutaResposta.Busca(codigo);

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

    @Override
    public void Insere(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {
        daoLutaResposta.Altera(evento);
        daoTiroResposta.Altera(evento);

        FolhaDeHabilidades habilidades = evento.getRespostaDoEvento().getHabilidadesAlteradas();
        abreConexao();
        preparaComandoSQL("UPDATE folha_habilidades SET mitos_cthulhu = ? WHERE id_evento = ?");

        try{
            ps.setShort(1, habilidades.getMitosDeCthulhu());
            ps.setInt(2, evento.getID());

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Folha Habilidades Resposta");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }
}
