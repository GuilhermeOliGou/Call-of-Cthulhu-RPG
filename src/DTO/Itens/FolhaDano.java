package DTO.Itens;

public class FolhaDano {
    
    //ATRIBUTOS
    
    private short[] rolagens;
    
    private short adicional;
    
    private boolean atordoamento;
    
    //CONSTRUTORES

    public FolhaDano() {
        super();
        
        this.adicional = 0;
        
        this.atordoamento = false;
    }

    public FolhaDano(short[] rolagens, 
            short adicional, 
            boolean atordoamento, boolean fogo) {
        super();
        
        this.rolagens = rolagens;
        
        this.adicional = adicional;
        
        this.atordoamento = atordoamento;
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
    

    public boolean isAtordoamento() {
        return atordoamento;
    }

    public void setAtordoamento(boolean atordoamento) {
        this.atordoamento = atordoamento;
    } 
}
