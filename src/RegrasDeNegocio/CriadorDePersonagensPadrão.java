package RegrasDeNegocio;

import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeCaracteristicas;
import utilidades.Log;

public class CriadorDePersonagensPadrão implements CriadorDePersonagens {
    
    //ATRIBUTOS
    
    private final Dados DADOS = new Dados();
    
    //CONSTRUTORES

    public CriadorDePersonagensPadrão() {
        super();
    }    
    
    //FUNÇÕES CARACTERÍSTICAS
    
    @Override
    public FolhaDeCaracteristicas GeradorDeFolhaDeCaracteristicas(){
        return new FolhaDeCaracteristicas(
                GeradorDeForca(), GeradorDeConstituicao(),
                GeradorDeTamanho(), GeradorDeDestreza(),
                GeradorDeAparencia(), GeradorDeInteligencia(),
                GeradorDeEducacao(), GeradorDePoder()
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
    public short GeradorDeAparencia(){
        return (short)((DADOS.D6()+DADOS.D6()+DADOS.D6())*5);
    }
    
    @Override
    public short GeradorDeInteligencia(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
    @Override
    public short GeradorDeEducacao(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
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
                    GeradorDeMovimento(caracteristicas.getForca(), caracteristicas.getDestreza(), 
                            caracteristicas.getTamanho()),
                    GeradorDeBonusDeDanoCorporal(caracteristicas.getForca(), 
                            caracteristicas.getTamanho()),
                    GeradorDeBuild(caracteristicas.getForca(), caracteristicas.getTamanho())
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
    public short GeradorDeMovimento(short forca, short destreza, short tamanho){
        if (destreza < tamanho && forca < tamanho)
            return 7;
        else if (destreza >= tamanho && forca >= tamanho)
            return 9;
        else 
            return 8;
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
    
    @Override
    public short GeradorDeBuild(short forca, short tamanho){
        short somaDeForETam = (short)(forca+tamanho);
        if (somaDeForETam >= 2 && somaDeForETam <= 64){
            return -2;
        }else if (somaDeForETam > 64 && somaDeForETam <= 84){
            return -1;
        }else if (somaDeForETam > 85 && somaDeForETam <= 124){
            return 0;
        }else if (somaDeForETam > 125 && somaDeForETam <= 164){
            return 1;
        }else{
            return 2;
        }
    }
    
    //FUNÇÕES ATRIBUTOS DE JOGADOR
    
    @Override
    public short GeradorDeSorte(){
        return (short)((DADOS.D6()+DADOS.D6()+6)*5);
    }
    
}
