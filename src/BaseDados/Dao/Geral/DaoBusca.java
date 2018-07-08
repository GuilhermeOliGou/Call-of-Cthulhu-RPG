package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;

public interface DaoBusca<T> {

    public T Busca(int id) throws BaseDadosException;
}
