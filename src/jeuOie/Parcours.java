package jeuOie;


@SuppressWarnings("serial")
public class Parcours extends Case  {
	
	
	public void jouerCase(Joueur j){
	}
	public Boolean isDeplacing() {
		return false;
	}
	public int getDeplacement() {
		return 0;
	}
	public Case Clone () {
		Parcours clonedcase = null;
	      try {
	         clonedcase = (Parcours)super.clone();
	        
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
}
