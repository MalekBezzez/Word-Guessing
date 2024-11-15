package JavaProjet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreM extends JFrame implements ActionListener {
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
	ArrayList<JButton> listeB = new ArrayList<JButton>(12);
	JButton bStart=new JButton("START GAME");
	
	JLabel  lbround= new JLabel("ROUND :1"); 
	  int  Start=0;
	  // les fentres a controller
	   FenetreJ FJ;
	    FenetreJ2 FJb;
	  
	  //resultats 
	    JLabel lbres=new JLabel("");
	    JPanel panres=new JPanel();
	    JPanel mainpan= new JPanel( new GridLayout(5,1,0,0));
	    
	
	
	public FenetreM(final ArrayList<String> mot)  { //  fenetre dans lequelle chronometre debut initialement et la fentre a bloqué
		
	
		
		 b1.setText(mot.get(0));
		 b2.setText(mot.get(1));
		 b3.setText(mot.get(2));
		 b4.setText(mot.get(3));
		 b5.setText(mot.get(4));
		 b6.setText(mot.get(5));
		 b7.setText(mot.get(6));
		 b8.setText(mot.get(7));
		 b9.setText(mot.get(8));
		 b10.setText(mot.get(9));
		 b11.setText(mot.get(10));
		 b12.setText(mot.get(11));
		 
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
			
			
	
		
		 lbround.setSize(5, 5);
		 JPanel Round=new JPanel();
		 //JPanel Pjoueur=new JPanel();
		 Round.add(lbround,BorderLayout.SOUTH);
		
		 
		 mainpan.add(Round);
		 //mainpan.add(Pjoueur);
		 
		 
		 
		 final JPanel pan1=new JPanel(new GridLayout(3,4,7,7));//diviser la zone  des boutons 
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
		  JPanel panmenu=new JPanel();
		  panmenu.add(bStart,BorderLayout.CENTER);
		  mainpan.add(panmenu);
		  JPanel pan2 =new JPanel(new GridLayout(1,3));//panel du temps et score des joueurs 
		  panres.add(lbres);
		  mainpan.add(pan2);
		  mainpan.add(panres);
		  
            this.add(mainpan,BorderLayout.CENTER);
			this.setTitle("Main window ");
			this.setSize(440,520);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setResizable(false);
			//pack();//size convient a la taille
			this.setVisible(true);
			// Rendre le JPanel focusable et lui attribuer le focus
		
			 bStart.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				
				 FJ.UnBlock();
				 
				 
				 FJ.startChronometre();
				 FJb.Block();
				 bStart.setEnabled(false);
				 Start= 1;
					for(int i=0;i<12;i++) {
						listeB.get(i).setVisible(true);
					}
					lbround.setVisible(true);
					
					
				 
			 }
				 
			 });
		
			
            
		 
		 
		 
		 
	}
	
	
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public  int getStart() {
		return Start;
	}
	public void setupRound(int nbRound) {
		String ch=Integer.toString(nbRound);
		String msg="Round:";
		msg+=ch;
		lbround.setText(msg);
		ArrayList<String> mot = generator.StringGenerator();
		FJ.setupJB(mot);
		FJb.setupJB(mot);
		setupMB(mot);
		
		
		
		
		
	}
	public void setf1(FenetreJ f) {
		FJ=f;
	}
	public void setf2(FenetreJ2 f) {
		FJb=f;
	}
	public void setupMB(ArrayList <String > mot ) {
		for(int i=0;i<12;i++) {
			this.listeB.get(i).setText(mot.get(i));
		}
}
	public void close() {
		if(FJ.nbtour==10) {
			System.exit(0);
			
		}
	}
}

