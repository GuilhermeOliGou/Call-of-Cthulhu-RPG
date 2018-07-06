/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DAO.Geral;

import BaseDados.BaseDadosException;
import DTO.ElementosDeSistema.Evento;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface DaoUtilidadeEvento<T>{
    
    public T Busca(int codigo) throws BaseDadosException;
    
    public void Insere(Evento evento)throws BaseDadosException;
    
    public void Altera(Evento evento)throws BaseDadosException;
    
    public void Remove(int codigo)throws BaseDadosException;
    
}
