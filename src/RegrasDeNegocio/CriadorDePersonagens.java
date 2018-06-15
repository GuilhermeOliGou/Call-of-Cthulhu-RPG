package RegrasDeNegocio;

import DTO.Personagens.*;

public interface CriadorDePersonagens {
    
    public Personagem GeradorDePersonagem();
    
    //CARACTERISTICAS
    
    public FolhaDeCaracteristicas GeradorDeFolhaDeCaracteristicas();
    
    public short GeradorDeForca();
    
    public short GeradorDeConstituicao();
    
    public short GeradorDeTamanho();
    
    public short GeradorDeDestreza();
    
    public short GeradorDeAparencia();
    
    public short GeradorDeInteligencia();
    
    public short GeradorDeEducacao();
    
    public short GeradorDePoder();
    
    //ATRIBUTOS
    
    public FolhaDeAtributos GeradorDeFolhaDeAtributos(FolhaDeCaracteristicas caracteristicas)
            throws RegraNegocioException;
    
    public short GeradorDeMaxHP(short constituicao, short tamanho);
    
    public short GeradorDeMaxMP(short poder);
    
    public short GeradorDeMovimento(short forca, short destreza, short tamanho);
    
    public short GeradorDeBonusDeDanoCorporal(short forca, short tamanho);
    
    public short GeradorDeBuild(short forca, short tamanho);
    
    //ATRIBUTOs DE JOGADOR
    
    public short GeradorDeSorte();
    
    public short GeradorDeMaxSanidade(short poder);
    
    public FolhaDeHabilidades GeradorDeFolhaDeHabilidades();
}
