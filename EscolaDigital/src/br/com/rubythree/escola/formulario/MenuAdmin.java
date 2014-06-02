package br.com.rubythree.escola.formulario;

import br.com.rubythree.escola.classe.loginDAO;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.com.rubythree.escola.classe.alunoDAO;
import br.com.rubythree.escola.modelo.Login;

public class MenuAdmin{
	static String filtro;
	
	public MenuAdmin(){
		final JFrame janela = new JFrame("Escola Digital");
		janela.setLayout(null);
		Color fontCol = new Color(190 ,190 ,190 );
		final Color btnCol = new Color(105 ,105 ,105);
		final Color tela = new Color(105 ,105 ,105 );
		ImageIcon imagem = new ImageIcon("grade1.jpg");
		JLabel paneltela = new JLabel();
		paneltela.setBounds(-5, -5, 1600, 900);
		paneltela.setIcon(imagem);
		janela.add(paneltela);
		
		JLabel lbltitulo1 = new JLabel("Configurações");
		lbltitulo1.setFont(new Font("FreeMono", Font.BOLD,25));
		lbltitulo1.setBounds(20, 5, 300, 30);
		lbltitulo1.setForeground(fontCol);
		paneltela.add(lbltitulo1);
		
		JLabel lbltitulo2 = new JLabel("de Login");
		lbltitulo2.setFont(new Font("FreeMono", Font.BOLD,25));
		lbltitulo2.setBounds(150, 30, 200, 30);
		lbltitulo2.setForeground(fontCol);
		paneltela.add(lbltitulo2);
		
		final JTable tblLogin = new JTable(0,0);
        tblLogin.setAutoCreateRowSorter(true); 
		
		final loginDAO ldao = new loginDAO();
		ldao.getTable(tblLogin);
		
		JScrollPane scrollPane = new JScrollPane(tblLogin);
		scrollPane.setBounds(30, 70, 300, 146);
		paneltela.add(scrollPane);
		
		JLabel lbllogin = new JLabel("Filtrar");
		lbllogin.setBounds(32, 226, 80, 20);
		lbllogin.setBackground(btnCol);
		lbllogin.setForeground(fontCol);
		paneltela.add(lbllogin);
		
		final JTextField txtlogin = new JTextField("Insira o nome de Login");
		txtlogin.setBounds(80, 226, 150, 20);
		txtlogin.setBackground(btnCol);
		txtlogin.setForeground(fontCol);
		txtlogin.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
		paneltela.add(txtlogin);
		
		txtlogin.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				filtro = txtlogin.getText();
				ldao.filtraTable(tblLogin, filtro);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (txtlogin.getText().equals("Insira o nome de Login")){
					txtlogin.setText("");
					}
			}
		});
	    	
		txtlogin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (txtlogin.getText().equals("")){
		    		txtlogin.setText("Insira o nome de Login");
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (txtlogin.getText().equals("Insira o nome de Login")){
		    		txtlogin.setText("");
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
}
		});
	    
		
		JButton cadastro = new JButton("Cadastrar");
		cadastro.setBounds(350, 70, 110, 30);
		cadastro.setForeground(Color.black);
//		cadastro.setBackground(btnCol);
		paneltela.add(cadastro);
		cadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new CadastroAdm();
			}
		});
		
		JButton alterLogin = new JButton("Alterar");
		alterLogin.setBounds(350, 105, 110, 30);
		alterLogin.setForeground(Color.black);
//		pesqLogin.setBackground(btnCol);
		paneltela.add(alterLogin);
		alterLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new AlteraAdm();
			}
		});
		
		final JButton voltar = new JButton("Menu");
		voltar.setBounds(382, 7, 80, 30);
		paneltela.add(voltar);
		voltar.setBackground(tela);
		voltar.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		
		voltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				new MenuCarregamento();
			}
		});
		
		janela.setSize(460,280);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		txtlogin.requestFocus();
	}
}
