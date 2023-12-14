package VIEW;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVendaProduto extends JFrame {

    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;
    private JTextField campoQuantidade;

    public TelaVendaProduto() {
        super("Venda de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração do painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Venda de Produtos"));

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

        // Configuração do botão vender
        JButton botaoVender = new JButton("Vender");
        botaoVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderProduto();
            }
        });
        botaoVender.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        // Configuração do layout
        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelTopo.add(new JLabel("Quantidade:"));
        painelTopo.add(campoQuantidade);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoVender);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void venderProduto() {
        // Aqui você pode adicionar a lógica para realizar a venda do produto selecionado
        // Por exemplo, chamar um serviço para processar a venda

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
            JOptionPane.showMessageDialog(this, "Selecione um produto para vender.");
            return;
        }

        String nomeProduto = (String) modeloTabela.getValueAt(linhaSelecionada, 0);

        JOptionPane.showMessageDialog(this, "Venda realizada: " +
                "Produto: " + nomeProduto +
                ", Quantidade: " + quantidade);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaVendaProduto();
            }
        });
    }
}
