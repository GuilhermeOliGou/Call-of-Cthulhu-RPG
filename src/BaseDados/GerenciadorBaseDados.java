/*
package BaseDados;

import ElementosDeJogo.Itens.ArmaDeFogo;
import ElementosDeJogo.Itens.Item;
import ElementosDeJogo.Itens.ItemChave;
import ElementosDeJogo.Itens.ItemConsumivel;
import ElementosDeJogo.Personagens.Jogador;
import ElementosDeJogo.Sistema.Eventos.Evento;
import ElementosDeJogo.Sistema.Local;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorBaseDados extends ConectorBaseDados {

    private static final String PASSWORD = "gvm507713";
    private static final String USER = "voull_";
    private static final String HOST = "db4free.net:3306";
    private static final String DB_NAME = "coo_ep";

    public GerenciadorBaseDados() {
        super();
    }

    @Override
    protected String getDbHost() {
        return HOST;
    }

    @Override
    protected String getDbName() {
        return DB_NAME;
    }

    @Override
    protected String getUser() {
        return USER;
    }

    @Override
    protected String getPassword() {
        return PASSWORD;
    }


    public void criaJogador(Jogador jogador)throws BaseDadosException{
        try{
            abreConexao();
            geraComandoSQL("INSERT INTO Jogadores (nomeJogador, descricaoJogador) values (?, ?)");
            ps.setString(1, jogador.getNome());
            ps.setString(2, jogador.getJogadorDescricao());
            ps.execute();
            fechaConexao();
        }catch(Exception e){
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
    }
    public List<Jogador> listaJogadores() throws Exception{
        ArrayList<Jogador> jogadores = new ArrayList<>();

        try {
            abreConexao();
            geraComandoSQL("SELECT * FROM Jogadores");
            rs = ps.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador(rs.getInt("idJogador"), rs.getString("nomeJogador"), rs.getString("jogadorDescricao"));
                jogadores.add(jogador);
                fechaConexao();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
        fechaConexao();

        return jogadores;
    }
    public Jogador carregaJogo(int jogadorID) throws Exception {
        Jogador jogador = null;
        abreConexao();
        geraComandoSQL("SELECT * FROM Jogadores LEFT JOIN Atributes WHERE idJogador = ?");
        try {
            ps.setInt(1, jogadorID);
            rs = ps.executeQuery();
            if(!rs.next()) throw new Exception();
            jogador = new Jogador(rs.getInt("idJogador"),
                    rs.getShort("forca"), rs.getShort("constituicao"),
                    rs.getShort("tamanho"), rs.getShort("destreza"),
                    rs.getShort("aparencia"),
                    rs.getShort("inteligencia"), rs.getShort("educacao"),
                    rs.getShort("poder"), rs.getShort("idade"), rs.getString("nomeJogador"),
                    rs.getShort("maxHP"), rs.getShort("maxMP"), rs.getShort("movimento"),
                    rs.getShort("bonusDeDanoCorporal"), rs.getShort("build"),
                    rs.getShort("sorte"), rs.getInt("ultimoLocal"));
            fechaConexao();
            jogador.setInventario(carregaItems(jogador.getId()));
        }catch(Exception e){
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
        return jogador;
    }

    private ArrayList<Item> carregaItems(int idJogador) throws Exception{
        ArrayList<Item> inventario = new ArrayList<>();
        abreConexao();
        geraComandoSQL("SELECT * FROM Item LEFT JOIN ListaItem on Item.itemID WHERE idJogador = 1");
        try{
            ps.setInt(1, idJogador);
            rs = ps.executeQuery();
            while(rs.next()){
                Item item = null;
                switch (rs.getString("tipoItem")) {
                    case "ArmaDeFogo":
                        item = new ArmaDeFogo(rs.getInt("itemID"), rs.getString("itemNome"),
                                rs.getString("itemDescricao"), 0, rs.getShort("itemDano"),
                                rs.getInt("itemAlcance"), rs.getShort("itemUsos"),
                                rs.getInt("itemPreco"), rs.getShort("itemFuncAtual"),
                                rs.getShort("itemMunicao"));
                        break;
                    case "ItemChave":
                        item = new ItemChave(rs.getInt("itemID"), rs.getString("itemNome"),
                                rs.getString("itemDescricao"));
                        break;
                    case "ItemConsumivel":
                        item = new ItemConsumivel(rs.getInt("itemID"), rs.getString("itemNome"),
                                rs.getString("itemDescricao"), rs.getShort("itemQntd"));
                        break;
                }
                inventario.add(item);
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
        fechaConexao();
        return inventario;
    }
    public Local carregaLocal(int idJogador, int idLocal)throws Exception{
        Local local = null;
        LinkedList<Evento> eventos = new LinkedList<>();
        abreConexao();
        geraComandoSQL("SELECT * FROM EVENTOS WHERE idJogador = ? AND idLocal = ?");
        String nomeLocal = null;
        try{
            ps.setInt(1, idJogador);
            ps.setInt(2, idLocal);
            rs = ps.executeQuery();
            if(!rs.next()) throw new Exception();
            nomeLocal = rs.getString("nomeLocal");
            idLocal = rs.getInt("idLocal");
            do{
                Evento evento = new Evento(rs.getInt("idLocal"), rs.getString("nomeEvento"), rs.getString("descricaoSucesso"),
                        rs.getString("descricaoFalha"), rs.getInt("idLocalRetorno"),
                        null, rs.getBoolean("eventoUnico"),
                        rs.getInt("qntTrigger"));
                eventos.add(evento);
            }while(rs.next());
            local = new Local(idLocal, nomeLocal, true, eventos);
        }catch(Exception e){
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
        return local;
    }

    public void salvaJogo(Jogador jogador, Local local) throws Exception{
        salvaJogador(jogador);
        salvaLocal(local, jogador.getId());
    }
    public void salvaLocal(Local local, int idJogador) throws BaseDadosException {
        try{
            for(Evento evento : local.getEventosDisponíveis()){
                abreConexao();
                geraComandoSQL("UPDATE Eventos SET qntTrigger = ? WHERE idJogador = ? AND idLocal = ?");
                ps.setInt(1, evento.getEventoRealizado());
                ps.setInt(2, idJogador);
                ps.setInt(3, local.getId());
                ps.execute();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
    }
    public void salvaJogador(Jogador jogador) throws Exception{
        abreConexao();
        try {
            geraComandoSQL("UPDATE Atributos SET forca = ?, constituicao = ?, tamanho = ?, destreza = ?, aparencia = ?, " +
                    "inteligencia = ?, educacao = ?, poder = ?, idade = ?, maxHP = ? maxMP = ?, movimento = ?, " +
                    "bonusDanoCorporal = ?, build = ?, sorte = ?, localidadeAtual = ?, hpAtual = ?, mpAtual = ? WHERE idJogador = ?");
            ps.setShort(1, jogador.getForca());
            ps.setShort(2, jogador.getConstituicao());
            ps.setShort(3, jogador.getTamanho());
            ps.setShort(4, jogador.getDestreza());
            ps.setShort(5, jogador.getAparencia());
            ps.setShort(6, jogador.getInteligencia());
            ps.setShort(7, jogador.getEducacao());
            ps.setShort(8, jogador.getPoder());
            ps.setShort(9, jogador.getIdade());
            ps.setShort(10, jogador.getMaxHp());
            ps.setShort(11, jogador.getMovimento());
            ps.setShort(12, jogador.getBonusDeDanoCorporal());
            ps.setShort(13, jogador.getBuild());
            ps.setInt(14, jogador.getLocalidadeAtual());
            ps.setShort(15, jogador.getHpAtual());
            ps.setShort(16, jogador.getMpAtual());
            ps.setInt(17, jogador.getId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseDadosException("Problemas no Banco de Dados");
        }
    }
}
*/