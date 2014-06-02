package br.com.rubythree.escola.formulario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import com.jgoodies.common.swing.MnemonicUtils;

import br.com.rubythree.escola.classe.loginDAO;

public class LoginADM{
	JFrame novaJanela;
	public LoginADM(JFrame janelaAnterior){
	this.novaJanela = janelaAnterior;
	
	fecha();
	final JFrame janela = new JFrame("Escola Digital");
	janela.setLayout(null);
	
	Color fontCol = new Color(190 ,190 ,190 );
	final Color btnCol = new Color(0,0,0);
	final Color tela = new Color(105 ,105 ,105 );
	Container c = janela.getContentPane();
	c.setBackground(tela);
	
	final JTextField txtlogin = new JTextField("Nome de usuário");
	txtlogin.setBounds(10, 25, 160, 30);
	txtlogin.setBackground(tela);
	txtlogin.setForeground(fontCol);
	txtlogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);  
	txtlogin.setBorder(BorderFactory.createLineBorder(btnCol, 1));
	janela.add(txtlogin);
	txtlogin.addKeyListener(new KeyListener() {
		@Override
		public void keyTyped(KeyEvent arg0) {
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			if (txtlogin.getText().equals("")){
				txtlogin.setText("Nome de usuário");
			}
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			if (txtlogin.getText().equals("Nome de usuário")){
				txtlogin.setText("");
				}
		}
	});
	txtlogin.addMouseMotionListener(new MouseMotionListener() {
		@Override
		public void mouseMoved(MouseEvent arg0) {
	    	if (txtlogin.getText().equals("Nome de usuário")){
			txtlogin.setText("");
			}
		}
		@Override
		public void mouseDragged(MouseEvent arg0) {}
	});
	janela.addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent arg0) {
			if (txtlogin.getText().equals("")){
				txtlogin.setText("Nome de usuário");
			}
		}
		@Override
		public void mouseDragged(MouseEvent arg0) {}
	});
	
	final JPasswordField txtsenha = new JPasswordField();
	txtsenha.setBounds(10, 57, 160, 30);
	txtsenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);  
	txtsenha.setBackground(tela);
	txtsenha.setForeground(fontCol);
	txtsenha.setBorder(BorderFactory.createLineBorder(btnCol, 1));
	janela.add(txtsenha);
	txtsenha.addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			if (txtlogin.getText().equals("")){
				txtlogin.setText("Nome de usuário");
			}
		}
		@Override
		public void mouseDragged(MouseEvent e) {}
	});
	
	ImageIcon imagem = new ImageIcon("grade1.jpg");
	JLabel paneltela = new JLabel();
	paneltela.setBackground(tela);
	paneltela.setBounds(-5, -5, 200, 200);
	paneltela.setIcon(imagem);
	janela.add(paneltela);
	
	final JButton logar = new JButton("OK");
	logar.setBounds(15, 97, 160, 30);
	logar.setBackground(btnCol);
	logar.setForeground(Color.white);
	paneltela.add(logar);
	logar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			loginDAO ldao = new loginDAO();
//			ldao.autentica(String.valueOf(txtlogin.getText()), String.valueOf(txtsenha.getText()));
			
			if (txtlogin.getText().equals("admin") && txtsenha.getText().equals("admin")){
				
				janela.dispose();
				new MenuAdmin();
				System.out.println("Logon");
				
			} else {
				JOptionPane.showMessageDialog(null, "Confira os dados preenchidos");
				txtsenha.setText("");
				txtlogin.requestFocus();
			}
		}
	});
	
	ImageIcon imgvoltar = new ImageIcon("volts.png");
	final JButton voltar = new JButton();
	voltar.setIcon(imgvoltar);
	voltar.setBounds(168, 7, 14, 14);
	paneltela.add(voltar);
	voltar.setBackground(tela);
	voltar.setBorder(BorderFactory.createLineBorder(tela, 1));
	
	voltar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			janela.dispose();
			new MenuCarregamento();
		}
	});
	
	janela.setSize(180,170);
	janela.setLocationRelativeTo(null);
	janela.setVisible(true);
	janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
	txtlogin.requestFocus();
	}
	
	public void fecha(){
		novaJanela.dispose();
	}
}
