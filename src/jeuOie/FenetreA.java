package jeuOie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetreA extends JFrame implements ActionListener 
{	
	@SuppressWarnings("deprecation")
	public FenetreA()
	{	
		this.setTitle("");										//Titre de la fentre
		this.setSize(525, 410);									//Taille de la fenetre
		this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
		this.setResizable(false);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1 = new JButton("    Nouvelle partie"); b1.setForeground(Color.WHITE); b1.setBackground(new Color(80,170,90));  b1.addActionListener(this);
		b2 = new JButton("    Reprendre  ");b2.setForeground(Color.WHITE); b2.setBackground(new Color(80,170,90)); b2.addActionListener(this);
		b3 = new JButton("      Scores   ");b3.setForeground(Color.WHITE); b3.setBackground(new Color(80,170,90)); b3.addActionListener(this);
		b4 = new JButton("     Quitter   ");b4.setForeground(Color.WHITE); b4.setBackground(new Color(80,170,90)); b4.addActionListener(this);    
		JLabel l1 = new JLabel(new ImageIcon("Media\\accueil.png"));
		JPanel p = new JPanel(new GridLayout(0,1));
		p.add(b1); p.add(b2); p.add(b3); p.add(b4);
		Container c = getContentPane();
		c.add(p, BorderLayout.EAST);
		c.add(l1, BorderLayout.CENTER);
		c.setBackground(new Color(123,217,108));
		this.show();    
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == b1) 
		{
			this.dispose();
			FenChoix f = new FenChoix();
			f.setVisible(true);
		}
		else if (source == b2) 
		{	
			this.dispose();
		}
		else if (source == b3)
		{
			this.dispose();
			//Meilleurs score 
			ArrayList<Partie> lp = new ArrayList<Partie>();
        	ArrayList<String> lpp = new ArrayList<String>();
        	File f = new File("sauvegardes\\Selma.sco");
        	if (f.exists())
        	{        		
        		try 
        		{
    				FileInputStream fichier = new FileInputStream("parties.ser");
    				@SuppressWarnings("resource")
    				ObjectInputStream ois = new ObjectInputStream(fichier);
    				lp = (ArrayList<Partie>) ois.readObject();	
    			} catch (FileNotFoundException d)  {} 
        		catch (ClassNotFoundException d)   {} 
        		catch (IOException d) {    			}
        		if (lp == null)
        		{
        			JOptionPane.showMessageDialog(null,
            			    "Aucune partie n'est sauvegardée!",
            			    "Aucune partie",
            			    JOptionPane.WARNING_MESSAGE); 
        		}
        		else
        		{
        			ComparateurPartie cp = new ComparateurPartie();
        			Collections.sort(lp, cp);
        			for (int i = 0; i<lp.size(); i++)
        			{
        				lpp.add("Joueur: "+lp.get(i).getJoueur().getNom()+" | Score: "+lp.get(i).getJoueur().getScore());
        			}
        			FenMeilleurScore fen = new FenMeilleurScore(lpp);
        			fen.setTitle("Meilleurs scores");
        			fen.setVisible(true);
        		}
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null,
        			    "Il n'existe aucune partie sauvegardée!",
        			    "Aucune partie",
        			    JOptionPane.WARNING_MESSAGE); 
        	}
		}
		else if(source == b4)
		{
			System.exit(1);
		}
	}
	
	void changeCouleur(JButton b)
	{
		if(b.getForeground() == Color.red) b.setForeground(Color.blue);
		else b.setForeground(Color.red);	
	}
	
	JButton b1,b2,b3,b4;
	
    public static void main(String[] args)
    {
		FenetreA fen = new FenetreA();
		fen.setVisible(true);
	}
}