package jeuOie;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Case implements Jeu, Serializable,Prototype
{	
	private int position;

	
	public int getPosition() 
	{
		return position;
	}

	public void setPosition(int position) 
	{
		this.position = position;
	}	

	public abstract void jouerCase(Joueur j);
	public abstract Boolean isDeplacing();
	public abstract int getDeplacement();
	public abstract Case Clone () ;
}