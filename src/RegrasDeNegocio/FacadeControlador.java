package RegrasDeNegocio;

import java.util.ArrayList;
import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.EventoLuta;
import DTO.ElementosDeSistema.Local;
import DTO.Personagens.Jogador;
import Telas.FacadeRegraNegocio;

public class FacadeControlador implements FacadeRegraNegocio{
    
    //ATRIBUTOS
    
    private final IntermediarioBaseDados BASEDADOS;
    private final int IDADEPADRAO = 19;
    private final ModeratorEventos MODERADOREVENTOS;
    private final ModeratorInsanidade INSANIDADE;
    private final ModeratorBatalha BATALHA;
    
    private Jogador jogador;
    private String resposta;
    private Local localidadeAtual;
    private ArrayList<Evento> eventosValidos;
    
    private boolean hasBatalha;
    private boolean hasResposta;
    
    //CONSTRUTOR
    
    public FacadeControlador() throws RegraNegocioException{
        super();
        
        this.BASEDADOS = new IntermediarioBaseDados();
        this.MODERADOREVENTOS = new ModeratorEventos();
        this.INSANIDADE = new ModeratorInsanidade();
        this.BATALHA = new ModeratorBatalha();
    }
    
    //FUNÇÕES
    
    //MENUS INICIAIS
    
    @Override
    public void criaJogador(String nome) throws RegraNegocioException{
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
    public boolean existeJogos() throws RegraNegocioException{
        this.BASEDADOS.CarregaTodosJogadores();
        return this.BASEDADOS.ListaDeJogadoresVazia();
    }
    
    @Override
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException{
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
        
        this.MODERADOREVENTOS.setJogador(this.jogador);
        
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
    public ArrayList<String> getAcoesBatalha() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        ArrayList<String> acoes = this.BATALHA.GetNomesAcoes();
        
        return this.INSANIDADE.Deformacoes(acoes);
    }
    
    @Override
    public String getNomePersonagem() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.jogador.getNome());
    }
    
    @Override
    public String getHPPersonagem() throws RegraNegocioException{
        String hpPersonagem = this.jogador.getAtributos().getHpAtual()+ " / " +
                this.jogador.getAtributos().getMaxHp();
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(hpPersonagem);
    }
    
    @Override
    public String getMPPersonagem() throws RegraNegocioException{
        String mpPersonagem = this.jogador.getAtributos().getMpAtual()+ " / " +
                this.jogador.getAtributos().getMaxMp();
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(mpPersonagem);
    }
    
    
    @Override
    public String getNomeInimigo() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.BATALHA.GetNomeInimigo());
    }
    
    @Override
    public String getHPInimigo() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.BATALHA.GetHPInimigo());
    }
    
    public void realizaAcaoBatalha(int indice) throws RegraNegocioException;
    
    //FUNÇÕES DE LOCAL E EVENTOS
    
    @Override
    public boolean hasResposta() throws RegraNegocioException{
        return this.hasResposta;
    }
   
    @Override
    public String getResposta() throws RegraNegocioException{
        this.hasResposta = false;
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.resposta);
    }
    
    @Override
    public ArrayList<String> getEventos() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        ArrayList<String> nomeEventos = new ArrayList<>();
        this.eventosValidos.forEach((e) -> {
            nomeEventos.add(this.INSANIDADE.DeformacaoInsanidade(e.getNome()));
        });
        return nomeEventos;
    }
    
    @Override
    public void executaEvento(int index) throws RegraNegocioException{
        if (this.hasBatalha)
            throw new RegraNegocioException("ERRO! BATALHA EM ANDAMENTO!");
        
        this.MODERADOREVENTOS.ExecutaEvento(this.eventosValidos.get(index));
        
        this.hasBatalha = this.MODERADOREVENTOS.HasBatalha();
        this.MODERADOREVENTOS.setHasBatalha(false);
        this.hasResposta = this.MODERADOREVENTOS.HasResposta();
        this.MODERADOREVENTOS.setHasResposta(false);
        
        if (this.hasBatalha){
            this.BATALHA.setJogador(this.jogador);
            this.BATALHA.setInimigo(((EventoLuta)(this.eventosValidos.get(index))).getInimigo());
            this.BATALHA.GeraAcoes();
        }
        
        this.localidadeAtual = this.BASEDADOS.CarregaLocal(
                this.jogador.getId(), this.jogador.getLocalidadeAtual());
        ModeratorValidaçãoEventos validadorEventos = new ModeratorValidaçãoEventos();
        this.eventosValidos = validadorEventos.GetEventosValidos(localidadeAtual);
    }
    
    @Override
    public String getDescricaoJogador() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.jogador.DescricaoJogador());
    }
    
    @Override
    public String carregaNomeLocal() throws RegraNegocioException{
        this.INSANIDADE.setInsanidadeJogador(this.jogador.getSanidadeAtual());
        return this.INSANIDADE.DeformacaoInsanidade(this.localidadeAtual.getNome());
    }
    
    //FUNÇÕES DE SALVAMENTO
    
    @Override
    public void salvarJogador() throws RegraNegocioException{
        this.BASEDADOS.SalvaJogo(this.jogador);
    }
    
}
