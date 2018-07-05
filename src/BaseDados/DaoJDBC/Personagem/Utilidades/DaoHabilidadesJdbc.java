package BaseDados.DaoJDBC.Personagem.Utilidades;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Personagem.Utilidades.DaoHabilidades;
import BaseDados.Dao.Personagem.Utilidades.DaoHabilidadesLutaJogador;
import BaseDados.Dao.Personagem.Utilidades.DaoHabilidadesTiroJogador;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;

import java.io.IOException;
import java.sql.SQLException;

public class DaoHabilidadesJdbc extends BancoDadosJdbc implements DaoHabilidades {

    private DaoHabilidadesTiroJogador daoTiro;
    private DaoHabilidadesLutaJogador daoLuta;

    public DaoHabilidadesJdbc(DaoHabilidadesLutaJogador daoLuta, DaoHabilidadesTiroJogador daoTiro) throws IOException {
        super();
        this.daoLuta = daoLuta;
        this.daoTiro = daoTiro;
    }

    @Override
    public FolhaDeHabilidades Busca(int codigo) throws BaseDadosException {

        daoLuta.Busca(codigo);
        daoTiro.Busca(codigo);


        abreConexao();
        preparaComandoSQL("SELECT * FROM folha_habilidades WHERE id_jogador = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar a Busca Folha Habilidades");
        }

        return null;
    }

    @Override
    public void Insere(Personagem personagem) throws BaseDadosException {

        daoTiro.Insere(personagem);
        daoLuta.Insere(personagem);

        Jogador jogador = (Jogador) personagem;
        FolhaDeHabilidades habilidades = jogador.getHabilidades();

        abreConexao();
        preparaComandoSQL("INSERT INTO folha_habilidades (mitos_cthulhu, id_jogador) VALUES (?, ?)");

        try {
            ps.setShort(1, habilidades.getMitosDeCthulhu());
            ps.setInt(2, jogador.getId());
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Folha Habilidades");
        }
    }

    @Override
    public void Altera(Personagem personagem) throws BaseDadosException {

        daoTiro.Altera(personagem);
        daoLuta.Altera(personagem);

        Jogador jogador = (Jogador) personagem;
        FolhaDeHabilidades habilidades = jogador.getHabilidades();

        abreConexao();
        preparaComandoSQL("UPDATE folha_habilidades SET mitos_cthulhu = ? WHERE id_jogador = ?");

        try {
            ps.setShort(1, habilidades.getMitosDeCthulhu());
            ps.setInt(2, jogador.getId());
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Folha Habilidades");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {

        daoLuta.Remove(codigo);
        daoTiro.Remove(codigo);

        abreConexao();
        preparaComandoSQL("DELETE * FROM folha_habilidades WHERE id_jogador = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel remover Habilidades Tiro, verifique se o Jogador enviado eh valido");
        }
    }
}
