package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controler.Ouvinte;
import Controler.OuvinteADM;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;


public class AdicionarProduto extends JFrame implements Ouvinte {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JPanel panel = new JPanel();
	private JTextArea textField_4;
	public void desenharTela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdicionarProduto.class.getResource("/VIEW/super-mercado_2.jpg")));
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("Cadastrar produto na Loja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0,0,540, 400);
		getContentPane().add(panel);
		panel.setLayout(null);
		setSize(540, 400);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle(" Cadastrar Produto ");
		setLocationRelativeTo(null);
		botoes();
		combo();
		textos();
		labels();
		Ouvinte ouvinte = new OuvinteADM(new TelaADM(), this);
		
		setVisible(true);
	}
	 
	public AdicionarProduto() {
	
	}
		void combo() {
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(325, 146, 30, 22);
			panel.add(comboBox);
			}
		
		void textos() {
			textField = new JTextField();
			textField.setBounds(131, 57, 218, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(131, 87, 218, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(131, 117, 113, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(131, 147, 59, 20);
			panel.add(textField_3);
			textField_3.setColumns(10);
		
			textField_4 = new JTextArea();
			textField_4.setBounds(29, 230, 250, 100);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
		}
		void labels() {
			JLabel lblNewLabel_5 = new JLabel("Descrição do Produto");
			lblNewLabel_5.setBounds(29, 196, 137, 14);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel = new JLabel("Tipo do produto");
			lblNewLabel.setBounds(230, 146, 80, 22);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nome");
			lblNewLabel_1.setBounds(91, 60, 38, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Marca");
			lblNewLabel_2.setBounds(91, 90, 38, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Valor");
			lblNewLabel_3.setBounds(91, 120, 38, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("quantidade");
			lblNewLabel_4.setBounds(62, 150, 67, 14);
			panel.add(lblNewLabel_4);
			
		}
		
		
		void botoes() {
			JButton btnNewButton = new JButton("Cadastrar");
			btnNewButton.setBounds(375, 220, 90, 25);
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Voltar");
			btnNewButton_1.setBounds(375, 270, 89, 23);
			panel.add(btnNewButton_1);
		}
		
		
		
	}

	

