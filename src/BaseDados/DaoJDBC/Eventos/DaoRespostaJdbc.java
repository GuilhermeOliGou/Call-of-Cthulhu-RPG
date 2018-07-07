/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoResposta;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Resposta;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class DaoRespostaJdbc extends BancoDadosJdbc implements DaoResposta {

    public DaoRespostaJdbc() throws BaseDadosException {
    }

    @Override
    public Resposta Busca(int codigo) throws BaseDadosException {
        return null;
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
