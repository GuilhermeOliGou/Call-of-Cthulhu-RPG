package telas;

import DTO.Personagens.Jogador;
import java.util.ArrayList;

public interface FacadeTelas {
    
    boolean existeJogos();
    
    ArrayList<Jogador> getJogadores();
    
    void salvarJogador(Jogador jogador);
    
    void resetaJogo();
}
