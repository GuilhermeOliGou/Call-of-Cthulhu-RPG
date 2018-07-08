package RegrasDeNegocio;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.EventoLuta;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import Utilidades.Log;

public class ModeratorEventos {
    
    //ATRIBUTOS
    
    private final VerificadorAtributos VERIFICADORATRIBUTOS;
    private final VerificadorHabilidades VERIFICADORHABILIDADES;
    private final VerificadorItens VERIFICADORITENS;
    
    private final TesteSucessoEvento TESTE;
       
    private String resposta;
    private Jogador jogador;
    private boolean hasResposta = false;
    private boolean hasBatalha = false;
    
    //CONSTRUTORES

    public ModeratorEventos() {
        super();
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos();
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades();
        this.VERIFICADORITENS = new VerificadorItens();
        
        this.TESTE = new TesteSucessoEvento();
    } 

    public ModeratorEventos(IntermediarioBaseDados baseDados, Jogador jogador, 
            String resposta) {
        super();
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos(jogador, resposta);
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades(jogador, resposta);
        this.VERIFICADORITENS = new VerificadorItens(jogador, resposta, baseDados);
        
        this.TESTE = new TesteSucessoEvento(jogador);
        
        this.resposta = resposta;
        this.jogador = jogador;
    }

    public ModeratorEventos(int INVENTARIOMAXIMO, int RETORNOMAXIMO,
            IntermediarioBaseDados baseDados, Jogador jogador, 
            String resposta, int[] quantidadeItens) {
        super();
        
        this.VERIFICADORATRIBUTOS = new VerificadorAtributos(jogador, resposta);
        this.VERIFICADORHABILIDADES = new VerificadorHabilidades(jogador, resposta);
        this.VERIFICADORITENS = new VerificadorItens(INVENTARIOMAXIMO, RETORNOMAXIMO, 
                jogador, resposta, baseDados);
        
        this.TESTE = new TesteSucessoEvento(jogador);
        
        this.resposta = resposta;
        this.jogador = jogador;
    }    
    
    //FUNÇÕES
    
    public void ExecutaEvento(Evento evento){
        String descricaoEvento = evento.getDescricao();
        if (descricaoEvento != null){
            this.hasResposta = true;
            this.resposta += descricaoEvento;
        }
        
        if (evento instanceof EventoAvancado){
            if (!TESTE.TestaSucesso((EventoAvancado)evento)){
                resposta += ((EventoAvancado)evento).getDescricaoFalha();
                return;
            }
        }else if(evento instanceof EventoLuta){
            this.hasBatalha = true;
            return;
        }
        
        Resposta respostasEvento = evento.getRespostaDoEvento();
        if (respostasEvento != null){

            FolhaDeAtributos atributosAlterados = respostasEvento.getAtributosAlterados();
            this.VERIFICADORATRIBUTOS.ChecaAtributosAlterados(atributosAlterados);

            this.VERIFICADORITENS.ChecaItens(respostasEvento);

            FolhaDeHabilidades habilidadesAlteradas = respostasEvento.getHabilidadesAlteradas();
            this.VERIFICADORHABILIDADES.ChecaHabilidadesAlterados(habilidadesAlteradas);
            
            if(this.jogador.getSanidadeAtual() > this.jogador.getMaxSanidade()){
                respostasEvento.setSanidadeAtualAlterada(
                        (respostasEvento.getSanidadeAtualAlterada() + 
                        this.jogador.getSanidadeAtual() - 
                        this.jogador.getMaxSanidade()));
            }

            short sanidadeAlterada = respostasEvento.getSanidadeAtualAlterada();
            this.jogador.setSanidadeAtual((short)(this.jogador.getSanidadeAtual() + sanidadeAlterada));
            VERIFICADORATRIBUTOS.EscreveAlteraçãoDePontos(sanidadeAlterada, "Sanidade");            
        }
        if (evento.isEventoUnico())
            evento.setEventoValidoFalso();
        try{
            this.jogador.setLocalidadeAtual(evento.getLocalDeRetorno());
        }catch(NullPointerException e){
            Log.gravaLog(e);
        }
    }
    
    public void LeResposta(Evento evento){
        Resposta respostasEvento = evento.getRespostaDoEvento();
        if (respostasEvento != null){

            FolhaDeAtributos atributosAlterados = respostasEvento.getAtributosAlterados();
            this.VERIFICADORATRIBUTOS.ChecaAtributosAlterados(atributosAlterados);

            this.VERIFICADORITENS.ChecaItens(respostasEvento);

            FolhaDeHabilidades habilidadesAlteradas = respostasEvento.getHabilidadesAlteradas();
            this.VERIFICADORHABILIDADES.ChecaHabilidadesAlterados(habilidadesAlteradas);
            
            if(this.jogador.getSanidadeAtual() > this.jogador.getMaxSanidade()){
                respostasEvento.setSanidadeAtualAlterada(
                        (respostasEvento.getSanidadeAtualAlterada() + 
                        this.jogador.getSanidadeAtual() - 
                        this.jogador.getMaxSanidade()));
            }

            short sanidadeAlterada = respostasEvento.getSanidadeAtualAlterada();
            this.jogador.setSanidadeAtual((short)(this.jogador.getSanidadeAtual() + sanidadeAlterada));
            VERIFICADORATRIBUTOS.EscreveAlteraçãoDePontos(sanidadeAlterada, "Sanidade");            
        }
        if (evento.isEventoUnico())
            evento.setEventoValidoFalso();
        try{
            this.jogador.setLocalidadeAtual(evento.getLocalDeRetorno());
        }catch(NullPointerException e){
            Log.gravaLog(e);
        }
    }
    
    //GETTERS E SETTERS

    public boolean HasBatalha() {
        return hasBatalha;
    }

    public void setHasBatalha(boolean hasBatalha) {
        this.hasBatalha = hasBatalha;
    }

    public boolean HasResposta() {
        return hasResposta;
    }

    public void setHasResposta(boolean hasResposta) {
        this.hasResposta = hasResposta;
    }
    
}
