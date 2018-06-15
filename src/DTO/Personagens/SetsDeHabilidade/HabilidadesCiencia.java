package DTO.Personagens.SetsDeHabilidade;

public class HabilidadesCiencia {
    
    //ATRIBUTOS
        
    private short cienciaAstronomia;
    private short cienciaBiologia;
    private short cienciaBotanica;
    private short cienciaCriptografia;
    private short cienciaEngenharia;
    private short cienciaFarmacia;
    private short cienciaFisica;
    private short cienciaForense;
    private short cienciaGeologia;
    private short cienciaMatematica;
    private short cienciaMetereologia;
    private short cienciaQuimica;
    private short cienciaZoologia;
    
    //CONSTRUTORES
    
    public HabilidadesCiencia() {
        super();
        
        this.cienciaAstronomia = 1;
        this.cienciaBiologia = 1;
        this.cienciaBotanica = 1;
        this.cienciaCriptografia = 1;
        this.cienciaEngenharia = 1;
        this.cienciaFarmacia = 1;
        this.cienciaFisica = 1;
        this.cienciaForense = 1;
        this.cienciaGeologia = 1;
        this.cienciaMatematica = 10;
        this.cienciaMetereologia = 1;
        this.cienciaQuimica = 1;
        this.cienciaZoologia = 1;        
    }

    public HabilidadesCiencia(boolean anotacoes) {
        this();
        
        if (anotacoes){
            this.cienciaAstronomia = 0;
            this.cienciaBiologia = 0;
            this.cienciaBotanica = 0;
            this.cienciaCriptografia = 0;
            this.cienciaEngenharia = 0;
            this.cienciaFarmacia = 0;
            this.cienciaFisica = 0;
            this.cienciaForense = 0;
            this.cienciaGeologia = 0;
            this.cienciaMatematica = 0;
            this.cienciaMetereologia = 0;
            this.cienciaQuimica = 0;
            this.cienciaZoologia = 0; 
        }
    }

    public HabilidadesCiencia(short cienciaAstronomia, short cienciaBiologia, 
            short cienciaBotanica, short cienciaCriptografia, short cienciaEngenharia, 
            short cienciaFarmacia, short cienciaFisica, short cienciaForense, 
            short cienciaGeologia, short cienciaMatematica, short cienciaMetereologia, 
            short cienciaQuimica, short cienciaZoologia) {
        super();
        
        this.cienciaAstronomia = cienciaAstronomia;
        this.cienciaBiologia = cienciaBiologia;
        this.cienciaBotanica = cienciaBotanica;
        this.cienciaCriptografia = cienciaCriptografia;
        this.cienciaEngenharia = cienciaEngenharia;
        this.cienciaFarmacia = cienciaFarmacia;
        this.cienciaFisica = cienciaFisica;
        this.cienciaForense = cienciaForense;
        this.cienciaGeologia = cienciaGeologia;
        this.cienciaMatematica = cienciaMatematica;
        this.cienciaMetereologia = cienciaMetereologia;
        this.cienciaQuimica = cienciaQuimica;
        this.cienciaZoologia = cienciaZoologia;
    }
    
    //GETTERS E SETTERS

    public short getCienciaAstronomia() {
        return cienciaAstronomia;
    }

    public void setCienciaAstronomia(short cienciaAstronomia) {
        this.cienciaAstronomia = cienciaAstronomia;
    }

    public short getCienciaBiologia() {
        return cienciaBiologia;
    }

    public void setCienciaBiologia(short cienciaBiologia) {
        this.cienciaBiologia = cienciaBiologia;
    }

    public short getCienciaBotanica() {
        return cienciaBotanica;
    }

    public void setCienciaBotanica(short cienciaBotanica) {
        this.cienciaBotanica = cienciaBotanica;
    }

    public short getCienciaCriptografia() {
        return cienciaCriptografia;
    }

    public void setCienciaCriptografia(short cienciaCriptografia) {
        this.cienciaCriptografia = cienciaCriptografia;
    }

    public short getCienciaEngenharia() {
        return cienciaEngenharia;
    }

    public void setCienciaEngenharia(short cienciaEngenharia) {
        this.cienciaEngenharia = cienciaEngenharia;
    }

    public short getCienciaFarmacia() {
        return cienciaFarmacia;
    }

    public void setCienciaFarmacia(short cienciaFarmacia) {
        this.cienciaFarmacia = cienciaFarmacia;
    }

    public short getCienciaFisica() {
        return cienciaFisica;
    }

    public void setCienciaFisica(short cienciaFisica) {
        this.cienciaFisica = cienciaFisica;
    }

    public short getCienciaForense() {
        return cienciaForense;
    }

    public void setCienciaForense(short cienciaForense) {
        this.cienciaForense = cienciaForense;
    }

    public short getCienciaGeologia() {
        return cienciaGeologia;
    }

    public void setCienciaGeologia(short cienciaGeologia) {
        this.cienciaGeologia = cienciaGeologia;
    }

    public short getCienciaMatematica() {
        return cienciaMatematica;
    }

    public void setCienciaMatematica(short cienciaMatematica) {
        this.cienciaMatematica = cienciaMatematica;
    }

    public short getCienciaMetereologia() {
        return cienciaMetereologia;
    }

    public void setCienciaMetereologia(short cienciaMetereologia) {
        this.cienciaMetereologia = cienciaMetereologia;
    }

    public short getCienciaQuimica() {
        return cienciaQuimica;
    }

    public void setCienciaQuimica(short cienciaQuimica) {
        this.cienciaQuimica = cienciaQuimica;
    }

    public short getCienciaZoologia() {
        return cienciaZoologia;
    }

    public void setCienciaZoologia(short cienciaZoologia) {
        this.cienciaZoologia = cienciaZoologia;
    }
    
}
