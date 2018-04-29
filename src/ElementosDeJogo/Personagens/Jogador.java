package ElementosDeJogo.Personagens;

import ElementosDeJogo.Sistema.Local;

public class Jogador extends Personagem {
    
    //ATRIBUTOS DE JOGADOR
    
    private short maxSanidade;
    private short sanidadeAtual;
    private short sorte;
    private short[] habilidades;
    
    //CONSTRUTORES

    public Jogador() {
        super();
    }

    public Jogador(short forca, short constituicao, short tamanho, short destreza, 
            short aparencia, short inteligencia, short educacao, short poder, 
            short idade, String nome, short maxHp, short maxMp, 
            short movimento, short bonusDeDanoCorporal, short build, short sorte,
            Local localidadeAtual) {
        super(forca, constituicao, tamanho, destreza, 
                aparencia, inteligencia, educacao, poder, 
                idade, nome, maxHp, maxMp,
                movimento, bonusDeDanoCorporal, build,
                localidadeAtual);
        this.habilidades = new short[]{5, 5, 1, 1, 5, 1, 15, 20, 5, 0, 1, 5, 1, (short)(destreza/2), 20, 10, 1, 5, 15, 25, 10, 10, 15, 20, 20, 5, 15, 20, 10, 10, 10, 25, 15, 30, 5, 1, 15, 20, 1, educacao, 5, 20, 20, 1, 10, 1, 10, 10, 5, 1, 10, 1, 1, 10, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 10, 25, 20, 10, 20, 20, 10};
        this.sorte = sorte;
        this.maxSanidade = poder;
        this.sanidadeAtual = maxSanidade;
    }

    //FIM DE CONSTRUTORES
    
    //GETTERS AND SETTERS
    
    public short getMaxSanidade() {
        return maxSanidade;
    }
    
    public void setMaxSanidade(short maxSanidade) {    
        this.maxSanidade = maxSanidade;
    }

    public short getSanidadeAtual() {
        return sanidadeAtual;
    }

    public void setSanidadeAtual(short sanidade) {
        this.sanidadeAtual = sanidade;
    }

    public short getSorte() {
        return sorte;
    }

    public void setSorte(short sorte) {
        this.sorte = sorte;
    }

    public short[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(short[] habilidades) {
        this.habilidades = habilidades;
    }
    
    public short getHabilidade(int indice) {
        return habilidades[indice];
    }

    public void setHabilidade(int indice, short valor) {
        habilidades[indice] = valor;
    }
    
    //FIM DE GETTERS AND SETTERS
    
}
