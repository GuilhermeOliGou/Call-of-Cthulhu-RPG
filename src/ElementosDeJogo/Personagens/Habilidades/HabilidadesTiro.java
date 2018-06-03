package ElementosDeJogo.Personagens.Habilidades;

public class HabilidadesTiro {
    
    //ATRIBUTOS
        
    private short tiroArco;
    private short tiroPistola;
    private short tiroArmaPesada;
    private short tiroLancaChamas;
    private short tiroMetralhadora;
    private short tiroRifleEscopeta;
    private short tiroSubmetralhadora;
    
    private short arremesso;
    
    //CONSTRUTORES

    public HabilidadesTiro() {
        super();
        
        this.tiroArco = 15;
        this.tiroPistola = 20;
        this.tiroArmaPesada = 10;
        this.tiroLancaChamas = 10;
        this.tiroMetralhadora = 10;
        this.tiroRifleEscopeta = 25;
        this.tiroSubmetralhadora = 10;   
        
        this.arremesso = 20;
    }
    
    public HabilidadesTiro(boolean anotacoes) {
        this();
        
        if (anotacoes){
            this.tiroArco = 0;
            this.tiroPistola = 0;
            this.tiroArmaPesada = 0;
            this.tiroLancaChamas = 0;
            this.tiroMetralhadora = 0;
            this.tiroRifleEscopeta = 0;
            this.tiroSubmetralhadora = 0;   

            this.arremesso = 0;
        }
    }
    
    //GETTERS E SETTER

    public short getTiroArco() {
        return tiroArco;
    }

    public void setTiroArco(short tiroArco) {
        this.tiroArco = tiroArco;
    }

    public short getTiroPistola() {
        return tiroPistola;
    }

    public void setTiroPistola(short tiroPistola) {
        this.tiroPistola = tiroPistola;
    }

    public short getTiroArmaPesada() {
        return tiroArmaPesada;
    }

    public void setTiroArmaPesada(short tiroArmaPesada) {
        this.tiroArmaPesada = tiroArmaPesada;
    }

    public short getTiroLancaChamas() {
        return tiroLancaChamas;
    }

    public void setTiroLancaChamas(short tiroLancaChamas) {
        this.tiroLancaChamas = tiroLancaChamas;
    }

    public short getTiroMetralhadora() {
        return tiroMetralhadora;
    }

    public void setTiroMetralhadora(short tiroMetralhadora) {
        this.tiroMetralhadora = tiroMetralhadora;
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
