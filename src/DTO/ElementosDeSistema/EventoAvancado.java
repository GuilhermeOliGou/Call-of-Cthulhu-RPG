package DTO.ElementosDeSistema;

import DTO.ElementosDeSistema.Evento;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.ElementosDeSistema.Local;
import DTO.ElementosDeSistema.Resposta;

public class EventoAvancado extends Evento {
    
    private String descricaoFalha;
    
    private short buildNecessaria;
    
    private int[] itensNecessários;
    private FolhaDeCaracteristicas característicasNecessarias;
    private FolhaDeHabilidades habilidadesNecessarias;

    //CONSTRUTORES
    
    public EventoAvancado() {
        super();
        
        this.descricaoFalha = "Falha!";
        
        this.buildNecessaria = 0;
        
        this.característicasNecessarias = new FolhaDeCaracteristicas();
        this.habilidadesNecessarias = new FolhaDeHabilidades();
    }

    public EventoAvancado(String descricaoFalha, short buildNecessaria,
            int[] itensNecessários, FolhaDeCaracteristicas característicasNecessarias, 
            FolhaDeHabilidades habilidadesNecessarias, 
            int id, String nome, String descricao, 
            Local localDeRetorno, Resposta respostaDoEvento, 
            boolean eventoRealizado, int qtdRealizacoes) {
        super(id, nome, descricao, 
                localDeRetorno, respostaDoEvento, 
                eventoRealizado, qtdRealizacoes);
        
        this.descricaoFalha = descricaoFalha;
        
        this.buildNecessaria = buildNecessaria;
        
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
    
    

    public short getBuildNecessaria() {
        return buildNecessaria;
    }

    public void setBuildNecessaria(short buildNecessaria) {
        this.buildNecessaria = buildNecessaria;
    }    
    
    

    public int[] getItensNecessários() {
        return itensNecessários;
    }

    public void setItensNecessários(int[] itensNecessários) {
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
