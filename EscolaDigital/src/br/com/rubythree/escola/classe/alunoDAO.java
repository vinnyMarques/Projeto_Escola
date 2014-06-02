package br.com.rubythree.escola.classe;
import br.com.rubythree.escola.conector.ConnectionFactory;
import br.com.rubythree.escola.modelo.Aluno;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.mysql.jdbc.Statement;

public class alunoDAO {
	int id;
	String nome;
	String sexo;
	String datanasc;
	String cpf;
	private Connection connection;
	int totalAlunos = 0;
	int totalMasculino = 0;
	int totalFeminino =0;
	Object titulo1 [][] = {};
	
	public alunoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}

	public int adiciona (Aluno aluno){
		int id;
		String sql = "insert into aluno (nome,sexo,dataNascimento,cpf) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getSexo());
			stmt.setString(3, aluno.getDataNascimento());
			stmt.setString(4, aluno.getCPF());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			id = rs.getInt(1);
			aluno.setID(id);
			stmt.close();
			System.out.println("Aluno "+aluno.getNome()+" cadastrado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	public void pesquisa (int id){
		Aluno aluno = new Aluno();
		String sql = ("select* from aluno where id=" +id);
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataNascimento(rs.getString("dataNascimento"));
				aluno.setCPF(rs.getString("cpf"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.nome = aluno.getNome();
		this.sexo = aluno.getSexo();
		this.datanasc = aluno.getDataNascimento();
		this.cpf = aluno.getCPF();
		
		System.out.println("Nome: " + aluno.getNome() + " - Sexo: " + aluno.getSexo()+ 
				" - Nascimento: "+ aluno.getDataNascimento()+ " - CPF: "+aluno.getCPF());
	}
	
	public void pesquisaCPF (String cpf){
		Aluno aluno = new Aluno();
		String sql = ("select* from aluno where cpf='" + cpf+"'");
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				aluno.setID(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDataNascimento(rs.getString("dataNascimento"));
				aluno.setCPF(rs.getString("cpf"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.id = aluno.getID();
		this.nome = aluno.getNome();
		this.sexo = aluno.getSexo();
		this.datanasc = aluno.getDataNascimento();
		this.cpf = aluno.getCPF();
		
		System.out.println("Nome: " + aluno.getNome() + " - Sexo: " + aluno.getSexo()+ 
				" - Nascimento: "+ aluno.getDataNascimento()+ " - CPF: "+aluno.getCPF());
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
	public String getDataNasc(){
		return this.datanasc;
	}
	public String getCPF(){
		return this.cpf;
	}
	
	public void altera (Aluno aluno, int id){
	String sql = "update aluno set nome=?, sexo=?, dataNascimento=?, cpf=?  where id=" +id;
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		if (aluno.getNome() != null){
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getSexo());
			stmt.setString(3, aluno.getDataNascimento());
			stmt.setString(4, aluno.getCPF());
			stmt.execute();
			stmt.close();
			System.out.println("Dados alterados");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public void remove(int id){
		Aluno aluno = new Aluno();
		String sql = "delete from aluno where id="+id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute(); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void getTable(JTable tblaluno) {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select nome, cpf, sexo, dataNascimento from aluno");
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblaluno.getModel()).addColumn("Nome", titulo1);
	            ((DefaultTableModel) tblaluno.getModel()).addColumn("CPF", titulo1); 
	            ((DefaultTableModel) tblaluno.getModel()).addColumn("Sexo", titulo1); 
	            ((DefaultTableModel) tblaluno.getModel()).addColumn("Nascimento", titulo1); 
	            while (rs.next()) {
	                ((DefaultTableModel) tblaluno.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    });
	                totalAlunos ++;
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public void filtraTable(JTable tblaluno, String valor) {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("SELECT nome, cpf, sexo, dataNascimento FROM  aluno WHERE  nome LIKE '%"+valor+"%'");
	            ResultSet rs = stmt.executeQuery();
	            ((DefaultTableModel) tblaluno.getModel()).setNumRows(0);
	            tblaluno.updateUI();
	            while (rs.next()) {
	                ((DefaultTableModel) tblaluno.getModel()).addRow(new Object[]{	
	                	rs.getString(1).trim(),
	                    rs.getString(2).trim(),
	                    rs.getString(3).trim(),
	                    rs.getString(4).trim(),
	                    });
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public int getTotalAlunos(){
		 return this.totalAlunos;
	 }
	 
	 public ArrayList<String> getLista() {
	        try {
	        	
	            ArrayList<String> alunos = new ArrayList<String>();
	            PreparedStatement stmt = this.connection.prepareStatement("select nome from aluno");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	 Aluno a = new Aluno();
	                a.setNome(rs.getString("nome"));
	                alunos.add(a.getNome()); 
	            }
	            rs.close();
	            stmt.close();
	            return alunos;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
//     JComboBox cbalunos = new JComboBox();
//		cbalunos.setBounds(200, 170, 200, 20);
//		pesqAluno.add(cbalunos);
//		for (String l : aldao.getLista()) {
//			cbalunos.addItem(l);
//		}
	 
	 public int getMasculino() {
	        try {
	            PreparedStatement stmt = this.connection.prepareStatement("select *from aluno where sexo ='Masculino'");
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
	            PreparedStatement stmt = this.connection.prepareStatement("select *from aluno where sexo ='Feminino'");
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
}
