package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;
import DTO.Itens.Item;

public interface DaoUtilidadeItem<T> {

    public T Busca(int codigo) throws BaseDadosException;

    public void Insere(Item item) throws BaseDadosException;

    public void Altera(Item item) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;

}
