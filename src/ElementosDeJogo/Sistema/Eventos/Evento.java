package ElementosDeJogo.Sistema.Eventos;

import ElementosDeJogo.Sistema.Local;
import ElementosDeJogo.Sistema.Resposta;

public class Evento {
    
    protected String nome;
    protected String descricao;
    protected Local localDeRetorno;
    protected Resposta respostaDoEvento;
    protected boolean eventoUnico;
    
    //CONSTRUTORES

    public Evento() {
        super();
    }
        
    public Evento(String nome, String descricao, Local localDeRetorno, Resposta respostaDoEvento,
                boolean eventoUnico) {
        this.descricao = descricao;
        this.nome = nome;
        this.localDeRetorno = localDeRetorno;
        this.respostaDoEvento = respostaDoEvento;
        this.eventoUnico = eventoUnico;
    }
    
    //FIM CONSTRUTORES
    
    //GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
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
    
    //FIM GETTERS AND SETTERS

}
