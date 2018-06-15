package DTO.ElementosDeSistema;

import DTO.Itens.Item;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;

public class Resposta {
    
    //ATRIBUTOS
    
    private int codigo;
    
    private FolhaDeAtributos atributosAlterados;
    private Item[] itensAdicionados;
    private Item[] itensRemovidos;
    private Local localDoPersonagemAlterado;
    
    private short sanidadeAtualAlterada;
    private FolhaDeHabilidades habilidadesAlteradas;
    
    //CONSTRUTORES

    public Resposta() {
        super();
        
        this.codigo = -1;
        
        this.atributosAlterados = new FolhaDeAtributos();
        this.localDoPersonagemAlterado = new Local();
        
        this.sanidadeAtualAlterada = 0;
        this.habilidadesAlteradas = new FolhaDeHabilidades();
    }

    public Resposta(int codigo,  
            FolhaDeAtributos atributosAlterados, Item[] itensAdicionados, 
            Item[] itensRemovidos, Local localDoPersonagemAlterado, 
            short sanidadeAtualAlterada, FolhaDeHabilidades habilidadesAlteradas) {
        super();
        
        this.codigo = codigo;
        
        this.atributosAlterados = atributosAlterados;
        this.itensAdicionados = itensAdicionados;
        this.itensRemovidos = itensRemovidos;
        this.localDoPersonagemAlterado = localDoPersonagemAlterado;
        
        this.sanidadeAtualAlterada = sanidadeAtualAlterada;
        this.habilidadesAlteradas = habilidadesAlteradas;
    }
    
    //GETTERS AND SETTERS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    public FolhaDeAtributos getAtributosAlterados() {
        return atributosAlterados;
    }

    public void setAtributosAlterados(FolhaDeAtributos atributosAlterados) {
        this.atributosAlterados = atributosAlterados;
    }

    public Item[] getItensAdicionados(){
        return itensAdicionados;
    }

    public void setItensAdicionados(Item[] itensAdicionados) {
        this.itensAdicionados = itensAdicionados;
    }

    public Item[] getItensRemovidos() {
        return itensRemovidos;
    }

    public void setItensRemovidos(Item[] itensRemovidos) {
        this.itensRemovidos = itensRemovidos;
    }

    public Local getLocalDoPersonagemAlterado() {
        return localDoPersonagemAlterado;
    }

    public void setLocalDoPersonagemAlterado(Local localDoPersonagemAlterado) {
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
