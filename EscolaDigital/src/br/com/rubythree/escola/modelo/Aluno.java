package br.com.rubythree.escola.modelo;

import br.com.rubythree.escola.classe.alunoDAO;

import javax.swing.JOptionPane;

public class Aluno {
		private int id;
		private String nome;
		private String sexo;
		private String dataNascimento;
		private String cpf;
		
		public int getID(){
			return this.id;
		}
		public void setID(int id){
			this.id = id;
		}
		
		public String getNome(){
			return this.nome;
		}
		public void setNome(String nome){
			this.nome = nome;
		}
		
		public String getSexo(){
			return this.sexo;
		}
		public void setSexo(String sexo){
			this.sexo = sexo;
		}
		
		public String getDataNascimento(){
			return this.dataNascimento;
		}
		public void setDataNascimento(String dataNascimento){
			this.dataNascimento = dataNascimento;
		}
		
		public String getCPF(){
			return this.cpf;
		}
		public void setCPF(String cpf){
			this.cpf = cpf;
		}
		
		public static void registra(){
			Aluno aluno = new Aluno();
			aluno.setNome(JOptionPane.showInputDialog("Nome"));
			aluno.setSexo(JOptionPane.showInputDialog("sexo"));
			aluno.setDataNascimento(JOptionPane.showInputDialog("Data de Nascimento"));
			aluno.setCPF(JOptionPane.showInputDialog("cpf"));
			
			new alunoDAO().adiciona(aluno);
		}
}
