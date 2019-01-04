package jeuOie;


@SuppressWarnings("serial")
public class Depart extends Case 
{	
	public void jouerCase(Joueur j){	}
	
	public Boolean isDeplacing() 
	{
		return false;
	}

	public int getDeplacement() 
	{
		return 0;
	}
	public Case Clone () {
		Depart clonedcase = null;
	      try {
	         clonedcase = (Depart)super.clone();
	      
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
}