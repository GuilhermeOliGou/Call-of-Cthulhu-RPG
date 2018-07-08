package RegrasDeNegocio;

import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Jogador;

public class TesteCaracteristicas {
    
    //ATRIBUTOS
    
    private final Dados DADOS;
    
    private Jogador jogador;
    
    //CONSTRUTORES

    public TesteCaracteristicas() {
        super();
        
        this.DADOS = new Dados();
    }

    public TesteCaracteristicas(Jogador jogador) {
        super();
        
        this.DADOS = new Dados();
        
        this.jogador = jogador;
    }
    
    //FUNÇÕES AUXILIARES
    
    private boolean RolamentoDeCaracteristicas(int possui, int necessita){
        if(necessita <= 0)
            return true;
        return (this.DADOS.TesteDePorcentagem() < (possui-necessita));
    }
    
    //FUNÇÕES
    
    public boolean TestaCaracteristicas(EventoAvancado evento){
        FolhaDeCaracteristicas possui = this.jogador.getAtributos().getCaracteristicas();
        FolhaDeCaracteristicas necessita = evento.getCaracterísticasNecessarias();
        
        return(RolamentoDeCaracteristicas(possui.getForca(),necessita.getForca())&&
                RolamentoDeCaracteristicas(possui.getConstituicao(), necessita.getConstituicao())&&
                RolamentoDeCaracteristicas(possui.getTamanho(), necessita.getTamanho())&&
                RolamentoDeCaracteristicas(possui.getDestreza(), necessita.getDestreza())&&
                RolamentoDeCaracteristicas(possui.getPoder(), necessita.getPoder())
                );
    }
    
}
