package Telas;

import RegrasDeNegocio.RegraNegocioException;
import java.util.ArrayList;


public class FacadeTelasImp implements FacadeRegraNegocio{
     
    @Override
    public void criaJogador(String nome) throws RegraNegocioException {
        // vamos te enviar uma string com o nome e vc cria um novo jogador/jogo/personagem
    }
    
    @Override
    public boolean existeJogos() throws RegraNegocioException {
        //tem que checar se tem algum jogo/jogador/personagem no bd 
        return false;
    }

    @Override
    public void salvarJogador() throws RegraNegocioException{
        //pegar o jogador instanciado e salvar ele (nesse caso, acho q salva tudo)
    }

    @Override
    public void resetaJogo() throws RegraNegocioException{
        //vai resetar o jogo, facil, pq vai deletar a database e criar outra e popular
    }
    
    @Override
    public ArrayList<String> getEventos() throws RegraNegocioException{
       //vai retornar uma lista com cada elemento sendo o nome dos eventos disponiveis
        ArrayList<String> eventos = null;
        
        return eventos;
    }
    
    @Override
    public ArrayList<String> getNomesJogadores() throws RegraNegocioException {
        //retorna uma lista com cada elemento sendo o nome de jogador/jogo/personagem
        //tem que estar na mesma ordem que o descricoesjogadores
        ArrayList<String> nomes = null;
        
        return nomes;
    }

    @Override
    public ArrayList<String> getDescricoesJogadores() throws RegraNegocioException{
        //retorna uma lista com cada elemento sendo a descrição do jogador/jogo/personagem
        //tem que estar na mesma ordem que o nomesjogadores
        
        
        //tava pensando em algo nesse estilo
        
        /*
        Nome: clodorvil
        idade: 19
        inventario: 15/20
        HpAtual: 78/100
        MpAtual: 30/100
        
        nao esquece os /n
        */
        ArrayList<String> descricoes = null;
        
        return descricoes;
    }

    @Override
    public String carregaJogador(int index) throws RegraNegocioException{
        /*
        CUIDADO
        
        quando a gente pedir a lista de nome de jogadores, vc tem que lembrar de
        salvar, pq vamos mandar o index do jogo/jogador/personagem que a gente
        escolher para vc deixar o personagem carregado na memoria pra n perder
        a referencia dele durante o jogo
        */
        String nomeJogador = null;
        
        return nomeJogador;
    }

    @Override
    public String getDescricaoJogador() throws RegraNegocioException{
        //durante o jogo, precisamos saber de uma descrição mais completa do jogador
        /*
        vai ser quase a mesma coisa que o outro, mas tem q ter mais informações
        como listar os itens, atributos e talz... precisamos conversar sobre isso
        */
        String descriJogador = null;
        
        return descriJogador;
    }

    @Override
    public boolean hasBatalha() throws RegraNegocioException{
        //só para saber se o evento é uma batalha ou não (pelo que eu entendi
        boolean batalha = false;
        
        return batalha;
    }

    @Override
    public void executaEvento(int index) throws RegraNegocioException{
        /*
        acho que aqui vamos executar o evento selecionado daquela lista de eventos
        */
    }

    

    @Override
    public String getHPPersonagem() throws RegraNegocioException{
        //retorna o HP atual do personagem...
        String HpPersonagem = null;
        
        return HpPersonagem;
    }
   
    @Override
    public String getHPInimigo() throws RegraNegocioException{
        //retorna o HP atual do inimigo
        String HpInimigo = null;
        return HpInimigo;
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
    public String getNomePersonagem() throws RegraNegocioException {
        //Vc Sabe ne
        String nomePersonagem = null;
        
        return nomePersonagem;
    }

    @Override
    public String getMPPersonagem() throws RegraNegocioException {
        //vc tbm sabe o q tem q fazer
        String MpPersonagem = null;
        
        return MpPersonagem;
    }

    @Override
    public String getNomeInimigo() throws RegraNegocioException {
        //esse tbm
        String nomeInimigo = null;
        
        return nomeInimigo;
    }

    @Override
    public String carregaNomeLocal() throws RegraNegocioException {
        //retorna o nome atual do local onde o personagem esta
        String nomeLocal = null;
        
        return nomeLocal;
    } 

    @Override
    public void realizaAcaoBatalha(int indice) throws RegraNegocioException {
        //isso é da batalha, vc ja deve saber o q faz
        //se n sabe, é a lista de acoes de batalha, ai vc faz seus paranaue ai
        //ah, n esquece de arrumar o medo e incrementar os inimigos derrotados(se tiver)
    }

    @Override
    public boolean hasResposta() throws RegraNegocioException {
        //se tiver resposta, avisa
        boolean resposta = false;
        
        return resposta;
    }

    @Override
    public String getResposta() throws RegraNegocioException {
        //retorna a resposta do evento pra gente mostrar para o usuario
        String resposta = null;
        
        return resposta;
    }
}
