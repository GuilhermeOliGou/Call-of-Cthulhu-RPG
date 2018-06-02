package ElementosDeJogo.Itens;

public class FolhaDano {
    
    //ATRIBUTOS
    
    private short[] rolagens;
    
    private short adicional;
    private short distanciaMod;
    
    private boolean atordoamento;
    private boolean fogo;
    
    //CONSTRUTORES

    public FolhaDano() {
        super();
    }

    public FolhaDano(short[] rolagens, 
            short adicional, short distanciaMod, 
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

    public short getDistanciaMod() {
        return distanciaMod;
    }

    public void setDistanciaMod(short distanciaMod) {
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
