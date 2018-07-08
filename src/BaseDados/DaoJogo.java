package BaseDados;

import DTO.ElementosDeSistema.Local;
import DTO.Personagens.Jogador;

import java.util.List;

public interface DaoJogo {

    public Jogador CarregaJogo(int codigo)throws BaseDadosException;

    public void CriaJogo(Jogador jogador) throws BaseDadosException;

    public void SalvaJogo(List<Local> locais, Jogador jogador) throws BaseDadosException;

    public void RemoveJogo(int codigo) throws BaseDadosException;

}
