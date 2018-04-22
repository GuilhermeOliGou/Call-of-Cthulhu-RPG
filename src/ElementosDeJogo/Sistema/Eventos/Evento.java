package ElementosDeJogo.Sistema.Eventos;

import ElementosDeJogo.Sistema.Local;
import ElementosDeJogo.Sistema.Resposta;

public class Evento {
    
    protected String nome;
    protected Local localDeRetorno;
    protected Resposta respostaDoEvento;
    protected boolean eventoUnico;
    
    //CONSTRUTORES

    public Evento() {
        super();
    }
        
    public Evento(String nome, Local localDeRetorno, Resposta respostaDoEvento,
                boolean eventoUnico) {
        this.nome = nome;
        this.localDeRetorno = localDeRetorno;
        this.respostaDoEvento = respostaDoEvento;
        this.eventoUnico = eventoUnico;
    }
    
    //FIM CONSTRUTORES
    
    //GETTERS E SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    //FIM GETTERS E SETTERS

}
