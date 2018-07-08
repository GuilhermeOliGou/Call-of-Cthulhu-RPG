package telas;

import DTO.Personagens.Jogador;
import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;

public interface FacadeRegraNegocio {
    
    //MENUS INICIAIS
    
    public void criaJogador(String nome) throws RegraNegocioException;
    
    public boolean existeJogos() throws RegraNegocioException;
    
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException;
     
    public ArrayList<String> getDescricoesJogadores() throws RegraNegocioException;
        
    public String carregaJogador(int index) throws RegraNegocioException;
    
    
    
    //INFORMAÇÕES DE BATALHA
    
    
    
    public boolean hasBatalha() throws RegraNegocioException;    
    
    public ArrayList<String> getAcoesBatalha() throws RegraNegocioException;
    
    public String getNomePersonagem() throws RegraNegocioException;
    
    public String getHPPersonagem() throws RegraNegocioException;
    
    public String getMPPersonagem() throws RegraNegocioException;
    
    public String getNomeInimigo() throws RegraNegocioException;
    
    public String getHPInimigo() throws RegraNegocioException;
    
    public void realizaAcaoBatalha(int indice) throws RegraNegocioException;
    
    
    
    //LOCAL E EVENTOS
    
   public boolean hasResposta() throws RegraNegocioException;
   
   public String getResposta() throws RegraNegocioException;
    
    public ArrayList<String> getEventos() throws RegraNegocioException;
    
    public void executaEvento(int index) throws RegraNegocioException;
    
    public String getDescricaoJogador() throws RegraNegocioException;
    
    public String carregaNomeLocal() throws RegraNegocioException;
    
    
    //FUNÇÕES DE SALVAMENTO
    
    
    public void salvarJogador(Jogador jogador) throws RegraNegocioException;
    
    public void resetaJogo() throws RegraNegocioException;
    
    public void resetaEPopula() throws RegraNegocioException;

   


    
}
