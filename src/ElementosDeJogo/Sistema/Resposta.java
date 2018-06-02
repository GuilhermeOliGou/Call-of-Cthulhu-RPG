package ElementosDeJogo.Sistema;

import ElementosDeJogo.Sistema.Eventos.Evento;

public class Resposta {
    
    //ATRIBUTOS GERAIS
    
    private int codigo;
    private Evento eventoAlterado;
    private Local localAlterado;
    
    //FIM ATRIBUTOS GERAIS
    
    //ATRIBUTOS DE PERSONAGEM
    
    //itens
    private int itemIdAlterado;
    private int itemNovo;
    private int itemDescartado;
    private Local localDoPersonagemAlterado;
    private short[] caracteristicasAlteradas;
    private short hpAtualAlterado;
    private short mpAtualAlterado;
    private short[] habilidadesAlteradas;
    private short sanidadeAtualAlterada;
    
    //FIM ATRIBUTOS DE PERSONAGEM
    
    //CONSTRUTORES

    public Resposta() {
        super();
    }
    
    public Resposta(int codigo, Evento eventoAlterado, Local localAlterado, Local localDePersonagemAlterado, short[] caracteristicasAlteradas, 
            short hpAtualAlterado, short mpAtualAlterado, short[] habilidadesAlteradas, short sanidadeAtualAlterada) {
        super();
        this.codigo = codigo;
        this.eventoAlterado = eventoAlterado;
        this.localAlterado = localAlterado;
        
        this.localDoPersonagemAlterado = localDePersonagemAlterado;
        this.caracteristicasAlteradas = caracteristicasAlteradas;
        this.hpAtualAlterado = hpAtualAlterado;
        this.mpAtualAlterado = mpAtualAlterado;
        this.habilidadesAlteradas = habilidadesAlteradas;
        this.sanidadeAtualAlterada = sanidadeAtualAlterada;
    }
    
    //FIM CONSTRUTORES
    
    //GETTERS AND SETTERS
    
    //GETTERS AND SETTERS ATRIBUTOS GERAIS

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
    
    //FIM GETTERS AND SETTERS ATRIBUTOS GERAIS
    
    //GETTERS AND SETTERS ATRIBUTOS DE PERSONAGEM

    public Local getLocalDePersonagemAlterado() {
        return getLocalDoPersonagemAlterado();
    }

    public void setLocalDePersonagemAlterado(Local localAlterado) {
        this.setLocalDoPersonagemAlterado(localAlterado);
    }

    public short[] getCaracteristicasAlteradas() {
        return caracteristicasAlteradas;
    }

    public void setCaracteristicasAlteradas(short[] caracteristicasAlteradas) {
        this.setCaracteristicasAlteradas(caracteristicasAlteradas);
    }

    public short getHpAtualAlterado() {
        return hpAtualAlterado;
    }

    public void setHpAtualAlterado(short hpAlterado) {
        this.hpAtualAlterado = hpAlterado;
    }

    public short getMpAtualAlterado() {
        return mpAtualAlterado;
    }

    public void setMpAtualAlterado(short mpAlterado) {
        this.mpAtualAlterado = mpAlterado;
    }  

    public short[] getHabilidadesAlteradas() {
        return habilidadesAlteradas;
    }

    public void setHabilidadesAlteradas(short[] habilidadesAlteradas) {
        this.setHabilidadesAlteradas(habilidadesAlteradas);
    }
    
    public short getHabilidade(int indice) {
        return habilidadesAlteradas[indice];
    }

    public void setHabilidade(int indice, short valor) {
        habilidadesAlteradas[indice] = valor;
    }

    public short getSanidadeAtualAlterada() {
        return sanidadeAtualAlterada;
    }

    public void setSanidadeAtualAlterada(short sanidadeAlterada) {
        this.sanidadeAtualAlterada = sanidadeAlterada;
    }      
    
    //FIM GETTERS AND SETTERS ATRIBUTOS DE PERSONAGEM
    
    //FIM GETTERS AND SETTERS

    public Local getLocalDoPersonagemAlterado() {
        return localDoPersonagemAlterado;
    }

    public void setLocalDoPersonagemAlterado(Local localDoPersonagemAlterado) {
        this.localDoPersonagemAlterado = localDoPersonagemAlterado;
    }

  
    
}
