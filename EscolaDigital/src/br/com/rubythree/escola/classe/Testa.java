package br.com.rubythree.escola.classe;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.rubythree.escola.modelo.*;

public class Testa {
	public static void main (String[]args){
		
		ProfessorDAO pdao = new ProfessorDAO();
//		Professor p = new Professor();
//		p.setNome("Ronaldo");
//		p.setSexo("Masculino");
//		p.setDataAdmissao("30/05/2014");
//		p.setPreco("80,00");
//		p.setCPF("002.002.000-00");
//		p.setMateriaP("Matemática");
//		p.setMateriaS("Português");
//		
//		pdao.confirmaCPF("002.002.900-00");
//		System.out.print("cpf - "+pdao.getConfirmaCPF());
		pdao.remove(5);
		
//		java.util.Date data = new Date();
//		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
//		String novaData = formatador.format(data);  
//		System.out.println(novaData);
	}

}
