package JavaProjet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
  


public class FenetreJ  extends JFrame implements ActionListener {
	JLabel lnom= new JLabel("Nom Joueur "); 
	JTextField tnom=new JTextField(20);
	ArrayList<String> mot =generator.StringGenerator();// on a obtenu le mot 
	
	// l'affectation de chaque bouton a chaque cractere 
	
	
	
	JButton valnom=new JButton("O.K");
	JButton b1= new JButton();
	JButton b2= new JButton();
	JButton b3= new JButton();
	JButton b4= new JButton();
	JButton b5= new JButton();
	JButton b6= new JButton();
	JButton b7= new JButton();
	JButton b8= new JButton();
	JButton b9= new JButton();
	JButton b10= new JButton();
	JButton b11= new JButton();
	JButton b12= new JButton();
	JButton validate=new JButton("Valider");
	String strtentative=""  ;
	ArrayList<JButton> listeB = new ArrayList<JButton>(12);
	ArrayList<String> listeTB= new ArrayList<String>(12); // liste texte des boutons 
	ArrayList<String> Dictionnaire=LectureFichier.dictionnaire();
	// temps  
	public Timer timer;
    public JLabel labelTemps;
    public int tempsTotal = 0;
      
    
    // Score
    ArrayList<String>  recapm=new ArrayList<String>(10);
    ArrayList<Integer>  recapt=new ArrayList<Integer>(10);
    String ch1="";
    JPanel panrecap=new JPanel();
    // score text pour joueur 1
    JTextField s1 = new JTextField("");
	JTextField s2 = new JTextField("");
	JTextField s3 = new JTextField("");
	JTextField s4 = new JTextField("");
	JTextField s5 = new JTextField("");
	JTextField s6 = new JTextField("");
	JTextField s7 = new JTextField("");
	JTextField s8 = new JTextField("");
	JTextField s9 = new JTextField("");
	JTextField s10 = new JTextField("");
	ArrayList<JTextField> liste = new ArrayList<JTextField>(10);
	JPanel Score=new JPanel(new GridLayout(1,2)) ;
	JLabel lScore=new JLabel("Score : ");
     
    
	
	
	
	
	
// je veut repeter le processus a chaque tour
	
	//ou le mot ecrit sera affiché
	
	JLabel msg=new JLabel("    Votre tentative sera ecrite au dessous  ↓ ↓ ↓");
	
	JLabel tentative=new JLabel(strtentative);
	ArrayList<Integer> historique=new ArrayList<Integer>(12);
	  
	boolean validtest= false;
	
	
     FenetreJ2 fcible;
      
     int nbtour=0;
     
     
     //fenetre de contole 
      
     FenetreM fcontrol;
	
	

     final JPanel mainpan=new JPanel(new GridLayout(7,1,5,5) );

	public FenetreJ(final ArrayList<String> mot, String Title )  {
		// final pour etre reconnu dans les classes definit au sein de ce classe
		// score j1
		
		Font originalFont = lScore.getFont();
        Font newFont = originalFont.deriveFont(originalFont.getSize() * 4F); 
        lScore.setFont(newFont);
		liste.add(s1);
		liste.add(s2);
		liste.add(s3);
		liste.add(s4);
		liste.add(s5);
		liste.add(s6);
		liste.add(s7);
		liste.add(s8);
		liste.add(s9);
		liste.add(s10);
		
		for (int i = 0; i < 10; i++) {
			liste.get(i).setVisible(false);
			
		}
		JPanel panscore = new JPanel(new GridLayout(1, 10,2,1));
		for (int i = 0; i < 10; i++) {
			panscore.add(liste.get(i));
		}
		Score.add(lScore);
		Score.add(panscore);
		//affectation des bouton dans une liste 
		listeB.add(b1);
		listeB.add(b2);
		listeB.add(b3);
		listeB.add(b4);
		listeB.add(b5);
		listeB.add(b6);
		listeB.add(b7);
		listeB.add(b8);
		listeB.add(b9);
		listeB.add(b10);
		listeB.add(b11);
		listeB.add(b12);
		
		 // blocker au prealable
		for(int i=0;i<12;i++) {
			this.listeB.get(i).setVisible(false);
		}
		validate.setVisible(false);
		 
		
		
		// l'affectation de chaque bouton a chaque cractere 
		String c1=mot.get(0);
		String c2=mot.get(1);
		String c3=mot.get(2);
		String c4=mot.get(3);
		String c5=mot.get(4);
		String c6=mot.get(5);
		String c7=mot.get(6);
		String c8=mot.get(7);
		String c9=mot.get(8);
		String c10=mot.get(9);
		String c11=mot.get(10);
		String c12=mot.get(11);
		//l'affectation de liste de texte bouton
		
		
		 b1.setText(c1);
		 b2.setText(c2);
		 b3.setText(c3);
		 b4.setText(c4);
		 b5.setText(c5);
		 b6.setText(c6);
		 b7.setText(c7);
		 b8.setText(c8);
		 b9.setText(c9);
		 b10.setText(c10);
		 b11.setText(c11);
		 b12.setText(c12);
		//l'affectation de liste de texte bouton
		 for(JButton b : listeB) {
			 listeTB.add(b.getText())	; }
		
       
		 
		 
		
		 JPanel pantext=new JPanel();
		 
		
		JPanel pan=new JPanel(new GridLayout(1,3,10,0));//
		pan.add(lnom);
		pan.add(tnom);
		pan.add(valnom);
		pantext.add(pan,BorderLayout.SOUTH);
		mainpan.add(pantext);
		
		
		// timer     
		labelTemps = new JLabel("Temps écoulé : 00:00");
        labelTemps.setHorizontalAlignment(SwingConstants.CENTER);
        labelTemps.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labelTemps, BorderLayout.CENTER); // a modifier

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsTotal++;//en seconde
                int minutes = tempsTotal / 60;
                int secondes = tempsTotal % 60;

