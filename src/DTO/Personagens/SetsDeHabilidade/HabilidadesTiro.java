package DTO.Personagens.SetsDeHabilidade;

public class HabilidadesTiro {
    
    //ATRIBUTOS
        
    private short tiroPistola;
    private short tiroRifleEscopeta;
    private short tiroSubmetralhadora;
    
    private short arremesso;
    
    //CONSTRUTORES

    public HabilidadesTiro() {
        super();
        
        this.tiroPistola = 20;
        this.tiroRifleEscopeta = 25;
        this.tiroSubmetralhadora = 10;   
        
        this.arremesso = 20;
    }
    
    public HabilidadesTiro(boolean anotacoes) {
        this();
        
        if (anotacoes){
            this.tiroPistola = 0;
            this.tiroRifleEscopeta = 0;
            this.tiroSubmetralhadora = 0;   

            this.arremesso = 0;
        }
    }

    public HabilidadesTiro(short tiroPistola, short tiroRifleEscopeta, short tiroSubmetralhadora, 
            short arremesso) {
        super();
        
        this.tiroPistola = tiroPistola;
        this.tiroRifleEscopeta = tiroRifleEscopeta;
        this.tiroSubmetralhadora = tiroSubmetralhadora;
        
        this.arremesso = arremesso;
    }
    
    //GETTERS E SETTERS

    public short getTiroPistola() {
        return tiroPistola;
    }

    public void setTiroPistola(short tiroPistola) {
        this.tiroPistola = tiroPistola;
    }

    public short getTiroRifleEscopeta() {
        return tiroRifleEscopeta;
    }

    public void setTiroRifleEscopeta(short tiroRifleEscopeta) {
        this.tiroRifleEscopeta = tiroRifleEscopeta;
    }

    public short getTiroSubmetralhadora() {
        return tiroSubmetralhadora;
    }

    public void setTiroSubmetralhadora(short tiroSubmetralhadora) {
        this.tiroSubmetralhadora = tiroSubmetralhadora;
    }

    public short getArremesso() {
        return arremesso;
    }

    public void setArremesso(short arremesso) {
        this.arremesso = arremesso;
    }    
       
}
