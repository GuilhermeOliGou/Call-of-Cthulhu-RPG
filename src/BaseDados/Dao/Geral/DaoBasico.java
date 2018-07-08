package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;

public interface DaoBasico<T> {

    public T Busca(int codigo) throws BaseDadosException;

    public void Insere(T t) throws BaseDadosException;

    public void Altera(T t) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;

}
