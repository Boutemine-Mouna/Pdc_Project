package jeuOie;

import java.awt.Frame;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Saut extends Case
{	
	
	public void jouerCase(Joueur j)
	{
	}
	
	public Boolean isDeplacing() 
	{
		return true;
	}
	
	public int getDeplacement() 
	{
		Random rand = new Random();
		int dep = rand.nextInt(100) + 1;
		JOptionPane.showMessageDialog(new Frame(), 
				"Case Saut! \nAvancer vers la case N°"+(dep+1),
				"Saut",
				JOptionPane.INFORMATION_MESSAGE);	
		return (dep - Plateau.getJoueur().getPosition());
	}
	public Case Clone () {
		Saut clonedcase = null;
	      try {
	         clonedcase = (Saut)super.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
}