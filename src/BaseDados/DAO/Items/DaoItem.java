package BaseDados.Dao.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Geral.Dao;
import DTO.Itens.Item;

import java.util.List;

public interface DaoItem extends DaoItemGeral {

    public List<Integer> ListaArma() throws BaseDadosException;

    public List<Integer> ListaConsumivel() throws BaseDadosException;

    public List<Integer> ListaTodos() throws BaseDadosException;
}
