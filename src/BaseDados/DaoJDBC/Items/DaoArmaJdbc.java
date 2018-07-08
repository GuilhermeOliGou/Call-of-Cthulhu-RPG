package BaseDados.DaoJDBC.Items;

import BaseDados.BaseDadosException;
import BaseDados.Dao.Items.DaoArma;
import BaseDados.Dao.Items.DaoItem;
import BaseDados.Dao.Items.Utilidades.DaoFolhaDano;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesLutaItem;
import BaseDados.Dao.Items.Utilidades.DaoHabilidadesTiroItem;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;
import Utilidades.Log;

import java.sql.SQLException;

public class DaoArmaJdbc extends BancoDadosJdbc implements DaoArma {

    private DaoItem daoItem;
    private DaoFolhaDano daoFolhaDano;
    private DaoHabilidadesTiroItem daoHabilidadesTiro;
    private DaoHabilidadesLutaItem daoHabilidadesLuta;

    public DaoArmaJdbc(DaoItem daoItem, DaoFolhaDano daoFolhaDano, DaoHabilidadesLutaItem daoHabilidadesLuta, DaoHabilidadesTiroItem daoHabilidadesTiro) throws BaseDadosException{
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
            preparaComandoSQL("SELECT * FROM item_arma WHERE id_item = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Erro no acesso");
        }

        try{
            Arma arma = null;
            if(rs.next()) {

                HabilidadesTiro habilidadesTiro = daoHabilidadesTiro.Busca(codigo);
                HabilidadesLuta habilidadesLuta = daoHabilidadesLuta.Busca(codigo);
                FolhaDano folhaDano = daoFolhaDano.Busca(codigo);

                short usosRound = rs.getShort("usos_round");
                short tamanhoPente = rs.getShort("tamanho_pente");
                short malFuncionamento = rs.getShort("mal_funcionamento");

                fechaConexao();

                arma = new Arma(item.getId(), item.getNome(), item.getDescricao(), habilidadesTiro, habilidadesLuta,
                        folhaDano, usosRound, tamanhoPente,
                        malFuncionamento);
            }
            fechaConexao();
            return arma;
        }catch (SQLException e ){
            fechaConexao();
            Log.gravaLog(e);
            throw new BaseDadosException("Arma nao encontrado");
        }
    }
}
