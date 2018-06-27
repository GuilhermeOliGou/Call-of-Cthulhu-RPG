package DTO.Personagens;

public class FolhaDeCaracteristicas {
    
    //ATRIBUTOS
    
    private short forca;
    private short constituicao;
    private short tamanho;
    private short destreza;
    private short poder;
    
    //CONSTRUTORES

    public FolhaDeCaracteristicas() {
        super();
        
        this.forca = 0;
        this.constituicao = 0;
        this.tamanho = 0;
        this.destreza = 0;
        this.poder = 0;
    }
    
    public FolhaDeCaracteristicas(short forca, short constituicao, 
            short tamanho, short destreza, short poder) {
        super();
        
        this.forca = forca;
        this.constituicao = constituicao;
        this.tamanho = tamanho;
        this.destreza = destreza;
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

    public short getPoder() {
        return poder;
    }

    public void setPoder(short poder) {
        this.poder = poder;
    }
    
}