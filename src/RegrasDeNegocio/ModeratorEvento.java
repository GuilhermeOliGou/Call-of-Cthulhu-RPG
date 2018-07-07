package RegrasDeNegocio;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoAvancado;
import DTO.ElementosDeSistema.Resposta;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

public class ModeratorEvento {
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    
    private boolean alterouHabilidades;
    
    private IntermediarioBaseDados baseDados;    
    private Jogador jogador;
    private Evento evento;    
    private String resposta;
    
    //CONSTRUTORES

    public ModeratorEvento() {
        super();
    } 

    public ModeratorEvento(IntermediarioBaseDados baseDados, Jogador jogador, Evento evento, 
            String resposta) {
        super();
        
        this.baseDados = baseDados;
        this.jogador = jogador;
        this.evento = evento;
        this.resposta = resposta;
        
        this.alterouHabilidades = false;
    }
    
    //FUNÇÕES AUXILIARES
    
    private void EscreveAlteraçãoHabilidades(int habilidadeAlterada){
        if (this.alterouHabilidades && habilidadeAlterada > 0)
            this.resposta += " O dom da sabedoria cresceu em você!";
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
    
    private void ChecaHabilidadesAlterados(FolhaDeHabilidades habilidadesAlteradas){
        short mitos = habilidadesAlteradas.getMitosDeCthulhu();
        EscreveAlteraçãoHabilidades(mitos);
        
        ChecaSetHabilidadeLuta(habilidadesAlteradas.getLuta());
        
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
                this.alterouHabilidades = false;
                
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
