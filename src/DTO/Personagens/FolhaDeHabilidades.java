package DTO.Personagens;

import DTO.Personagens.SetsDeHabilidade.*;

public class FolhaDeHabilidades {
             
    //ATRIBUTOS
    
    private short mitosDeCthulhu;
    
    private HabilidadesLuta luta;
    private HabilidadesTiro tiro;
    
    //CONSTRUTORES

    public FolhaDeHabilidades() {
        super();
        
        this.mitosDeCthulhu = 0;
    }
    
    public FolhaDeHabilidades(short destreza) {
        super();
        
        this.mitosDeCthulhu = 0;
        
        luta = new HabilidadesLuta(destreza);
        tiro = new HabilidadesTiro();
    }

    public FolhaDeHabilidades(short mitosDeCthulhu, HabilidadesLuta luta, HabilidadesTiro tiro) {
        super();
        
        this.mitosDeCthulhu = mitosDeCthulhu;
        
        this.luta = luta;
        this.tiro = tiro;
    }
    
    //GETTERS E SETTERS

    public short getMitosDeCthulhu() {
        return mitosDeCthulhu;
    }

    public void setMitosDeCthulhu(short mitosDeCthulhu) {
        this.mitosDeCthulhu = mitosDeCthulhu;
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
