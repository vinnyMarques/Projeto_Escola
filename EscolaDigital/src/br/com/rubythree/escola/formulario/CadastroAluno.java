package br.com.rubythree.escola.formulario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import br.com.rubythree.escola.classe.alunoDAO;
import br.com.rubythree.escola.modelo.Aluno;

public class CadastroAluno implements ActionListener{
JFrame novaJanela;
	
	public CadastroAluno(JFrame janela){
		this.novaJanela = janela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fecha();
		final JFrame cadCliente = new JFrame("Escola Digital");
		Container c = cadCliente.getContentPane();
		c.setBackground(Color.white);
		cadCliente.setLocationRelativeTo(null);
		cadCliente.setLayout(null);
		final Color textcol1 = new Color(193,255,193);//verde
		final Color textcol2 = new Color(245,222,179);//vermelho
		
		JLabel lblnome = new JLabel("Aluno");
		lblnome.setBounds(20, 40, 80, 20);
		cadCliente.add(lblnome);
		final JTextField txtnome = new JTextField();
		txtnome.setBounds(20, 60, 220, 20);
		cadCliente.add(txtnome);
		javax.swing.text.MaskFormatter cpfformater = null;
		try {
			cpfformater = new javax.swing.text.MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final JTextField txtcpf = new javax.swing.JFormattedTextField(cpfformater);
		final JButton btncadastrar = new JButton("Cadastrar");
		
		txtnome.addKeyListener(new KeyListener() {
		
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtnome.getText().equals("") || txtnome.getText().length()>30){
					txtnome.setBackground(textcol2);
				} else {
					txtnome.setBackground(textcol1);
				}
				if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ")){
					btncadastrar.setVisible(false);
				} else {
					btncadastrar.setVisible(true);
				}
			}
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setBounds(20, 90, 100, 20);
		cadCliente.add(lblcpf);
		txtcpf.setBounds(20,  110, 110, 20);
		cadCliente.add(txtcpf);
		txtcpf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtcpf.getText().equals("   .   .   -  ")){
					txtcpf.setBackground(textcol2);
				} else {
					txtcpf.setBackground(textcol1);
				}
				if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ")){
					btncadastrar.setVisible(false);
				} else {
					btncadastrar.setVisible(true);
				}				
			}
			public void keyPressed(KeyEvent arg0) {}
		});
		
		JLabel lblsexo = new JLabel("Sexo");
		lblsexo.setBounds(140, 90, 100, 20);
		cadCliente.add(lblsexo);
		ArrayList<String> lsexo = new ArrayList<String>();
		lsexo.add("Selecione");
		lsexo.add("Masculino");
	    lsexo.add("Feminino");
		final JComboBox cbsexo = new JComboBox();
		cbsexo.setBounds(140, 110, 100, 20);
		cadCliente.add(cbsexo);
		for (String l : lsexo) {
			cbsexo.addItem(l);
		}
		
		JLabel lbldataNasc = new JLabel("Nascimento");
		lbldataNasc.setBounds(20, 140, 150, 20);
		cadCliente.add(lbldataNasc);
		final JDateChooser datanasc = new JDateChooser();
		datanasc.setBounds(20,160,150,20);
		cadCliente.add(datanasc);
		
		btncadastrar.setFont(new Font("Nimbus Mono L", Font.BOLD,45));
		btncadastrar.setBounds(25, 210, 200, 80);
		btncadastrar.setFont(new Font("", Font.BOLD,16));
		cadCliente.add(btncadastrar);
		btncadastrar.setBackground(textcol1);
		
		btncadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String confere = txtnome.getText();
				if (confere.isEmpty() || txtcpf.getText().equals("   .   .   -  ")){
					JOptionPane.showMessageDialog(null, "Preencha corretamente");
					} 
				else{
					Aluno al = new Aluno();
					if (datanasc.getDate() != null) {
						java.util.Date data = datanasc.getDate();
						SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
						String novaData = formatador.format(data);  
						al.setDataNascimento(String.valueOf(novaData)); 
					} else {
						al.setDataNascimento("");
					}
					al.setNome(String.valueOf(txtnome.getText()));
					if (cbsexo.getSelectedItem() == "Selecione"){
						al.setSexo(String.valueOf(""));
					} else {
						al.setSexo(String.valueOf(cbsexo.getSelectedItem()));	
					}
					if (txtcpf.getText() == null){
						al.setCPF(String.valueOf(""));
					} else {
						al.setCPF(String.valueOf(txtcpf.getText()));
					}
					
					new alunoDAO().adiciona(al);
					
					txtnome.setText("");
					cbsexo.setSelectedIndex(0);
					datanasc.setDate(null);
					txtcpf.setText("");
					txtnome.setBackground(Color.white);
					txtcpf.setBackground(Color.white);
					JOptionPane.showMessageDialog(null, "Cadastrado");
					btncadastrar.setVisible(false);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Confira os valores inseridos");
					txtnome.setBackground(textcol2);
					txtcpf.setBackground(textcol2);
				}
			}
		});
		
		cadCliente.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ")){
					btncadastrar.setVisible(false);
				} else {
					btncadastrar.setVisible(true);
				}
				
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cadCliente.setSize(250, 330);
		cadCliente.setLocationRelativeTo(null);
		cadCliente.setVisible(true);
		cadCliente.setDefaultCloseOperation(cadCliente.EXIT_ON_CLOSE);
		
		 ImageIcon imgvoltar = new ImageIcon("voltar.png");
		 final JButton voltar =  new JButton();
		 voltar.setIcon(imgvoltar);
		 voltar.setBackground(Color.white);
		 voltar.setBounds(206, 03, 39, 39);//65v 25
		 cadCliente.add(voltar);
		 voltar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		
		 final Color btncolor = new Color (105,105,105);
		 final Color btncolor2 = new Color (253,245,230);
		
		 voltar.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				voltar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
				voltar.setBackground(Color.white);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				voltar.setBorder(BorderFactory.createLineBorder(btncolor, 1));
				voltar.setBackground(btncolor2);
				if (voltar.requestFocus(true)){
					voltar.setBackground(btncolor2);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}});
		 
		 voltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadCliente.dispose();
				new MenuPrincipal();
				
			}
		});
		 btncadastrar.setVisible(false);
		 txtnome.requestFocus();
	}
	
	public void fecha(){
		novaJanela.dispose();
	}
}
