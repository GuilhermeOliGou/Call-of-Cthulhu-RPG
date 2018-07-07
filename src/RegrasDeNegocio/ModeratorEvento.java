package RegrasDeNegocio;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

public class ModeratorEvento {
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    
    private IntermediarioBaseDados baseDados;    
    private Jogador jogador;
    private Evento evento;
    
    private String resposta;
    
    //CONSTRUTORES

    public ModeratorEvento() {
        super();
    } 

    public ModeratorEvento(IntermediarioBaseDados baseDados, Jogador jogador, Evento evento) {
        super();
        
        this.baseDados = baseDados;
        this.jogador = jogador;
        this.evento = evento;
    }
    
    //FUNÇÕES AUXILIARES
    
    private boolean HouveAlteraçãoHabilidades(int habilidadeAlterada){
        if (habilidadeAlterada > 0){
            this.resposta += " O dom da sabedoria cresceu em você!";
            return true;
        }
        return false;
    }
    
    private void EscreveAlteraçãoDePontos(int pontosAlterados, String atributo){
        if (pontosAlterados > 0){
            this.resposta += " Você ganhou " + pontosAlterados + " pontos de " + atributo + "!"; 
        }else if (pontosAlterados < 0){
            this.resposta += " Você perdeu " + pontosAlterados + " pontos de " + atributo + "!"; 
        }
    }
    
    private void ChecaCaracteristicasAlteradas(FolhaDeCaracteristicas caracteristicasAlteradas){
        short forcaAlterada = caracteristicasAlteradas.getForca();
        this.jogador.getAtributos().getCaracteristicas().setForca((short)(
                this.jogador.getAtributos().getCaracteristicas().getForca()+forcaAlterada));
        EscreveAlteraçãoDePontos(forcaAlterada, "Força");
        
        short constituicaoAlterada = caracteristicasAlteradas.getConstituicao();
        this.jogador.getAtributos().getCaracteristicas().setConstituicao((short)(
                this.jogador.getAtributos().getCaracteristicas().getConstituicao()+constituicaoAlterada));
        EscreveAlteraçãoDePontos(constituicaoAlterada, "Constituição");
        
        short tamanhoAlterado = caracteristicasAlteradas.getTamanho();
        this.jogador.getAtributos().getCaracteristicas().setTamanho((short)(
                this.jogador.getAtributos().getCaracteristicas().getTamanho()+tamanhoAlterado));
        EscreveAlteraçãoDePontos(tamanhoAlterado, "Tamanho");
        
        short destrezaAlterado = caracteristicasAlteradas.getDestreza();
        this.jogador.getAtributos().getCaracteristicas().setDestreza((short)(
                this.jogador.getAtributos().getCaracteristicas().getDestreza()+destrezaAlterado));
        EscreveAlteraçãoDePontos(destrezaAlterado, "Destreza");
        
        short poderAlterado = caracteristicasAlteradas.getPoder();
        this.jogador.getAtributos().getCaracteristicas().setPoder((short)(
                this.jogador.getAtributos().getCaracteristicas().getPoder()+poderAlterado));
        EscreveAlteraçãoDePontos(poderAlterado, "Poder");
    }
    
    private void ChecaAtributosAlterados(FolhaDeAtributos atributosAlterados){
        ChecaCaracteristicasAlteradas(atributosAlterados.getCaracteristicas());
        
        short hpAlterado = atributosAlterados.getHpAtual();
        this.jogador.getAtributos().setHpAtual((short)(this.jogador.getAtributos().getHpAtual()
                + hpAlterado));
        EscreveAlteraçãoDePontos(hpAlterado, "Saúde");

        short mpAlterado = atributosAlterados.getMpAtual();
        this.jogador.getAtributos().setMpAtual((short)(this.jogador.getAtributos().getMpAtual()
                + mpAlterado));
        EscreveAlteraçãoDePontos(mpAlterado, "Magia");
    }
    
    private boolean ChecaSetHabilidadeTiro(HabilidadesTiro habilidadesAlteradas){//Precisa ser mudado
        short pistola = habilidadesAlteradas.getTiroPistola();
        if (HouveAlteraçãoHabilidades(pistola))
            return true;
        
        short rifleEscopeta = habilidadesAlteradas.getTiroRifleEscopeta();
        if (HouveAlteraçãoHabilidades(rifleEscopeta))
            return true;
        
        short submetralhadora = habilidadesAlteradas.getTiroSubmetralhadora();
        if (HouveAlteraçãoHabilidades(submetralhadora))
            return true;
        
        short arremesso = habilidadesAlteradas.getArremesso();
        return HouveAlteraçãoHabilidades(arremesso);
    }
    
    private void ChecaHabilidadesAlterados(FolhaDeHabilidades habilidadesAlteradas){
        short mitos = habilidadesAlteradas.getMitosDeCthulhu();
        if (HouveAlteraçãoHabilidades(mitos))
            return;
        
        ChecaSetHabilidadeTiro(habilidadesAlteradas.getTiro());
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
                ChecaAtributosAlterados(atributosAlterados);
                
                
                
                FolhaDeHabilidades habilidadesAlteradas = respostasEvento.getHabilidadesAlteradas();
                ChecaHabilidadesAlterados(habilidadesAlteradas);
                
                short sanidadeAlterada = respostasEvento.getSanidadeAtualAlterada();
                this.jogador.setSanidadeAtual((short)(this.jogador.getSanidadeAtual() + sanidadeAlterada));
                EscreveAlteraçãoDePontos(sanidadeAlterada, "Sanidade");
            }
        }
        
        this.jogador.setLocalidadeAtual(this.evento.getLocalDeRetorno());
    }
    
    //GETTERS E SETTERS

    public String getResposta() {
        return resposta;
    }   
    
}
