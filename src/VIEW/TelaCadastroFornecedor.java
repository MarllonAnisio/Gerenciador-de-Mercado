package VIEW;

import javax.swing.*;
import javax.swing.border.*;

import Controler.FacadeLoja;
import DTO.DtoUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroFornecedor extends JFrame {

    private JTextField campoNomeFornecedor;
    private JTextField campoCNPJ;
    private JTextField campoCidade;
    private JTextArea areaDescricao;

    public TelaCadastroFornecedor() {
        super("Cadastro de Fornecedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Cadastro de Fornecedor"));

        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel rotuloNomeFornecedor = new JLabel("Nome do Fornecedor:");
        campoNomeFornecedor = new JTextField();
        campoNomeFornecedor.setPreferredSize(new Dimension(300, 25));
        campoNomeFornecedor.setBorder(BorderFactory.createEtchedBorder());

        JLabel rotuloCNPJ = new JLabel("CNPJ:");
        campoCNPJ = new JTextField();
        campoCNPJ.setPreferredSize(new Dimension(300, 25));
        campoCNPJ.setBorder(BorderFactory.createEtchedBorder());

        JLabel rotuloCidade = new JLabel("Cidade:");
        campoCidade = new JTextField();
        campoCidade.setPreferredSize(new Dimension(300, 25));
        campoCidade.setBorder(BorderFactory.createEtchedBorder());

        JLabel rotuloDescricao = new JLabel("Descrição:");
        areaDescricao = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaDescricao);
        scrollPane.setPreferredSize(new Dimension(300, 60));
        areaDescricao.setBorder(BorderFactory.createEtchedBorder());

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFornecedor();
            }
        });
        botaoCadastrar.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

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

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        painelPrincipal.add(rotuloNomeFornecedor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelPrincipal.add(campoNomeFornecedor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(rotuloCNPJ, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelPrincipal.add(campoCNPJ, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(rotuloCidade, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        painelPrincipal.add(campoCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(rotuloDescricao, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        painelPrincipal.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        painelPrincipal.add(botaoCadastrar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        painelPrincipal.add(botaoVoltar, gbc);

        JPanel painelWrapper = new JPanel(new BorderLayout());
        painelWrapper.add(painelPrincipal, BorderLayout.CENTER);
        painelWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(painelWrapper);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarFornecedor() {
        String nomeFornecedor = campoNomeFornecedor.getText();
        String cnpj = campoCNPJ.getText();
        String cidade = campoCidade.getText();
        String descricao = areaDescricao.getText();
        if (!nomeFornecedor.isEmpty() && !cnpj.isEmpty() && !cidade.isEmpty() && !descricao.isEmpty()) {
             FacadeLoja loja = new FacadeLoja();
             long cnpj1 = Long.parseLong(cnpj);
             DtoUser user = new DtoUser(nomeFornecedor, cnpj1 ,0,descricao,cidade);
             if(loja.criarFornecedor(user)) {
            	 campoNomeFornecedor.setText("");
            	 campoCNPJ.setText("");
             	 campoCidade.setText("");
             	 areaDescricao.setText("");
             	 JOptionPane.showMessageDialog(null, "fornecedor  foi cadastrado ", "sucesso", 2);
             		
             }
             else{
             	JOptionPane.showMessageDialog(null, "fornecedor ja existe", " produto ja existente", 2);
             	}
             
             }else {
            	 JOptionPane.showMessageDialog(null, "preencha todos os campos ", "erro de campo", 2);
             }
            
         }
        
    private void voltar() {
       dispose();
       new TelaADM();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroFornecedor();
            }
        });
    }
}


