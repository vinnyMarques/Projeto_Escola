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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

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

import br.com.rubythree.escola.classe.ProfessorDAO;;

public class PesquisaProfessor {
	static String filtro;
	static String filtroMateria;
	static String filtroPreco;
	public PesquisaProfessor(){
		final JFrame pesqAluno = new JFrame("Escola Digital");
		Container c = pesqAluno.getContentPane();
		c.setBackground(Color.white);
		pesqAluno.setLayout(null);
	
		Color textcol2 = new Color(193,255,193);
		final JTable tblprofessor = new JTable(0,0);	
		tblprofessor.setAutoCreateRowSorter(true);
//		tblaluno.setFillsViewportHeight(true);
//		tblaluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		final ProfessorDAO pdao = new ProfessorDAO();
		pdao.getTable(tblprofessor);
		
		JScrollPane scrollPane = new JScrollPane(tblprofessor);
		scrollPane.setBounds(35, 60, 630, 146);	
//		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
		pesqAluno.add(scrollPane);
		String[] columnNames = {"Total", "Masculinos","Femininos",};
		
		Object[][] data = {{pdao.getTotalProfessores(),pdao.getMasculino(), pdao.getFeminino(),}};
		JTable tblsexo = new JTable(data, columnNames);
		JScrollPane scsexo = new JScrollPane(tblsexo);
		scsexo.setBounds(413, 210, 250, 34);	
		pesqAluno.add(scsexo);
		defineRenderers(tblprofessor, tblsexo);
		
		JLabel lblpesquisa = new JLabel("Professor");
		lblpesquisa.setBounds(38, 220, 80, 20);
		pesqAluno.add(lblpesquisa);
		final JTextField txtnome = new JTextField("Filtrar por professor");
		txtnome.setBounds(110, 220, 250, 20);
		pesqAluno.add(txtnome);
		txtnome.setBackground(textcol2);
	    	txtnome.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				filtro = txtnome.getText();
				pdao.filtraNome(tblprofessor, filtro);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (txtnome.getText().equals("Filtrar por professor")){
					txtnome.setText("");
					}
				}
		});
	    	
	    	txtnome.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {
					if (txtnome.getText().equals("")){
						txtnome.setText("Filtrar por professor");
						}
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if (txtnome.getText().equals("Filtrar por professor")){
						txtnome.setText("");
						}
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
			});	    	
	    	
	    	JLabel lblpesquisa2 = new JLabel("Matéria");
			lblpesquisa2.setBounds(38, 245, 80, 20);
			pesqAluno.add(lblpesquisa2);
			final JTextField txtAula = new JTextField("Filtrar por Matéria");
			txtAula.setBounds(110, 245, 250, 20);
			pesqAluno.add(txtAula);
			txtAula.setBackground(textcol2);
			txtAula.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent arg0) {}
				@Override
				public void keyReleased(KeyEvent arg0) {
					filtroMateria = txtAula.getText();
					pdao.filtraMateria(tblprofessor, filtroMateria);
				}
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (txtAula.getText().equals("Filtrar por Matéria")){
						txtAula.setText("");
						}
					}
			});
		    	
			txtAula.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {
						if (txtAula.getText().equals("")){
							txtAula.setText("Filtrar por Matéria");
							}
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						if (txtAula.getText().equals("Filtrar por Matéria")){
							txtAula.setText("");
							}
					}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
			
			
	    	JLabel lblpesquisa3 = new JLabel("Preço");
	    	lblpesquisa3.setBounds(38, 270, 80, 20);
			pesqAluno.add(lblpesquisa3);
			final JTextField txtPreco = new JTextField("Filtrar por Preço");
			txtPreco.setBounds(110, 270, 250, 20);
			pesqAluno.add(txtPreco);
			txtPreco.setBackground(textcol2);
			txtPreco.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent arg0) {}
				@Override
				public void keyReleased(KeyEvent arg0) {
					filtroPreco = txtPreco.getText();
					pdao.filtraPreco(tblprofessor, filtroPreco);
				}
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (txtPreco.getText().equals("Filtrar por Preço")){
						txtPreco.setText("");
						}
					}
			});
		    	
			txtPreco.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {
						if (txtPreco.getText().equals("")){
							txtPreco.setText("Filtrar por Preço");
							}
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						if (txtPreco.getText().equals("Filtrar por Preço")){
							txtPreco.setText("");
							}
					}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
			
	    ImageIcon imgvoltar = new ImageIcon("voltar.png");
	    final JButton voltar =  new JButton();
	    voltar.setIcon(imgvoltar);
	    voltar.setBackground(Color.white);
		voltar.setBounds(626, 03, 39, 39);
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
		
		final Color textcol1 = new Color(245,222,179);//vermelho
		JPanel pnFiltro = new JPanel();
		pnFiltro.setBounds(35, 210, 350, 85);
		pnFiltro.setBackground(textcol1);
		pnFiltro.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
		pesqAluno.add(pnFiltro);
		 
		ImageIcon imagem = new ImageIcon("agenda.jpeg");
		Color font = new Color(0,0,0);
		JLabel lbltitulo = new JLabel();
		lbltitulo.setIcon(imagem);
		lbltitulo.setBounds(02, -10, 128, 128);
		pesqAluno.add(lbltitulo);
		
		JLabel lbltitnome = new JLabel("Professores");
		lbltitnome.setForeground(font);
		lbltitnome.setFont(new Font("FreeMono", Font.BOLD,35));
		lbltitnome.setBounds(105, 15, 300, 40);
		pesqAluno.add(lbltitnome);
		
		pesqAluno.setSize(670, 330);
		pesqAluno.setLocationRelativeTo(null);
		pesqAluno.setVisible(true);
		pesqAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtnome.requestFocus();
	}
	
	private static void defineRenderers(JTable tblprofessor, JTable tblsexo) {  
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();  
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);  
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);  
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  
        
        TableColumnModel modeloDaColuna = tblprofessor.getColumnModel();   
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);  
        modeloDaColuna.getColumn(1).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(3).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(4).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(0).setPreferredWidth(110); 
        modeloDaColuna.getColumn(1).setPreferredWidth(70); 
        modeloDaColuna.getColumn(2).setPreferredWidth(110); 
        modeloDaColuna.getColumn(3).setPreferredWidth(110);
        modeloDaColuna.getColumn(4).setPreferredWidth(110);
        
        TableColumnModel modeloDaColuna2 = tblsexo.getColumnModel();  
        modeloDaColuna2.getColumn(0).setCellRenderer(rendererCentro);  
        modeloDaColuna2.getColumn(1).setCellRenderer(rendererCentro);  
        modeloDaColuna2.getColumn(2).setCellRenderer(rendererCentro);  
        tblprofessor.setEnabled(false); 
		tblsexo.setEnabled(false);
    }
}
