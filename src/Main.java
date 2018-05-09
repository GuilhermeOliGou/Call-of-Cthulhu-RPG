import Geral.Dados;
import RegrasDeNegocio.GerenciadorRegrasNegocio;
import RegrasDeNegocio.RegrasDeNegocio;
import Visualização.GerenciadorDeVisualizacao;

public class Main {
    
    public static void main(String[] args){
        Dados dados = new Dados();
        RegrasDeNegocio gerenciadorDeRegras = new GerenciadorRegrasNegocio(dados);
        GerenciadorDeVisualizacao telas = new GerenciadorDeVisualizacao(gerenciadorDeRegras);
        telas.CriaTelaCriacao();
    }
    
}
