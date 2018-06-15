package DTO.ElementosDeSistema;

import DTO.ElementosDeSistema.Local;
import DTO.ElementosDeSistema.Resposta;

public class Evento {

    protected int id;
    
    protected String nome;
    protected String descricao;
    
    protected Local localDeRetorno;
    
    protected Resposta respostaDoEvento;
    
    protected boolean eventoUnico;
    protected int qtdRealizacoes;
    
    //CONSTRUTORES

    public Evento() {
        super();
        
        this.id = -1;
        
        this.nome = "";
        this.descricao = "Sucesso!";
        
        this.localDeRetorno = new Local();
        
        this.respostaDoEvento = new Resposta();
        
        this.eventoUnico = true;
        this.qtdRealizacoes = 0;
    }
        
    public Evento(int id, 
            String nome, String descricao, 
            Local localDeRetorno, 
            Resposta respostaDoEvento,
            boolean eventoRealizado, int qtdRealizacoes) {
        super();
        
        this.id = id;
        
        this.nome = nome;
        this.descricao = descricao;
        
        this.localDeRetorno = localDeRetorno;
        
        this.respostaDoEvento = respostaDoEvento;
        
        this.eventoUnico = eventoRealizado;
        this.qtdRealizacoes = qtdRealizacoes;
    }

    /*
    IMPORTANTE:
        Uso preferencial: eventos de deslocamento
    */
    public Evento(int id, String nome, Local localDeRetorno) {
        super();
        
        this.id = id;
        this.nome = nome;
        this.localDeRetorno = localDeRetorno;
    }

    /*
    IMPORTANTE:
        Uso preferencial: interação com o cenário
    */
    public Evento(int id, String nome, String descricao, Resposta respostaDoEvento) {
        super();
        
        this.id = id;
        
        this.nome = nome;
        this.descricao = descricao;
        
        this.respostaDoEvento = respostaDoEvento;
    }
    
    //GETTERS AND SETTERS

    public int getId() {
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

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    

    public Local getLocalDeRetorno() {
        return localDeRetorno;
    }

    public void setLocalDeRetorno(Local localDeRetorno) {
        this.localDeRetorno = localDeRetorno;
    }
    
    

    public Resposta getRespostaDoEvento() {
        return respostaDoEvento;
    }

    public void setRespostaDoEvento(Resposta respostaDoEvento) {
        this.respostaDoEvento = respostaDoEvento;
    }
    
    

    public boolean isEventoUnico() {
        return eventoUnico;
    }

    public void setEventoUnico(boolean eventoUnico) {
        this.eventoUnico = eventoUnico;
    }

    public int getQtdRealizacoes() {
        return qtdRealizacoes;
    }

    public void setQtdRealizacoes(int qtdRealizacoes) {
        this.qtdRealizacoes = qtdRealizacoes;
    }

}
