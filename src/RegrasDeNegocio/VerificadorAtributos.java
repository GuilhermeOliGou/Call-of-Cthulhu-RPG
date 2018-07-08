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
    
    
    
    //FUNÇÕES AUXILIARES
    
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
    
    //FUNÇÕES
    
    public void ChecaAtributosAlterados(FolhaDeAtributos atributosAlterados){
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
    
}
