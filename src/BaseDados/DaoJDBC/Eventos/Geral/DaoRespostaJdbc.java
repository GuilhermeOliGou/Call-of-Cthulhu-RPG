/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DaoJDBC.Eventos.Geral;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.Resposta.DaoAtributosResposta;
import BaseDados.Dao.Evento.Resposta.DaoHabilidadesResposta;
import BaseDados.Dao.Evento.Resposta.DaoItemModificadoResposta;
import BaseDados.Dao.Evento.Resposta.DaoResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DaoRespostaJdbc extends BancoDadosJdbc implements DaoResposta {

    private DaoAtributosResposta daoAtributosResposta;
    private DaoHabilidadesResposta daoHabilidadesResposta;
    private DaoItemModificadoResposta daoItemModificadoResposta;

    public DaoRespostaJdbc(DaoAtributosResposta daoAtributosResposta, DaoHabilidadesResposta daoHabilidadesResposta, DaoItemModificadoResposta daoItemModificadoResposta) throws BaseDadosException {
        super();

        this.daoAtributosResposta = daoAtributosResposta;
        this.daoHabilidadesResposta = daoHabilidadesResposta;
        this.daoItemModificadoResposta = daoItemModificadoResposta;
    }

    @Override
    public Resposta Busca(int codigo) throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM resposta WHERE id_evento = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel Buscar Resposta");
        }
        try {
            if(rs.next()){
                short sanidadeAlterada = rs.getShort("sanidade_alterada");

                FolhaDeHabilidades habilidades = daoHabilidadesResposta.Busca(codigo);
                FolhaDeAtributos atributos = daoAtributosResposta.Busca(codigo);
                List<Integer[]> itemModificado = daoItemModificadoResposta.Busca(codigo);

                fechaConexao();
                return new Resposta(atributos, itemModificado.get(0), itemModificado.get(1), sanidadeAlterada, habilidades);
            }
            return null;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontrar Buscar Resposta");
        }
    }

    @Override
    public void Insere(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Altera(Evento evento) throws BaseDadosException {

    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

    }


    public List<Resposta> Lista() throws BaseDadosException {
        return null;
    }
}
