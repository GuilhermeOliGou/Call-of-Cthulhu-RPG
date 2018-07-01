package telas;

import DTO.Personagens.Jogador;
import java.util.ArrayList;

public interface FacadeTelas {
    
    public boolean existeJogos();
    
    public ArrayList<String> getDescricoesJogadores();
    
    public String getPersonagem();
    
    public String getHPPersonagem();
    
    public String getHPMaxPersonagem();
    
    public String getInimigo();
    
    public String getHPInimigo();
    
    public String getHPMaxInimigo();
    
    public ArrayList<String> getAcoesBatalha();
        
    public String carregaJogador(int index);
    
    public String getDescricaoEvento();
    
    public boolean getBatalha();
    
    public String getDescricaoJogador();
    
    public Local carregaLocal();
    
    public void salvarJogador(Jogador jogador);
    
    public void resetaJogo();
    
    public ArrayList<String> getEventos();
    
    public void executaEvento(int index);
    
    public void resetaEPopula();
    
}
