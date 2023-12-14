package VIEW;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import Controler.FacadeLoja;
import Model.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaListaProdutos extends JFrame {
	FacadeLoja fachada = new FacadeLoja();
	ArrayList<Produto> produtos = fachada.retornaProdutos();
   
			
	private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;

    public TelaListaProdutos() {
        super("Lista de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));

        // Configuração da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Marca");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Tipo");
        modeloTabela.addColumn("Valor");
        modeloTabela.addColumn("Quantidade");

        preencherTabela();

        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        JButton botaoCadastrarNovo = new JButton("Cadastrar Novo Produto");
        botaoCadastrarNovo.addActionListener(e -> abrirTelaCadastroProduto());
        botaoCadastrarNovo.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaAnterior();
            }
        });

        painelPrincipal.add(scrollPane, BorderLayout.CENTER);
        painelPrincipal.add(botaoCadastrarNovo, BorderLayout.SOUTH);
        painelPrincipal.add(botaoVoltar, BorderLayout.NORTH);

        JPanel painelWrapper = new JPanel(new BorderLayout());
        painelWrapper.add(painelPrincipal, BorderLayout.CENTER);
        painelWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(painelWrapper);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherTabela() {
        for (Produto produto : produtos) {
            Object[] linha = {
                    produto.getNameProduto(),
                    produto.getNomeMarca(),
                    produto.getDescricao(),
                    produto.getTipoDoProduto(),
                    produto.getValorProduto(),
                    produto.getQtdProdutos()
            };
            modeloTabela.addRow(linha);
        }
    }
    private void abrirTelaCadastroProduto() {
    	dispose();
    	new TelaCadastroProduto();
    }

    private void voltarTelaAnterior() {
        dispose();
        new TelaADM();
        
    }

    public static void main(String[] args) {
        new TelaListaProdutos();
      
    	
    }
}

