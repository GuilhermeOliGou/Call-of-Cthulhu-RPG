package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.*;
import BaseDados.Dao.Items.Utilidades.DaoFolhaDano;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesLutaItem;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesTiroItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoArmaJdbc extends BancoDadosJdbc implements DaoArma {

    private DaoItem daoItem;
    private DaoFolhaDano daoFolhaDano;
    private DaoHabilidadesTiroItem daoHabilidadesTiro;
    private DaoHabilidadesLutaItem daoHabilidadesLuta;

    public DaoArmaJdbc(DaoItem daoItem, DaoFolhaDano daoFolhaDano, DaoHabilidadesLutaItem daoHabilidadesLuta, DaoHabilidadesTiroItem daoHabilidadesTiro) throws Exception{
        super();
        this.daoItem = daoItem;
        this.daoFolhaDano = daoFolhaDano;
        this.daoHabilidadesTiro = daoHabilidadesTiro;
        this.daoHabilidadesLuta = daoHabilidadesLuta;
    }

    @Override
    public Arma Busca(int codigo) throws BaseDadosException {
        Item item = daoItem.Busca(codigo);

        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM arma WHERE id_item = ?");
            ps.setInt(1, codigo);
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            if(rs.next()) {

                HabilidadesTiro habilidadesTiro = daoHabilidadesTiro.Busca(codigo);
                HabilidadesLuta habilidadesLuta = daoHabilidadesLuta.Busca(codigo);
                FolhaDano folhaDano = daoFolhaDano.Busca(codigo);

                Arma arma = new Arma(item.getId(), item.getNome(), item.getDescricao(), habilidadesTiro, habilidadesLuta,
                        folhaDano, rs.getShort("usos_round"), rs.getShort("tamanho_pente"),
                        rs.getShort("mal_funcionamento"));
                fechaConexao();
                return arma;
            }

        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Arma nao encontrado");
        }
        return null;
    }

    @Override
    public void Insere(Arma arma) throws BaseDadosException {
        daoItem.Insere(arma);

        abreConexao();
        try{
            preparaComandoSQL("INSERT INTO arma (usos_round, tamanho_pente, mal_funcionamento, nome) VALUES (?, ?, ?) SELECT nome FROM item WHERE item.item_nome = ?");
            ps.setShort(1, arma.getUsosPorRound());
            ps.setShort(2, arma.getTamanhoDoPente());
            ps.setShort(3, arma.getMalFuncionamento());
            ps.setString(4, arma.getNome());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel adicionar Arma");
        }

        daoHabilidadesLuta.Insere(arma);
        daoHabilidadesTiro.Insere(arma);
        daoFolhaDano.Insere(arma);

    }

    @Override
    public void Altera(Arma arma) throws BaseDadosException {
        daoItem.Altera(arma);

        abreConexao();
        try{
            preparaComandoSQL("UPDATE arma SET usos_round = ?, tamanho_pente = ?, mal_funcionamento = ? WHERE id_item = ?");
            ps.setShort(1, arma.getUsosPorRound());
            ps.setShort(2, arma.getTamanhoDoPente());
            ps.setShort(3, arma.getMalFuncionamento());
            ps.setInt(4, arma.getId());
            ps.execute();
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel modificar Arma");
        }

        daoHabilidadesTiro.Altera(arma);
        daoHabilidadesLuta.Altera(arma);
        daoFolhaDano.Altera(arma);

    }
    @Override
    public void Remove(int codigo) throws BaseDadosException{

        daoHabilidadesTiro.Remove(codigo);
        daoHabilidadesLuta.Remove(codigo);
        daoFolhaDano.Remove(codigo);

        abreConexao();
        try{
            preparaComandoSQL("DELETE FROM arma WHERE id.item = ?");
            ps.setInt(1, codigo);
            ps.execute();
        }catch(SQLException e){
            throw new BaseDadosException("Não foi possível remover a Arma");
        }
        daoItem.Remove(codigo);
    }

    @Override
    public List<Arma> Lista() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM arma LEFT JOIN item ON arma.id_item = item.id_item WHERE item.tipo_item = Arma");
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Arma> armas = new ArrayList<>();
        try {
            while (rs.next()) {
                HabilidadesTiro habilidadesTiro = daoHabilidadesTiro.Busca(rs.getInt("id_item"));
                HabilidadesLuta habilidadesLuta = daoHabilidadesLuta.Busca(rs.getInt("id_item"));
                FolhaDano folhaDano = daoFolhaDano.Busca(rs.getInt("id_item"));

                Arma arma = new Arma(rs.getInt("id_item"), rs.getString("nome_item"),
                        rs.getString("descricao_item"), habilidadesTiro, habilidadesLuta, folhaDano,
                        rs.getShort("usos_round"), rs.getShort("tamanho_pente"),
                        rs.getShort("mal_funcionamento"));
                armas.add(arma);
            }
            return armas;
        }
        catch(SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no aceeso ao BD");
        }
    }

    @Override
    public List<Arma> ListaDoPersonagem(int codigo) throws BaseDadosException {
        return null;
    }
}
