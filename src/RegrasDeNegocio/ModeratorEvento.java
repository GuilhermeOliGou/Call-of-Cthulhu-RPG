package RegrasDeNegocio;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;

public class ModeratorEvento {
    
    //ATRIBUTOS
      
    private Evento evento;    
    
    private final VerificadorAtributos VERIFICADORATRIBUTOS;
    private final VerificadorHabilidades VERIFICADORHABILIDADES;
    private final VerificadorItens VERIFICADORITENS;
    
    //CONSTRUTORES

    public ModeratorEvento() {
        super();
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos();
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades();
        this.VERIFICADORITENS = new VerificadorItens();
    } 

    public ModeratorEvento(IntermediarioBaseDados baseDados, Jogador jogador, Evento evento, 
            String resposta, int[] quantidadeItens) {
        super();
        this.evento = evento;
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos(jogador, resposta);
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades(jogador, resposta);
        this.VERIFICADORITENS = new VerificadorItens(jogador, resposta, quantidadeItens, baseDados);
    }

    public ModeratorEvento(int INVENTARIOMAXIMO, int RETORNOMAXIMO,
            IntermediarioBaseDados baseDados, Jogador jogador, Evento evento, 
            String resposta, int[] quantidadeItens) {
        super();
        
        
        this.evento = evento;
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos(jogador, resposta);
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades(jogador, resposta);
        this.VERIFICADORITENS = new VerificadorItens(INVENTARIOMAXIMO, RETORNOMAXIMO, 
                jogador, resposta, quantidadeItens, baseDados);
    }    
    
    //FUNÇÕES
    
    public void ExecutaEvento(){
        if (this.evento instanceof EventoAvancado){
            
        }else{
            String descricaoEvento = this.evento.getDescricao();
            if (descricaoEvento != null){
                this.resposta += descricaoEvento;
            }
            Resposta respostasEvento = this.evento.getRespostaDoEvento();
            if (respostasEvento != null){
                
                FolhaDeAtributos atributosAlterados = respostasEvento.getAtributosAlterados();
                this.VERIFICADORATRIBUTOS.ChecaAtributosAlterados(atributosAlterados);
                
                this.VERIFICADORITENS.ChecaItens(respostasEvento);
                
                FolhaDeHabilidades habilidadesAlteradas = respostasEvento.getHabilidadesAlteradas();
                this.VERIFICADORHABILIDADES.ChecaHabilidadesAlterados(habilidadesAlteradas);
                
                short sanidadeAlterada = respostasEvento.getSanidadeAtualAlterada();
                this.jogador.setSanidadeAtual((short)(this.jogador.getSanidadeAtual() + sanidadeAlterada));
                EscreveAlteraçãoDePontos(sanidadeAlterada, "Sanidade");
            }
        }
        
        this.jogador.setLocalidadeAtual(this.evento.getLocalDeRetorno());
    }
    
}
