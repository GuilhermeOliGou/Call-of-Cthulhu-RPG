package RegrasDeNegocio;

import Geral.Dados;

public class GerenciadorRegrasNegocio implements RegrasDeNegocio {
    
    private final Dados DADOS;

    public GerenciadorRegrasNegocio(Dados dados) {
        this.DADOS = dados;
    }
            
    //FUNÇÕES DE CRIAÇÃO DE PERSONAGEM
    
    //FUNÇÕES DE ATRIBUTOS PRINCIPAIS
    
    @Override
    public int GeradorDeForca(){
        return (DADOS.D6()+DADOS.D6()+DADOS.D6())*5;
    }
    
    @Override
    public int GeradorDeConstituicao(){
        return (DADOS.D6()+DADOS.D6()+DADOS.D6())*5;
    }
    
    @Override
    public int GeradorDeTamanho(){
        return (DADOS.D6()+DADOS.D6()+6)*5;
    }
    
    @Override
    public int GeradorDeDestreza(){
        return (DADOS.D6()+DADOS.D6()+DADOS.D6())*5;
    }
    
    @Override
    public int GeradorDeAparencia(){
        return (DADOS.D6()+DADOS.D6()+DADOS.D6())*5;
    }
    
    @Override
    public int GeradorDeInteligencia(){
        return (DADOS.D6()+DADOS.D6()+6)*5;
    }
    
    @Override
    public int GeradorDeEducacao(){
        return (DADOS.D6()+DADOS.D6()+6)*5;
    }
    
    @Override
    public int GeradorDePoder(){
        return (DADOS.D6()+DADOS.D6()+DADOS.D6())*5;
    }
    
    @Override
    public int GeradorDeSorte(){
        return (DADOS.D6()+DADOS.D6()+6)*5;
    }
    
    //FIM FUNÇÕES DE ATRIBUTOS PRINCIPAIS
    
    //FUNÇÕES DE ATRIBUTOS SECUNDARIOS
    
    @Override
    public int GeradorDeMovimento(int forca, int destreza, int tamanho){
        if (destreza < tamanho && forca < tamanho)
            return 7;
        else if (destreza >= tamanho && forca >= tamanho)
            return 9;
        else 
            return 8;
    }
    
    @Override
    public int GeradorDeBonusDeDanoCorporal(int forca, int tamanho){        
        short somaDeForETam = (short)(forca+tamanho);
        if (somaDeForETam >= 2 && somaDeForETam <= 64){
            return -2;
        }else if (somaDeForETam > 64 && somaDeForETam <= 84){
            return -1;
        }else if (somaDeForETam > 85 && somaDeForETam <= 124){
            return 0;
        }else if (somaDeForETam > 125 && somaDeForETam <= 164){
            return DADOS.D4();
        }else{
            return DADOS.D6();
        }
        
    }
    
    @Override
    public int GeradorDeBuild(int forca, int tamanho){
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
    
    //FIM FUNÇÕES DE ATRIBUTOS SECUNDARIOS
    
    //FIM FUNÇÕES CRIAÇÃO DE PERSONAGEM
    
}
