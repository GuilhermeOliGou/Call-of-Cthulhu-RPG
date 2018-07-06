/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DaoJDBC.Eventos;

import BaseDados.BaseDadosException;
import BaseDados.DAO.Evento.DaoEventoBase;
import BaseDados.Dao.Evento.DaoEvento;
import BaseDados.Dao.Evento.DaoEventoAvancado;
import BaseDados.Dao.Evento.DaoEventoLuta;
import BaseDados.DaoJDBC.BancoDadosJdbc;

/**
 *
 * @author Administrador
 */
public class DaoEventoBaseJdbc extends BancoDadosJdbc implements DaoEventoBase{
    
    DaoEvento daoEvento;
    DaoEventoAvancado daoEventoAvancado;
    DaoEventoLuta daoEventoLuta;
    
    public DaoEventoBaseJdbc() throws BaseDadosException{
        super();
        daoEvento = new DaoEventoJdbc();
        daoEventoAvancado = new DaoEventoAvancadoJdbc(daoEvento);
        daoEventoLuta = new DaoEventoLutaJdbc(daoEvento);
        
        
    
}
