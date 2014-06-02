package br.com.rubythree.escola.formulario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.rubythree.escola.classe.loginDAO;
import br.com.rubythree.escola.modelo.Login;

public class CadastroAdm{
JFrame novaJanela;
	
	public CadastroAdm(){
		
		final JFrame cadAdm = new JFrame("Escola Digital");
		Container c = cadAdm.getContentPane();
		c.setBackground(Color.black);
		cadAdm.setLocationRelativeTo(null);
		cadAdm.setLayout(null);
		
		ImageIcon imagem = new ImageIcon("grade1.jpg");
		JLabel paneltela = new JLabel();
		paneltela.setBounds(0, 0, 1600, 900);
		paneltela.setIcon(imagem);
		cadAdm.add(paneltela);
		final Color tela = new Color(105 ,105 ,105 );
		final Color fontCol = new Color(54, 54, 54 );//0,0,0
		final Color textcol1 = new Color(154 ,255 ,154 );//verde
		final Color textcol2 = new Color(245,222,179);//vermelho
		final loginDAO ldao = new loginDAO();
		
		JLabel lbllogin = new JLabel("Novo Usuário");
		lbllogin.setBounds(20, 30, 130, 20);
		lbllogin.setForeground(Color.white);
		paneltela.add(lbllogin);
		final JTextField txtlogin = new JTextField();
		txtlogin.setBackground(textcol2);
		txtlogin.setBorder(BorderFactory.createLineBorder(fontCol, 2));
		txtlogin.setBounds(20, 50, 150, 20);
		paneltela.add(txtlogin);
		txtlogin.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				ldao.confirmaLogin(txtlogin.getText());
				if (ldao.getConfirmaLogin() == true && txtlogin.getText() != ("") && txtlogin.getText().length() > 5 && txtlogin.getText().length() <= 15){
					txtlogin.setBackground(textcol1);
				} else {
					txtlogin.setBackground(textcol2);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(20, 90, 130, 20);
		lblsenha.setForeground(Color.white);
		paneltela.add(lblsenha);
		final JPasswordField txtsenha = new JPasswordField();
		txtsenha.setBounds(20, 110, 150, 20);
		txtsenha.setBorder(BorderFactory.createLineBorder(fontCol, 2));
		txtsenha.setBackground(textcol2);
		paneltela.add(txtsenha);
		txtsenha.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtsenha.getText().length() > 5 && txtsenha.getText().length() <= 15){
					txtsenha.setBackground(textcol1);
				} else {
					txtsenha.setBackground(textcol2);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		JLabel lblsenha2 = new JLabel("Confirme a Senha");
		lblsenha2.setBounds(20, 140, 130, 20);
		lblsenha2.setForeground(Color.white);
		paneltela.add(lblsenha2);
		final JPasswordField txtsenha2 = new JPasswordField();
		txtsenha2.setBounds(20, 160, 150, 20);
		txtsenha2.setBorder(BorderFactory.createLineBorder(fontCol, 2));
		txtsenha2.setBackground(textcol2);
		paneltela.add(txtsenha2);
		txtsenha2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtsenha2.getText().equals(txtsenha.getText())){
					txtsenha2.setBackground(textcol1);
				} else {
					txtsenha2.setBackground(textcol2);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.setBounds(20, 200, 150, 60);
		btncadastrar.setBackground(Color.black);
		btncadastrar.setForeground(Color.white);
		btncadastrar.setBorder(BorderFactory.createLineBorder(textcol1, 1));
		paneltela.add(btncadastrar);
		btncadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtlogin.getBackground().equals(textcol2) || txtsenha.getBackground().equals(textcol2) || txtsenha2.getBackground().equals(textcol2)){
					JOptionPane.showMessageDialog(null,"Preencha corretamente os campos");
					txtlogin.requestFocus();
				} else {
					System.out.println("OK");
					try {
						Login log = new Login();
						log.setUser(txtlogin.getText());
						log.setPass(txtsenha.getText());
						ldao.adiciona(log);
						
						JOptionPane.showMessageDialog(null,"Usuário " +txtlogin.getText()+" cadastrado");
						txtlogin.setText("");
						txtsenha.setText("");
						txtsenha2.setText("");
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Preencha corretamente os campos");
					}
				}
				
			}
		});
		
		ImageIcon imgvoltar = new ImageIcon("volts.png");
		final JButton voltar = new JButton();
		voltar.setIcon(imgvoltar);
		voltar.setBounds(172, 4, 14, 14);
		paneltela.add(voltar);
		voltar.setBackground(tela);
		voltar.setBorder(BorderFactory.createLineBorder(tela, 1));
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadAdm.dispose();
				new MenuAdmin();
			}
		});

		cadAdm.setSize(190, 300);
		cadAdm.setLocationRelativeTo(null);
		cadAdm.setVisible(true);
		txtlogin.requestFocus();
		cadAdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
