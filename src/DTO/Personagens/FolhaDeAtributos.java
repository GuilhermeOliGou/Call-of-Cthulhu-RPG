package DTO.Personagens;

public class FolhaDeAtributos{
    
    //ATRIBUTOS
    
    private FolhaDeCaracteristicas caracteristicas;
    
    private short maxHp;
    private short maxMp;
    private short hpAtual;
    private short mpAtual;
    private short bonusDeDanoCorporal;
    
    //CONSTRUTORES

    public FolhaDeAtributos() {
        super();
        
        this.caracteristicas = new FolhaDeCaracteristicas();
        
        this.maxHp = 0;
        this.maxMp = 0;
        this.hpAtual = 0;
        this.mpAtual = 0;
        this.bonusDeDanoCorporal = 0;
    }
    
    public FolhaDeAtributos(FolhaDeCaracteristicas caracteristicas, 
            short maxHp, short maxMp,
            short hpAtual, short mpAtual, short bonusDeDanoCorporal) {
        super();
        
        this.caracteristicas = caracteristicas;
        
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.hpAtual = hpAtual;
        this.mpAtual = mpAtual;
        this.bonusDeDanoCorporal = bonusDeDanoCorporal;
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

    public short getBonusDeDanoCorporal() {
        return bonusDeDanoCorporal;
    }

    public final void setBonusDeDanoCorporal(short bonusDeDanoCorporal) {
        this.bonusDeDanoCorporal = bonusDeDanoCorporal;
    }
    
}
