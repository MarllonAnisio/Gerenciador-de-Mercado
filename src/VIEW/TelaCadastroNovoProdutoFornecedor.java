package VIEW;

import javax.swing.*;
import javax.swing.border.*;

import Controler.FacadeLoja;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.TipoProduto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroNovoProdutoFornecedor extends JFrame {

    private JTextField campoNomeProduto;
    private JTextField campoMarca;
    private JTextArea areaDescricao;
    private JComboBox<String> comboBoxTipoProduto;
    private JTextField campoValor;
    private JTextField campoQuantidade;
    private JTextField campoCnpj;

    public TelaCadastroNovoProdutoFornecedor() {
        super("Cadastro de Novo Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração do painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Cadastro de Novo Produto"));

        // Configuração dos componentes
        campoNomeProduto = new JTextField();
        campoMarca = new JTextField();
        areaDescricao = new JTextArea(5, 20);
        comboBoxTipoProduto = new JComboBox<>(new String[]{"ALIMENTOS", "BEBIDAS"," BEBIDAS_ALCOOLICAS" ,"MATERIAL_ESCOLAR HIGIENE"});
        campoValor = new JTextField();
        campoQuantidade = new JTextField();
        campoCnpj = new JTextField();

        // Configuração do JButton para cadastrar novo produto
        JButton botaoCadastrarNovoProduto = new JButton("Cadastrar Produto");
        botaoCadastrarNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarNovoProduto();
            }
        });
        botaoCadastrarNovoProduto.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        // Configuração do JButton para voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        botaoVoltar.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        // Configuração do layout
        JPanel painelFormulario = new JPanel(new GridLayout(7, 2, 10, 10));
        painelFormulario.add(new JLabel("Nome do Produto:"));
        painelFormulario.add(campoNomeProduto);
        painelFormulario.add(new JLabel("Marca:"));
        painelFormulario.add(campoMarca);
        painelFormulario.add(new JLabel("Descrição:"));
        painelFormulario.add(new JScrollPane(areaDescricao));
        painelFormulario.add(new JLabel("Tipo de Produto:"));
        painelFormulario.add(comboBoxTipoProduto);
        painelFormulario.add(new JLabel("Valor:"));
        painelFormulario.add(campoValor);
        painelFormulario.add(new JLabel("Quantidade:"));
        painelFormulario.add(campoQuantidade);
        painelFormulario.add(new JLabel("CNPJ (14 dígitos):"));
        painelFormulario.add(campoCnpj);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCadastrarNovoProduto);
        painelBotoes.add(botaoVoltar);

        painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarNovoProduto() {
        // Obtém os valores dos campos
        String nomeProduto = campoNomeProduto.getText();
        String marca = campoMarca.getText();
        String descricao = areaDescricao.getText();
        String tipoProduto = (String) comboBoxTipoProduto.getSelectedItem();
        String valorStr = campoValor.getText();
        String quantidadeStr = campoQuantidade.getText();
        String cnpj = campoCnpj.getText();

        // Validando CNPJ
        if (cnpj.length() != 14 || !cnpj.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "CNPJ inválido. Deve conter exatamente 14 dígitos numéricos.");
            return;
        }

        // Validando valores numéricos
        double valor = 0.0;
        int quantidade = 0;
        long Cn = Long.parseLong(cnpj);
        if(!nomeProduto.isEmpty() && !marca.isEmpty() && !descricao.isEmpty() && !tipoProduto.isEmpty() && !quantidadeStr.isEmpty()) {
        	valor = Double.parseDouble(valorStr);
            quantidade = Integer.parseInt(quantidadeStr);      
        	DtoProduto produto = new DtoProduto(nomeProduto,valor,marca,TipoProduto.valueOf(tipoProduto),descricao,quantidade);
        	FacadeLoja fachada = new FacadeLoja();
        	DtoUser user = new DtoUser(Cn, 0);
        	if(fachada.criarProdutoFornecedor(produto, user)) {
        		 JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso ", "Produto cadastrado", 2);
        		 
        	}
        
        }
        JOptionPane.showMessageDialog(null, "preencha os campos em branco", "ação impossivel", 2);
    }

    private void voltar() {
    	  dispose();
    	  new TelaADM();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroNovoProdutoFornecedor());
    }
}
