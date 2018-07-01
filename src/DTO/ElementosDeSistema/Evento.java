package DTO.ElementosDeSistema;

public class Evento {

    protected final int ID;
    
    protected String nome;
    protected String descricao;
    
    protected int localDeRetorno;
    
    protected Resposta respostaDoEvento;
    
    protected boolean eventoUnico;
    protected boolean eventoValido;
    
    //CONSTRUTORES

    public Evento() {
        super();
        
        this.ID = -1;
        
        this.nome = "";
        this.descricao = "Sucesso!";
        
        this.localDeRetorno = -1;
        
        this.respostaDoEvento = new Resposta();
        
        this.eventoUnico = true;
        this.eventoValido = true;
    }
        
    public Evento(int id, 
            String nome, String descricao, 
            int localDeRetorno, 
            Resposta respostaDoEvento,
            boolean eventoUnico) {
        super();
        
        this.ID = id;
        
        this.nome = nome;
        this.descricao = descricao;
        
        this.localDeRetorno = localDeRetorno;
        
        this.respostaDoEvento = respostaDoEvento;
        
        this.eventoUnico = eventoUnico;
    }

    /*
    IMPORTANTE:
        Uso preferencial: eventos de deslocamento
    */
    public Evento(int id, String nome, int localDeRetorno) {
        super();
        
        this.ID = id;
        this.nome = nome;
        this.localDeRetorno = localDeRetorno;
    }

    /*
    IMPORTANTE:
        Uso preferencial: interação com o cenário
    */
    public Evento(int id, String nome, String descricao, Resposta respostaDoEvento) {
        super();
        
        this.ID = id;
        
        this.nome = nome;
        this.descricao = descricao;
        
        this.respostaDoEvento = respostaDoEvento;
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

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
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

    public boolean isEventoValido() {
        return eventoValido;
    }

    public void setEventoValidoFalso() {
        this.eventoValido = false;
    }

}
