package Telas;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Local;
import DTO.Personagens.Jogador;
import RegrasDeNegocio.CriadorDePersonagensPadrão;
import RegrasDeNegocio.IntermediarioBaseDados;
import RegrasDeNegocio.ModeratorEventos;
import RegrasDeNegocio.ModeratorInsanidade;
import RegrasDeNegocio.ModeratorValidaçãoEventos;
import RegrasDeNegocio.RegraNegocioException;
import RegrasDeNegocio.Validador;
import java.util.ArrayList;


public class FacadeTelasImp implements FacadeRegraNegocio{
       //ATRIBUTOS
    
    private final IntermediarioBaseDados BASEDADOS;
    private final int IDADEPADRAO = 19;
    private final ModeratorEventos MODERADOREVENTOS;
    private final ModeratorInsanidade INSANIDADE;
    
    private Jogador jogador;
    private String resposta;
    private Local localidadeAtual;
    private ArrayList<Evento> eventosValidos;
    
    private boolean hasBatalha;
    private boolean hasResposta; 
    
    //CONSTRUTOR
    
    public FacadeTelasImp() throws RegraNegocioException{
        super();
        
        this.BASEDADOS = new IntermediarioBaseDados();
        this.MODERADOREVENTOS = new ModeratorEventos(BASEDADOS, jogador, resposta);
        this.INSANIDADE = new ModeratorInsanidade();
    }
    
    
    
    @Override
    public void criaJogador(String nome) throws RegraNegocioException {
         this.BASEDADOS.CarregaTodosJogadores();
        if(this.BASEDADOS.DevolveTodosJogadores().size() >= 10)
            throw new RegraNegocioException("ERRO! NÃO HÁ MAIS SLOTS DE SALVAMENTO!");
        Validador validador = new Validador();
        String nomeValido = validador.ValidadorNome(nome);
        CriadorDePersonagensPadrão criador = new CriadorDePersonagensPadrão();
        this.jogador = criador.CriarJogador(0, nomeValido, this.IDADEPADRAO);
        this.BASEDADOS.LimpaJogadores();
        this.BASEDADOS.CriaJogo(jogador);
        this.localidadeAtual = this.BASEDADOS.CarregaLocal(this.jogador.getId(), 
                this.jogador.getLocalidadeAtual());
        ModeratorValidaçãoEventos validadorEventos = new ModeratorValidaçãoEventos();
        this.eventosValidos = validadorEventos.GetEventosValidos(localidadeAtual);
    }
    
    @Override
    public boolean existeJogos() throws RegraNegocioException {
        this.BASEDADOS.CarregaTodosJogadores();
        return this.BASEDADOS.ListaDeJogadoresVazia();
    }
    
     @Override
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException {
        ArrayList<String> nomesJogadores = new ArrayList<>();
        ArrayList<Jogador> jogadores = this.BASEDADOS.DevolveTodosJogadores();
        jogadores.stream().map((j) -> j.getNome()).forEachOrdered((nomeJogador) -> {
            nomesJogadores.add(nomeJogador);
        });
        return nomesJogadores;
    }
    
    
    @Override
    public ArrayList<String> getDescricoesJogadores() throws RegraNegocioException{
          ArrayList<String> descricaoJogadores = new ArrayList<>();
        ArrayList<Jogador> jogadores = this.BASEDADOS.DevolveTodosJogadores();
        for (Jogador j : jogadores){
            descricaoJogadores.add(j.DescricaoJogador());
        }
        return descricaoJogadores;
    }

    @Override
    public String carregaJogador(int index) throws RegraNegocioException{
        this.jogador = this.BASEDADOS.DevolveJogador(index);
        this.BASEDADOS.LimpaJogadores();
        this.localidadeAtual = this.BASEDADOS.CarregaLocal(this.jogador.getId(), 
                this.jogador.getLocalidadeAtual());
        ModeratorValidaçãoEventos validadorEventos = new ModeratorValidaçãoEventos();
        this.eventosValidos = validadorEventos.GetEventosValidos(localidadeAtual);
        return this.jogador.getNome();
    }
    
