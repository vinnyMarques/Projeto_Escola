package br.com.rubythree.escola.formulario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import br.com.rubythree.escola.classe.alunoDAO;
import br.com.rubythree.escola.modelo.Aluno;

public class PesquisaAluno implements ActionListener {
	static String filtro;
	JFrame novaJanela;
		
		public PesquisaAluno(JFrame janela){
			this.novaJanela = janela;
		}
		
	@Override
	public void actionPerformed (ActionEvent arg0) {
		fecha();
		final JFrame pesqAluno = new JFrame("Escola Digital");
		Container c = pesqAluno.getContentPane();
		c.setBackground(Color.white);
		pesqAluno.setLayout(null);
	
		Color textcol2 = new Color(193,255,193);
		final JTable tblaluno = new JTable(0,0);	
        tblaluno.setAutoCreateRowSorter(true);
//		tblaluno.setFillsViewportHeight(true);
//		tblaluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		alunoDAO aldao = new alunoDAO();
		aldao.getTable(tblaluno);
		
		JScrollPane scrollPane = new JScrollPane(tblaluno);
		scrollPane.setBounds(35, 60, 430, 146);	
//		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
		pesqAluno.add(scrollPane);
		String[] columnNames = {"Total", "Masculinos","Femininos",};
		
		Object[][] data = {{aldao.getTotalAlunos(),aldao.getMasculino(), aldao.getFeminino(),}};
		JTable tblsexo = new JTable(data, columnNames);
		JScrollPane scsexo = new JScrollPane(tblsexo);
		scsexo.setBounds(213, 240, 250, 34);	
		pesqAluno.add(scsexo);
		defineRenderers(tblaluno, tblsexo);
		
		JLabel lblpesquisa = new JLabel("Filtrar:");
		lblpesquisa.setBounds(38, 210, 80, 20);
		pesqAluno.add(lblpesquisa);
		
		final JTextField txtnome = new JTextField("Insira o Nome de filtragem");
		txtnome.setBounds(95, 210, 250, 20);
		pesqAluno.add(txtnome);
		txtnome.setBackground(textcol2);
		
	    	txtnome.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				filtro = txtnome.getText();
				new alunoDAO().filtraTable(tblaluno, filtro);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (txtnome.getText().equals("Insira o Nome de filtragem")){
					txtnome.setText("");
					}
			}
		});
	    	
	    	txtnome.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent arg0) {
			    	if (txtnome.getText().equals("Insira o Nome de filtragem")){
					txtnome.setText("");
					}
				}
				@Override
				public void mouseDragged(MouseEvent arg0) {}
			});
	    
	    tblaluno.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtnome.getText().equals("")){
					txtnome.setText("Insira o Nome de filtragem");
					}
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});	
	    
	    tblsexo.addMouseMotionListener(new MouseMotionListener() {		
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtnome.getText().equals("")){
					txtnome.setText("Insira o Nome de filtragem");
					}
				
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
	    
	    scrollPane.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtnome.getText().equals("")){
					txtnome.setText("Insira o Nome de filtragem");
					}
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
	    pesqAluno.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (txtnome.getText().equals("")){
					txtnome.setText("Insira o Nome de filtragem");
					}
			}
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
	    
	   
	    ImageIcon imgvoltar = new ImageIcon("voltar.png");
	    final JButton voltar =  new JButton();
	    voltar.setIcon(imgvoltar);
	    voltar.setBackground(Color.white);
		voltar.setBounds(426, 03, 39, 39);//65v 25
		pesqAluno.add(voltar);
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
					pesqAluno.dispose();
					new MenuPrincipal();
					
				}
			});
		
		ImageIcon imagem = new ImageIcon("agenda.jpeg");
		Color font = new Color(0,0,0);
		JLabel lbltitulo = new JLabel();
		lbltitulo.setIcon(imagem);
		lbltitulo.setBounds(02, -10, 128, 128);
		pesqAluno.add(lbltitulo);
		
		JLabel lbltitnome = new JLabel("Alunos");
		lbltitnome.setForeground(font);
		lbltitnome.setFont(new Font("FreeMono", Font.BOLD,35));
		lbltitnome.setBounds(105, 15, 200, 40);
		pesqAluno.add(lbltitnome);
		
		pesqAluno.setSize(470, 310);
		pesqAluno.setLocationRelativeTo(null);
		pesqAluno.setVisible(true);
		pesqAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtnome.requestFocus();
	}
	
	public void fecha(){
		novaJanela.dispose();
	}
	
	private static void defineRenderers(JTable tblaluno, JTable tblsexo) {  
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();  
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);  
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);  
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  
        
        TableColumnModel modeloDaColuna = tblaluno.getColumnModel();   
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);  
        modeloDaColuna.getColumn(1).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(3).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(0).setPreferredWidth(110); 
        modeloDaColuna.getColumn(1).setPreferredWidth(90); 
        modeloDaColuna.getColumn(2).setPreferredWidth(60); 
        modeloDaColuna.getColumn(3).setPreferredWidth(60); 
        
        TableColumnModel modeloDaColuna2 = tblsexo.getColumnModel();  
        modeloDaColuna2.getColumn(0).setCellRenderer(rendererCentro);  
        modeloDaColuna2.getColumn(1).setCellRenderer(rendererCentro);  
        modeloDaColuna2.getColumn(2).setCellRenderer(rendererCentro);  
        tblaluno.setEnabled(false); 
		tblsexo.setEnabled(false);
    }
}
