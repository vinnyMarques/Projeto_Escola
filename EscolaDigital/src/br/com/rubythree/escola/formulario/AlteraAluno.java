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

public class AlteraAluno implements ActionListener{
JFrame novaJanela;
int id;
	
	public AlteraAluno(JFrame janela){
		this.novaJanela = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fecha();
		final JFrame alterCliente = new JFrame("Escola Digital");
		Container c = alterCliente.getContentPane();
		c.setBackground(Color.white);
		alterCliente.setLocationRelativeTo(null);
		alterCliente.setLayout(null);
		JLabel lblPesquisa = new JLabel("CPF");
		lblPesquisa.setBounds(20, 30, 80, 20);
		alterCliente.add(lblPesquisa);
		lblPesquisa.setForeground(Color.black);
		lblPesquisa.setFont(new Font("", Font.BOLD,13));
		
		Color textcol2 = new Color(193,255,193);
		javax.swing.text.MaskFormatter cpfformater = null;
		try {
			cpfformater = new javax.swing.text.MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final JTextField txtPesquisa = new javax.swing.JFormattedTextField(cpfformater);
		txtPesquisa.setBounds(20, 50, 110, 28);
		alterCliente.add(txtPesquisa);
		txtPesquisa.setBackground(textcol2);
		
		JLabel lblnome = new JLabel("Aluno");
		lblnome.setBounds(20, 90, 80, 20);
		alterCliente.add(lblnome);
		final JTextField txtnome = new JTextField();
		txtnome.setBounds(20, 110, 220, 20);
		alterCliente.add(txtnome);
		
		JLabel lblcpf = new JLabel("CPF");
		lblcpf.setBounds(20, 140, 100, 20);
		alterCliente.add(lblcpf);
		
		final JTextField txtcpf = new javax.swing.JFormattedTextField(cpfformater);
		txtcpf.setBounds(20,  160, 110, 20);
		alterCliente.add(txtcpf);
		
		JLabel lblsexo = new JLabel("Sexo");
		lblsexo.setBounds(140, 140, 100, 20);
		alterCliente.add(lblsexo);
		ArrayList<String> lsexo = new ArrayList<String>();
		lsexo.add("Selecione");
		lsexo.add("Masculino");
	    lsexo.add("Feminino");
		final JComboBox cbsexo = new JComboBox();
		cbsexo.setBounds(140, 160, 100, 20);
		alterCliente.add(cbsexo);
		for (String l : lsexo) {
			cbsexo.addItem(l);
		}
		
//		final JTextField txtsexo = new JTextField();
//		txtsexo.setBounds(140, 160, 100, 20);
//		cadCliente.add(txtsexo);
		
		JLabel lbldataNasc = new JLabel("Nascimento");
		lbldataNasc.setBounds(20, 190, 150, 20);
		alterCliente.add(lbldataNasc);
		
		javax.swing.text.MaskFormatter dataformater = null;
		try {
			dataformater = new javax.swing.text.MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final JTextField txtdatanasc = new javax.swing.JFormattedTextField(dataformater);
		txtdatanasc.setBounds(20,210,150,20);
		alterCliente.add(txtdatanasc);
		
		final JButton btneditar =  new JButton("Editar");
		btneditar.setBounds(100, 255, 80, 25);
		alterCliente.add(btneditar);
		
		final JButton btnexcluir =  new JButton("Excluir");
		btnexcluir.setBounds(20, 255, 80, 25);
		alterCliente.add(btnexcluir);
		
		final JButton btnsalvar =  new JButton("Salvar");
		btnsalvar.setBounds(100, 255, 80, 25);
		alterCliente.add(btnsalvar);
		
		btneditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtnome.setEditable(true);
				cbsexo.setEnabled(true);
				txtdatanasc.setEditable(true);
				txtcpf.setEditable(true);
				
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
				String confere = txtnome.getText();
				if (confere.isEmpty() || txtcpf.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Preencha corretamente");
				txtPesquisa.requestFocus();
				} else {
					alunoDAO aldao = new alunoDAO();
					Aluno al = new Aluno();
							
					//name
					al.setNome(String.valueOf(txtnome.getText()));
					//sex
					if (cbsexo.getSelectedItem() == "Selecione"){
						al.setSexo(String.valueOf(""));
					} else {
						al.setSexo(String.valueOf(cbsexo.getSelectedItem()));	
					}
					//document
					if (txtcpf.getText() == null){
						al.setCPF(String.valueOf(""));
					} else {
						al.setCPF(String.valueOf(txtcpf.getText()));
					}
					//date
					if (txtdatanasc.getText() == null){
						al.setDataNascimento(String.valueOf(""));
					} else{
						al.setDataNascimento(String.valueOf(txtdatanasc.getText()));
					}
					
					aldao.altera(al, id );
					
					
					txtPesquisa.setText("");
					txtnome.setText("");
					cbsexo.setSelectedIndex(0);
					txtcpf.setText("");
					txtdatanasc.setText("");
					btneditar.setVisible(false);
					btnsalvar.setVisible(false);
					btnexcluir.setVisible(false);
					txtnome.setEditable(false);
					cbsexo.setEnabled(false);
					txtdatanasc.setEditable(false);
					txtcpf.setEditable(false);
					txtPesquisa.requestFocus();
					JOptionPane.showMessageDialog(null, "Alteração Concluída");
					}
			}
			
			if (x == 1){
				System.out.print("Nao 1");
				txtPesquisa.setText("");
				txtnome.setText("");
				cbsexo.setSelectedIndex(0);
				txtcpf.setText("");
				txtdatanasc.setText("");
				btnexcluir.setVisible(false);
				btneditar.setVisible(false);
				btnsalvar.setVisible(false);
				txtnome.setEditable(false);
				cbsexo.setEnabled(false);
				txtdatanasc.setEditable(false);
				txtcpf.setEditable(false);
				txtPesquisa.requestFocus();
			}
			
			if (x == 2){
				System.out.print("Cancelar 2");	
			}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "CPF já cadastrado");
			}
		}
	});
		
		ImageIcon imagem = new ImageIcon("next.png");
		final JButton btnpesquisar = new JButton();
		btnpesquisar.setIcon(imagem);
		btnpesquisar.setBounds(130, 50, 27, 27);
