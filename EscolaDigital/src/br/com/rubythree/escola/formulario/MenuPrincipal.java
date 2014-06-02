package br.com.rubythree.escola.formulario;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MenuPrincipal{
	
	public MenuPrincipal() {

		final JFrame mainFrame = new JFrame("Escola Digital");
		final Color frame = new Color(139,115,85);
		final Color tan = new Color(224,238,238) ;//232//////
		final Color btncolor2 = new Color (0,0,0);//139,115,85
		final Color btncolor1 = new Color (0,0,0);
		final Color font = new Color(0,0,0);//139,119,101
		Color titulo = new Color(205 ,183 ,158 );//   205 ,175 ,149
		
		Container c = mainFrame.getContentPane();
		c.setBackground(btncolor1);
		mainFrame.requestFocusInWindow();
		mainFrame.setLayout(null);
	
		JLabel lbltitulo1 = new JLabel("Aluno");
		lbltitulo1.setForeground(titulo);
		lbltitulo1.setFont(new Font("FreeMono", Font.BOLD,35));
		lbltitulo1.setBounds(80, 10, 300, 80);
		mainFrame.add(lbltitulo1);
		
		final JButton cadAluno = new JButton("Cadastro");
		cadAluno.setBounds(50, 80, 150, 40);
		mainFrame.add(cadAluno); 
		cadAluno.setFont(new Font("Tahoma", Font.BOLD,13));
		cadAluno.setForeground(font);
		CadastroAluno ca = new CadastroAluno(mainFrame);
		cadAluno.setBackground(tan);
		cadAluno.addActionListener(ca);
		cadAluno.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		cadAluno.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				cadAluno.setBounds(45, 75, 160, 50);
				cadAluno.setFont(new Font("Tahoma", Font.BOLD,16));
				cadAluno.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		cadAluno.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				cadAluno.setFont(new Font("Tahoma", Font.BOLD,13));
				cadAluno.setBounds(50, 80, 150, 40);
				cadAluno.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		final JButton pesqAluno = new JButton("Consulta");
		pesqAluno.setBounds(50, 120, 150, 40);
		pesqAluno.setForeground(font);
		pesqAluno.setBackground(tan);
		mainFrame.add(pesqAluno);
		pesqAluno.setFont(new Font("Tahoma", Font.BOLD,13));
		PesquisaAluno pesquisaAl = new PesquisaAluno(mainFrame);
		pesqAluno.addActionListener(pesquisaAl);
		pesqAluno.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		pesqAluno.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				pesqAluno.setBounds(45, 115, 160, 50);
				pesqAluno.setFont(new Font("Tahoma", Font.BOLD,16));
				pesqAluno.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		pesqAluno.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				pesqAluno.setFont(new Font("Tahoma", Font.BOLD,13));
				pesqAluno.setBounds(50, 120, 150, 40);
				pesqAluno.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		final JButton btnalterAl = new JButton("Alterar");
		btnalterAl.setBounds(50, 160, 150, 40);
		btnalterAl.setForeground(font);
		mainFrame.add(btnalterAl);
		btnalterAl.setFont(new Font("Tahoma", Font.BOLD,13));
		btnalterAl.setBackground(tan);
		AlteraAluno alteraal = new AlteraAluno(mainFrame);
		btnalterAl.addActionListener(alteraal);
		btnalterAl.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		btnalterAl.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnalterAl.setFont(new Font("Tahoma", Font.BOLD,16));
				btnalterAl.setBounds(45, 155, 160, 50);
				btnalterAl.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		btnalterAl.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				btnalterAl.setFont(new Font("Tahoma", Font.BOLD,13));
				btnalterAl.setBounds(50, 160, 150, 40);
				btnalterAl.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		JLabel lbltitulo2 = new JLabel("Professor");
		lbltitulo2.setForeground(titulo);
		lbltitulo2.setFont(new Font("FreeMono", Font.BOLD,35));
		lbltitulo2.setBounds(270, 10, 300, 80);
		mainFrame.add(lbltitulo2);
		
		final JButton cadProfessor = new JButton("Cadastro");
		cadProfessor.setBounds(280, 80, 150, 40);
		mainFrame.add(cadProfessor);
		cadProfessor.setForeground(font);
		cadProfessor.setBackground(tan);
		cadProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
		cadProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		cadProfessor.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				cadProfessor.setBounds(275, 75, 160, 50);
				cadProfessor.setFont(new Font("Tahoma", Font.BOLD,16));
				cadProfessor.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		cadProfessor.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				cadProfessor.setBounds(280, 80, 150, 40);
				cadProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
				cadProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		cadProfessor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				new CadastroProfessor();
				
			}
		});
		
		final JButton pesqProfessor = new JButton("Consulta");
		pesqProfessor.setBounds(280, 120, 150, 40);
		pesqProfessor.setBackground(tan);
		pesqProfessor.setForeground(font);
		mainFrame.add(pesqProfessor);
		pesqProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
		pesqProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		pesqProfessor.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				pesqProfessor.setBounds(275, 115, 160, 50);
				pesqProfessor.setFont(new Font("Tahoma", Font.BOLD,16));
				pesqProfessor.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
		pesqProfessor.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				pesqProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
				pesqProfessor.setBounds(280, 120, 150, 40);
				pesqProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		pesqProfessor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				new PesquisaProfessor();
			}
		});
		final JButton alterProfessor = new JButton("Alterar");
		alterProfessor.setBounds(280, 160, 150, 40);
		alterProfessor.setBackground(tan);
		alterProfessor.setForeground(font);
		mainFrame.add(alterProfessor);
		alterProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
		alterProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
		alterProfessor.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				alterProfessor.setBounds(275, 155, 160, 50);
				alterProfessor.setFont(new Font("Tahoma", Font.BOLD,16));
				alterProfessor.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override 
			public void mouseDragged(MouseEvent e) {}
		});
		alterProfessor.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				alterProfessor.setFont(new Font("Tahoma", Font.BOLD,13));
				alterProfessor.setBounds(280, 160, 150, 40);
				alterProfessor.setBorder(BorderFactory.createLineBorder(btncolor2, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		final JButton btnsair = new JButton("X");
		btnsair.setFont(new Font("Tahoma", Font.BOLD,14));
		btnsair.setForeground(Color.LIGHT_GRAY);
		btnsair.setBorder(BorderFactory.createLineBorder(btncolor1, 1));
		btnsair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				
			}
		});
		
		final Color orred = new Color(139,0,0);
		btnsair.setBounds(5, 5, 50, 30);
		mainFrame.add(btnsair);
		btnsair.setBackground(orred);
		btnsair.setVisible(true);
		btnsair.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				btnsair.setBounds(5, 5, 50, 30);
				btnsair.setFont(new Font("Tahoma", Font.BOLD,14));
				btnsair.setBorder(BorderFactory.createLineBorder(btncolor1, 1));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsair.setBounds(2, 2, 56, 36);
				btnsair.setFont(new Font("Tahoma", Font.BOLD,16));
				btnsair.setBorder(BorderFactory.createLineBorder(btncolor1, 2));
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		ImageIcon imagem = new ImageIcon("fundo.jpg");
		JLabel paneltela = new JLabel();
		paneltela.setBounds(-400, -200, 1600, 900);
		paneltela.setIcon(imagem);
		mainFrame.add(paneltela);
		
		ImageIcon imagemagenda = new ImageIcon("fundoagenda.png");
		JLabel panelagenda = new JLabel();
		panelagenda.setBounds(400, 419, 942, 355);
		panelagenda.setIcon(imagemagenda);
		paneltela.add(panelagenda);
		
		final Color gold = new Color(139 ,117, 0 );
		ImageIcon agendarIcon = new ImageIcon("AgendaMais2.png");
		final JLabel agendamentos = new JLabel();
		agendamentos.setBounds(150, 45, 41, 41);
		agendamentos.setIcon(agendarIcon);
		agendamentos.setBackground(Color.white);
		panelagenda.add(agendamentos);
		agendamentos.setBorder(BorderFactory.createLineBorder(null));
		agendamentos.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Clickou");
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				agendamentos.setBorder(BorderFactory.createLineBorder(null));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				agendamentos.setBorder(BorderFactory.createLineBorder(gold, 1));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		ImageIcon consAgendaIcon = new ImageIcon("AgendaCons.png");
		final JLabel consAgenda = new JLabel();
		consAgenda.setBounds(193, 45, 41, 41);
		consAgenda.setIcon(consAgendaIcon);
		consAgenda.setBackground(Color.white);
		panelagenda.add(consAgenda);
		consAgenda.setBorder(BorderFactory.createLineBorder(null));
		consAgenda.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Clickou");
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				consAgenda.setBorder(BorderFactory.createLineBorder(null));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				consAgenda.setBorder(BorderFactory.createLineBorder(gold, 1));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		ImageIcon agendaModifyIcon = new ImageIcon("AgendaModify.png");
		final JLabel modifyAgenda = new JLabel();
		modifyAgenda.setBounds(236, 45, 41, 41);
		modifyAgenda.setIcon(agendaModifyIcon);
		modifyAgenda.setBackground(Color.white);
		panelagenda.add(modifyAgenda);
		modifyAgenda.setBorder(BorderFactory.createLineBorder(null));
		modifyAgenda.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Clickou");
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				modifyAgenda.setBorder(BorderFactory.createLineBorder(null));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				modifyAgenda.setBorder(BorderFactory.createLineBorder(gold, 1));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		mainFrame.setSize(500,350);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.requestFocusInWindow();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
