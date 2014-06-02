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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.rubythree.escola.classe.ProfessorDAO;
import br.com.rubythree.escola.modelo.Professor;

import com.toedter.calendar.JDateChooser;

public class CadastroProfessor {
	private static int contMateria = 0; 
	public CadastroProfessor(){
		
		final JFrame cadCliente = new JFrame("Escola Digital");
		Container c = cadCliente.getContentPane();
		c.setBackground(Color.white);
		cadCliente.setLocationRelativeTo(null);
		cadCliente.setLayout(null);
		final Color textcol1 = new Color(193,255,193);//verde
		final Color textcol2 = new Color(245,222,179);//vermelho
		
		final ProfessorDAO pdao = new ProfessorDAO();
		
		JLabel lblnome = new JLabel("Professor");
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
				pdao.confirmaCPF(txtcpf.getText());
				if (txtcpf.getText().equals("   .   .   -  ") || pdao.getConfirmaCPF()== false){
					txtcpf.setBackground(textcol2);
				} else {
					txtcpf.setBackground(textcol1);
				}
				if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ") || pdao.getConfirmaCPF()== false){
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
		
		JLabel lbldataNasc = new JLabel("Entrada");
		lbldataNasc.setBounds(20, 140, 100, 20);
		cadCliente.add(lbldataNasc);
		
		java.util.Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
		final String dataHoje = formatador.format(data);  
		final JTextField txtData = new JTextField();
		txtData.setText(dataHoje);
		txtData.setEditable(false);
		txtData.setBounds(20,160,100,20);
		cadCliente.add(txtData);
		
		JLabel lblpreco = new JLabel("Preço (dia)");
		lblpreco.setBounds(140, 140, 100, 20);
		cadCliente.add(lblpreco);
		ArrayList<String> lpreco = new ArrayList<String>();
		lpreco.add("Selecione");
		lpreco.add("30,00");
		lpreco.add("40,00");
		lpreco.add("50,00");
		lpreco.add("60,00");
		lpreco.add("70,00");
		lpreco.add("80,00");
		lpreco.add("90,00");
		lpreco.add("100,00");
		lpreco.add("110,00");
		lpreco.add("120,00");
		lpreco.add("130,00");
		lpreco.add("140,00");
		lpreco.add("150,00");
		lpreco.add("160,00");
		lpreco.add("170,00");
		lpreco.add("180,00");
		lpreco.add("190,00");
		lpreco.add("200,00");
		final JComboBox cbpreco = new JComboBox();
		cbpreco.setBounds(140, 160, 100, 20);
		cadCliente.add(cbpreco);
		for (String l : lpreco) {
			cbpreco.addItem(l);
		}
		
		final JLabel lblmateria = new JLabel("Matéria");
		lblmateria.setBounds(45, 190, 100, 20);
		lblmateria.setForeground(Color.gray);
		cadCliente.add(lblmateria);
		ArrayList<String> lmateria = new ArrayList<String>();
		lmateria.add("Selecione");
		lmateria.add("Língua Portuguesa");
		lmateria.add("Língua Inglesa");
		lmateria.add("Língua Espanhola");
		lmateria.add("Língua Japonesa");
		lmateria.add("Matemática");
		lmateria.add("História");
		lmateria.add("Geografia");
		lmateria.add("Geologia");
		lmateria.add("Ciências");
		lmateria.add("Biologia");
		
		final JComboBox cbmateria1 = new JComboBox();
		cbmateria1.setBounds(45, 210, 160, 20);
		cadCliente.add(cbmateria1);
		for (String l : lmateria) {
			cbmateria1.addItem(l);
		}
		
		final JLabel lblm1 = new JLabel("1ª");
		lblm1.setBounds(20, 208, 30, 20);
		cadCliente.add(lblm1);
		
		final JLabel lblm2 = new JLabel("2ª");
		lblm2.setBounds(20, 233, 30, 20);
		cadCliente.add(lblm2);
		
		final JLabel lblm3 = new JLabel("3ª");
		lblm3.setBounds(20, 258, 30, 20);
		cadCliente.add(lblm3);
		
		final JComboBox cbmateria2 = new JComboBox();
		cbmateria2.setBounds(45, 235, 160, 20);
		cadCliente.add(cbmateria2);
		for (String l : lmateria) {
			cbmateria2.addItem(l);
		}
		
		final JComboBox cbmateria3 = new JComboBox();
		cbmateria3.setBounds(45, 260, 160, 20);
		cadCliente.add(cbmateria3);
		for (String l : lmateria) {
			cbmateria3.addItem(l);
		}
		
		final JLabel lblMenosMateria = new JLabel();
		cbmateria2.setVisible(false);
		cbmateria3.setVisible(false);
		lblMenosMateria.setVisible(false);
		lblm2.setVisible(false);
		lblm3.setVisible(false);
		
		ImageIcon maisMateria = new ImageIcon("maisMateria.png");
		final JLabel lblmaisMateria = new JLabel();
		lblmaisMateria.setBounds(210, 210, 22, 22);
		lblmaisMateria.setIcon(maisMateria);
		lblmaisMateria.setBackground(Color.white);
		cadCliente.add(lblmaisMateria);
		lblmaisMateria.setBorder(BorderFactory.createLineBorder(Color.white,1));
		lblmaisMateria.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Clickou");
				if(contMateria ==0){
					cbmateria2.setVisible(true);
					lblm2.setVisible(true);
					btncadastrar.setBounds(25, 280, 200, 80);//
					cadCliente.setSize(250, 420);//
					contMateria =1;
					lblMenosMateria.setVisible(true);
					lblMenosMateria.setBounds(210, 235, 22, 22);
				} else if(contMateria ==1){
					cbmateria3.setVisible(true);
					lblm3.setVisible(true);
					btncadastrar.setBounds(25, 300, 200, 80);//
					cadCliente.setSize(250, 440);//
					contMateria =2;
					lblMenosMateria.setVisible(true);
					lblMenosMateria.setBounds(210, 260, 22, 22);
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblmaisMateria.setBorder(BorderFactory.createLineBorder(Color.white,1));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblmaisMateria.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		ImageIcon menosMateria = new ImageIcon("menosMateria.png");
		lblMenosMateria.setBounds(210, 235, 22, 22);
		lblMenosMateria.setIcon(menosMateria);
		lblMenosMateria.setBackground(Color.white);
		cadCliente.add(lblMenosMateria);
		lblMenosMateria.setBorder(BorderFactory.createLineBorder(Color.white,1));
		lblMenosMateria.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Clickou");
				if(contMateria ==1){
					cbmateria2.setVisible(false);
					lblm2.setVisible(false);
					btncadastrar.setBounds(25, 260, 200, 80);//
					cadCliente.setSize(250, 400);//
					contMateria =0;
					lblMenosMateria.setVisible(false);
				}else if(contMateria ==2){
					cbmateria3.setVisible(false);
					lblm3.setVisible(false);
					lblMenosMateria.setBounds(210, 235, 22, 22);
					btncadastrar.setBounds(25, 280, 200, 80);//
					cadCliente.setSize(250, 420);//
					contMateria =1;
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMenosMateria.setBorder(BorderFactory.createLineBorder(Color.white,1));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMenosMateria.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		btncadastrar.setFont(new Font("Nimbus Mono L", Font.BOLD,45));
		btncadastrar.setBounds(25, 260, 200, 80);
		btncadastrar.setFont(new Font("", Font.BOLD,16));
		cadCliente.add(btncadastrar);
		btncadastrar.setBackground(textcol1);
		
		btncadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if (txtnome.getText().isEmpty() 
						|| txtcpf.getText().equals("   .   .   -  ")
						|| cbpreco.getSelectedItem().equals("Selecione")
						|| cbmateria1.getSelectedItem().equals("Selecione")){
					JOptionPane.showMessageDialog(null, "Preencha corretamente");
					} 
				else{
					Professor p = new Professor();
					
					p.setNome(txtnome.getText());
					if (cbsexo.getSelectedItem().equals("Selecione")){
						p.setSexo(String.valueOf(""));
					} else {
						p.setSexo(String.valueOf(cbsexo.getSelectedItem()));	
					}
					p.setDataAdmissao(txtData.getText());
					p.setPreco(String.valueOf(cbpreco.getSelectedItem()));
					p.setCPF(txtcpf.getText());
					p.setMateriaP(String.valueOf(cbmateria1.getSelectedItem()));
					if (contMateria ==0){
						p.setMateriaS(String.valueOf("Não Possui"));
						p.setMateriaT(String.valueOf("Não Possui"));
					} else if (contMateria ==1){
						p.setMateriaS(String.valueOf(cbmateria2.getSelectedItem()));
						p.setMateriaT(String.valueOf("Não Possui"));
					} else if (contMateria ==2){
						p.setMateriaS(String.valueOf(cbmateria2.getSelectedItem()));
						p.setMateriaT(String.valueOf(cbmateria3.getSelectedItem()));
					}
					
					pdao.adiciona(p);
					
					btncadastrar.setVisible(false);
					txtnome.setText("");
					cbsexo.setSelectedIndex(0);
					txtData.setText(dataHoje);
					cbpreco.setSelectedIndex(0);
					txtcpf.setText("");
					cbmateria1.setSelectedIndex(0);
					cbmateria2.setSelectedIndex(0);
					cbmateria3.setSelectedIndex(0);
					cbmateria2.setVisible(false);
					cbmateria3.setVisible(false);
					lblm2.setVisible(false);
					lblm3.setVisible(false);
					lblMenosMateria.setVisible(false);
					btncadastrar.setBounds(25, 260, 200, 80);//
					cadCliente.setSize(250, 400);//
					contMateria=0;
					txtnome.setBackground(Color.white);
					txtcpf.setBackground(Color.white);
					JOptionPane.showMessageDialog(null, "Cadastrado");
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
				if (txtnome.getText().isEmpty() || txtcpf.getText().equals("   .   .   -  ") || pdao.getConfirmaCPF()== false){
					btncadastrar.setVisible(false);
				} else {
					btncadastrar.setVisible(true);
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		
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
		 
		cadCliente.setSize(250, 400);
		cadCliente.setLocationRelativeTo(null);
		cadCliente.setVisible(true);
		cadCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btncadastrar.setVisible(false);
		txtnome.requestFocus();
	}
}
