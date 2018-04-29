package ElementosDeJogo.Sistema;

import ElementosDeJogo.Sistema.Eventos.Evento;
import java.util.LinkedList;

public class Local {
    
    private String nome;
    private LinkedList<Evento> eventosDisponíveis;

    //CONSTRUTORES

    public Local() {
        super();
    }
    
    public Local(String nome, LinkedList<Evento> eventosDisponíveis) {
        super();
        this.nome = nome;
        this.eventosDisponíveis = eventosDisponíveis;
    }
    
    //FIM CONSTRUTORES
    
    //GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedList<Evento> getEventosDisponíveis() {
        return eventosDisponíveis;
    }

    public void setEventosDisponíveis(LinkedList<Evento> eventosDisponíveis) {
        this.eventosDisponíveis = eventosDisponíveis;
    }
    
    public Evento getEventoDisponivel(int indice) {
        return eventosDisponíveis.get(indice);
    }

    public void setEventoDisponivel(int indice ,Evento evento) {
        this.eventosDisponíveis.add(indice, evento); 
    }
    
    //FIM GETTERS AND SETTERS
    
}
