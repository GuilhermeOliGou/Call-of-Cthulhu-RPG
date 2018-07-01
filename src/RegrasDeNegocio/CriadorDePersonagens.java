package RegrasDeNegocio;

import DTO.Personagens.*;

public interface CriadorDePersonagens {
    
    public Jogador GeradorDeJogador();
    
    //CARACTERISTICAS
    
    public FolhaDeCaracteristicas GeradorDeFolhaDeCaracteristicas();
    
    public short GeradorDeForca();
    
    public short GeradorDeConstituicao();
    
    public short GeradorDeTamanho();
    
    public short GeradorDeDestreza();
    
    public short GeradorDePoder();
    
    //ATRIBUTOS
    
    public FolhaDeAtributos GeradorDeFolhaDeAtributos(FolhaDeCaracteristicas caracteristicas)
            throws RegraNegocioException;
    
    public short GeradorDeMaxHP(short constituicao, short tamanho);
    
    public short GeradorDeMaxMP(short poder);
    
    public short GeradorDeBonusDeDanoCorporal(short forca, short tamanho);
    
    //ATRIBUTOs DE JOGADOR
    
    public short GeradorDeSorte();
    
    public FolhaDeHabilidades GeradorDeFolhaDeHabilidades(short destreza);
}
