package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;
import DTO.Itens.Item;

public interface DaoUtilidade<T, U> {
    public T Busca(int codigo) throws BaseDadosException;

    public void Insere(U u) throws BaseDadosException;

    public void Altera(U u) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;
}
