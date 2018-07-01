package DTO.ElementosDeSistema;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;

public class Resposta {
    
    //ATRIBUTOS
    
    private final int ID;
    
    private FolhaDeAtributos atributosAlterados;
    private int[] itensAdicionados;
    private int[] itensRemovidos;
    private int localDoPersonagemAlterado;
    
    private short sanidadeAtualAlterada;
    private FolhaDeHabilidades habilidadesAlteradas;
    
    //CONSTRUTORES

    public Resposta() {
        super();
        
        this.ID = -1;
        
        this.atributosAlterados = new FolhaDeAtributos();
        this.localDoPersonagemAlterado = -1;
        
        this.sanidadeAtualAlterada = 0;
        this.habilidadesAlteradas = new FolhaDeHabilidades();
    }

    public Resposta(int codigo,  
            FolhaDeAtributos atributosAlterados, int[] itensAdicionados, 
            int[] itensRemovidos, int localDoPersonagemAlterado, 
            short sanidadeAtualAlterada, FolhaDeHabilidades habilidadesAlteradas) {
        super();
        
        this.ID = codigo;
        
        this.atributosAlterados = atributosAlterados;
        this.itensAdicionados = itensAdicionados;
        this.itensRemovidos = itensRemovidos;
        this.localDoPersonagemAlterado = localDoPersonagemAlterado;
        
        this.sanidadeAtualAlterada = sanidadeAtualAlterada;
        this.habilidadesAlteradas = habilidadesAlteradas;
    }
    
    //GETTERS AND SETTERS

    public int getID() {
        return ID;
    }
    
    

    public FolhaDeAtributos getAtributosAlterados() {
        return atributosAlterados;
    }

    public void setAtributosAlterados(FolhaDeAtributos atributosAlterados) {
        this.atributosAlterados = atributosAlterados;
    }

    public int[] getItensAdicionados(){
        return itensAdicionados;
    }

    public void setItensAdicionados(int[] itensAdicionados) {
        this.itensAdicionados = itensAdicionados;
    }

    public int[] getItensRemovidos() {
        return itensRemovidos;
    }

    public void setItensRemovidos(int[] itensRemovidos) {
        this.itensRemovidos = itensRemovidos;
    }

    public int getLocalDoPersonagemAlterado() {
        return localDoPersonagemAlterado;
    }

    public void setLocalDoPersonagemAlterado(int localDoPersonagemAlterado) {
        this.localDoPersonagemAlterado = localDoPersonagemAlterado;
    }
    
    

    public short getSanidadeAtualAlterada() {
        return sanidadeAtualAlterada;
    }

    public void setSanidadeAtualAlterada(short sanidadeAtualAlterada) {
        this.sanidadeAtualAlterada = sanidadeAtualAlterada;
    }

    public FolhaDeHabilidades getHabilidadesAlteradas() {
        return habilidadesAlteradas;
    }

    public void setHabilidadesAlteradas(FolhaDeHabilidades habilidadesAlteradas) {
        this.habilidadesAlteradas = habilidadesAlteradas;
    }
    
    
    
}
