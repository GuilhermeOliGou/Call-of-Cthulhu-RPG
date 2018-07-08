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
        HabilidadesLuta luta = jogador.getHabilidades().getLuta();
        
        short esquiva = habilidadesAlteradas.getEsquiva();
        luta.setEsquiva((short)(luta.getEsquiva()+esquiva));
        EscreveAlteraçãoHabilidades(esquiva);
        
        short machado = habilidadesAlteradas.getLutaMachado();
        luta.setLutaMachado((short)(luta.getLutaMachado()+machado));
        EscreveAlteraçãoHabilidades(machado);
        
        short livre = habilidadesAlteradas.getLutaLivre();
        luta.setLutaLivre((short)(luta.getLutaLivre()+livre));
        EscreveAlteraçãoHabilidades(livre);
        
        short lanca = habilidadesAlteradas.getLutaLanca();
        luta.setLutaLanca((short)(luta.getLutaLanca()+lanca));
        EscreveAlteraçãoHabilidades(lanca);
        
        short espada = habilidadesAlteradas.getLutaEspada();
        luta.setLutaEspada((short)(luta.getLutaEspada()+espada));
        EscreveAlteraçãoHabilidades(espada);
        
        short chicote = habilidadesAlteradas.getLutaChicote();
        luta.setLutaChicote((short)(luta.getLutaChicote()+chicote));
        EscreveAlteraçãoHabilidades(chicote);
    }
    
    private void ChecaSetHabilidadeTiro(HabilidadesTiro habilidadesAlteradas){
        HabilidadesTiro tiro = jogador.getHabilidades().getTiro();
        
        short pistola = habilidadesAlteradas.getTiroPistola();
        tiro.setTiroPistola((short)(tiro.getTiroPistola()+pistola));
        EscreveAlteraçãoHabilidades(pistola);
        
        short rifleEscopeta = habilidadesAlteradas.getTiroRifleEscopeta();
        tiro.setTiroRifleEscopeta((short)(tiro.getTiroRifleEscopeta()+rifleEscopeta));
        EscreveAlteraçãoHabilidades(rifleEscopeta);
        
        short submetralhadora = habilidadesAlteradas.getTiroSubmetralhadora();
        tiro.setTiroSubmetralhadora((short)(tiro.getTiroSubmetralhadora()+submetralhadora));
        EscreveAlteraçãoHabilidades(submetralhadora);
        
        short arremesso = habilidadesAlteradas.getArremesso();
        tiro.setArremesso((short)(tiro.getArremesso()+arremesso));
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
