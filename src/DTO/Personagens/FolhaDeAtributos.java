package DTO.Personagens;

public class FolhaDeAtributos{
    
    //ATRIBUTOS
    
    private FolhaDeCaracteristicas caracteristicas;
    
    private short maxHp;
    private short maxMp;
    private short hpAtual;
    private short mpAtual;
    private short movimento;
    private short bonusDeDanoCorporal;
    private short build;
    
    //CONSTRUTORES

    public FolhaDeAtributos() {
        super();
        
        this.caracteristicas = new FolhaDeCaracteristicas();
        
        this.maxHp = 0;
        this.maxMp = 0;
        this.hpAtual = 0;
        this.mpAtual = 0;
        this.movimento = 0;
        this.bonusDeDanoCorporal = 0;
        this.build = 0;
    }
    
    public FolhaDeAtributos(FolhaDeCaracteristicas caracteristicas, 
            short maxHp, short maxMp, short hpAtual, short mpAtual, 
            short movimento, short bonusDeDanoCorporal, short build) {
        super();
        
        this.caracteristicas = caracteristicas;
        
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.hpAtual = hpAtual;
        this.mpAtual = mpAtual;
        this.movimento = movimento;
        this.bonusDeDanoCorporal = bonusDeDanoCorporal;
        this.build = build;
    }

    //GETTERS E SETTERS

    public FolhaDeCaracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(FolhaDeCaracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    
    
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
    
}
