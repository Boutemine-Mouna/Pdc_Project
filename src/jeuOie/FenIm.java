package jeuOie;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class FenIm extends JFrame implements ActionListener, MouseListener 
{	
	private ImgPan[] images = new ImgPan[4];
	private String[] noms;
	private int secret=-1;
	private int choix= -1; 
	private Image Case;
	
	public FenIm(String[] images, Image cas) 
	{	
		int i;
		/*----------------	GRAPHIQUE -------------*/
		this.setTitle("");										//Titre de la fentre
	    this.setSize(400, 500);									//Taille de la fenetre
	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionnée
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 	//Pour que Fermer ferme reellement
	    Case = cas;						//La case de definition (case correspondante dans le tableau des case du Plateau)
	    this.getContentPane().setLayout(new FlowLayout());
	    JLabel mot = new JLabel();
	    mot.setText("Veuillez cliquer sur l'image qui correspond à :");
	    this.getContentPane().add(mot);	    
	    mot = new JLabel();
	    mot.setText(images[0]);
	    this.getContentPane().add(mot);
	    Random rand = new Random(); 		
		secret= rand.nextInt(4);
		System.out.println(" Mot : "+images[0]);
		String tmp = images[secret];
		images[secret] = images[0];
		images[0] = tmp;
		noms = images;
		for(i=0;i<4;i++)
		{
			this.images[i]= new ImgPan(noms[i]);
			this.getContentPane().add(this.images[i]);
			(this.images[i]).addMouseListener(this);
		}
	    JButton bt = new JButton("     ok     ");				//bouton de validation
	    this.getContentPane().add(bt);
	    bt.addActionListener(this);
	    LeMain.getPartie().setAlwaysOnTop(true);
	    setAlwaysOnTop(true);
	    this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if((choix +1)>0 )
		{
			Joueur j=LeMain.getPartie().getJoueur();
			PanneauInfo info = LeMain.getPartie().getInfo();
			Plateau plat = LeMain.getPartie().getPlat();	
			LeMain.getPartie().setAlwaysOnTop(false);
		    setAlwaysOnTop(false);
			if(choix != secret)
				JOptionPane.showMessageDialog(new Frame(),"Fausse reponse!", "Image",JOptionPane.WARNING_MESSAGE);
			else
			{   Image img= new Image();
				j.incrementer( img.getPOINTGAGNE());
				info.setScores();
				Case.add();
				info.setSomme(2);
			    info.getLancerDes().setEnabled(false);
			    info.repaint();
			    plat.activer();
			    JOptionPane.showMessageDialog(new Frame(),
			    		"Vous avez gagner "+img.getPOINTGAGNE()+" points!\nAvancez de deux cases", 
			    		"Aide",
			    		JOptionPane.INFORMATION_MESSAGE);
			}					
			LeMain.getPartie().setEnabled(true);
			this.dispose();
		}
		else 
		{
			LeMain.getPartie().setAlwaysOnTop(false);
		    setAlwaysOnTop(false);			
			JOptionPane.showMessageDialog(new Frame(),
					"Veuillez d'abord cliquer sur une image !", 
					"Erreur",
					JOptionPane.ERROR_MESSAGE);
			LeMain.getPartie().setAlwaysOnTop(true);
		    setAlwaysOnTop(true);
		}
	}

	public void mouseClicked(MouseEvent arg0) 
	{
		int i;
		if(arg0.getSource()==images[0])
		{		
			choix = 0;
			for(i=0;i<4;i++)
			{
				(this.images[i]).setIcon(noms[i]);
			}
			(this.images[0]).setIcon((noms[0]+"S"));	
		}else if(arg0.getSource()==images[1])
		{	
			choix = 1;
			for(i=0;i<4;i++)
			{
				(this.images[i]).setIcon(noms[i]);
			}
			(this.images[1]).setIcon((noms[1]+"S"));	
		}else if(arg0.getSource()==images[2])
		{
			choix = 2;
			for(i=0;i<4;i++)
			{
				(this.images[i]).setIcon(noms[i]);
			}
			(this.images[2]).setIcon((noms[2]+"S"));	
		}else if(arg0.getSource()==images[3])
		{
			choix = 3;
			for(i=0;i<4;i++)
			{
				(this.images[i]).setIcon(noms[i]);
			}
			(this.images[3]).setIcon((noms[3]+"S"));	
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {	}
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) {	}
	public void mouseReleased(MouseEvent arg0) { }
}