//		btnpesquisar.setFont(new Font("", Font.BOLD,13));
		alterCliente.add(btnpesquisar);
		btnpesquisar.setBackground(Color.black);
		

//		Color xcol = new Color(245,245,245);
		ImageIcon imagem2 = new ImageIcon("x1.png");
		final JButton limpar =  new JButton();
		limpar.setBounds(158, 50, 28, 28);
		limpar.setIcon(imagem2);
		alterCliente.add(limpar);
		limpar.setBackground(Color.BLACK);
		limpar.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		limpar.setVisible(false);
		
		txtPesquisa.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPesquisa.getText().equals("   .   .   -  ")){
					limpar.setVisible(false);
				} else {
					limpar.setVisible(true);
				}	
				
			}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		alterCliente.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtPesquisa.getText().equals("   .   .   -  ")){
					limpar.setVisible(false);
				} else {
					limpar.setVisible(true);
				}	
				
			}
			@Override
			public void mouseDragged(MouseEvent arg0) {}
		});
		
		txtPesquisa.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtPesquisa.getText().equals("   .   .   -  ")){
					limpar.setVisible(false);
				} else {
					limpar.setVisible(true);
				}	
			}		
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		
		limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtPesquisa.setText("");
				txtnome.setText("");
				cbsexo.setSelectedIndex(0);
				txtcpf.setText("");
				txtdatanasc.setText("");
				btnexcluir.setVisible(false);
				btneditar.setVisible(false);
				btnsalvar.setVisible(false);
				txtnome.setEditable(false);
				cbsexo.setEnabled(false);
				txtdatanasc.setEditable(false);
				txtcpf.setEditable(false);
				txtPesquisa.requestFocus();
				limpar.setVisible(false);
			}
		});
		
		btnpesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						alunoDAO aldao = new alunoDAO();
						
						String cpf = String.valueOf(txtPesquisa.getText()); 
						aldao.pesquisaCPF(cpf);
						
						id = aldao.getID();
						txtnome.setText(aldao.getNome());
						txtcpf.setText(aldao.getCPF());
						txtdatanasc.setText(aldao.getDataNasc());
						
						if (aldao.getSexo().equals("Masculino")){
							cbsexo.setSelectedIndex(1);
						} else if (aldao.getSexo().equals("Feminino")){
							cbsexo.setSelectedIndex(2);
						} else{
							cbsexo.setSelectedIndex(0);
						}
						
						btneditar.setVisible(true);
						btnexcluir.setVisible(true);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "CPF Incorreto");
						txtcpf.setText("");
						txtPesquisa.requestFocus();
					}
				}
		});
		
		btnexcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int excluir = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Excluir ?");
				if (excluir == 0){
				
				txtPesquisa.setText("");
				txtnome.setText("");
				cbsexo.setSelectedIndex(0);
				txtcpf.setText("");
				txtdatanasc.setText("");
				btnexcluir.setVisible(false);
				btneditar.setVisible(false);
				btnsalvar.setVisible(false);
				txtnome.setEditable(false);
				cbsexo.setEnabled(false);
				txtdatanasc.setEditable(false);
				txtcpf.setEditable(false);
				txtPesquisa.requestFocus();
				JOptionPane.showMessageDialog(null, "Dados Removidos");
				new alunoDAO().remove(id);
				}
				
				if (excluir == 1){
					txtPesquisa.setText("");
					txtnome.setText("");
					cbsexo.setSelectedIndex(0);
					txtcpf.setText("");
					txtdatanasc.setText("");
					btnexcluir.setVisible(false);
					btneditar.setVisible(false);
					btnsalvar.setVisible(false);
					txtnome.setEditable(false);
					cbsexo.setEnabled(false);
					txtdatanasc.setEditable(false);
					txtcpf.setEditable(false);
					txtPesquisa.requestFocus();
				}
			}
		});
		
		alterCliente.setSize(280, 350);
		alterCliente.setLocationRelativeTo(null);
		alterCliente.setVisible(true);
		alterCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 ImageIcon imgvoltar = new ImageIcon("voltar.png");
		 final JButton voltar =  new JButton();
		 voltar.setIcon(imgvoltar);
		 voltar.setBackground(Color.white);
		 voltar.setBounds(237, 03, 39, 39);//65v 25
		 alterCliente.add(voltar);
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
					alterCliente.dispose();
					new MenuPrincipal();
					
				}
			});
		 
		alterCliente.add(voltar);
		btneditar.setVisible(false);
		btnsalvar.setVisible(false);
		btnexcluir.setVisible(false);
		txtnome.setEditable(false);
		cbsexo.setEnabled(false);
		txtdatanasc.setEditable(false);
		txtcpf.setEditable(false);
		txtPesquisa.requestFocus();
	}
	
	public void fecha(){
		novaJanela.dispose();
	}

}
