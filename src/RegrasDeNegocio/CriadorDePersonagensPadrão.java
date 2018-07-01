package RegrasDeNegocio;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import DTO.Personagens.FolhaDeHabilidades;
import utilidades.Log;

public class CriadorDePersonagensPadrão implements CriadorDePersonagens {
    
    //ATRIBUTOS
    
    private final short DESTREZAPADRAO = 40;
    
    private final Dados DADOS = new Dados();
    
    //CONSTRUTORES

    public CriadorDePersonagensPadrão() {
        super();
    } 
    
    //FUNÇÕES PRINCIPAIS
    
    public Jogador GeradorDeJogador(){
        FolhaDeCaracteristicas caracteristicas = GeradorDeFolhaDeCaracteristicas();
        FolhaDeAtributos atributos;
        try{
            atributos = GeradorDeFolhaDeAtributos(caracteristicas);
        }catch(RegraNegocioException e){
            Log.gravaLog(e);
            atributos = Ge
        }
    } 
    
    //FUNÇÕES CARACTERÍSTICAS
    
    @Override
    public FolhaDeCaracteristicas GeradorDeFolhaDeCaracteristicas(){
        return new FolhaDeCaracteristicas(
                GeradorDeForca(), GeradorDeConstituicao(),
                GeradorDeTamanho(), GeradorDeDestreza(),
                GeradorDePoder()
        );
    }
    
    @Override
    public short GeradorDeForca(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    @Override
    public short GeradorDeConstituicao(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    @Override
    public short GeradorDeTamanho(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
    @Override
    public short GeradorDeDestreza(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    @Override
    public short GeradorDePoder(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    //FUNÇÕES ATRIBUTOS
    
    @Override
    public FolhaDeAtributos GeradorDeFolhaDeAtributos(FolhaDeCaracteristicas caracteristicas) 
            throws RegraNegocioException{
        try{
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
        }catch(NullPointerException e){
            Log.gravaLog(e);
            throw new RegraNegocioException("FOLHA DE CARACTERÍSTICAS NÃO INICIALIZADA!"
                    + "INCAPAZ DE CRIAR UMA FOLHA DE ATRIBUTOS");
        }
    }
    
    @Override
    public short GeradorDeMaxHP (short constituicao, short tamanho){
        return (short)((constituicao+tamanho)/10);
    }
    
    @Override
    public short GeradorDeMaxMP (short poder){
        return (short)((poder)/5);
    }
    
    @Override
    public short GeradorDeBonusDeDanoCorporal(short forca, short tamanho){        
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
    
    @Override
    public short GeradorDeSorte(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
    @Override
    public FolhaDeHabilidades GeradorDeFolhaDeHabilidades(short destreza){
        return new FolhaDeHabilidades(destreza);
    }
    
}
