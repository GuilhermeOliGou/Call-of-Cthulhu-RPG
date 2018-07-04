package BaseDados.DaoJDBC;

import BaseDados.BaseDadosException;
import BaseDados.DaoFactory_Teste.*;
import DTO.Itens.Arma;
import DTO.Itens.FolhaDano;
import DTO.Itens.Item;
import DTO.Personagens.SetsDeHabilidade.HabilidadesLuta;
import DTO.Personagens.SetsDeHabilidade.HabilidadesTiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

public class DaoArmaJdbc extends BancoDadosJdbc implements DaoArma {

    DaoItem daoItem;
    DaoFolhaDano daoFolhaDano;
    DaoHabilidadesTiro daoHabilidadesTiro;
    DaoHabilidadesLuta daoHabilidadesLuta;

    public DaoArmaJdbc(DaoItem daoItem, DaoFolhaDano daoFolhaDano, DaoHabilidadesLuta daoHabilidadesLuta, DaoHabilidadesTiro daoHabilidadesTiro)throws Exception{
        super();
        this.daoItem = daoItem;
        this.daoFolhaDano = daoFolhaDano;
        this.daoHabilidadesTiro = daoHabilidadesTiro;
        this.daoHabilidadesLuta = daoHabilidadesLuta;
    }

    @Override
    public Arma Busca(int codigo) throws BaseDadosException {
        Item item = daoItem.Busca(codigo);
        HabilidadesTiro habilidadesTiro = daoHabilidadesTiro.Busca(codigo);
        HabilidadesLuta habilidadesLuta = daoHabilidadesLuta.Busca(codigo);
        FolhaDano folhaDano = daoFolhaDano.Busca(codigo);
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
            rs.next();
            Arma arma = new Arma(item.getId(), item.getNome(), item.getDescricao(), habilidadesTiro, habilidadesLuta,
                    folhaDano, rs.getShort("usos_round"), rs.getShort("tamanho_pente"),
                    rs.getShort("mal_funcionamento"));
            fechaConexao();
            return arma;
        }catch (SQLException e ){
            fechaConexao();
            throw new BaseDadosException("Arma nao encontrado");
        }
    }

    @Override
    public void Insere(Arma arma) throws BaseDadosException {
        daoItem.Insere(arma);
        daoHabilidadesLuta.Insere(arma.getHabilidadesUsadasLuta());
        daoHabilidadesTiro.Insere(arma.getHabilidadesUsadasTiro());
        daoFolhaDano.Insere(arma.getDano());

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
    }

    @Override
    public void Altera(Arma arma) throws BaseDadosException {
        daoItem.Altera(arma);
        daoHabilidadesTiro.Altera(arma.getHabilidadesUsadasTiro());
        daoHabilidadesLuta.Altera(arma.getHabilidadesUsadasLuta());
        daoFolhaDano.Altera(arma.getDano());

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

    }

    public void Remove(int codigo) throws BaseDadosException{
        daoItem.Remove(codigo);
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

    }

    @Override
    public List<Arma> Lista() throws BaseDadosException {
        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM arma LEFT JOIN item ON arma.id_item = item.id_item WHERE item.tipo_item = Arma");
            ps.executeQuery();
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
        /*
        List<HabilidadesTiro> listaHabilidadesTiro = daoHabilidadesTiro.Lista();
        List<HabilidadesLuta> listaHabilidadesLuta = daoHabilidadesLuta.Lista();
        List<FolhaDano> listaFolhaDano = daoFolhaDano.Lista();

        abreConexao();
        try {
            preparaComandoSQL("SELECT * FROM arma LEFT JOIN item ON arma.id_item = item.id_item WHERE item.tipo_item = Arma");
            ps.executeQuery();
        }
        catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        ArrayList<Arma> armas = new ArrayList<>();
        try{
            while(rs.next()){
                for(HabilidadesTiro tiro : listaHabilidadesTiro){
                    if(tiro.getId() == rs.getInt("id_item")){
                        for(HabilidadesLuta luta : listaHabilidadesLuta){
                            if(luta.getId() == rs.getInt("id_item")){
                                for(FolhaDano folhaDano : listaFolhaDano){
                                    if(folhaDano.getId() == rs.getInt("id_item")){
                                        Arma arma = new Arma(rs.getInt("id_item"), rs.getString("nome_arma"), rs.getString("descricao_arma"), tiro, luta, folhaDano, rs.getShort("usos_round"), rs.getShort("tamanho_pente"), rs.getShort("mal_funcionamento"));
                                        armas.add(arma);
                                        listaFolhaDano.remove(folhaDano);
                                    }

                                }
                               listaHabilidadesLuta.remove(luta);
                            }

                        }
                    }
                }
            }
            fechaConexao();
            return armas;
        }catch (SQLException e){
            fechaConexao();
            throw new BaseDadosException("Erro no acesso");
        }
        */
    }

    @Override
    public List<Arma> ListaDoPersonagem(int codigo) throws BaseDadosException {

    }
}
