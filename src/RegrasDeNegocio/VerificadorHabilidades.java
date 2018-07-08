package RegrasDeNegocio;

import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.SetsDeHabilidade.*;

public class VerificadorHabilidades {
    
    //ATRIBUTOS
    
    private Jogador jogador;
    private String resposta;
    private boolean alterouHabilidades;
    
    //CONSTRUTORES

    public VerificadorHabilidades() {
        super();
    }  

    public VerificadorHabilidades(Jogador jogador, String resposta) {
        this.jogador = jogador;
        this.resposta = resposta;
        this.alterouHabilidades = false;
    }    
    
    //FUNÇÕES AUXILIARES
    
    private void EscreveAlteraçãoHabilidades(int habilidadeAlterada){
        if (this.alterouHabilidades && habilidadeAlterada > 0)
            this.resposta += " O dom da sabedoria cresceu em você!";
    }
    
    private void ChecaSetHabilidadeLuta(HabilidadesLuta habilidadesAlteradas){
        short esquiva = habilidadesAlteradas.getEsquiva();
        this.jogador.getHabilidades().getLuta().setEsquiva(
                (short)(this.jogador.getHabilidades().getLuta().getEsquiva()+esquiva)
        );
        EscreveAlteraçãoHabilidades(esquiva);
        
        short machado = habilidadesAlteradas.getLutaMachado();
        this.jogador.getHabilidades().getLuta().setLutaMachado(
                (short)(this.jogador.getHabilidades().getLuta().getLutaMachado()+machado)
        );
        EscreveAlteraçãoHabilidades(machado);
        
        short livre = habilidadesAlteradas.getLutaLivre();
        this.jogador.getHabilidades().getLuta().setLutaLivre(
                (short)(this.jogador.getHabilidades().getLuta().getLutaLivre()+livre)
        );
        EscreveAlteraçãoHabilidades(livre);
        
        short lanca = habilidadesAlteradas.getLutaLanca();
        this.jogador.getHabilidades().getLuta().setLutaLanca(
                (short)(this.jogador.getHabilidades().getLuta().getLutaLanca()+lanca)
        );
        EscreveAlteraçãoHabilidades(lanca);
        
        short espada = habilidadesAlteradas.getLutaEspada();
        this.jogador.getHabilidades().getLuta().setLutaEspada(
                (short)(this.jogador.getHabilidades().getLuta().getLutaEspada()+espada)
        );
        EscreveAlteraçãoHabilidades(espada);
        
        short chicote = habilidadesAlteradas.getLutaChicote();
        this.jogador.getHabilidades().getLuta().setLutaChicote(
                (short)(this.jogador.getHabilidades().getLuta().getLutaChicote()+chicote)
        );
        EscreveAlteraçãoHabilidades(chicote);
    }
    
    private void ChecaSetHabilidadeTiro(HabilidadesTiro habilidadesAlteradas){
        short pistola = habilidadesAlteradas.getTiroPistola();
        this.jogador.getHabilidades().getTiro().setTiroPistola(
                (short)(this.jogador.getHabilidades().getTiro().getTiroPistola()+pistola)
        );
        EscreveAlteraçãoHabilidades(pistola);
        
        short rifleEscopeta = habilidadesAlteradas.getTiroRifleEscopeta();
        this.jogador.getHabilidades().getTiro().setTiroRifleEscopeta(
                (short)(this.jogador.getHabilidades().getTiro().getTiroRifleEscopeta()+rifleEscopeta)
        );
        EscreveAlteraçãoHabilidades(rifleEscopeta);
        
        short submetralhadora = habilidadesAlteradas.getTiroSubmetralhadora();
        this.jogador.getHabilidades().getTiro().setTiroSubmetralhadora(
                (short)(this.jogador.getHabilidades().getTiro().getTiroSubmetralhadora()+submetralhadora)
        );
        EscreveAlteraçãoHabilidades(submetralhadora);
        
        short arremesso = habilidadesAlteradas.getArremesso();
        this.jogador.getHabilidades().getTiro().setArremesso(
                (short)(this.jogador.getHabilidades().getTiro().getArremesso()+arremesso)
        );
        EscreveAlteraçãoHabilidades(arremesso);
    }
    
    //FUNÇÕES
    
    public void ChecaHabilidadesAlterados(FolhaDeHabilidades habilidadesAlteradas){
        short mitos = habilidadesAlteradas.getMitosDeCthulhu();
        EscreveAlteraçãoHabilidades(mitos);
        
        ChecaSetHabilidadeLuta(habilidadesAlteradas.getLuta());
        
        ChecaSetHabilidadeTiro(habilidadesAlteradas.getTiro());       
    }
    
}
