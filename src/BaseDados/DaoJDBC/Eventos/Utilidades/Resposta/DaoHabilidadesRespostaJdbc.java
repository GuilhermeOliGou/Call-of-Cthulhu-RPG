package BaseDados.DaoJDBC.Eventos.Utilidades.Resposta;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.Resposta.DaoHabilidadesLutaResposta;
import BaseDados.Dao.Evento.Resposta.DaoHabilidadesResposta;
import BaseDados.Dao.Evento.Resposta.DaoHabilidadesTiroResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import Utilidades.Log;

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
        preparaComandoSQL("SELECT * FROM habilidades_resposta WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel realizar a Busca Folha Habilidades Resposta");
        }

        try {
            FolhaDeHabilidades habilidades = null;
            if(rs.next()){
                short mitos = rs.getShort("mitos_cthulhu");

                habilidades = new FolhaDeHabilidades(mitos, luta, tiro);
            }
            fechaConexao();
            return habilidades;
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Nao foi possivel encontrar Folha Habilidades Resposta");
        }
    }

}
