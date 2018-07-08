package RegrasDeNegocio;

import DTO.ElementosDeSistema.*;
import DTO.Itens.*;
import DTO.Personagens.*;

import BaseDados.BaseDadosException;
import java.util.List;

public interface FacadeBaseDados {
    
    

    //ELEMENTOS DE SISTEMA
    
    
        
    public Local LeLocal(int idPersonagem, int codigo) throws BaseDadosException;

    
    //ITENS

    public Item LeItem(int codigo) throws BaseDadosException;

    //PERSONAGENS


    public Jogador LeJogador(int codigo) throws BaseDadosException;

    public void EscreveJogador(Jogador jogador) throws BaseDadosException;
    
    public void AlteraJogador(List<Local> locais, Jogador jogador) throws BaseDadosException;

    public void RemoveJogador(int codigo) throws BaseDadosException;

    public List<Jogador> ListaJogadores() throws BaseDadosException;
    

    
}