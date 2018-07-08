package Elementos;


public enum Medo {
    NORMAL(0), DESCONFIADO(1),ASSUSTADO(2),APAVORADO(3);
    
    private final int tipo;
    
    private Medo(int tipo){
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return this.tipo;
    }
}
