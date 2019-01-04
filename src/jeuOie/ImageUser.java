package jeuOie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageUser extends JPanel
{	
    Image img ;
	public ImageUser(int i)
	{
		super();
		setPreferredSize(new Dimension(180,135));
		String tmp= "Media\\Im"+i+".png";
        try
        {
        	img = ImageIO.read(new File(tmp));
        } catch (IOException e) 
        {
        	img = null;        			
	    }  
	}
	
	public void paintComponent(Graphics g)
	{
		if(img!=null)
		{
			g.setColor(new Color(123,217,108));
	        g.drawImage(img, 7, 0, this);
	    }
	}
}