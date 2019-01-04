package jeuOie;

import java.util.Random;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Definition extends Question
{	
	private final int POINTGAGNE = 20;
	private final int POINTPERDU = -10;
	
	@SuppressWarnings("rawtypes")
	private static TreeSet tableauIndice = new TreeSet();
	public int getPOINTGAGNE() {return POINTGAGNE ;}
	public int getPOINTPERDU() {return POINTPERDU ;}
	@SuppressWarnings("unchecked")
	public void jouerCase(Joueur j)
	{
		// generer une question
		Random rand = new Random(); 
		String definition="", secretWord="";
		k = rand.nextInt(Partie.TAILLEDEFINITION ) ;
		if(tableauIndice.size() == Partie.TAILLEDEFINITION) 
		{
			tableauIndice.removeAll(tableauIndice);
			System.out.println("  Reinitialisation  !!! toute les definitions on ete vus !");
		}
		while(!(tableauIndice.add(k)))
			k = rand.nextInt(Partie.TAILLEDEFINITION );
		definition = Partie.getDefinition(k,0);
		secretWord = Partie.getDefinition(k,1);
		tableauIndice.remove(k);
		//poser les question-------------------------------------------
		@SuppressWarnings("unused")
		FenDef fen = new FenDef(definition,secretWord,this);
		LeMain.getPartie().setEnabled(false);			
	}
	public Case Clone () {
		Definition clonedcase = null;
	      try {
	         clonedcase = (Definition)super.clone();
	  
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	};
	public Boolean isDeplacing() 
	{
		if(DEPLACEMENT > 0)return true;
		else return false;
	}

	public int getDeplacement() 
	{
		return DEPLACEMENT;
	}
	
	public void setDeplacement(int k) 
	{
		DEPLACEMENT = k;
	}
	
	@SuppressWarnings("unchecked")
	public void add()
	{
		tableauIndice.add(k);
	}

	@SuppressWarnings("rawtypes")
	public static TreeSet getTableauIndice()
	{
		return tableauIndice;
	}
	
	@SuppressWarnings("rawtypes")
	public static void setTableauIndice(TreeSet set)
	{
		 tableauIndice = set;
	}
}