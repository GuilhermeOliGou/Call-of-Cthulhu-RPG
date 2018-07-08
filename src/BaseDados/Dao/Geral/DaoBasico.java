package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;

public interface DaoBasico<T, U> {

    public T Busca(int codigo) throws BaseDadosException;

    public void Altera(U u) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;

}
