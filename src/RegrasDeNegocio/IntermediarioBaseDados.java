package RegrasDeNegocio;

import BaseDados.FacadeImplementada;

public class IntermediarioBaseDados {

    //ATRIBUTOS
    
    private FacadeBaseDados baseDados;
    
    
    
    //CONSTRUTORES

    public IntermediarioBaseDados() {
        super();
        
        this.baseDados = new FacadeImplementada();
    }    
    
    //FUNÇÕES
    
}
