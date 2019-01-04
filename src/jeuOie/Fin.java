package jeuOie;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Fin extends Case
{	private static IStream 	buffer= new FileStream();
	public void jouerCase(Joueur j)
	{
		 
		int i=0,min;
		TreeSet <Integer> sco = new TreeSet <Integer>();
		Boolean exist=false;	
		buffer.ReadStream("sauvegardes\\"+j.getNom()+".sco",i,sco,10);
	    if(i<10)
	    {
	    	if(!sco.add(j.getScore()))
	    		exist = true;
	    }else
	    {
	    	min=sco.first();
	    	System.out.println(" min= " + min);
	    	if(sco.add(j.getScore()))
	    		sco.remove(min);
	    	else exist = true;
	    }
		if(!exist)
		{  
			buffer.whriteStream("sauvegardes\\"+j.getNom()+".sco",sco);
		}
		LeMain.getPartie().getInfo().getLancerDes().setEnabled(false);
		JOptionPane.showMessageDialog(new Frame(),
				"Fin de la partie !\nVous avez obtenu un score de "+j.getScore()+" points !\n(nouvelle Partie) pour rejouer",
				"Fin",
				JOptionPane.INFORMATION_MESSAGE);
				j.setPosition(0);
				j.setScore(0);
	}
	
	public Boolean isDeplacing() 
	{
		return false;
	}
	
	public int getDeplacement() 
	{
		return 0;
	}
	public Case Clone () {
		Fin clonedcase = null;
	      try {
	         clonedcase = (Fin)super.clone();
	        
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clonedcase;
	}
}