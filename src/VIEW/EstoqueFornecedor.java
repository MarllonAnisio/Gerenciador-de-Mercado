package VIEW;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstoqueFornecedor extends JFrame {

    private JComboBox<String> comboBoxFornecedores;
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;

    public EstoqueFornecedor() {
        super("Cadastro de Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração do painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Cadastro de Produto"));

        // Configuração do JComboBox de fornecedores
        String[] fornecedores = {"Fornecedor A", "Fornecedor B", "Fornecedor C"};
        comboBoxFornecedores = new JComboBox<>(fornecedores);
        comboBoxFornecedores.setBorder(BorderFactory.createEtchedBorder());

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

        // Configuração do botão cadastrar novo produto
        JButton botaoCadastrarNovo = new JButton("Cadastrar Novo Produto");
        botaoCadastrarNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarNovoProduto();
            }
        });
        botaoCadastrarNovo.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        // Configuração do layout
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTopo.add(new JLabel("Fornecedor:"));
        painelTopo.add(comboBoxFornecedores);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCadastrarNovo);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarNovoProduto() {
        // Aqui você pode adicionar a lógica para cadastrar o produto no sistema
        // Por exemplo, chamar um serviço de cadastro, salvar em um banco de dados, etc.

        // Obtém os valores selecionados no JComboBox e adiciona uma nova linha na tabela
        String fornecedorSelecionado = (String) comboBoxFornecedores.getSelectedItem();
        modeloTabela.addRow(new Object[]{"Novo Produto", "Marca", "Descrição", "Tipo", 0.0, 0});

        JOptionPane.showMessageDialog(this, "Novo produto cadastrado para o fornecedor: " + fornecedorSelecionado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EstoqueFornecedor();
            }
        });
    }
}

