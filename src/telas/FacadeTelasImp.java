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
    public void salvarJogador(Jogador jogador) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void resetaJogo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public ArrayList<String> getEventos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getDescricoesJogadores() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String carregaJogador(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getDescricaoJogador() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getDescricaoEvento(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean getBatalha() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void executaEvento(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    

    @Override
    public String getHPPersonagem() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getHPMaxPersonagem() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    @Override
    public String getHPInimigo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getHPMaxInimigo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<String> getAcoesBatalha() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void resetaEPopula() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getNomePersonagem() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMPPersonagem() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMPMaxPersonagem() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getNomeInimigo() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String carregaNomeLocal() throws RegraNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); 
    } 
}
