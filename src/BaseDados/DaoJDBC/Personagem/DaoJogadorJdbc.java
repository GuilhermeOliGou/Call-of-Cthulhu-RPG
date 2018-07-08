package BaseDados.DaoJDBC.Personagem;

import BaseDados.BaseDadosException;
import BaseDados.Dao.DaoHabilidadeRequerida;
import BaseDados.Dao.Personagem.DaoInventario;
import BaseDados.Dao.Personagem.DaoJogador;
import BaseDados.Dao.Personagem.DaoPersonagem;
import BaseDados.Dao.Personagem.Utilidades.DaoHabilidades;
import BaseDados.DaoJDBC.BancoDadosJdbc;
import DTO.Itens.Item;
import DTO.Personagens.FolhaDeAtributos;
import DTO.Personagens.FolhaDeHabilidades;
import DTO.Personagens.Jogador;
import DTO.Personagens.Personagem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoJogadorJdbc extends BancoDadosJdbc implements DaoJogador {

    private DaoPersonagem daoPersonagem;
    private DaoInventario daoInventario;


    public DaoJogadorJdbc(DaoPersonagem daoPersonagem, DaoInventario daoInventario) throws Exception{
        super();
        this.daoPersonagem = daoPersonagem;
        this.daoInventario = daoInventario;
    }

    @Override
    public Jogador Busca(int codigo) throws BaseDadosException {

        abreConexao();
        preparaComandoSQL("SELECT * FROM jogador WHERE id_personagem = ?");

        try {
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel Buscar Jogador");
        }

        try {
            Jogador jogador = null;
            if(rs.next()){
                short maxSanidade = rs.getShort("max_sanidade");
                short sanidadeAtual = rs.getShort("sanidade_atual");
                short sorte = rs.getShort("sorte");

                Personagem personagem = daoPersonagem.Busca(codigo);

                String nome = personagem.getNome();
                short idade = personagem.getIdade();
                int ultimoLocal = personagem.getLocalidadeAtual();
                FolhaDeAtributos atributos = jogador.getAtributos();

                List<Integer[]> inventario = daoInventario.Busca(codigo);

                jogador = new Jogador(codigo, atributos, idade, nome, ultimoLocal, maxSanidade, sanidadeAtual, sorte, inventario.get(0), inventario.get(1));

            }
            return jogador;
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encontar Jogador");
        }
    }

    @Override
    public void Insere(Jogador jogador) throws BaseDadosException {
        daoPersonagem.Insere(jogador);

        daoInventario.Insere(jogador);


        short maxSanidade = jogador.getMaxSanidade();
        short sanidadeAtual = jogador.getSanidadeAtual();
        short sorte = jogador.getSorte();
        int id = jogador.getId();


        abreConexao();
        preparaComandoSQL("INSERT INTO jogador (max_sanidade, sanidade_atual, sorte, id_personagem) VALUES (?, ?, ?, ?)");

        try {
            ps.setShort(1, maxSanidade);
            ps.setShort(2, sanidadeAtual);
            ps.setShort(3, sanidadeAtual);
            ps.setInt(4, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Jogador");
        }
    }

    @Override
    public void Altera(Jogador jogador) throws BaseDadosException {
        daoPersonagem.Altera(jogador);

        daoInventario.Altera(jogador);


        short maxSanidade = jogador.getMaxSanidade();
        short sanidadeAtual = jogador.getSanidadeAtual();
        short sorte = jogador.getSorte();
        int id = jogador.getId();


        abreConexao();
        preparaComandoSQL("UPDATE jogador SET max_sanidade = ?, sanidade_atual = ?, sorte = ? WHERE id_personagem = ?");

        try {
            ps.setShort(1, maxSanidade);
            ps.setShort(2, sanidadeAtual);
            ps.setShort(3, sanidadeAtual);
            ps.setInt(4, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel inserir Jogador");
        }
    }

    @Override
    public void Remove(int codigo) throws BaseDadosException {
        daoInventario.Remove(codigo);


        abreConexao();
        preparaComandoSQL("DELETE FROM jogador WHERE id_personagem = ?");

        try{
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (SQLException e ){
            throw new BaseDadosException("Nao foi possivel remover Jogador");

        }
        daoPersonagem.Remove(codigo);
    }

    @Override
    public List<Jogador> Lista() throws BaseDadosException {
        abreConexao();
        preparaComandoSQL("SELECT * FROM jogador");

        try{
            rs = ps.executeQuery();

        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel realizar Lista Jogadores");
        }

        try {
            List<Jogador> jogadores = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id_personagem");
                short maxSanidade = rs.getShort("max_sanidade");
                short sanidadeAtual = rs.getShort("sanidade_atual");
                short sorte = rs.getShort("sorte");

                Personagem personagem = daoPersonagem.Busca(id);

                String nome = personagem.getNome();
                short idade = personagem.getIdade();
                int ultimoLocal = personagem.getLocalidadeAtual();
                FolhaDeAtributos atributos = personagem.getAtributos();


                List<Integer[]> inventario = daoInventario.Busca(id);

               Jogador jogador = new Jogador(id, atributos, idade, nome, ultimoLocal, maxSanidade, sanidadeAtual, sorte, inventario.get(0), inventario.get(1));

                jogadores.add(jogador);
            }
            if(jogadores.size() == 0) return null;
            return jogadores;
        }catch (SQLException e){
            throw new BaseDadosException("Nao foi possivel encrontrar Lista Jogadores");
        }

    }


}
