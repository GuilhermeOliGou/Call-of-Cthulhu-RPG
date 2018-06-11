package BaseDados;

import ElementosDeJogo.Itens.FolhaDano;

import java.util.List;

public class DaoFolhaDanoJdbc implements DaoFolhaDano {
    @Override
    public FolhaDano buscaFolhaDano(int codigo) throws BaseDadosException {
        return null;
    }

    @Override
    public void escreveFolhaDano(FolhaDano folhaDano) throws BaseDadosException {

    }

    @Override
    public void alteraFolhaDano(FolhaDano folhaDano) throws BaseDadosException {

    }

    @Override
    public List<FolhaDano> listaFolhaDano() throws BaseDadosException {
        return null;
    }

    @Override
    public List<FolhaDano> listaFolhaDanoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
