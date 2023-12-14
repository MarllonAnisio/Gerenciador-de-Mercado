package VIEW;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCompraProdutoFornecedor extends JFrame {

    private JComboBox<String> comboBoxFornecedores;
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;
    private JTextField campoQuantidade;

    public TelaCompraProdutoFornecedor() {
        super("Compra de Produtos de Fornecedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração do painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Compra de Produtos de Fornecedor"));

        // Configuração do JComboBox de fornecedores
        String[] fornecedores = {"Fornecedor A", "Fornecedor B", "Fornecedor C"};
        comboBoxFornecedores = new JComboBox<>(fornecedores);
        comboBoxFornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarProdutosPorFornecedor();
            }
        });
        comboBoxFornecedores.setBorder(BorderFactory.createEtchedBorder());

        // Configuração do JTextField de quantidade
        campoQuantidade = new JTextField();
        campoQuantidade.setPreferredSize(new Dimension(50, 25));
        campoQuantidade.setBorder(BorderFactory.createEtchedBorder());

        // Configuração da tabela de produtos
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Marca");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Tipo");
        modeloTabela.addColumn("Valor");
        modeloTabela.addColumn("Quantidade");

        tabelaProdutos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        // Configuração do botão comprar
        JButton botaoComprar = new JButton("Comprar");
        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarProduto();
            }
        });
        botaoComprar.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        // Configuração do layout
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(new JLabel("Fornecedor:"));
        painelTopo.add(comboBoxFornecedores);
        painelTopo.add(new JLabel("Quantidade:"));
        painelTopo.add(campoQuantidade);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoComprar);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarProdutosPorFornecedor() {
        // Aqui você pode adicionar a lógica para atualizar a tabela de produtos com base no fornecedor selecionado
        // Por exemplo, chamar um serviço para obter os produtos do fornecedor selecionado

        // Limpando a tabela
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        // Adicionando alguns dados fictícios para fins de demonstração
        modeloTabela.addRow(new Object[]{"Produto1", "Marca1", "Descrição1", "Tipo1", 10.0, 100});
        modeloTabela.addRow(new Object[]{"Produto2", "Marca2", "Descrição2", "Tipo2", 15.0, 50});
    }

    private void comprarProduto() {
        // Aqui você pode adicionar a lógica para realizar a compra do produto selecionado
        // Por exemplo, chamar um serviço para processar a compra

        String fornecedorSelecionado = (String) comboBoxFornecedores.getSelectedItem();
        String quantidadeStr = campoQuantidade.getText();

        // Validando a quantidade
        int quantidade = 0;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Por favor, insira um valor numérico.");
            return;
        }

        // Obtendo o produto selecionado na tabela (supondo que a primeira linha esteja selecionada)
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para comprar.");
            return;
        }

        String nomeProduto = (String) modeloTabela.getValueAt(linhaSelecionada, 0);

        JOptionPane.showMessageDialog(this, "Compra realizada: " +
                "Produto: " + nomeProduto +
                ", Fornecedor: " + fornecedorSelecionado +
                ", Quantidade: " + quantidade);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCompraProdutoFornecedor();
            }
        });
    }
}

