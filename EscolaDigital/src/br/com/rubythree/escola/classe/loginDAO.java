package br.com.rubythree.escola.classe;
import br.com.rubythree.escola.conector.ConnectionFactory;
import br.com.rubythree.escola.modelo.Aluno;
import br.com.rubythree.escola.modelo.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

public class loginDAO {
	private int id;
	private String user;
	private String pass;
	private boolean autentica;
	private boolean confirmaLogin;
	Connection connection;
	
	public loginDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public int adiciona (Login login){
		int id;
		String sql = "insert into login (user,password) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, login.getUser());
			stmt.setString(2, login.getPass());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			id = rs.getInt(1);
			login.setID(id);
			stmt.close();
			System.out.println("Usuário "+login.getUser()+" cadastrado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	public void altera (Login login, int id){
		String sql = "update login set user=?, password=?  where id=" +id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, login.getUser());
				stmt.setString(2, login.getPass());
				stmt.execute();
				stmt.close();
				System.out.println("Dados alterados");
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	public void remove(String user){
		String sql = "delete from login where user='" + user+"'";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute(); 
			stmt.close();
			System.out.println("Login removido");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void pesquisa (String user){
		Login log = new Login();
		String sql = ("select* from login where user='" + user+"'");
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				log.setID(rs.getInt("id"));
				log.setUser(rs.getString("user"));
				log.setPass(rs.getString("password"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.id = log.getID();
		this.user = log.getUser();
		this.pass = log.getPass();
		
		System.out.println("ID: " + log.getID() + " - Login: " + log.getUser()+ 
				" - Senha: "+ log.getPass());
	}
	
	public int getID(){
		return this.id;
	}
	public String getUser(){
		return this.user;
	}
	public String getPass(){
		return this.pass;
	}
	
	Object linhaTb [][] = {};
	public void getTable(JTable tblLogin) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select user from login");
            ResultSet rs = stmt.executeQuery();
            ((DefaultTableModel) tblLogin.getModel()).addColumn("Usuário", linhaTb);
//            ((DefaultTableModel) tblLogin.getModel()).addColumn("Senha", linhaTb); 
            while (rs.next()) {
                ((DefaultTableModel) tblLogin.getModel()).addRow(new Object[]{	
                	rs.getString(1).trim(),
//                    rs.getString(2).trim(),
                    });
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void filtraTable(JTable tblLogin, String valor) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select user from login WHERE  user LIKE '%"+valor+"%'");
            ResultSet rs = stmt.executeQuery();
            ((DefaultTableModel) tblLogin.getModel()).setNumRows(0);
            tblLogin.updateUI();
            while (rs.next()) {
                ((DefaultTableModel) tblLogin.getModel()).addRow(new Object[]{	
                	rs.getString(1).trim(),
//                    rs.getString(2).trim(),
                    });
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void autentica(String user, String pass){
		String sql = "select*from login where user='"+user+"' and password='"+pass+"'";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				autentica = true;
			} else {
				autentica = false;
			}
		} catch (Exception e) {
				autentica = false;
		}
	}
	
	public boolean getAutenticacao (){
		return autentica;
	}
	
	public void confirmaLogin(String user){
		String sql = "select*from login where user='"+user+"'";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				confirmaLogin = false;
			} else {
				confirmaLogin = true;
			}
		} catch (Exception e) {
				System.out.println("erro confirma login");
		}
	}
	
	public boolean getConfirmaLogin (){
		return confirmaLogin;
	}
}
