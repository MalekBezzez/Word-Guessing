package JavaProjet;

import java.util.ArrayList;

public class generator {
	 
	public static ArrayList<String>  StringGenerator() {
		ArrayList<String> mot = new ArrayList<String>(12);
	
		ArrayList<String> voy = new ArrayList<String>(5);
		voy.add("A");
		voy.add("E");
		voy.add("I");
		voy.add("O");
		voy.add("U");
		//"AEIOU";
		ArrayList<String>  alpha = new ArrayList<String>(26)  ;
		  for (char c = 'A'; c <= 'Z'; c++) {
	            alpha.add(String.valueOf(c));}
		
		int randomNum;
		 
		 mot.add(alpha.get(4));//Ajouter 1ere lettre car le plus frequent 
		 
		
		 mot.add(alpha.get(0));//Ajouter deuxieme A car la lettre le plus frequent  en 2eme  place
		 String ch ;
		
		 for(int i=2;i<12;i++) {
			                 //terminer les dix caracteres restantes
			 
			 while(true ) {
			 randomNum = (int)(Math.random()*26);
			 
			 ch=alpha.get(randomNum);
			 if (voy.contains(ch)) {//1ere cas  ch est un voyelle 
				 int nbocvoy=0;
				 for(int j=0;j<i;j++) { //calculer nb d'occurence du voyelle ch 
					 if (ch.equals(mot.get(j)))
						 nbocvoy++;
					 }
				if(nbocvoy<=2) { // si chaine contient au max deux ch au prealable valide
					 mot.add(ch);
					 break;}//arreter le while	
				}//fin 1ere cas
			 else {//2eme cas 
				 int nbocon=0;
			 for(int j=0;j<i;j++) { //calculer nb d'occurence du consonne ch 
				 if (ch.equals(mot.get(j)))
					 nbocon++;
				 }
			if(nbocon<=1) { // si chaine contient au max deux ch au prealable valide
				 mot.add(ch);
				 break;} //arreter le while 
					 
				 }//fin 2eme cas
			 }
			 
		 }
		 
		 return mot  ;}// fin de la meth-
}
		 
		 
		 
		 
		
		 
		