                labelTemps.setText(String.format("Temps écoulé : %02d:%02d", minutes, secondes));
                
                if(tempsTotal>= 60*4) {
                	nbtour++;
        			//  echoué  *********
        			
        			tentative.setText("");
        			strtentative="";
        			recapm.add("");
    				recapt.add(4*60);
        			 
                	mainpan.setEnabled(false);// desactiver saisi clavier
    				for(JButton eb : listeB) {// desactiver les bouton
    					eb.setEnabled(false);
    				}
    				validate.setEnabled(false);
    				stopChronometre();
    				historique.clear();//initialiser historique pour la prochaine tentative
    				validtest=true;
    				if(nbtour==fcible.nbtour)	{ // round accomplit 
    				    	fcontrol.setupRound(nbtour+1);
    				       }
    					
    					
    					if(nbtour%2!=0) {//si le nombre de tour est impaire c'est le tour du joueur 2
    					fcible.UnBlock();
    					fcible.startChronometre();}
    					else {// le nombre de tour est paire
    						UnBlock();
    						startChronometre();
    						
    					}
                }
            }
        });
        //fin 
    

		
		
		JPanel pantemp= new JPanel();
		pantemp.add(labelTemps);
		mainpan.add(pantemp);
		
		
		final JPanel pan1=new JPanel(new GridLayout(3,4,7,7));//diviser la zone 
		pan1.add(b1);
		pan1.add(b2);
		pan1.add(b3);
		pan1.add(b4);
		pan1.add(b5);
		pan1.add(b6);
		pan1.add(b7);
		pan1.add(b8);
		pan1.add(b9);
		pan1.add(b10);
		pan1.add(b11);
		pan1.add(b12);
		mainpan.add(pan1);
		mainpan.add(msg);
		 JPanel pantent=new JPanel();
		 pantent.add(tentative);
		 
		 mainpan.add(pantent);
		 JPanel panval= new JPanel();
		 panval.add(validate,BorderLayout.NORTH);
				 
		 mainpan.add(panval);
		 mainpan.add(Score);
		
		
		
		 
		 
		
		 //les actionslistener
		 valnom.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			 tnom.setEnabled(false);
			 valnom.setEnabled(false);
			 pan1.requestFocusInWindow();
			
			 
		 }});
		 
	
		b1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
				historique.add(0);
				
				strtentative+=b1.getText();
				
				tentative.setText(strtentative);
					b1.setEnabled(false);
					
					   
					
					}
			pan1.requestFocusInWindow();	}});
	
		
		b2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b2) {
				
				strtentative+=b2.getText();
				
				tentative.setText(strtentative);
					b2.setEnabled(false);
					historique.add(1) ;
					
					}
			pan1.requestFocusInWindow();}});
		
		
		
		b3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b3) {
				
				strtentative+=b3.getText();
				
				tentative.setText(strtentative);
					b3.setEnabled(false);
					historique.add(2) ;}
			pan1.requestFocusInWindow();}});
		
		
		b4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b4) {
				
				strtentative+=b4.getText();
				
				tentative.setText(strtentative);
					b4.setEnabled(false);
					historique.add(3) ;}
			pan1.requestFocusInWindow();}});
		
		
		
		
		b5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b5) {
				
				strtentative+=b5.getText();
				
				tentative.setText(strtentative);
					b5.setEnabled(false);
					historique.add(4) ;}
			pan1.requestFocusInWindow();}});
		
		b6.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b6) {
				
				strtentative+=b6.getText();
				
				tentative.setText(strtentative);
					b6.setEnabled(false);
					historique.add(5) ;}
			pan1.requestFocusInWindow();}});
		b7.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b7) {
				
				strtentative+=b7.getText();
				
				tentative.setText(strtentative);
					b7.setEnabled(false);
					historique.add(6) ;}
			pan1.requestFocusInWindow();}});
		
		b8.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b8) {
				
				strtentative+=b8.getText();
				
				tentative.setText(strtentative);
					b8.setEnabled(false);
					historique.add(7) ;}
			pan1.requestFocusInWindow();}});
		b9.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b9) {
				
				strtentative+=b9.getText();
				
				tentative.setText(strtentative);
					b9.setEnabled(false);
					historique.add(8) ;}
			pan1.requestFocusInWindow();	}});
		b10.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b10) {
				
				strtentative+=b10.getText();
				
				tentative.setText(strtentative);
					b10.setEnabled(false);
					historique.add(9) ;}
			pan1.requestFocusInWindow();}});

		b11.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b11) {
				
				strtentative+=b11.getText();
				
				tentative.setText(strtentative);
					b11.setEnabled(false);
					historique.add(10) ;}
			pan1.requestFocusInWindow();}});
		b12.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b12) {
				
				strtentative+=b12.getText();
				
				tentative.setText(strtentative);
					b12.setEnabled(false);
					historique.add(11) ;}
				pan1.requestFocusInWindow();	}});
		validate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			nbtour++;
			pan1.setFocusable(true);
			pan1.requestFocusInWindow();
			String result=tentative.getText();
			ch1=result;
			tentative.setText("");
			strtentative="";
			 String lowresult=result.toLowerCase();
			
			
			if((Dictionnaire.contains(lowresult))&& (lowresult.length()>=2) && !(ch1.equals(fcible.ch2))) {//le mot est valide 
				
				// update score si vrai 
				 updateScoreboard1();
				recapm.add(lowresult);
				recapt.add(tempsTotal);
				
				
				
				 //sauvegarder le mot dans liste score ,sauvegarder le temps et bloquer la fentre ,supprimer historique bouton
				mainpan.setEnabled(false);// desactiver saisi clavier
				for(JButton eb : listeB) {// desactiver les bouton
					eb.setEnabled(false);
				}
				validate.setEnabled(false);
				stopChronometre();
				historique.clear();//initialiser historique pour la prochaine tentative
				validtest=true;
					
			}
			else { // le mot n'est pas valide
				recapm.add("");
				recapt.add(4*60);
				
				mainpan.setEnabled(false);
				for(JButton eb : listeB) {
					eb.setEnabled(false);}
				validate.setEnabled(false);
				stopChronometre();
				historique.clear();//initialiser historique pour la prochaine tentative
				validtest=true;}
			if (nbtour<10)	{ // le jeu n'est pas fini
		    if(nbtour==fcible.nbtour)	{ // round accomplit 
		    	fcible.ch2="";
		    	ch1="";
		    	fcontrol.setupRound(nbtour+1);
		    	
		    	
		    	
		    	
		    	
		    }
			
			
			if(nbtour%2!=0) {//si le nombre de tour est impaire c'est le tour du joueur 2
			fcible.UnBlock();
			fcible.startChronometre();}
			else {// le nombre de tour est paire
				UnBlock();
				startChronometre();
				
			}
			}
			else	{ // affichage de score 
				
                 			
				Block();
				fcible.Block();
				mainpan.setVisible(!mainpan.isVisible());// fenetre1
				fcible.mainpan.setVisible(!fcible.mainpan.isVisible());
				                                                         // fenetre2
				Object [][]  RF1  ;
				RF1=calcRecap(recapm,recapt);
				String[] column={"Round", "Mot trouvé", "Temps de Round", "Longueur de mot"};
				
				 DefaultTableModel model = new DefaultTableModel(RF1,column);

			        // Création de la JTable avec le modèle de données
			        JTable table = new JTable(model);

			        // Ajout de la JTable à un JScrollPane pour la visualisation facile
			        JScrollPane scrollPane = new JScrollPane(table);
			        
			       scrollPane.setPreferredSize(new Dimension(600, 400));
			        panrecap.add( scrollPane);
			        add(panrecap,BorderLayout.CENTER);
			       setSize(800,400);
			      
			       Object [][]  RF2  ;
					RF2=calcRecap(fcible.recapm2,fcible.recapt2);
					String[] column1={"Round", "Mot trouvé", "Temps de Round", "Longueur de mot"};
					
					 DefaultTableModel model1 = new DefaultTableModel(RF2,column1);

				        // Création de la JTable avec le modèle de données
				        JTable table1 = new JTable(model1);

				      
				        JScrollPane scrollPane1 = new JScrollPane(table1);
				        
				        scrollPane1.setPreferredSize(new Dimension(600, 400));
				        fcible.panrecap2.add(scrollPane1);
				        fcible.add(fcible.panrecap2,BorderLayout.CENTER);
				      fcible. setSize(800,400);
				
				      
				      
				      fcontrol.lbround.setVisible(false);
				      for(int i=0;i<12;i++) { // deisparaitre les boutons 
							fcontrol.listeB.get(i).setVisible(false);
						}
				      if((int)RF1[10][1] > (int)RF2[10][1]) {
				    	  fcontrol.lbres.setText("Joueur 1:  "+tnom.getText().toUpperCase()+" est le gagnant");
				    	  
				    	  
				    	  
				      }
				      else  if((int)RF1[10][1] < (int)RF2[10][1]) {
				    	  fcontrol.lbres.setText("Joueur 2:  "+fcible.tnom.getText().toUpperCase()+" est le gagnant");
				    	  
				    	  
				    	  
				      }
				      else if((int)RF1[10][3]>(int)RF2[10][3]) {
				    	  fcontrol.lbres.setText("Joueur 1:  "+tnom.getText().toUpperCase()+" est le gagnant");
				      }
				      else  if((int)RF1[10][3] < (int)RF2[10][3]) {
				    	  fcontrol.lbres.setText("Joueur 2:  "+fcible.tnom.getText().toUpperCase()+" est le gagnant");
				    	 	  
				      }
				      else  if((int)RF1[10][2] > (int)RF2[10][2]) {
				    	  fcontrol.lbres.setText("Joueur 2:  "+fcible.tnom.getText().toUpperCase()+" est le gagnant");
				    	   	  
				      }
				      else  {
				    	  fcontrol.lbres.setText("Joueur 1:  "+tnom.getText().toUpperCase()+" est le gagnant");
				    	  
				    	  
				    	  
				      }
				    
				      
				      fcontrol.panres.add(fcontrol.lbres,BorderLayout.CENTER);
				      fcontrol.mainpan.add(fcontrol.panres,BorderLayout.SOUTH);
				      fcontrol.bStart.setText("GAME OVER ");
				      fcontrol.bStart.setEnabled(false);
			
				
			}
		}
		});
		
		
		//fin 
		
		//b3.addActionListener(new Supprimer()); // DEFINIT APRES
		
		this.add(mainpan,BorderLayout.CENTER);
		//add(pan1,BorderLayout.CENTER);
		//add(pantent,BorderLayout.SOUTH);
		
		
		this.setTitle(Title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();//size convient a la taille
		this.setVisible(true);
		// Rendre le JPanel focusable et lui attribuer le focus
		pan1.setFocusable(true);
		pan1.requestFocusInWindow();
		
		
		//partie claviers 
		 pan1.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e
	            		) {
	            		String cl=String.valueOf(e.getKeyChar());//recuperation du caractere taper 
	                // Vérification si la touche pressée est "k" (utilisation de KeyEvent.VK_K)
	                if (listeTB.contains(cl.toUpperCase())) {// tester si le caractere taper parmis les proposées
	                	
	                    // recherche de bouton qui a se caractere
	                	for(int i=0;i<=11;i++) {
	                		if(((cl.toUpperCase() ).equals(listeB.get(i).getText())) && (listeB.get(i).isEnabled())) //on a trouver l'indice
	                			{ //le bouton est activé au prealable 
	                			
	                			strtentative+=listeB.get(i).getText();
	                			tentative.setText(strtentative);
	                			historique.add(i);
	                			listeB.get(i).setEnabled(false);
	                			
	                				
	                			
	                			break;
	                		}
	                	}
	                    
	                }
	                if ((e.getKeyCode() == KeyEvent.VK_Z) && (e.isControlDown())&& (!historique.isEmpty())) {
	                	int ind=historique.get(historique.size() - 1);
	                	historique.remove(historique.size()-1);//supprimer dernier ajouter'
	                	
	                	listeB.get(ind).setEnabled(true);
	                	strtentative=strtentative.substring(0,strtentative.length()-1);//supprimer derniere caractere
	                	tentative.setText(strtentative);//mise a jour 
	                	                                                  // Ctrl+Z a été pressé, effacez le dernier caractère
	                	//
	                }
	                    // Ctrl+Z a été pressé, effacez le dernier caractère
	           
	            
	            
	            }
	            
	        });
	// 	
		
	









	
	}
	
	

	





	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
