package ElementosDeJogo.Sistema;

import ElementosDeJogo.Sistema.Eventos.Evento;
import java.util.LinkedList;

public class Local {
    
    private String nome;
    private LinkedList<Evento> eventosDisponíveis;

    public Local(String nome, LinkedList<Evento> eventosDisponíveis) {
        this.nome = nome;
        this.eventosDisponíveis = eventosDisponíveis;
    }
    
}
