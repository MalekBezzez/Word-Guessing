package JavaProjet;

import java.util.ArrayList;

public class test {public static void main(String args[]) {
	ArrayList<String> mot = generator.StringGenerator();
	 FenetreM M= new FenetreM(mot) ;
	FenetreJ2 j2 =new FenetreJ2(mot,"Fenetre joueur 2");
	
	FenetreJ j1 =new FenetreJ(mot,"Fentre joueur 1");
	
	j1.setfcible(j2);
	j2.setfcible(j1);
	
	 
	  M.setf1(j1);
	  M.setf2(j2);
	  j1.setfcontrol(M);
	  j2.setfcontrol(M);
	  
	  
	  
	  
}
	

	 
	 }
	 
	 
	




