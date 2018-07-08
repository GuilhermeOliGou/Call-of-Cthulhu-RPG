package RegrasDeNegocio;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.Jogador;

public class CriadorDePersonagensPadrão{
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    private final int LOCALPADRAO = 1; 
    
    //CONSTRUTORES

    public CriadorDePersonagensPadrão() {
        super();
    } 
    
    //FUNÇÕES PRINCIPAIS
    
    public Jogador CriarJogador(int id, String nome, int idade)throws RegraNegocioException{
        FolhaDeCaracteristicas caracteristicas = GeradorDeFolhaDeCaracteristicas();
        FolhaDeAtributos atributos = GeradorDeFolhaDeAtributos(caracteristicas);
        return new Jogador(id,atributos,(short)idade,nome,this.LOCALPADRAO,
                caracteristicas.getPoder(),caracteristicas.getPoder(),
                GeradorDeSorte(),new Integer[20], new Integer[20]);
    } 
    
    //FUNÇÕES CARACTERÍSTICAS
    
    private FolhaDeCaracteristicas GeradorDeFolhaDeCaracteristicas(){
        return new FolhaDeCaracteristicas(
                GeradorDeForca(), GeradorDeConstituicao(),
                GeradorDeTamanho(), GeradorDeDestreza(),
                GeradorDePoder()
        );
    }
    
    private short GeradorDeForca(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    private short GeradorDeConstituicao(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    private short GeradorDeTamanho(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
    private short GeradorDeDestreza(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    private short GeradorDePoder(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    //FUNÇÕES ATRIBUTOS
    
    private FolhaDeAtributos GeradorDeFolhaDeAtributos(FolhaDeCaracteristicas caracteristicas){
        short maxHP = GeradorDeMaxHP(caracteristicas.getConstituicao(), 
                caracteristicas.getTamanho());
        short maxMP = GeradorDeMaxMP(caracteristicas.getPoder());
        return new FolhaDeAtributos(
                caracteristicas,
                maxHP,maxMP,
                maxHP,maxMP,
                GeradorDeBonusDeDanoCorporal(caracteristicas.getForca(), 
                        caracteristicas.getTamanho())
        );
        
    }
    
    private short GeradorDeMaxHP (short constituicao, short tamanho){
        return (short)((constituicao+tamanho)/10);
    }
    
    private short GeradorDeMaxMP (short poder){
        return (short)((poder)/5);
    }
    
    private short GeradorDeBonusDeDanoCorporal(short forca, short tamanho){        
        short somaDeForETam = (short)(forca+tamanho);
        if (somaDeForETam >= 2 && somaDeForETam <= 64){
            return -2;
        }else if (somaDeForETam > 64 && somaDeForETam <= 84){
            return -1;
        }else if (somaDeForETam > 85 && somaDeForETam <= 124){
            return 0;
        }else if (somaDeForETam > 125 && somaDeForETam <= 164){
            return (short)DADOS.D4();
        }else{
            return (short)DADOS.D6();
        }
        
    }
    
    //FUNÇÕES ATRIBUTOS DE JOGADOR
    
    private short GeradorDeSorte(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
}
