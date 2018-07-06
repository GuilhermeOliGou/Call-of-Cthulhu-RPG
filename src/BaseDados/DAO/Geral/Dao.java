package BaseDados.Dao.Geral;

import BaseDados.BaseDadosException;

import java.util.List;

public interface Dao<T> {

    public T Busca(int codigo) throws BaseDadosException;

    public void Insere(T t) throws BaseDadosException;

    public void Altera(T t) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;

    public List<T> Lista() throws BaseDadosException;

}
