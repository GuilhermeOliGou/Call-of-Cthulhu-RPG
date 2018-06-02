package ElementosDeJogo.Personagens.Habilidades;

public class HabilidadesLuta {
    
    //ATRIBUTOS
    
    private short esquiva;
    
    private short lutaMachado;
    private short lutaLivre;
    private short lutaSerraEletrica;
    private short lutaMangual;
    private short lutaGarrote;
    private short lutaLanca;
    private short lutaEspada;
    private short lutaChicote;
        
    //CONSTRUTORES

    public HabilidadesLuta() {
        super();
        
        this.esquiva = 25;
        
        this.lutaMachado = 15;
        this.lutaLivre = 25;
        this.lutaSerraEletrica = 10;
        this.lutaMangual = 10;
        this.lutaGarrote = 15;
        this.lutaLanca = 20;
        this.lutaEspada = 20;
        this.lutaChicote = 5;
    }

    public HabilidadesLuta(short destreza) {
        super();
        
        this.esquiva = (short)(destreza/2);
        
        this.lutaMachado = 15;
        this.lutaLivre = 25;
        this.lutaSerraEletrica = 10;
        this.lutaMangual = 10;
        this.lutaGarrote = 15;
        this.lutaLanca = 20;
        this.lutaEspada = 20;
        this.lutaChicote = 5;
    }
    
    //GETTERS E SETTERS

    public short getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(short esquiva) {
        this.esquiva = esquiva;
    }

    public short getLutaMachado() {
        return lutaMachado;
    }

    public void setLutaMachado(short lutaMachado) {
        this.lutaMachado = lutaMachado;
    }

    public short getLutaLivre() {
        return lutaLivre;
    }

    public void setLutaLivre(short lutaLivre) {
        this.lutaLivre = lutaLivre;
    }

    public short getLutaSerraEletrica() {
        return lutaSerraEletrica;
    }

    public void setLutaSerraEletrica(short lutaSerraEletrica) {
        this.lutaSerraEletrica = lutaSerraEletrica;
    }

    public short getLutaMangual() {
        return lutaMangual;
    }

    public void setLutaMangual(short lutaMangual) {
        this.lutaMangual = lutaMangual;
    }

    public short getLutaGarrote() {
        return lutaGarrote;
    }

    public void setLutaGarrote(short lutaGarrote) {
        this.lutaGarrote = lutaGarrote;
    }

    public short getLutaLanca() {
        return lutaLanca;
    }

    public void setLutaLanca(short lutaLanca) {
        this.lutaLanca = lutaLanca;
    }

    public short getLutaEspada() {
        return lutaEspada;
    }

    public void setLutaEspada(short lutaEspada) {
        this.lutaEspada = lutaEspada;
    }

    public short getLutaChicote() {
        return lutaChicote;
    }

    public void setLutaChicote(short lutaChicote) {
        this.lutaChicote = lutaChicote;
    }
    
}
