package ElementosDeJogo.Personagens.Habilidades;

public class FolhaDeHabilidades{
    
    //ATRIBUTOS
    
    private short mitosDeCthulhu;
    
    private short usoDeComputadores;
    private short reparoEletrico;
    private short eletronica;
    private short deteccao;
    
    private HabilidadesCiencia ciencia;
    private HabilidadesInterpessoais interpessoais;
    private HabilidadesLuta luta;
    private HabilidadesTiro tiro;
        
    //CONSTRUTORES
    
    public FolhaDeHabilidades() {        
        this.mitosDeCthulhu = 0;
        
        this.usoDeComputadores = 5;
        this.reparoEletrico = 10;
        this.eletronica = 1;
        this.deteccao = 25;   
        
        this.ciencia = new HabilidadesCiencia();
        this.interpessoais = new HabilidadesInterpessoais();
        this.luta = new HabilidadesLuta();
        this.tiro = new HabilidadesTiro();
    }

    public FolhaDeHabilidades(short destreza) {        
        this.mitosDeCthulhu = 0;
        
        this.usoDeComputadores = 5;
        this.reparoEletrico = 10;
        this.eletronica = 1;
        this.deteccao = 25;   
        
        this.ciencia = new HabilidadesCiencia();
        this.interpessoais = new HabilidadesInterpessoais();
        this.luta = new HabilidadesLuta(destreza);
        this.tiro = new HabilidadesTiro();
    }
    
    //GETTERS E SETTERS

    public short getMitosDeCthulhu() {
        return mitosDeCthulhu;
    }

    public void setMitosDeCthulhu(short mitosDeCthulhu) {
        this.mitosDeCthulhu = mitosDeCthulhu;
    }

    public short getUsoDeComputadores() {
        return usoDeComputadores;
    }

    public void setUsoDeComputadores(short usoDeComputadores) {
        this.usoDeComputadores = usoDeComputadores;
    }

    public short getReparoEletrico() {
        return reparoEletrico;
    }

    public void setReparoEletrico(short reparoEletrico) {
        this.reparoEletrico = reparoEletrico;
    }

    public short getEletronica() {
        return eletronica;
    }

    public void setEletronica(short eletronica) {
        this.eletronica = eletronica;
    }

    public short getDeteccao() {
        return deteccao;
    }

    public void setDeteccao(short deteccao) {
        this.deteccao = deteccao;
    }

    public HabilidadesCiencia getCiencia() {
        return ciencia;
    }

    public void setCiencia(HabilidadesCiencia ciencia) {
        this.ciencia = ciencia;
    }

    public HabilidadesInterpessoais getInterpessoais() {
        return interpessoais;
    }

    public void setInterpessoais(HabilidadesInterpessoais interpessoais) {
        this.interpessoais = interpessoais;
    }

    public HabilidadesLuta getLuta() {
        return luta;
    }

    public void setLuta(HabilidadesLuta luta) {
        this.luta = luta;
    }

    public HabilidadesTiro getTiro() {
        return tiro;
    }

    public void setTiro(HabilidadesTiro tiro) {
        this.tiro = tiro;
    }
        
}
