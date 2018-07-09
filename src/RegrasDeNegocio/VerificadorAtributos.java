package RegrasDeNegocio;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Jogador;

public class VerificadorAtributos {
    
    //ATRIBUTOS
    
    private Jogador jogador;
    private String resposta;
    
    //CONSTRUTORES

    public VerificadorAtributos() {
        super();
    }

    public VerificadorAtributos(Jogador jogador, String resposta) {
        super();
        
        this.jogador = jogador;
        this.resposta = resposta;
    }
    
    //FUNÇÕES DE ESCRITA
    
    public void EscreveAlteraçãoDePontos(int pontosAlterados, String atributo){
        if (pontosAlterados > 0){
            this.resposta += " Você ganhou " + pontosAlterados + " pontos de " + atributo + "!"; 
        }else if (pontosAlterados < 0){
            this.resposta += " Você perdeu " + pontosAlterados + " pontos de " + atributo + "!"; 
        }
    }
    
    //FUNÇÕES AUXILIARES
    
    private void ChecaCaracteristicasAlteradas(FolhaDeCaracteristicas caracteristicasAlteradas){
        FolhaDeCaracteristicas caracteristicas = jogador.getAtributos().getCaracteristicas();
        
        short forcaAlterada = caracteristicasAlteradas.getForca();
        caracteristicas.setForca((short)(caracteristicas.getForca()+forcaAlterada));
        EscreveAlteraçãoDePontos(forcaAlterada, "Força");
        
        short constituicaoAlterada = caracteristicasAlteradas.getConstituicao();
        caracteristicas.setConstituicao((short)(caracteristicas.getConstituicao()+constituicaoAlterada));
        EscreveAlteraçãoDePontos(constituicaoAlterada, "Constituição");
        
        short tamanhoAlterado = caracteristicasAlteradas.getTamanho();
        caracteristicas.setTamanho((short)(caracteristicas.getTamanho()+tamanhoAlterado));
        EscreveAlteraçãoDePontos(tamanhoAlterado, "Tamanho");
        
        short destrezaAlterado = caracteristicasAlteradas.getDestreza();
        caracteristicas.setDestreza((short)(caracteristicas.getDestreza()+destrezaAlterado));
        EscreveAlteraçãoDePontos(destrezaAlterado, "Destreza");
        
        short poderAlterado = caracteristicasAlteradas.getPoder();
        caracteristicas.setPoder((short)(caracteristicas.getPoder()+poderAlterado));
        EscreveAlteraçãoDePontos(poderAlterado, "Poder");
    }
    
    //FUNÇÕES
    
    public void ChecaAtributosAlterados(FolhaDeAtributos atributosAlterados){
        ChecaCaracteristicasAlteradas(atributosAlterados.getCaracteristicas());
        
        FolhaDeAtributos atributos = jogador.getAtributos();
        
        short hpAlterado = atributosAlterados.getHpAtual();
        atributos.setHpAtual((short)(atributos.getHpAtual()+ hpAlterado));
        EscreveAlteraçãoDePontos(hpAlterado, "Saúde");

        short mpAlterado = atributosAlterados.getMpAtual();
        atributos.setMpAtual((short)(atributos.getMpAtual()+ mpAlterado));
        EscreveAlteraçãoDePontos(mpAlterado, "Magia");
    }
    
    //GETTERS E SETTERS

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
}
