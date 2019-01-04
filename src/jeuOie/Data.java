package jeuOie;

import java.io.Serializable;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Data implements Serializable
{
	//Plateau
	private Case[] tab;
	private Joueur j;
	private Boolean actif;
	//Info
	private int somme=0;
	private int[] des;	
	//Definitions et Images vues
	@SuppressWarnings("rawtypes")
	private TreeSet[] tableauIndice;
	
	public Data(){	}

	public Joueur getJoueur() 
	{
		return j;
	}

	public void setJoueur(Joueur j) 
	{
		this.j = j;
	}

	public Case[] getTab() 
	{
		return tab;
	}

	public void setTab(Case[] tab) 
	{
		this.tab = tab;
	}

	public Boolean getActif() 
	{
		return actif;
	}

	public void setActif(Boolean actif) 
	{
		this.actif = actif;
	}

	public int getSomme() 
	{
		return somme;
	}

	public void setSomme(int somme) 
	{
		this.somme = somme;
	}

	public int[] getDes() 
	{
		return des;
	}

	public void setDes(int de1, int de2) 
	{
		des = new int [2];
		des[0]=de1;
		des[1]=de2;		
	}

	@SuppressWarnings("rawtypes")
	public TreeSet getTableauIndice(int i) 
	{
		return tableauIndice[i];
	}

	@SuppressWarnings("rawtypes")
	public void setTableauIndice(TreeSet defs, TreeSet imgs) 
	{
		tableauIndice = new TreeSet[2];
		tableauIndice[0]=defs;
		tableauIndice[1]=imgs;
	}

}