public void setupJB(ArrayList <String > mot ) {
	for(int i=0;i<12;i++) {
		this.listeB.get(i).setText(mot.get(i));
		
	}
	// mise a jour de la liste texte button;
	for(int i=0;i< listeTB.size();i++) {
		listeTB.set(i, mot.get(i));
		
	}
}
public void Block() {
	for(JButton b :this.listeB) {
		b.setEnabled(false);
		b.setVisible(true);
	}
	this.validate.setEnabled(false);
	validate.setVisible(true);
}
public void UnBlock() {
	for(JButton b :this.listeB) {
		b.setVisible(true);
		b.setEnabled(true);
		
	}
	this.validate.setEnabled(true);
	this.validate.setVisible(true);
}
public void startChronometre() {
    timer.start();
}

public void stopChronometre() {
	tempsTotal=0;
	    
    timer.stop();
    labelTemps.setText("Temps écoulé : 00:00");
  
}

public void setfcible(FenetreJ2 FJ) {
	this.fcible=FJ;
	
}
public void setfcontrol(FenetreM M) {
	fcontrol=M;
}

public Object[][] calcRecap(ArrayList <String> recapm,ArrayList <Integer> recapt){
	
	 Object[][] data = new Object[11][4];//drniere ligne pour le totale
	// data [0][0]="Round";
	 //data[0][1] = "Mot Trouvé";
	 //data [0][2] = "temps de Round";
	 //data [0][3] = "Longuer de mot ";
	 for(int i=0;i<10;i++) {// remplissage de rounde  
		 data[i][0]=i+1;
	 }
	 for (int i=0 ; i<10 ;i++){
		 if (recapm.get(i).equals("") ){
		 data[i][1] = "Echec";
		 }
		 else {
		 data[i][1] = "Succes";
		 } 
	 }
	  int sommet=0;// varible pour le temps total en seconde 
	 for(int i=0;i<10;i++) {
		 data[i][2]=recapt.get(i);
		 sommet+= recapt.get(i);
	 }
	 data[10][2]=sommet;
	 int maxl=0;
	 for (int i=0 ; i<10 ;i++){
		  
		 if (recapm.get(i).equals("")){
		 data[i][3]="Echec" ;
		 }
		 else{
			 
		 data[i][3] = recapm.get(i).length();
		 if(maxl<=(int)data[i][3]) {
			 maxl=(int)data[i][3];
			 
		 }
		 
		 }
	 }
	 
	 data[10][0] =" total " ;
	 int sommemot = 0;
	 for(int i=0 ;i<10 ;i++){
	 if (!recapm.get(i).equals("")){
	 sommemot++;
	 }
	 }
	 data[10][1] = sommemot ;
	 data [10][3]="max longeur= "+maxl;
	 
	 return data; 
	
	
	
	

}
//scoreboard
	public void updateScoreboard1() {
		// Mise à jour de la couleur en fonction du score

		for (int i = 0; i < 10; i++) {
			if (!liste.get(i).isVisible()) {
				Color color = new Color(0, 0, 0);
				liste.get(i).setBackground(color);
				liste.get(i).setVisible(true);
				break;
			}
		}
	}


}







