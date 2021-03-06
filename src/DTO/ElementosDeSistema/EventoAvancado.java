package DTO.ElementosDeSistema;

import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;

public class EventoAvancado extends Evento {
    
    private String descricaoFalha;
    
    private Integer[] itensNecessários;
    private FolhaDeCaracteristicas característicasNecessarias;
    private FolhaDeHabilidades habilidadesNecessarias;

    //CONSTRUTORES
    
    public EventoAvancado() {
        super();
        
        this.descricaoFalha = "Falha!";
        
        this.característicasNecessarias = new FolhaDeCaracteristicas();
        this.habilidadesNecessarias = new FolhaDeHabilidades();
    }

    public EventoAvancado(String descricaoFalha,
            Integer[] itensNecessários, FolhaDeCaracteristicas característicasNecessarias, 
            FolhaDeHabilidades habilidadesNecessarias, 
            int id, String nome, String descricao, 
            int localDeRetorno, Resposta respostaDoEvento, 
            boolean eventoRealizado) {
        super(id, nome, descricao, 
                localDeRetorno, respostaDoEvento, 
                eventoRealizado);
        
        this.descricaoFalha = descricaoFalha;
        
        this.itensNecessários = itensNecessários;
        this.característicasNecessarias = característicasNecessarias;
        this.habilidadesNecessarias = habilidadesNecessarias;
    }

    //GETTERS AND SETTERS

    public String getDescricaoFalha() {
        return descricaoFalha;
    }

    public void setDescricaoFalha(String descricaoFalha) {
        this.descricaoFalha = descricaoFalha;
    }    
    
    

    public Integer[] getItensNecessários()  throws ArrayIndexOutOfBoundsException, NullPointerException{
        return itensNecessários;
    }

    public void setItensNecessários(Integer[] itensNecessários)  throws ArrayIndexOutOfBoundsException, 
            NullPointerException{
        this.itensNecessários = itensNecessários;
    }

    public FolhaDeCaracteristicas getCaracterísticasNecessarias() {
        return característicasNecessarias;
    }

    public void setCaracterísticasNecessarias(FolhaDeCaracteristicas característicasNecessarias) {
        this.característicasNecessarias = característicasNecessarias;
    }

    public FolhaDeHabilidades getHabilidadesNecessarias() {
        return habilidadesNecessarias;
    }

    public void setHabilidadesNecessarias(FolhaDeHabilidades habilidadesNecessarias) {
        this.habilidadesNecessarias = habilidadesNecessarias;
    }
    
}