    //FUNÇÕES DE BATALHA
    
    @Override
    public boolean hasBatalha() throws RegraNegocioException{
        return this.hasBatalha;
    }  
    
    
    
    @Override
    public String getNomePersonagem() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(this.jogador.getNome());
    }
    
    @Override
    public String getHPPersonagem() throws RegraNegocioException{
        String hpPersonagem = this.jogador.getAtributos().getHpAtual()+ " / " +
                this.jogador.getAtributos().getMaxHp();
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(hpPersonagem);
    }
    
    @Override
    public String getMPPersonagem() throws RegraNegocioException{
        String mpPersonagem = this.jogador.getAtributos().getMpAtual()+ " / " +
                this.jogador.getAtributos().getMaxMp();
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(mpPersonagem);
    }
    
  
    
  
    
    //FUNÇÕES DE LOCAL E EVENTOS
    
    @Override
    public boolean hasResposta() throws RegraNegocioException{
        return this.hasResposta;
    }
   
    @Override
    public String getResposta() throws RegraNegocioException{
        this.hasResposta = false;
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(this.resposta);
    }
    
    @Override
    public ArrayList<String> getEventos() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        ArrayList<String> nomeEventos = new ArrayList<>();
        this.eventosValidos.forEach((e) -> {
            nomeEventos.add(this.INSANIDADE.DeformaçãoInsanidade(e.getNome()));
        });
        return nomeEventos;
    }
    
    @Override
    public void executaEvento(int index) throws RegraNegocioException{
        if (this.hasBatalha){
            throw new RegraNegocioException("ERRO! BATALHA EM ANDAMENTO!");
        }
        this.MODERADOREVENTOS.ExecutaEvento(this.eventosValidos.get(index));
        this.hasBatalha = this.MODERADOREVENTOS.HasBatalha();
        this.MODERADOREVENTOS.setHasBatalha(false);
        this.hasResposta = this.MODERADOREVENTOS.HasResposta();
        this.MODERADOREVENTOS.setHasResposta(false);
    }
    
    @Override
    public String getDescricaoJogador() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(this.jogador.DescricaoJogador());
    }
    
    @Override
    public String carregaNomeLocal() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformaçãoInsanidade(this.localidadeAtual.getNome());
    }
    
    //FUNÇÕES DE SALVAMENTO
    
    @Override
    public void salvarJogador() throws RegraNegocioException{
        this.BASEDADOS.SalvaJogo(this.jogador);
    }

    
    
    //---------------------------------------------------------
    
    
    //FUNÇÕES QUE FALTAM IMPLEMENTAR
    @Override
    public void resetaJogo() throws RegraNegocioException{
        //vai resetar o jogo, facil, pq vai deletar a database e criar outra e popular
    }

  
    @Override
    public ArrayList<String> getAcoesBatalha() throws RegraNegocioException{
       //retorna as acoes que o personagem pode fazer em uma batalha
        ArrayList<String> acoesBatalha = null;
        
        return acoesBatalha;
    }

    @Override
    public void resetaEPopula() throws RegraNegocioException{
       //exclui o BD e cria um novo e popula com as informações padrões
    }
    
      @Override
    public String getNomeInimigo() throws RegraNegocioException {
        //esse tbm
        String nomeInimigo = null;
        
        return nomeInimigo;
    }
    
    
         @Override
    public String getHPInimigo() throws RegraNegocioException{
        //retorna o HP atual do inimigo
        String HpInimigo = null;
        return HpInimigo;
    }
    
       @Override
    public void realizaAcaoBatalha(int indice) throws RegraNegocioException {
        //isso é da batalha, vc ja deve saber o q faz
        //se n sabe, é a lista de acoes de batalha, ai vc faz seus paranaue ai
        //ah, n esquece de arrumar o medo e incrementar os inimigos derrotados(se tiver)
    }

}
