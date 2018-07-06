/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Evento.DaoEvento;
import BaseDados.Dao.Evento.DaoEventoAvancado;
import BaseDados.DaoJDBC.BancoDadosJdbc;

/**
 *
 * @author Administrador
 */
public class DaoEventoAvancadoJdbc extends BancoDadosJdbc implements DaoEventoAvancado{
    
    private DaoEvento daoEvento;
    
    public DaoEventoAvancadoJdbc(DaoEvento daoEvento) throws BaseDadosException{
        super();
        this.daoEvento = daoEvento;
    }
}
