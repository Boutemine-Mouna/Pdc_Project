package jeuOie;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenMeilleurScore extends JFrame
{     
     public FenMeilleurScore(ArrayList<String> lp)
     {
    	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	 this.setBounds(200,200,300, 300);
    	 this.setVisible(true);
     }
     
     public FenMeilleurScore(Joueur j)
     {
		this.setTitle("Scores");								//Titre de la fentre
	    this.setSize(488, 423);									//Taille de la fenetre
	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//Pour que Fermer ferme reellement
	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionnée
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	    	
    	Container c = this.getContentPane();
    	c.setLayout(new BorderLayout());
    	c.add(new PanelEnTete(j,c.getWidth()),BorderLayout.NORTH);
    	c.add(new PanelScore(j,c.getWidth()),BorderLayout.CENTER);
    	this.setVisible(true);
     }
}