package jeuOie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImgPan extends JPanel
{	
	private Image img;	
	public ImgPan(String im)
	{
		try
		{
			img = ImageIO.read(new File( "Image\\"+im+".png"));
		    repaint();
		}catch (IOException e) {    }
		setPreferredSize(new Dimension(171,179));
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(123,217,108));
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		g.drawImage(img, 0,0, this);  
	}

	public void setIcon(String string) 
	{
		try
		{
			img = ImageIO.read(new File( "Image\\"+string+".png"));
		    repaint();
		}catch (IOException e) {    }
	}
}