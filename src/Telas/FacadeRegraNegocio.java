package telas;

import DTO.Personagens.Jogador;
import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;

public interface FacadeRegraNegocio {
    
    //MENUS INICIAIS
    
    
    
    public boolean existeJogos() throws RegraNegocioException;
    
    public ArrayList<String> getDescricoesJogadores() throws RegraNegocioException;
        
    public String carregaJogador(int index) throws RegraNegocioException;
    
    
    
    //INFORMAÇÕES DE BATALHA
    
    
    
    public boolean getBatalha() throws RegraNegocioException;
    
    public ArrayList<String> getAcoesBatalha() throws RegraNegocioException;
    
    public String getNomePersonagem() throws RegraNegocioException;
    
    public String getHPPersonagem() throws RegraNegocioException;
    
    public String getHPMaxPersonagem() throws RegraNegocioException;
    
    public String getMPPersonagem() throws RegraNegocioException;
    
    public String getMPMaxPersonagem() throws RegraNegocioException;
    
    public String getNomeInimigo() throws RegraNegocioException;
    
    public String getHPInimigo() throws RegraNegocioException;
    
    public String getHPMaxInimigo() throws RegraNegocioException;
    
    
    
    //LOCAL E EVENTOS
    
    
    
    public String getDescricaoEvento() throws RegraNegocioException;
    
    public ArrayList<String> getEventos() throws RegraNegocioException;
    
    public void executaEvento(int index) throws RegraNegocioException;
    
    public String getDescricaoJogador() throws RegraNegocioException;
    
    public String carregaNomeLocal() throws RegraNegocioException;
    
    
    //FUNÇÕES DE SALVAMENTO
    
    
    public void salvarJogador(Jogador jogador) throws RegraNegocioException;
    
    public void resetaJogo() throws RegraNegocioException;
    
    public void resetaEPopula() throws RegraNegocioException;
    
}
