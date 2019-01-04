package jeuOie;

import java.awt.Frame;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Bonus extends Case implements Cloneable
{	
	private final int POINTGAGNE = 10;
	private final int DEPLACEMENT = 2;
	
	public void jouerCase(Joueur j)
	{	
		j.incrementer(POINTGAGNE);	
		JOptionPane.showMessageDialog(new Frame(),
				"Bonus! \nVous venez de ganger 10 points!\nAvancez de deux cases",
				"Bonus",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Boolean isDeplacing() 
	{
		return true;
	}
    public int getPOINTGAGNE() {return POINTGAGNE ;}
    public int getDEPLACEMENT() {return DEPLACEMENT ;}
	public int getDeplacement() 
	{
		return DEPLACEMENT;
	}
	public Case Clone () {
		Bonus clonedcase = null;
	      try {
	         clonedcase = (Bonus)super.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
}