package jeuOie;

import java.util.Random;

public class Des 
{
	public Des(){		}
	
	public int Lancer()
	{
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
}
