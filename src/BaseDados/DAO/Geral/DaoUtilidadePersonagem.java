package BaseDados.Dao.Geral;


import DTO.Personagens.Personagem;

public interface DaoUtilidadePersonagem<T> {

    public T Busca(int codigo);

    public void Insere(Personagem personagem);

    public void Altera(Personagem personagem);

    public void Remove(int codigo);

}
