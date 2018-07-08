package DTO.ElementosDeSistema;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;

public class Resposta {
    
    //ATRIBUTOS
    
    private FolhaDeAtributos atributosAlterados;
    
    private Integer[] itensAdicionados;
    private Integer[] itensRemovidos;
    
    private short sanidadeAtualAlterada;
    private FolhaDeHabilidades habilidadesAlteradas;
    
    //CONSTRUTORES

    public Resposta() {
        super();
        
        this.atributosAlterados = new FolhaDeAtributos();
        
        this.sanidadeAtualAlterada = 0;
        this.habilidadesAlteradas = new FolhaDeHabilidades();
    }

    public Resposta(FolhaDeAtributos atributosAlterados, 
            Integer[] itensAdicionados, Integer[] itensRemovidos, 
            short sanidadeAtualAlterada, FolhaDeHabilidades habilidadesAlteradas) {
        super();
        
        this.atributosAlterados = atributosAlterados;
        
        this.itensAdicionados = itensAdicionados;
        this.itensRemovidos = itensRemovidos;
        
        this.sanidadeAtualAlterada = sanidadeAtualAlterada;
        this.habilidadesAlteradas = habilidadesAlteradas;
    }
    
    //GETTERS AND SETTERS   

    public FolhaDeAtributos getAtributosAlterados() {
        return atributosAlterados;
    }

    public void setAtributosAlterados(FolhaDeAtributos atributosAlterados) {
        this.atributosAlterados = atributosAlterados;
    }
    
    

    public Integer[] getItensAdicionados() throws ArrayIndexOutOfBoundsException, NullPointerException{
        return itensAdicionados;
    }

    public void setItensAdicionados(Integer[] itensAdicionados) throws ArrayIndexOutOfBoundsException, 
            NullPointerException{
        this.itensAdicionados = itensAdicionados;
    }

    public Integer[] getItensRemovidos() throws ArrayIndexOutOfBoundsException, NullPointerException{
        return itensRemovidos;
    }

    public void setItensRemovidos(Integer[] itensRemovidos) throws ArrayIndexOutOfBoundsException
            , NullPointerException{
        this.itensRemovidos = itensRemovidos;
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
