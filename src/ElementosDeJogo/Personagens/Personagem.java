package ElementosDeJogo.Personagens;

import ElementosDeJogo.Sistema.Local;

public class Personagem {
    
    //ATRIBUTOS PRIMÁRIOS
    
    protected short forca;
    protected short constituicao;
    protected short tamanho;
    protected short destreza;
    protected short aparencia;
    protected short inteligencia;
    protected short educacao;
    protected short poder;
    
    //FIM DE ATRIBUTOS PRINCIPAIS
    
    //ATRIBUTOS SECUNDARIOS
    
    protected short maxHp;
    protected short maxMp;
    protected short hpAtual;
    protected short mpAtual;
    protected short movimento;
    protected short bonusDeDanoCorporal;
    protected short build;
    protected short idade;
    protected String nome;
    
    //FIM DE ATRIBUTOS SECUNDARIOS
    
    //ATRIBUTOS DE SISTEMA
    
    protected Local localidadeAtual;
    
    //FIM ATRIBUTOS DE SISTEMA
    
    //CONSTRUTORES
    
    public Personagem (){
        super();
    }

    public Personagem(short forca, short constituicao, short tamanho, short destreza, 
            short aparencia, short inteligencia, short educacao, short poder, 
            short idade, String nome, short maxHp, short maxMp,  
            short movimento, short bonusDeDanoCorporal, short build,
            Local localidadeAtual) {
        super();
        
        this.forca = forca;
        this.constituicao = constituicao;
        this.tamanho = tamanho;
        this.destreza = destreza;
        this.aparencia = aparencia;
        this.inteligencia = inteligencia;
        this.educacao = educacao;
        this.poder = poder;
        
        this.idade = idade;
        this.nome = nome;
        
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.hpAtual = maxHp;
        this.mpAtual = maxMp;
        this.movimento = movimento;
        this.bonusDeDanoCorporal = bonusDeDanoCorporal;
        this.build = build;
        
        this.localidadeAtual = localidadeAtual;
    }

    
    
    //FIM CONSTRUTORES
    
    //GETTERS AND SETTERS
    
    //GETTERS AND SETTERS DE ATRIBUTOS PRINCIPAIS

    public short getForca() {
        return forca;
    }

    public void setForca(short forca) {
        this.forca = forca;
    }

    public short getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(short constituicao) {
        this.constituicao = constituicao;
    }

    public short getTamanho() {
        return tamanho;
    }

    public void setTamanho(short tamanho) {
        this.tamanho = tamanho;
    }

    public short getDestreza() {
        return destreza;
    }

    public void setDestreza(short destreza) {
        this.destreza = destreza;
    }

    public short getAparencia() {
        return aparencia;
    }

    public void setAparencia(short aparencia) {
        this.aparencia = aparencia;
    }

    public short getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(short inteligencia) {
        this.inteligencia = inteligencia;
    }

    public short getEducacao() {
        return educacao;
    }

    public void setEducacao(short educacao) {
        this.educacao = educacao;
    }

    public short getPoder() {
        return poder;
    }

    public void setPoder(short poder) {
        this.poder = poder;
    }
    
    //FIM GETTERS AND SETTERS DE ATRIBUTOS PRINCIPAIS
    
    //GETTERS AND SETTERS DE ATRIBUTOS SECUNDARIOS

    public short getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(short maxHp) {
        this.maxHp = maxHp;
    }

    public short getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(short maxMp) {
        this.maxMp = maxMp;
    }
    
    public short getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(short hpAtual) {
        this.hpAtual = hpAtual;
    }
    
    public short getMpAtual() {
        return mpAtual;
    }

    public void setMpAtual(short mpAtual) {
        this.mpAtual = mpAtual;
    }
    
    public short getMovimento() {
        return movimento;
    }

    public final void setMovimento(short movimento) {
        this.movimento = movimento;
    }

    public short getBonusDeDanoCorporal() {
        return bonusDeDanoCorporal;
    }

    public final void setBonusDeDanoCorporal(short bonusDeDanoCorporal) {
        this.bonusDeDanoCorporal = bonusDeDanoCorporal;
    }
    
    public short getBuild() {
        return build;
    }

    public final void setBuild(short build) {
        this.build = build;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        if (idade < 15)        
            this.idade = 15;
        else if (idade > 90)
            this.idade = 90;
        else
            this.idade = idade;            
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //FIM GETTERS AND SETTERS DE ATRIBUTOS SECUNDARIOS
    
    //GETTERS AND SETTERS DE ATRIBUTOS DE SISTEMA
    
    public Local getLocalidadeAtual() {
        return localidadeAtual;
    }

    public void setLocalidadeAtual(Local localidadeAtual) {
        this.localidadeAtual = localidadeAtual;
    }
    
    //FIM GETTERS AND SETTERS DE ATRIBUTOS DE SISTEMA
    
    //FIM DE GETTERS AND SETTERS0
    
}
