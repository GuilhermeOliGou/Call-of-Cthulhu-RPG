package RegrasDeNegocio;

import DTO.Personagens.Jogador;
import java.util.ArrayList;
import telas.FacadeRegraNegocio;

public class FacadeControlador implements FacadeRegraNegocio{
    
    //ATRIBUTOS
    
    private final IntermediarioBaseDados BASEDADOS;
    private final int IDADEPADRAO = 19;
    
    private Jogador jogador;
    private String Resposta;
    
    private boolean hasBatalha;
    private boolean hasResposta;
    
    //CONSTRUTOR
    
    public FacadeControlador() throws RegraNegocioException{
        super();
        
        this.BASEDADOS = new IntermediarioBaseDados();
    }
    
    //FUNÇÕES
    
    //MENUS INICIAIS
    
    @Override
    public void criaJogador(String nome) throws RegraNegocioException{
        Validador validador = new Validador();
        String nomeValido = validador.ValidadorNome(nome);
        CriadorDePersonagensPadrão criador = new CriadorDePersonagensPadrão();
        this.jogador = criador.CriarJogador(0, nomeValido, this.IDADEPADRAO);
        this.BASEDADOS.LimpaJogadores();
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
        this.BASEDADOS.LimpaJogadores();
        return this.jogador.getNome();
    }
    
}
