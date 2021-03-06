package DTO.ElementosDeSistema;

import java.util.LinkedList;

public class Local {
    
    //ATRIBUTOS

    private int id;

    private String nome;    
    private LinkedList<Evento> eventosDisponíveis;

    public Local() {
        super();
        
        this.id = -1;
        
        this.nome = "Red Hook";
        this.eventosDisponíveis = new LinkedList<>();
    }
    
    public Local(String nome, LinkedList<Evento> eventosDisponíveis, int id) {
        super();
        
        this.id = id;
        
        this.nome = nome;
        this.eventosDisponíveis = eventosDisponíveis;
    }
    
    //GETTERS AND SETTERS
    
    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

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
    
}
