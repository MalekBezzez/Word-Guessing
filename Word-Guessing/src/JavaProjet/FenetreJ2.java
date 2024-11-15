package JavaProjet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
  


public class FenetreJ2  extends JFrame implements ActionListener {
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
	ArrayList<String> Dictionnaire=LectureFichier.dictionnaire();
	ArrayList<String> listeTB= new ArrayList<String>(12); // liste texte des boutons 
	// temps  
	public Timer timer;
    public JLabel labelTemps;
    public int tempsTotal = 0;
      
    
    // Score 
    ArrayList<String>  recapm2=new ArrayList<String>();
    ArrayList<Integer>  recapt2=new ArrayList<Integer>(); 
	String ch2="";
	JPanel panrecap2=new JPanel();
	
    // score text pour joueur 2
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
	
	
	FenetreJ fcible;
	 
	int nbtour=0;
	// fentetre de control
	
	  FenetreM fcontrol;
	
	  JPanel mainpan=new JPanel(new GridLayout(7,1,5,5) );
	
	



	public FenetreJ2(final ArrayList<String> mot, String Title )  { // final pour etre reconnu dans les classes definit au sein de ce classe
		
		
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
		 // blocker au prealable
			for(int i=0;i<12;i++) {
				this.listeB.get(i).setVisible(false);
			}
			
			//l'affectation de liste de texte bouton
			 for(JButton b : listeB) {
				 listeTB.add(b.getText())	; }
			validate.setVisible(false);
			
		
		 
		 
		 
		
		 JPanel pantext=new JPanel();
		 
		
		JPanel pan=new JPanel(new GridLayout(1,3,10,0));//bech tji 
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
                
                if(tempsTotal>=60*4) { // echoué ******
                	nbtour++;
        			
        			
        			tentative.setText("");
        			strtentative="";
        			recapm2.add("");
    				recapt2.add(4*60);
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
    				
    				if(nbtour%2!=0) {//si le nombre de tour est impaire c'est son tour 
    					UnBlock();
    					startChronometre();
    					}
    					else {// le nombre de tour est paire
    						
    						fcible.UnBlock();
    						fcible.startChronometre();
    						
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
			ch2=result;
			tentative.setText("");
			strtentative="";
			 String lowresult=result.toLowerCase();
			
			if((Dictionnaire.contains(lowresult))&& (lowresult.length()>=2) && !(ch2.equals(fcible.ch1))) {//le mot est valide 
				
				updateScoreboard1();
				recapm2.add(lowresult);
				recapt2.add(tempsTotal);
				// update score ,sauvegarder le mot dans liste score ,sauvegarder le temps et bloquer la fentre ,supprimer historique bouton
				mainpan.setEnabled(false);// desactiver saisi clavier
				for(JButton eb : listeB) {// desactiver les bouton
					eb.setEnabled(false);
				}
				validate.setEnabled(false);
				stopChronometre();
				historique.clear();//initialiser historique pour la prochaine tentative
				validtest=true;
					
			}
			else {
				recapm2.add("");
				recapt2.add(4);
				mainpan.setEnabled(false);
				for(JButton eb : listeB) {
					eb.setEnabled(false);}
				validate.setEnabled(false);
				stopChronometre();
				historique.clear();//initialiser historique pour la prochaine tentative
				validtest=true;
			
			}
			if(nbtour==fcible.nbtour)	{ // round accomplit 
				ch2="";
				fcible.ch1="";
				
		    	fcontrol.setupRound(nbtour+1);
		    	
		    	
		    	
		    	
		    }
			
			if(nbtour%2!=0) {//si le nombre de tour est impaire c'est son tour 
				UnBlock();
				startChronometre();
				}
				else {// le nombre de tour est paire
					
					fcible.UnBlock();
					fcible.startChronometre();
					
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
	            		String cl=String.valueOf(e.getKeyChar());
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
public void setfcible(FenetreJ f) {
	this.fcible=f;
	
}
public void setfcontrol(FenetreM M) {
	fcontrol=M;
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








