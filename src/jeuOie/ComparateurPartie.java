package jeuOie;

import java.util.Comparator;

public class ComparateurPartie implements Comparator<Partie> 
{
	public int compare(Partie p1, Partie p2) 
	{	
		Integer i1 = p1.getJoueur().getScore();
		Integer i2 = p2.getJoueur().getScore();	
		return i2.compareTo(i1);
	}
}