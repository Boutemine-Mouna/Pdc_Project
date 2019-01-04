package jeuOie;

import java.awt.Frame;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Malus extends Case
{	
	private final int POINTPERDU = -10;
	private final int DEPLACEMENT = -2;
	
	
	public void jouerCase(Joueur j)
	{	
		j.incrementer(POINTPERDU);	
		JOptionPane.showMessageDialog(new Frame(),
				"Malus! \nVous venez de perdre 10 points!\nReculez de deux cases",
				"Malus",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public int getPOINTPERDU() {return POINTPERDU ;}
	public int getDEPLACEMENT() {return DEPLACEMENT ;}
	 
	public Boolean isDeplacing() 
	{
		return true;
	}

	public int getDeplacement() 
	{
		return DEPLACEMENT;
	}
	public Case Clone () {
		Malus clonedcase = null;
	      try {
	         clonedcase = (Malus)super.clone();
	    
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
}