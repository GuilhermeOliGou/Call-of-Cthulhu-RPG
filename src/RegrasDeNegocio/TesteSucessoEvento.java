package RegrasDeNegocio;

import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.Jogador;

public class TesteSucessoEvento {
    
    //ATRIBUTOS
    
    private final TesteItem ITEM;
    private final TesteCaracteristicas CARACTERISTICAS;
    private final TesteHabilidades HABILIDADES;
    
    private Jogador jogador;
    
    //CONSTRUTORES

    public TesteSucessoEvento() {
        super();
        
        this.ITEM = new TesteItem();
        this.CARACTERISTICAS = new TesteCaracteristicas();
        this.HABILIDADES = new TesteHabilidades();
    }

    public TesteSucessoEvento(Jogador jogador) {
        super();
        
        this.ITEM = new TesteItem(jogador);
        this.CARACTERISTICAS = new TesteCaracteristicas(jogador);
        this.HABILIDADES = new TesteHabilidades();
        
        this.jogador = jogador;
    }
    
    //FUNÇÕES AUXILIARES
    
    //FUNÇÕES
    
    public boolean TestaSucesso(EventoAvancado evento){
        return (this.ITEM.TestaItens(evento) &&
                this.CARACTERISTICAS.TestaCaracteristicas(evento)&&
                this.HABILIDADES.TestaHabilidades(evento)
                );
    }
    
}
