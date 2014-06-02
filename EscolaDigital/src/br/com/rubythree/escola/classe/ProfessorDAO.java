package br.com.rubythree.escola.classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.rubythree.escola.conector.ConnectionFactory;
import br.com.rubythree.escola.modelo.Professor;

import com.mysql.jdbc.Statement;

public class ProfessorDAO {
	int id;
	String nome;
	String sexo;
	String dataAdmissao;
	String preco;
	String cpf;
	String mPrimaria;
	String mSecundaria;
	String mTerciaria;
	private Connection connection;
	int totalProfessores = 0;
	int totalMasculino = 0;
	int totalFeminino =0;
	Object titulo1 [][] = {};
	
	public ProfessorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public int adiciona (Professor professor){
		int id;
		String sql = "insert into professor (nome,sexo,dataAdmissao, preco, cpf, materiaPrimaria, materiaSecundaria, materiaTerciaria) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getSexo());
			stmt.setString(3, professor.getDataAdmissao());
			stmt.setString(4, professor.getPreco());
			stmt.setString(5, professor.getCPF());
			stmt.setString(6, professor.getMateriaP());
			stmt.setString(7, professor.getMateriaS());
			stmt.setString(8, professor.getMateriaT());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			id = rs.getInt(1);
			professor.setID(id);
			stmt.close();
			System.out.println("Professor "+professor.getNome()+" cadastrado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	public void pesquisaCPF (String cpf){
		Professor professor = new Professor();
		String sql = ("select* from professor where cpf='" + cpf +"'");
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				professor.setID(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setSexo(rs.getString("sexo"));
				professor.setDataAdmissao(rs.getString("dataAdmissao"));
				professor.setPreco(rs.getString("preco"));
				professor.setCPF(rs.getString("cpf"));
				professor.setMateriaP(rs.getString("materiaPrimaria"));
				professor.setMateriaS(rs.getString("materiaSecundaria"));
				professor.setMateriaT(rs.getString("materiaTerciaria"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.id = professor.getID();
		this.nome = professor.getNome();
		this.sexo = professor.getSexo();
		this.dataAdmissao = professor.getDataAdmissao();
		this.preco = professor.getPreco();
		this.cpf = professor.getCPF();
		this.mPrimaria = professor.getMateriaP();
		this.mSecundaria = professor.getMateriaS();
		this.mTerciaria = professor.getMateriaT();
		
		System.out.println("Professor: " + professor.getNome() + " - Sexo: " + professor.getSexo()+ 
				" - Admissão: "+ professor.getDataAdmissao()+ " - Preço: "+ professor.getPreco()+ " - CPF: "+professor.getCPF()+ " - Materia Primaria: "+professor.getMateriaP());
	}
	
	public int getID(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public String getSexo(){
		return this.sexo;
	}
	public String getDataAdmissao(){
		return this.dataAdmissao;
	}
	public String getPreco(){
		return this.preco;
	}
	public String getCPF(){
		return this.cpf;
	}
	public String getMateriaP(){
		return this.mPrimaria;
	}
	public String getMateriaS(){
		return this.mSecundaria;
	}
	public String getMateriaT(){
		return this.mTerciaria;
	}
	
	
	public void altera (Professor professor, int id){
	String sql = "update professor set nome=?, sexo=?, dataAdmissao=?, preco=?, cpf=?,materiaPrimaria=?, materiaSecundaria=?, materiaTerciaria=?  where id=" +id;
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		if (professor.getNome() != null){
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getSexo());
			stmt.setString(3, professor.getDataAdmissao());
			stmt.setString(4, professor.getPreco());
			stmt.setString(5, professor.getCPF());
			stmt.setString(6, professor.getMateriaP());
			stmt.setString(7, professor.getMateriaS());
			stmt.setString(8, professor.getMateriaT());
			stmt.execute();
			stmt.close();
			System.out.println("Dados alterados");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public void remove(int id){
		String sql = "delete from professor where id="+id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute(); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void getTable(JTable tblprofessor) {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select nome, preco, materiaPrimaria, materiaSecundaria, materiaTerciaria from professor");
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblprofessor.getModel()).addColumn("Nome", titulo1);
	            ((DefaultTableModel) tblprofessor.getModel()).addColumn("Preço (aula)", titulo1); 
	            ((DefaultTableModel) tblprofessor.getModel()).addColumn("Matéria 1", titulo1); 
	            ((DefaultTableModel) tblprofessor.getModel()).addColumn("Matéria 2", titulo1); 
	            ((DefaultTableModel) tblprofessor.getModel()).addColumn("Matéria 3", titulo1); 
	            while (rs.next()) {
	                ((DefaultTableModel) tblprofessor.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    rs.getString(5).trim(),
	                    });
	                totalProfessores ++;
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public void filtraNome(JTable tblprofessor, String nome) {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select nome, preco, materiaPrimaria, materiaSecundaria, materiaTerciaria from professor WHERE  nome LIKE '%"+nome+"%'");
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblprofessor.getModel()).setNumRows(0);
	            tblprofessor.updateUI();
	            while (rs.next()) {
	                ((DefaultTableModel) tblprofessor.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    rs.getString(5).trim(),
	                    });
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public void filtraPreco(JTable tblprofessor, String preco) {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select nome, preco, materiaPrimaria, materiaSecundaria, materiaTerciaria from professor WHERE  preco LIKE '%"+preco+"%'");
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblprofessor.getModel()).setNumRows(0);
	            tblprofessor.updateUI();
	            while (rs.next()) {
	                ((DefaultTableModel) tblprofessor.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    rs.getString(5).trim(),
	                    });
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public void filtraMateria(JTable tblprofessor, String materia) {
		 	String sql = ("select nome, preco, materiaPrimaria, materiaSecundaria, materiaTerciaria from professor where materiaPrimaria LIKE '%"+materia+"%' || materiaSecundaria LIKE '%"+materia+"%' || materiaTerciaria LIKE '%"+materia+"%'");
		 	try { 
	            PreparedStatement stmt = this.connection.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblprofessor.getModel()).setNumRows(0);
	            tblprofessor.updateUI();
	            while (rs.next()) {
	                ((DefaultTableModel) tblprofessor.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    rs.getString(5).trim(),
	                    });
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 
	 public int getTotalProfessores(){
		 return this.totalProfessores;
	 }
	 
	 public ArrayList<String> getLista() {
	        try {
	        	
	            ArrayList<String> professores = new ArrayList<String>();
	            PreparedStatement stmt = this.connection.prepareStatement("select nome from professor");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	 Professor p = new Professor();
	                p.setNome(rs.getString("nome"));
	                professores.add(p.getNome()); 
	            }
	            rs.close();
	            stmt.close();
	            return professores;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
//      JComboBox cbprofessores = new JComboBox();
//		cbprofessores.setBounds(200, 170, 200, 20);
//		frame.add(cbprofessores);
//		for (String l : profDAO.getLista()) {
//			cbprofessores.addItem(l);
//		}
	 
	 public int getMasculino() {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select *from professor where sexo ='Masculino'");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                totalMasculino ++;
	            }
	            rs.close();
	            stmt.close();
	            return this.totalMasculino;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public int getFeminino() {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select *from professor where sexo ='Feminino'");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                totalFeminino ++;
	            }
	            rs.close();
	            stmt.close();
	            return this.totalFeminino;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }

	 boolean confirmaCPF;
	 public void confirmaCPF(String cpf){
			String sql = "select*from professor where cpf='"+cpf+"'";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()){
					confirmaCPF = false;
				} else {
					confirmaCPF = true;
				}
			} catch (Exception e) {
					System.out.println("erro confirma cpf");
			}
	 }
	 
			public boolean getConfirmaCPF (){
				return confirmaCPF;
		}
}
