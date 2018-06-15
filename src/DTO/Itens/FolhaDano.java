package DTO.Itens;

public class FolhaDano {
    
    //ATRIBUTOS
    
    private short[] rolagens;
    
    private short adicional;
    
    private boolean distanciaMod;
    
    private boolean atordoamento;
    private boolean fogo;
    
    //CONSTRUTORES

    public FolhaDano() {
        super();
        
        this.adicional = 0;
        
        this.distanciaMod = false;
        
        this.atordoamento = false;
        this.fogo = false;
    }

    public FolhaDano(short[] rolagens, 
            short adicional, 
            boolean distanciaMod, 
            boolean atordoamento, boolean fogo) {
        super();
        
        this.rolagens = rolagens;
        
        this.adicional = adicional;
        
        this.distanciaMod = distanciaMod;
        
        this.atordoamento = atordoamento;
        this.fogo = fogo;
    }
    
    //GETTERS E SETTERS

    public short[] getRolagens() {
        return rolagens;
    }

    public void setRolagens(short[] rolagens) {
        this.rolagens = rolagens;
    }
    
    

    public short getAdicional() {
        return adicional;
    }

    public void setAdicional(short adicional) {
        this.adicional = adicional;
    }
    
    

    public boolean isDistanciaMod() {
        return distanciaMod;
    }

    public void setDistanciaMod(boolean distanciaMod) {
        this.distanciaMod = distanciaMod;
    }
    
    

    public boolean isAtordoamento() {
        return atordoamento;
    }

    public void setAtordoamento(boolean atordoamento) {
        this.atordoamento = atordoamento;
    }

    public boolean isFogo() {
        return fogo;
    }

    public void setFogo(boolean fogo) {
        this.fogo = fogo;
    }
    
}
