/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEvento;
import BaseDados.Dao.Geral.Dao;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.ElementosDeSistema.Evento;

/**
 *
 * @author Administrador
 */
public class DaoEventoJdbc extends BancoDadosJdbc implements DaoEvento{
    
    public DaoEventoJdbc()throws BaseDadosException{
        super();
    }

}
