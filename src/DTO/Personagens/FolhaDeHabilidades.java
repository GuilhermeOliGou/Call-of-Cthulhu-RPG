package DTO.Personagens;

public class FolhaDeHabilidades {
             
    //ATRIBUTOS
    
    protected short mitosDeCthulhu;
    
    //CONSTRUTORES

    public FolhaDeHabilidades() {
        super();
        
        this.mitosDeCthulhu = 0;
    }

    public FolhaDeHabilidades(short mitosDeCthulhu) {
        super();
        
        this.mitosDeCthulhu = mitosDeCthulhu;
    }
    
    //GETTERS E SETTERS

    public short getMitosDeCthulhu() {
        return mitosDeCthulhu;
    }

    public void setMitosDeCthulhu(short mitosDeCthulhu) {
        this.mitosDeCthulhu = mitosDeCthulhu;
    }
    
}
