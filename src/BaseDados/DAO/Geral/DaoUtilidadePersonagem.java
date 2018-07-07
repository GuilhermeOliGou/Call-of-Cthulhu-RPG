package BaseDados.Dao.Geral;


import BaseDados.BaseDadosException;
import DTO.Personagens.Personagem;

public interface DaoUtilidadePersonagem<T> extends DaoUtilidade<T, Personagem>{

    public T Busca(int codigo) throws BaseDadosException;

    public void Insere(Personagem personagem) throws BaseDadosException;

    public void Altera(Personagem personagem) throws BaseDadosException;

    public void Remove(int codigo) throws BaseDadosException;

}
