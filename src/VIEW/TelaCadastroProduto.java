package VIEW;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controler.FacadeLoja;
import DTO.DtoProduto;
import Model.TipoProduto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroProduto extends JFrame {

    private JTextField campoNomeProduto;
    private JTextField campoMarca;
    private JTextArea areaDescricao;
    private JComboBox<String> comboBoxTipo;
    private JTextField campoValor;
    private JTextField campoQuantidade;

    public TelaCadastroProduto() {
        super("Cadastro de Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(7, 2, 10, 10));
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Defina a cor de fundo do painel principal
        painelPrincipal.setBackground(new Color(173, 216, 230));

        JLabel rotuloNomeProduto = new JLabel("Nome do Produto:");
        campoNomeProduto = new JTextField();
        campoNomeProduto.setPreferredSize(new Dimension(200, 25));

        JLabel rotuloMarca = new JLabel("Marca:");
        campoMarca = new JTextField();
        campoMarca.setPreferredSize(new Dimension(200, 25));

        JLabel rotuloDescricao = new JLabel("Descrição:");
        areaDescricao = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaDescricao);
        scrollPane.setPreferredSize(new Dimension(200, 60));

        JLabel rotuloTipo = new JLabel("Tipo do Produto:");
        String[] tipos = {"ALIMENTOS", "BEBIDAS"," BEBIDAS_ALCOOLICAS" ,"MATERIAL_ESCOLAR HIGIENE"};
        comboBoxTipo = new JComboBox<>(tipos);
        comboBoxTipo.setPreferredSize(new Dimension(200, 25));

        JLabel rotuloValor = new JLabel("Valor:");
        campoValor = new JTextField();
        campoValor.setPreferredSize(new Dimension(200, 25));

        JLabel rotuloQuantidade = new JLabel("Quantidade:");
        campoQuantidade = new JTextField();
        campoQuantidade.setPreferredSize(new Dimension(200, 25));

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaAnterior();
            }
        });

        painelPrincipal.add(rotuloNomeProduto);
        painelPrincipal.add(campoNomeProduto);
        painelPrincipal.add(rotuloMarca);
        painelPrincipal.add(campoMarca);
        painelPrincipal.add(rotuloDescricao);
        painelPrincipal.add(scrollPane);
        painelPrincipal.add(rotuloTipo);
        painelPrincipal.add(comboBoxTipo);
        painelPrincipal.add(rotuloValor);
        painelPrincipal.add(campoValor);
        painelPrincipal.add(rotuloQuantidade);
        painelPrincipal.add(campoQuantidade);
        painelPrincipal.add(botaoVoltar);
        painelPrincipal.add(botaoCadastrar);

        JPanel painelWrapper = new JPanel(new BorderLayout());
        painelWrapper.add(painelPrincipal, BorderLayout.CENTER);
        painelWrapper.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(painelWrapper);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarProduto() {
        String nomeProduto = campoNomeProduto.getText();
        String marca = campoMarca.getText();
        String descricao = areaDescricao.getText();
        String tipo = (String) comboBoxTipo.getSelectedItem();
        String valor = campoValor.getText();
        String quantidade = campoQuantidade.getText();
        if(!nomeProduto.isEmpty() && !marca.isEmpty() && !descricao.isEmpty() && !tipo.isEmpty() && !quantidade.isEmpty()) {
        	double valorF = Double.parseDouble(valor);     
        	int qtd = Integer.parseInt(quantidade);        
        	DtoProduto produto = new DtoProduto(nomeProduto,valorF,marca,TipoProduto.valueOf(tipo),descricao,qtd);
        	FacadeLoja fachada = new FacadeLoja();
        	if(fachada.adicionarProdutoLoja(produto)) {
        		 campoNomeProduto.setText("");
        		 campoMarca.setText("");
        		 areaDescricao.setText("");
        		 campoValor.setText("");
        		 campoQuantidade.setText("");
        		 JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso ", "Produto cadastrado", 1);
        		 
        	}
        
        }
        else{
        	JOptionPane.showMessageDialog(null, "preencha os campos em branco", "ação impossivel", 2);
        }
    }

    private void voltarTelaAnterior() {
        // Feche a tela atual ao voltar para a tela anterior
        dispose();
        new TelaADM();
        
    }

}



