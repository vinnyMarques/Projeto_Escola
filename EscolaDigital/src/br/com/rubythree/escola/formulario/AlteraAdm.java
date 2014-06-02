package br.com.rubythree.escola.formulario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.rubythree.escola.classe.alunoDAO;
import br.com.rubythree.escola.classe.loginDAO;
import br.com.rubythree.escola.modelo.Aluno;
import br.com.rubythree.escola.modelo.Login;

public class AlteraAdm{
	static int id;
	static String LoginPesq;
	
	public AlteraAdm(){
		
		final JFrame cadAdm = new JFrame("Escola Digital");
		Container c = cadAdm.getContentPane();
		c.setBackground(Color.black);
		cadAdm.setLocationRelativeTo(null);
		cadAdm.setLayout(null);
		
		ImageIcon imagem = new ImageIcon("grade1.jpg");
		JLabel paneltela = new JLabel();
		paneltela.setBounds(0, 0, 1600, 300);
		paneltela.setIcon(imagem);
		cadAdm.add(paneltela);
		final Color tela = new Color(105 ,105 ,105 );
		final Color fontCol = new Color(54, 54, 54 );//0,0,0
		final Color textcol1 = new Color(154 ,255 ,154 );//verde
		final Color textcol2 = new Color(245,222,179);//vermelho
		final loginDAO ldao = new loginDAO();
		
		JLabel lblPesquisa = new JLabel("Usuário");
		lblPesquisa.setBounds(20, 20, 120, 20);
		lblPesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		paneltela.add(lblPesquisa);
		lblPesquisa.setForeground(Color.white);
		
		final JTextField txtPesquisa = new JTextField();
		txtPesquisa.setBounds(20, 40, 120, 30);
		paneltela.add(txtPesquisa);
		txtPesquisa.setForeground(Color.white);
		txtPesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPesquisa.setBackground(Color.black);
		txtPesquisa.setBorder(BorderFactory.createLineBorder(fontCol, 3));
//		txtPesquisa.setFont(new Font("", Font.BOLD,13));
		
		JLabel lbllogin = new JLabel("Login");
		lbllogin.setBounds(20, 90, 130, 20);
		lbllogin.setForeground(Color.white);
		paneltela.add(lbllogin);
		final JTextField txtlogin = new JTextField();
		txtlogin.setBackground(Color.black);
		txtlogin.setForeground(Color.white);
		txtlogin.setBorder(BorderFactory.createLineBorder(fontCol, 2));
		txtlogin.setBounds(20, 110, 150, 22);
		paneltela.add(txtlogin);
		txtlogin.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				txtlogin.setForeground(Color.black);
				ldao.confirmaLogin(txtlogin.getText());
				if (ldao.getConfirmaLogin() == true && txtlogin.getText().length() > 5
						&& txtlogin.getText().length() <= 15
						|| txtlogin.getText().equals(LoginPesq)
						|| txtlogin.getText().equals(txtPesquisa.getText())){
					txtlogin.setBackground(textcol1);
				} else {
					txtlogin.setBackground(textcol2);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		final JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(20, 150, 130, 20);
		lblsenha.setForeground(Color.white);
		paneltela.add(lblsenha);
		final JPasswordField txtsenha = new JPasswordField();
		txtsenha.setBackground(Color.black);
		txtsenha.setForeground(Color.white);
		txtsenha.setBorder(BorderFactory.createLineBorder(fontCol, 2));
		txtsenha.setBounds(20, 170, 150, 22);
		paneltela.add(txtsenha);
		txtsenha.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				txtsenha.setForeground(Color.black);
				if (txtsenha.getText().length() >= 5 && txtsenha.getText().length() <= 15){
					txtsenha.setBackground(textcol1);
				} else {
					txtsenha.setBackground(textcol2);
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		
		ImageIcon imppesq = new ImageIcon("next.png");
		final JButton btnpesquisar = new JButton();
		btnpesquisar.setIcon(imppesq);
		btnpesquisar.setBackground(fontCol);
		btnpesquisar.setBounds(143, 43, 23, 23);
		btnpesquisar.setBorder(BorderFactory.createLineBorder(fontCol, 1));
		paneltela.add(btnpesquisar);
		
		ImageIcon imagem2 = new ImageIcon("x1.png");
		final JButton limpar =  new JButton();
		limpar.setBounds(167, 43, 23, 23);
		limpar.setIcon(imagem2);
		paneltela.add(limpar);
		limpar.setBackground(Color.BLACK);
		limpar.setBorder(BorderFactory.createLineBorder(fontCol, 1));
		limpar.setVisible(false);
		
		
		final JButton btneditar =  new JButton("Editar");
		btneditar.setBounds(100, 220, 80, 25);
		paneltela.add(btneditar);
		
		final JButton btnexcluir =  new JButton("Excluir");
		btnexcluir.setBounds(20, 220, 80, 25);
		paneltela.add(btnexcluir);
		
		final JButton btnsalvar =  new JButton("Salvar");
		btnsalvar.setBounds(100, 220, 80, 25);
		paneltela.add(btnsalvar);
		
		txtPesquisa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPesquisa.getText().equals("")){
					limpar.setVisible(false);
				} else {
					limpar.setVisible(true);
				}	
				
			}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblsenha.setText("Senha");
				txtlogin.setBackground(Color.black);
				txtlogin.setForeground(Color.white);
				txtsenha.setBackground(Color.black);
				txtsenha.setForeground(Color.white);
				
				txtPesquisa.setText("");
				txtlogin.setText("");
				txtsenha.setText("");
				txtPesquisa.setForeground(Color.white);
				btnexcluir.setVisible(false);
				btneditar.setVisible(false);
				btnsalvar.setVisible(false);
				txtlogin.setEditable(false);
				txtsenha.setEditable(false);
				txtPesquisa.requestFocus();
				limpar.setVisible(false);
				txtPesquisa.setEditable(true);
			}
		});
		
		btnpesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ldao.confirmaLogin(txtPesquisa.getText());
					if (ldao.getConfirmaLogin() == false){
						ldao.pesquisa(txtPesquisa.getText());
						id = ldao.getID();
						txtlogin.setText(ldao.getUser());
						txtsenha.setText(ldao.getPass());
						LoginPesq = ldao.getUser();
						
						btneditar.setVisible(true);
						btnexcluir.setVisible(true);
						txtPesquisa.setForeground(fontCol);
						txtPesquisa.setEditable(false);
					} else {
						JOptionPane.showMessageDialog(null, "Login Incorreto");
						txtPesquisa.requestFocus();
						
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Login Incorreto");
					txtPesquisa.setText("");
					txtlogin.setText("");
					txtsenha.setText("");
					txtPesquisa.requestFocus();
				}
			}
		});
		
		btneditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblsenha.setText("Nova Senha");
				txtlogin.setForeground(Color.black);
				txtsenha.setForeground(Color.black);
				txtlogin.setBackground(textcol1);
				txtsenha.setBackground(textcol1);
				txtlogin.setEditable(true);
				txtsenha.setEditable(true);
				btneditar.setVisible(false);
				btnsalvar.setVisible(true);
				
			}
		});
		
		btnsalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
			int x = JOptionPane.showConfirmDialog(null, "Deseja aplicar as alterações");
			if (x == 0){
				System.out.print("Sim 0");
				if (txtlogin.getBackground().equals(textcol2) || txtsenha.getBackground().equals(textcol2)){
					JOptionPane.showMessageDialog(null,"Preencha corretamente os campos");
					txtlogin.requestFocus();
				} else {
						
					Login log = new Login();
					log.setUser(txtlogin.getText());
					log.setPass(txtsenha.getText());
					ldao.altera(log, id);
					
					
					lblsenha.setText("Senha");
					txtlogin.setBackground(Color.black);
					txtlogin.setForeground(Color.white);
					txtsenha.setBackground(Color.black);
					txtsenha.setForeground(Color.white);
					
					txtPesquisa.setText("");
					txtlogin.setText("");
					txtsenha.setText("");
					txtPesquisa.setForeground(Color.white);
					btnexcluir.setVisible(false);
					btneditar.setVisible(false);
					btnsalvar.setVisible(false);
					txtlogin.setEditable(false);
					txtsenha.setEditable(false);
					txtPesquisa.requestFocus();
					limpar.setVisible(false);
					txtPesquisa.setEditable(true);
					JOptionPane.showMessageDialog(null, "Alteração Concluída");
					}
			}
			
			if (x == 1){
				lblsenha.setText("Senha");
				txtlogin.setBackground(Color.black);
				txtlogin.setForeground(Color.white);
				txtsenha.setBackground(Color.black);
				txtsenha.setForeground(Color.white);
				
				txtPesquisa.setText("");
				txtlogin.setText("");
				txtsenha.setText("");
				txtPesquisa.setForeground(Color.white);
				btnexcluir.setVisible(false);
				btneditar.setVisible(false);
				btnsalvar.setVisible(false);
				txtlogin.setEditable(false);
				txtsenha.setEditable(false);
				txtPesquisa.requestFocus();
				limpar.setVisible(false);
				txtPesquisa.setEditable(true);
			}
			} catch (Exception e2) {
				System.out.println("erro alterar");
			}
		}
	});

		btnexcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int excluir = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Excluir ?");
				if (excluir == 0){
					
					JOptionPane.showMessageDialog(null, "Dados Removidos");
					ldao.remove(LoginPesq);
					
					lblsenha.setText("Senha");
					txtlogin.setBackground(Color.black);
					txtlogin.setForeground(Color.white);
					txtsenha.setBackground(Color.black);
					txtsenha.setForeground(Color.white);
					
					txtPesquisa.setText("");
					txtlogin.setText("");
					txtsenha.setText("");
					txtPesquisa.setForeground(Color.white);
					btnexcluir.setVisible(false);
					btneditar.setVisible(false);
					btnsalvar.setVisible(false);
					txtlogin.setEditable(false);
					txtsenha.setEditable(false);
					txtPesquisa.requestFocus();
					limpar.setVisible(false);
					txtPesquisa.setEditable(true);
				}
		
				if (excluir == 1){
					lblsenha.setText("Senha");
					txtlogin.setBackground(Color.black);
					txtlogin.setForeground(Color.white);
					txtsenha.setBackground(Color.black);
					txtsenha.setForeground(Color.white);
					
					txtPesquisa.setText("");
					txtlogin.setText("");
					txtsenha.setText("");
					txtPesquisa.setForeground(Color.white);
					btnexcluir.setVisible(false);
					btneditar.setVisible(false);
					btnsalvar.setVisible(false);
					txtlogin.setEditable(false);
					txtsenha.setEditable(false);
					txtPesquisa.requestFocus();
					limpar.setVisible(false);
					txtPesquisa.setEditable(true);
				}
			}
		});

		ImageIcon imgvoltar = new ImageIcon("volts.png");
		final JButton voltar = new JButton();
		voltar.setIcon(imgvoltar);
		voltar.setBounds(182, 4, 14, 14);
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
		
		btnsalvar.setVisible(false);
		txtlogin.setEditable(false);
		txtsenha.setEditable(false);
		
		cadAdm.setSize(200, 300);
		cadAdm.setLocationRelativeTo(null);
		cadAdm.setVisible(true);
		
		txtPesquisa.requestFocus();
		cadAdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
