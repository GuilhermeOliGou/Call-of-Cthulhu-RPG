package BaseDados;

import ElementosDeJogo.Itens.FolhaDano;

import java.util.List;

public interface DaoFolhaDano {
    //Busca uma Folha de Dano especifica no Banco de Dados e retorna suas descricoes.
    public FolhaDano BuscaFolhaDano(int codigo) throws BaseDadosException;

    //Registra uma Folha de Dano "generica" no Banco de Dados
    public void EscreveFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    //Modifica uma Folha de Dano "generica" ja existente.
    public void AlteraFolhaDano(FolhaDano folhaDano) throws BaseDadosException;

    //Lista todos as Folhas de Dano registradas no Banco de Dados.
    public List<FolhaDano> ListaFolhaDano() throws BaseDadosException;

    //Lista as Folhas de Dano de um dado Personagem (Seja um Jogador ou um NPC)
    public List<FolhaDano> ListaFolhaDanoPersonagem(int codigo) throws BaseDadosException;
}
