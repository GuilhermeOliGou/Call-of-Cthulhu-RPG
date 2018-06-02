package ElementosDeJogo.Personagens.Habilidades;

public class HabilidadesInterpessoais {
    
    //ATRIBUTOS
    
    private short sedução;
    private short falaRapida;
    private short intimidacao;
    private short persuasao;
    
    //CONSTRUTORES

    public HabilidadesInterpessoais() {
        super();
        
        this.sedução = 15;
        this.falaRapida = 5;
        this.intimidacao = 15;
        this.persuasao = 10;
    }
    
    //GETTERS E SETTERS

    public short getSedução() {
        return sedução;
    }

    public void setSedução(short sedução) {
        this.sedução = sedução;
    }

    public short getFalaRapida() {
        return falaRapida;
    }

    public void setFalaRapida(short falaRapida) {
        this.falaRapida = falaRapida;
    }

    public short getIntimidacao() {
        return intimidacao;
    }

    public void setIntimidacao(short intimidacao) {
        this.intimidacao = intimidacao;
    }

    public short getPersuasao() {
        return persuasao;
    }

    public void setPersuasao(short persuasao) {
        this.persuasao = persuasao;
    }
    
}
