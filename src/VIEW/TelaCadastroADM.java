package VIEW;

import javax.swing.*;
import javax.swing.border.*;

import Controler.FacadeLoja;
import DTO.DtoUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TelaCadastroADM extends JFrame {

    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaCadastroADM() {
        super("Cadastro de ADM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);
        OuvinteDoLogin ouvinte = new OuvinteDoLogin();
        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Cadastro de ADM"));

        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(300, 25));
        campoNome.setBorder(BorderFactory.createEtchedBorder());

        JLabel rotuloEmail = new JLabel("Email:");
        campoEmail = new JTextField();
        campoEmail.setPreferredSize(new Dimension(300, 25));
        campoEmail.setBorder(BorderFactory.createEtchedBorder());

        JLabel rotuloSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField();
        campoSenha.setPreferredSize(new Dimension(300, 25));
        campoSenha.setBorder(BorderFactory.createEtchedBorder());

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(ouvinte);
        botaoVoltar.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(ouvinte);
        botaoCadastrar.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 15, 5, 15)
        ));
        
       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        painelPrincipal.add(rotuloNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelPrincipal.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(rotuloEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelPrincipal.add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(rotuloSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        painelPrincipal.add(campoSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2; // Span across both columns
        painelPrincipal.add(botaoVoltar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painelPrincipal.add(botaoCadastrar, gbc);

        JPanel painelWrapper = new JPanel(new BorderLayout());
        painelWrapper.add(painelPrincipal, BorderLayout.CENTER);
        painelWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(painelWrapper);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void windowClosing(ActionEvent clique) {
    	
    	int escolha = JOptionPane.showConfirmDialog((JFrame) this, "Voltar para a tela de AdM?", "Fechar Janela",
    			JOptionPane.YES_NO_OPTION);
    	
    	if (escolha == JOptionPane.YES_OPTION) {
    		dispose();
    		new TelaLoginADM();
    		
    	}
    }

    private void cadastrarADM() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        char[] senhaChars = campoSenha.getPassword();
        String senha = new String(senhaChars);
        FacadeLoja fachada = new FacadeLoja();
        if(!email.isEmpty() && !senha.isEmpty() && !nome.isEmpty()) {
        	DtoUser user = new DtoUser(nome,email,senha);
        	if(fachada.criarADM(user)) {
        		dispose();
        		new TelaADM();
        	}	
        }
        else {
        	JOptionPane.showMessageDialog(null, "preencha os campos em branco", "ação impossivel", 2);
        }
     
    }
    public class OuvinteDoLogin implements ActionListener{
    	
    	public void  actionPerformed(ActionEvent Clique) {
    		String play = Clique.getActionCommand();
    		switch (play) {
    		
    		case "Cadastrar":
    			cadastrarADM();
    			break;
    		case "Voltar":
    			voltar();
    			break;
    		}

    	}
    }
    
    
    
    
    
    
    
    
    
    private void voltar() {
      
        dispose();
        new TelaLoginADM();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroADM();
            }
        });
    }
}
