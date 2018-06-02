package ElementosDeJogo.Sistema.Eventos;

import ElementosDeJogo.Sistema.Local;
import ElementosDeJogo.Sistema.Resposta;

public class Evento {

    protected int id;
    
    protected String nome;
    protected String descricaoSucesso;
    protected String descricaoFalha;
    
    protected int localDeRetorno;
    protected Resposta respostaDoEvento;
    protected boolean eventoUnico;
    private int eventoRealizado;
    
    //CONSTRUTORES

    public Evento() {
        super();
    }
        
    public Evento(int id, String nome, String descricaoSucesso, String descricaoFalha, int localDeRetorno, Resposta respostaDoEvento,
                boolean eventoUnico, int eventoRealizado) {
        this.id = id;
        this.nome = nome;
        this.descricaoSucesso = descricaoSucesso;
        this.descricaoFalha = descricaoFalha;
        this.localDeRetorno = localDeRetorno;
        this.respostaDoEvento = respostaDoEvento;
        this.eventoUnico = eventoUnico;
        this.eventoRealizado = eventoRealizado;
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

    public String getDescricaoSucesso() {
        return descricaoSucesso;
    }
    public String getDescricaoFalha(){
        return descricaoFalha;
    }
    public String setDescricaoFalha(){
        return descricaoFalha;
    }

    public void setDescricaoFalha(String descricaoFalha) {
        this.descricaoFalha = descricaoFalha;
    }

    public int getLocalDeRetorno() {
        return localDeRetorno;
    }

    public void setLocalDeRetorno(int localDeRetorno) {
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

    public int getEventoRealizado() {
        return eventoRealizado;
    }

    public void setEventoRealizado(int eventoRealizado) {
        this.eventoRealizado = eventoRealizado;
    }

}
