package DTO.ElementosDeSistema;

import java.util.LinkedList;

public class Local {
    
    //ATRIBUTOS

    private final int ID;

    private String nome;    
    private LinkedList<Evento> eventosDisponíveis;

    public Local() {
        super();
        
        this.ID = -1;
        
        this.nome = "Red Hook";
        this.eventosDisponíveis = new LinkedList<>();
    }
    
    public Local(String nome, LinkedList<Evento> eventosDisponíveis, int id) {
        super();
        
        this.ID = id;
        
        this.nome = nome;
        this.eventosDisponíveis = eventosDisponíveis;
    }
    
    //GETTERS AND SETTERS
    
    public int getID() {
        return ID;
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
    
    public Evento getEventoDisponivel(int indice) {
        return eventosDisponíveis.get(indice);
    }

    public void setEventoDisponivel(int indice ,Evento evento) {
        this.eventosDisponíveis.add(indice, evento); 
    }
    
}
