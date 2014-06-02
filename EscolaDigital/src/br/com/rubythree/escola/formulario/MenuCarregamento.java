package br.com.rubythree.escola.formulario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.rubythree.escola.classe.alunoDAO;
import br.com.rubythree.escola.classe.loginDAO;

public class MenuCarregamento {
	
	public MenuCarregamento(){
		final JFrame janela = new JFrame("Escola");
		janela.setLayout(null);
		
		Color fontCol = new Color(105,105,105);
		final Color btnCol = new Color(100,149,237);
		final Color tela = new Color(255,250,250);
		Container c = janela.getContentPane();
		c.setBackground(tela);
		
		final JTextField txtlogin = new JTextField("Nome de usuário");
		txtlogin.setBounds(10, 25, 140, 30);
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
		txtsenha.setBounds(10, 57, 140, 30);
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
		
		JButton logar = new JButton("OK");
		logar.setBounds(11, 97, 138, 30);
		janela.add(logar);
		logar.setBackground(btnCol);
		logar.setForeground(Color.white);
		logar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginDAO ldao = new loginDAO();
				ldao.autentica(String.valueOf(txtlogin.getText()), String.valueOf(txtsenha.getText()));
				
				if (ldao.getAutenticacao()== true){
					janela.dispose();
					new MenuPrincipal();
					System.out.println("Logon");
					
				} else {
					JOptionPane.showMessageDialog(null, "Confira os dados preenchidos");
					txtsenha.setText("");
					txtlogin.requestFocus();
				}
			}
		});
		
		
		ImageIcon imagem = new ImageIcon("cadeado.png");
		final JButton adm = new JButton();
		adm.setIcon(imagem);
		adm.setBounds(138, 1, 20, 20);
		janela.add(adm);
		adm.setBackground(Color.white);
		adm.setBorder(BorderFactory.createLineBorder(tela, 1));
		adm.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				txtlogin.requestFocus();
				adm.setBounds(138, 1, 20, 20);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				adm.requestFocus();
				adm.setBounds(136, 0, 22, 22);
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		adm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new LoginADM(janela);
				
			}
		});
		janela.setSize(160,170);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		txtlogin.requestFocus();
	}
}
