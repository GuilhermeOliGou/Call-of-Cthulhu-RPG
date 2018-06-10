package ElementosDeJogo.Sistema;

import ElementosDeJogo.Itens.Item;
import ElementosDeJogo.Personagens.FolhaDeAtributos;
import ElementosDeJogo.Personagens.Habilidades.FolhaDeHabilidades;
import ElementosDeJogo.Sistema.Eventos.Evento;

public class Resposta {
    
    //ATRIBUTOS
    
    private int codigo;
    
    private Evento eventoAlterado;
    private Local localAlterado;
    
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
        
        this.eventoAlterado = new Evento();
        this.localAlterado = new Local();
        
        this.atributosAlterados = new FolhaDeAtributos();
        this.localDoPersonagemAlterado = new Local();
        
        this.sanidadeAtualAlterada = 0;
        this.habilidadesAlteradas = new FolhaDeHabilidades();
    }

    public Resposta(int codigo, 
            Evento eventoAlterado, Local localAlterado, 
            FolhaDeAtributos atributosAlterados, Item[] itensAdicionados, 
            Item[] itensRemovidos, Local localDoPersonagemAlterado, 
            short sanidadeAtualAlterada, FolhaDeHabilidades habilidadesAlteradas) {
        super();
        
        this.codigo = codigo;
        
        this.eventoAlterado = eventoAlterado;
        this.localAlterado = localAlterado;
        
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

    
    
    public Evento getEventoAlterado() {
        return eventoAlterado;
    }

    public void setEventoAlterado(Evento eventoAlterado) {
        this.eventoAlterado = eventoAlterado;
    }

    public Local getLocalAlterado() {
        return localAlterado;
    }

    public void setLocalAlterado(Local localAlterado) {
        this.localAlterado = localAlterado;
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
