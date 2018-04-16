package ElementosDeJogo;

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
    protected short movimento;
    protected short bonusDeDanoCorporal;
    protected short build;
    protected short hpAtual;
    protected short mpAtual;
    protected short idade;
    protected String nome;
    
    //FIM DE ATRIBUTOS SECUNDARIOS
    
    //CONSTRUTORES
    
    public Personagem (){
        super();
    }

    public Personagem(short forca, short constituicao, short tamanho, short destreza, 
            short aparencia, short inteligencia, short educacao, short poder, 
            short idade, String nome, short d4, short d6) {
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
        
        setMaxHp();
        setMaxMp();
        setMovimento();
        setBonusDeDanoCorporal(d4, d6);
        setBuild();
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

    public final void setMaxHp() {
        this.maxHp = (short)((getConstituicao()+getTamanho())/10);
        setHpAtual(maxHp);
    }

    public short getMaxMp() {
        return maxMp;
    }

    public final void setMaxMp() {
        this.maxMp = (short)((getPoder()/5));
        setMpAtual(maxMp);
    }
    
    public short getMovimento() {
        return movimento;
    }

    public final void setMovimento() {
        short _destreza = getDestreza();
        short _forca = getForca();
        short _tamanho = getTamanho();
        if (_destreza < _tamanho && _forca < _tamanho)
            this.movimento = 7;
        else if (_destreza >= _tamanho && _forca >= _tamanho)
            this.movimento = 9;
        else 
            this.movimento = 8;
    }

    public short getBonusDeDanoCorporal() {
        return bonusDeDanoCorporal;
    }

    public final void setBonusDeDanoCorporal(short rolamentoD4, short rolamentoD6) {
        short somaDeForETam = (short)(getForca()+getTamanho());
        if (somaDeForETam >= 2 && somaDeForETam <= 64){
            this.bonusDeDanoCorporal = -2;
        }else if (somaDeForETam > 64 && somaDeForETam <= 84){
            this.bonusDeDanoCorporal = -1;
        }else if (somaDeForETam > 85 && somaDeForETam <= 124){
            this.bonusDeDanoCorporal = 0;
        }else if (somaDeForETam > 125 && somaDeForETam <= 164){
            this.bonusDeDanoCorporal = rolamentoD4;
        }else{
            this.bonusDeDanoCorporal = rolamentoD6;
        }
    }
    
    public short getBuild() {
        return build;
    }

    public final void setBuild() {
        short somaDeForETam = (short)(getForca()+getTamanho());
        if (somaDeForETam >= 2 && somaDeForETam <= 64){
            this.build = -2;
        }else if (somaDeForETam > 64 && somaDeForETam <= 84){
            this.build = -1;
        }else if (somaDeForETam > 85 && somaDeForETam <= 124){
            this.build = 0;
        }else if (somaDeForETam > 125 && somaDeForETam <= 164){
            this.build = 1;
        }else{
            this.build = 2;
        }
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
    
    //FIM DE GETTERS AND SETTERS
    
}
