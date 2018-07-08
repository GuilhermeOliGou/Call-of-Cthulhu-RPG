package RegrasDeNegocio;

import DTO.ElementosDeSistema.EventoAvancado;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import Utilidades.Log;

public class TesteHabilidades {
    
    //ATRIBUTOS
    
    private final Dados DADOS;
    
    private Jogador jogador;
    private boolean sucessoAbsoluto;
    
    //CONSTRUTORES

    public TesteHabilidades() {
        super();
        
        this.DADOS = new Dados();
    }

    public TesteHabilidades(Jogador jogador) {
        super();
        
        this.DADOS = new Dados();
        
        this.jogador = jogador;
        this.sucessoAbsoluto = true;
    }
    
    //FUNÇÕES AUXILIARES
    
    private FolhaDeHabilidades InstanciaFolha(EventoAvancado evento){
        try{
            return evento.getHabilidadesNecessarias();
        }catch(NullPointerException e){
            Log.gravaLog(e);
            
            return new FolhaDeHabilidades();
        }
    }
    
    //Esse pequeno inteiro tem o objetivo de manter a organização do código
    //Para que o desenvolvedor tenha plena consciência do que se passa
    private int Melhoria(){
        if (this.DADOS.TesteDePorcentagem() < this.jogador.getSorte())
            return this.DADOS.D12();
        return this.DADOS.D10();
    }
    
    //Esse pequeno condicional tem o objetivo de manter a organização do código
    //Para que o desenvolvedor tenha plena consciência do que se passa
    private boolean MelhoraHabilidade(int possui){
        return (this.DADOS.TesteDePorcentagem() > possui);
    }
    
    private boolean RolamentoHabilidade(int possui, int dificuldade){
        if (dificuldade <= 0)
            return false;
        boolean sucesso = (this.DADOS.TesteDePorcentagem() < (int)(possui/dificuldade));
        this.sucessoAbsoluto = (this.sucessoAbsoluto && 
                sucesso);
        return sucesso && MelhoraHabilidade(possui);
    }
    
    private void TesteLuta(EventoAvancado evento){
        HabilidadesLuta possui = this.jogador.getHabilidades().getLuta();
        HabilidadesLuta dificuldade = evento.getHabilidadesNecessarias().getLuta();
        
        if(RolamentoHabilidade(possui.getEsquiva(), dificuldade.getEsquiva())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setEsquiva((short)(alteradas.getEsquiva()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getLutaMachado(), dificuldade.getLutaMachado())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setLutaMachado((short)(alteradas.getLutaMachado()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getLutaLivre(), dificuldade.getLutaLivre())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setLutaLivre((short)(alteradas.getLutaLivre()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getLutaLanca(), dificuldade.getLutaLanca())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setLutaLanca((short)(alteradas.getLutaLanca()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getLutaEspada(), dificuldade.getLutaEspada())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setLutaEspada((short)(alteradas.getLutaEspada()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getLutaChicote(), dificuldade.getLutaChicote())){
            HabilidadesLuta alteradas = InstanciaFolha(evento).getLuta();
            alteradas.setLutaChicote((short)(alteradas.getLutaChicote()+Melhoria()));
        }
    }
    
    private void TesteTiro(EventoAvancado evento){
        HabilidadesTiro possui = this.jogador.getHabilidades().getTiro();
        HabilidadesTiro dificuldade = evento.getHabilidadesNecessarias().getTiro();
        
        if(RolamentoHabilidade(possui.getTiroPistola(), dificuldade.getTiroPistola())){
            HabilidadesTiro alteradas = InstanciaFolha(evento).getTiro();
            alteradas.setTiroPistola((short)(alteradas.getTiroPistola()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getTiroRifleEscopeta(), dificuldade.getTiroRifleEscopeta())){
            HabilidadesTiro alteradas = InstanciaFolha(evento).getTiro();
            alteradas.setTiroRifleEscopeta((short)(alteradas.getTiroRifleEscopeta()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getTiroSubmetralhadora(), dificuldade.getTiroSubmetralhadora())){
            HabilidadesTiro alteradas = InstanciaFolha(evento).getTiro();
            alteradas.setTiroSubmetralhadora((short)(alteradas.getTiroSubmetralhadora()+Melhoria()));
        }
        
        if(RolamentoHabilidade(possui.getArremesso(), dificuldade.getArremesso())){
            HabilidadesTiro alteradas = InstanciaFolha(evento).getTiro();
            alteradas.setArremesso((short)(alteradas.getArremesso()+Melhoria()));
        }
    }
    
    //FUNÇÕES
    
    public boolean TestaHabilidades(EventoAvancado evento){
        FolhaDeHabilidades possui = this.jogador.getHabilidades();
        FolhaDeHabilidades dificuldade = evento.getHabilidadesNecessarias();
        
        if(RolamentoHabilidade(possui.getMitosDeCthulhu(), dificuldade.getMitosDeCthulhu())){
            FolhaDeHabilidades alteradas = InstanciaFolha(evento);
            alteradas.setMitosDeCthulhu((short)(alteradas.getMitosDeCthulhu()+Melhoria()));
        }
            
        TesteLuta(evento);     
        
        
        return this.sucessoAbsoluto;
    }
    
}
