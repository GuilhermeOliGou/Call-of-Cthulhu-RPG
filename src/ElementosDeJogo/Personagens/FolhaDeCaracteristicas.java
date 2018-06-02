package ElementosDeJogo.Personagens;

public class FolhaDeCaracteristicas {
    
    //ATRIBUTOS
    
    private short forca;
    private short constituicao;
    private short tamanho;
    private short destreza;
    private short aparencia;
    private short inteligencia;
    private short educacao;
    private short poder;
    
    //CONSTRUTORES

    public FolhaDeCaracteristicas() {
        super();
    }
    
    public FolhaDeCaracteristicas(short forca, short constituicao, 
            short tamanho, short destreza, short aparencia, 
            short inteligencia, short educacao, short poder) {
        super();
        
        this.forca = forca;
        this.constituicao = constituicao;
        this.tamanho = tamanho;
        this.destreza = destreza;
        this.aparencia = aparencia;
        this.inteligencia = inteligencia;
        this.educacao = educacao;
        this.poder = poder;
    }   
    
    //GETTERS E SETTERS
    
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
    
}
