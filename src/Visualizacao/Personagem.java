package Visualizacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Personagem extends GerenciadorDeVisualizacao {

    private JFrame janelaPersonagem;
    private JPanel jPanelTelaPersonagem;
    private JButton jButtonSalvar, jButtonSalvarSair,jButtonLocal;
    private  TelaLocal local = CriaTelaLocal();
    
    private JTable tabelaInventario = new JTable(new DefaultTableModel(
                new Object[]{"Código", "Nome"},0));

    private JTable tabelaAtributos = new JTable(new DefaultTableModel(
                new Object[]{"FORÇA", "CONSTITUIÇÃO", "TAMANHO", "DESTREZA", "APARENCIA",
                    "INTELIGENCIA", "EDUCAÇÃO", "PODER", "MAX HP", "MAX MP", "HP ATUAL",
                    "MP ATUAL", "MOVIMENTO", "BONUS DANO CORPORAL", "BUILD", "IDADE"},0));;
    
    public Personagem() {
        super();
        Montar();
    }

    private void Montar() {
        setLayout(null);
       
        preparaJanela();
        preparaPainel();
        preparaInventarioPersonagem();
        preparaAtributosPersonagem();
        preparaBotaoSalvar();
        preparaBotaoSalvarSair();
        preparaBotaoLocal();
        //preparaImagemJogador();
        mostraJanela();

    }

    private void preparaJanela() {
        int largura = Toolkit.getDefaultToolkit().getScreenSize().width;
        janelaPersonagem = new JFrame("Personagem");
        janelaPersonagem.setResizable(false);
        janelaPersonagem.setLocation(largura - 1000, 150);
        janelaPersonagem.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void preparaPainel() {
        jPanelTelaPersonagem = new JPanel();
        jPanelTelaPersonagem.setLayout(null);
        jPanelTelaPersonagem.setBackground(java.awt.Color.LIGHT_GRAY);
        JLabel nome = new JLabel("Personagem");
        nome.setBounds(425, 0, 150, 50);
        jPanelTelaPersonagem.add(nome);
        janelaPersonagem.add(jPanelTelaPersonagem);

    }

    private void preparaInventarioPersonagem() {
        DefaultTableModel model = (DefaultTableModel) tabelaInventario.getModel();
        model.addRow(new Object[]{"CODIGO","NOME"});
        model.addRow(new Object[]{1, "Lapis"});
        model.addRow(new Object[]{2, "caneta"});
        model.addRow(new Object[]{3, "chave"});
        model.addRow(new Object[]{1, "Lapis"});
        model.addRow(new Object[]{2, "caneta"});
        model.addRow(new Object[]{3, "chave"});
        
        tabelaInventario.setBounds(20,75,500,200);
        jPanelTelaPersonagem.add(tabelaInventario);
        
    }

    private void preparaAtributosPersonagem() {
        DefaultTableModel model = (DefaultTableModel) tabelaAtributos.getModel();
        model.addRow(new Object[]{"FORÇA", "CONSTITUIÇÃO", "TAMANHO", "DESTREZA", "APARENCIA",
                    "INTELIGENCIA", "EDUCAÇÃO", "PODER", "MAX HP", "MAX MP", "HP ATUAL",
                    "MP ATUAL", "MOVIMENTO", "BONUS DANO CORPORAL", "BUILD", "IDADE"});
        model.addRow(new Object[]{20,12,20,35,45,60,75,3,40,40,40,40,37,1,1,19});
        
        tabelaAtributos.setBounds(25,300,950,100);
        jPanelTelaPersonagem.add(tabelaAtributos);
    }

    private void preparaBotaoSalvar() {
        jButtonSalvar = new JButton("Salvar");
        jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Salvar");

            }
        });
        jButtonSalvar.setBounds(800, 10, 150, 30);
        jPanelTelaPersonagem.add(jButtonSalvar);
    }

    private void preparaBotaoSalvarSair() {
        jButtonSalvarSair = new JButton("Salvar e Sair");
        jButtonSalvarSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Salvar e Sair");
                CriaTelaInicial();
                local.encerraJanela();
                janelaPersonagem.setVisible(false);
                
            }
        });
        jButtonSalvarSair.setBounds(800, 60, 150, 30);
        jPanelTelaPersonagem.add(jButtonSalvarSair);
    }
    private void preparaBotaoLocal(){
        jButtonLocal = new JButton("Abrir Local");
        jButtonLocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(local.isVisible()==false){
                    local.janelaLocal.setVisible(true);
               }
            }
        });
        jButtonLocal.setBounds(800,100,150,30);
        jPanelTelaPersonagem.add(jButtonLocal);
    }

    private void mostraJanela() {
        janelaPersonagem.pack();
        janelaPersonagem.setSize(1000, 500);
        janelaPersonagem.setVisible(true);
    }

    //Metodos Auxiliares
    private void clearTable(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
}
