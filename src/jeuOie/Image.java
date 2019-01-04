package jeuOie;

import java.util.Random;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Image extends Question 
{	
	private final int POINTGAGNE = 10;
	@SuppressWarnings("rawtypes")
	private static TreeSet tableauIndice = new TreeSet();	
	@SuppressWarnings({ "rawtypes", "unchecked" })
  
	public void jouerCase(Joueur j) 
	{
		int i,l;
		// generer les images----------------------------------------
		Random rand = new Random(); 
		TreeSet nombres = new TreeSet();
		String images[]=new String[4];
		for (i =1;i<4;i++){
			images[i]="Selma";
		}
		k = rand.nextInt(Partie.TAILLEIMAGE );
		if(tableauIndice.size() == Partie.TAILLEIMAGE) 
		{
			tableauIndice.removeAll(tableauIndice);
			System.out.println("  Reinitialisation  !!! toute les images on ete vus !");
		}
		while(!tableauIndice.add(k))
		{
			k = rand.nextInt(Partie.TAILLEIMAGE );
		}
		nombres.add(k);
		images[0]=Partie.getImage(k);
		tableauIndice.remove(k);		
		for (i =1;i<4;i++)
		{
			l=rand.nextInt(Partie.TAILLEIMAGE);
			while(!nombres.add(l))
			{
				l=rand.nextInt(Partie.TAILLEIMAGE);
			}
			images[i]=Partie.getImage(l);
		}
		//poser les questions
		@SuppressWarnings("unused")
		FenIm fen = new FenIm(images,this);
		LeMain.getPartie().setEnabled(false);
	}
	public int getPOINTGAGNE() {return POINTGAGNE ;}
	public Case Clone () {
		Image clonedcase = null;
	      try {
	         clonedcase = (Image)super.clone();
	         
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