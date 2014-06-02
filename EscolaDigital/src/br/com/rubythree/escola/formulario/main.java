package br.com.rubythree.escola.formulario;
import java.awt.Menu;

import com.jgoodies.common.swing.MnemonicUtils;


public class main {

	public static void main (String args[]){
		
		SplashJF splash = new SplashJF();
		splash.setVisible(true);
		splash.carregar();
		
		splash.dispose();
		new MenuCarregamento();	
	}
}
