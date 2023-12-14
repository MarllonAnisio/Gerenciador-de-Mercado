package VIEW;

import javax.swing.*;
import javax.swing.border.*;

import Controler.FacadeLoja;
import DAO.UsuarioNaoEncontradaExeption;
import DTO.DtoUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginADM extends JFrame {

    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaLoginADM() {
        super("Login ADM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração do painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona uma borda ao painel principal
        painelPrincipal.setBorder(BorderFactory.createTitledBorder("Login ADM"));

        // Configuração dos componentes
        campoEmail = new JTextField();
        campoSenha = new JPasswordField();

        // Configuração dos botões
        JButton botaoAcessar = new JButton("Acessar");
        JButton botaoCadastrar = new JButton("Cadastrar");

        // Adiciona ouvinte para os botões
        botaoAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checarLogin();
            }
        });
        
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroADM();
            }
        });

        // Configuração do layout
        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        painelFormulario.add(new JLabel("Email:"));
        painelFormulario.add(campoEmail);
        painelFormulario.add(new JLabel("Senha:"));
        painelFormulario.add(campoSenha);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painelBotoes.add(botaoAcessar);
        painelBotoes.add(botaoCadastrar);

        painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checarLogin() {
       FacadeLoja fachada = new FacadeLoja();
       String email = campoEmail.getText();
       char[] senhaChars = campoSenha.getPassword();
       String senha = new String(senhaChars);
       if(!senha.isEmpty() && !email.isEmpty()) {
    	   DtoUser user = new DtoUser(email, senha);
    	   try {
		   if(fachada.procureADM(user)) {
			   dispose();
			   new TelaADM();   
			   }
		} catch (UsuarioNaoEncontradaExeption e) {
			JOptionPane.showMessageDialog(null, "usuario nao encontrado", "ação impossivel", 2);
		}  
       }else {
    	   JOptionPane.showMessageDialog(null, "preencha os campos em branco", "ação impossivel", 2);
       }

    }
    

    private void abrirTelaCadastroADM() {
        dispose();
        new TelaCadastroADM();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLoginADM();
            }
        });
    }
}

