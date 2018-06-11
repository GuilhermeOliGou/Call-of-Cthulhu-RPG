package BaseDados;

import ElementosDeJogo.Itens.Arma;

import java.util.List;

public class DaoArmaJdbc implements DaoArma {

    public DaoArmaJdbc(){

    }

    @Override
    public Arma BuscaArma(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void EscreveArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public void AlteraArma(Arma arma) throws BaseDadosException {

    }

    @Override
    public List<Arma> ListaArma() throws BaseDadosException {
        return null;
    }

    @Override
    public List<Arma> ListaArmaPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
