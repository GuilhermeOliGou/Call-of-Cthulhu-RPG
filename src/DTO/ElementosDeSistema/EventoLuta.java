package DTO.ElementosDeSistema;

import DTO.Personagens.Personagem;

public class EventoLuta extends Evento{
    
    //ATRIBUTOS
    
    private Personagem inimigo;
    
    //CONSTRUTORES
    
    public EventoLuta(){
        super();
    }

    public EventoLuta(int id, String nome, String descricao, 
            int localDeRetorno, Resposta respostaDoEvento, boolean eventoUnico,
            Personagem inimigo) {
        super(id, nome, descricao, 
                localDeRetorno, respostaDoEvento, true);
        
        this.inimigo = inimigo;
    }
    
    //GETTERS E SETTERS

    public Personagem getInimigo() {
        return inimigo;
    }

    public void setInimigo(Personagem inimigo) {
        this.inimigo = inimigo;
    }
    
}
