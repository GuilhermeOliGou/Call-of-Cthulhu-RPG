/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.Dao.Evento;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Geral.DaoUtilidadeEvento;
import DTO.ElementosDeSistema.Evento;

import java.util.LinkedList;
import java.util.List;


public interface DaoEvento extends DaoUtilidadeEvento<Evento>{

    public LinkedList<Evento> Lista(int IdLocal) throws BaseDadosException;
    
}
