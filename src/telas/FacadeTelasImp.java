package telas;

import DTO.Personagens.Jogador;
import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;


public class FacadeTelasImp implements FacadeRegraNegocio{
     
    @Override
    public void criaJogador(String nome) throws RegraNegocioException {
        
    }
    
    @Override
    public boolean existeJogos() throws RegraNegocioException {
        return false;
    }

    @Override
    public void salvarJogador(Jogador jogador) throws RegraNegocioException{

    }

    @Override
    public void resetaJogo() throws RegraNegocioException{
        
    }
    
    @Override
    public ArrayList<String> getEventos() throws RegraNegocioException{
        ArrayList<String> eventos = null;
        return eventos;
    }
    
    @Override
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException {
        ArrayList<String> nomes = null;
        return nomes;
    }

    @Override
    public ArrayList<String> getDescricoesJogadores() throws RegraNegocioException{
        ArrayList<String> descricoes = null;
        return descricoes;
    }

    @Override
    public String carregaJogador(int index) throws RegraNegocioException{
        String nomeJogador = null;
        
        return nomeJogador;
    }

    @Override
    public String getDescricaoJogador() throws RegraNegocioException{
        String descriJogador = null;
        
        return descriJogador;
    }

    @Override
    public boolean hasBatalha() throws RegraNegocioException{
        boolean batalha = false;
        
        return batalha;
    }

    @Override
    public void executaEvento(int index) throws RegraNegocioException{
        
    }

    

    @Override
    public String getHPPersonagem() throws RegraNegocioException{
        String HpPersonagem = null;
        return HpPersonagem;
    }
   
    @Override
    public String getHPInimigo() throws RegraNegocioException{
        String HpInimigo = null;
        return HpInimigo;
    }

   

    @Override
    public ArrayList<String> getAcoesBatalha() throws RegraNegocioException{
        ArrayList<String> acoesBatalha = null;
        
        return acoesBatalha;
    }

    @Override
    public void resetaEPopula() throws RegraNegocioException{
       
    }

    @Override
    public String getNomePersonagem() throws RegraNegocioException {
        String nomePersonagem = null;
        return nomePersonagem;
    }

    @Override
    public String getMPPersonagem() throws RegraNegocioException {
        String MpPersonagem = null;
        
        return MpPersonagem;
    }

    

    @Override
    public String getNomeInimigo() throws RegraNegocioException {
        String nomeInimigo = null;
        return nomeInimigo;
    }

    @Override
    public String carregaNomeLocal() throws RegraNegocioException {
        String nomeLocal = null;
        return nomeLocal;
    } 

    @Override
    public void realizaAcaoBatalha(int indice) throws RegraNegocioException {
        
    }

    @Override
    public boolean hasResposta() throws RegraNegocioException {
        boolean resposta = false;
        return resposta;
    }

    @Override
    public String getResposta() throws RegraNegocioException {
        String resposta = null;
        return resposta;
    }
}
