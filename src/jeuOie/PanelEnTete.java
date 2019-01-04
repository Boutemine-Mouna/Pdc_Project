
package jeuOie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelEnTete extends JPanel
{
	public PanelEnTete(Joueur j, int width) 
	{
		setPreferredSize(new Dimension(width,130));
		setLayout(new BorderLayout());
		ImageIcon im = new ImageIcon("Media\\Img"+j.getPion()+".png");	
		JLabel nom = new JLabel(j.getNom()+" ");
		Font font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 100);
		nom.setFont(font);
		nom.setForeground(Color.WHITE);	
		add(new JLabel(im),BorderLayout.WEST);
		add(nom,BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g)
	{//fonScore.
	    try 
	    {//dessiner le fond
	    	g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());  
	        Image img = ImageIO.read(new File("Media\\EnteteScore.png"));
	        g.drawImage(img, 0,0, this);
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }  
	}
}