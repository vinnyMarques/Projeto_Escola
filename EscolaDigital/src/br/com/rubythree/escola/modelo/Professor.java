package br.com.rubythree.escola.modelo;

public class Professor {
	private int id;
	private String nome;
	private String sexo;
	private String dataAdmissao;
	private String preco;
	private String cpf;
	private String materiaPrimaria;
	private String materiaSecundaria;
	private String materiaTerciaria;
	
	public String getMateriaP(){
		return this.materiaPrimaria;
	}
	public void setMateriaP(String materiaPrimaria){
		this.materiaPrimaria = materiaPrimaria;
	}
	
	public String getMateriaS(){
		return this.materiaSecundaria;
	}
	public void setMateriaS(String materiaSecundaria){
		this.materiaSecundaria = materiaSecundaria;
	}
	
	public String getMateriaT(){
		return this.materiaTerciaria;
	}
	public void setMateriaT(String materiaTerciaria){
		this.materiaTerciaria = materiaTerciaria;
	}
	
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
	
	public String getDataAdmissao(){
		return this.dataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao){
		this.dataAdmissao = dataAdmissao;
	}
	
	public String getPreco(){
		return this.preco;
	}
	public void setPreco(String preco){
		this.preco = preco;
	}
	public String getCPF(){
		return this.cpf;
	}
	public void setCPF(String cpf){
		this.cpf = cpf;
	}
}
