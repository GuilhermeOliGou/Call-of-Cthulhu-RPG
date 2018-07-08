package BaseDados.Dao.Evento;

import BaseDados.BaseDadosException;

import java.util.List;

public interface DaoEventoJogador {

    public List<Integer> Busca(int idPersonagem, int idLocal) throws BaseDadosException;

    public void Insere(int idPersonagem) throws BaseDadosException;

    public void Remove(int idPersonagem, int idLocal) throws BaseDadosException;

    public void RemoveJogador(int idPersonagem) throws BaseDadosException;
}
