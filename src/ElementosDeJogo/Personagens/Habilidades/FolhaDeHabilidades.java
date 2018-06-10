package ElementosDeJogo.Personagens.Habilidades;

import RegrasDeNegocio.RegraNegocioException;
import utilidades.Log;

public class FolhaDeHabilidades{
    
    //ATRIBUTOS
    
    private final boolean FOLHAPADRAOEMBRANCO = true;    
    private final short DESTREZAPADRAO = 40;
    
    private short mitosDeCthulhu;
    
    private short usoDeComputadores;
    private short reparoEletrico;
    private short eletronica;
    private short deteccao;
    
    private HabilidadesCiencia ciencia;
    private HabilidadesInterpessoais interpessoais;
    private HabilidadesTiro tiro;
    private HabilidadesLuta luta;
        
    //CONSTRUTORES
    
    public FolhaDeHabilidades() {    
        super();
        
        this.mitosDeCthulhu = 0;
        
        this.usoDeComputadores = 0;
        this.reparoEletrico = 0;
        this.eletronica = 0;
        this.deteccao = 0;   
        
        this.ciencia = new HabilidadesCiencia(FOLHAPADRAOEMBRANCO);
        this.interpessoais = new HabilidadesInterpessoais(FOLHAPADRAOEMBRANCO);
        this.luta = new HabilidadesLuta();
        this.tiro = new HabilidadesTiro(FOLHAPADRAOEMBRANCO);
    }

    public FolhaDeHabilidades(short destreza) throws RegraNegocioException { 
        super();
        
        this.mitosDeCthulhu = 0;
        
        this.usoDeComputadores = 5;
        this.reparoEletrico = 10;
        this.eletronica = 1;
        this.deteccao = 25;   
        
        this.ciencia = new HabilidadesCiencia();
        this.interpessoais = new HabilidadesInterpessoais();
        this.tiro = new HabilidadesTiro();
        
        try{
            this.luta = new HabilidadesLuta(destreza);
        }catch(NullPointerException e){
            Log.gravaLog(e);
            this.luta = new HabilidadesLuta(DESTREZAPADRAO);
            throw new RegraNegocioException("FOLHA DE CARACTERÍSTICAS NÃO INICIALIZADA!!");
        }
    }

    public FolhaDeHabilidades(short mitosDeCthulhu, 
            short usoDeComputadores, short reparoEletrico, short eletronica, short deteccao, 
            HabilidadesCiencia ciencia, HabilidadesInterpessoais interpessoais, 
            HabilidadesTiro tiro, HabilidadesLuta luta) {
        super();
        
        this.mitosDeCthulhu = mitosDeCthulhu;
        
        this.usoDeComputadores = usoDeComputadores;
        this.reparoEletrico = reparoEletrico;
        this.eletronica = eletronica;
        this.deteccao = deteccao;
        
        this.ciencia = ciencia;
        this.interpessoais = interpessoais;
        this.tiro = tiro;
        this.luta = luta;
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

    public HabilidadesTiro getTiro() {
        return tiro;
    }

    public void setTiro(HabilidadesTiro tiro) {
        this.tiro = tiro;
    }

    public HabilidadesLuta getLuta() {
        return luta;
    }

    public void setLuta(HabilidadesLuta luta) {
        this.luta = luta;
    }
        
}