package jeuOie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenChoix extends JFrame  implements ActionListener
{	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Color WHITE = null;
	private static final Color BLUE = null;	
	int i;
    JButton b1,b2,b3; 
    JLabel l1; 
    JTextField entre1;
    
    public FenChoix()
    {
    	this.setTitle("");										//Titre de la fentre
		this.setSize(576, 407);									//Taille de la fenetre
		this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
		this.setResizable(false);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    Container c = getContentPane();
	    JPanel p = new JPanel(new GridLayout(0,1));
		JLabel l = new JLabel("	     Veuillez entrer vôtre nom           	");l.setBackground(BLUE);  
		c.setLayout(new BorderLayout());
		entre1 = new JTextField("");
		i=1;
		p.add(l);
		p.add(entre1);
		b1 = new JButton(" Suivant"); b1.setForeground(Color.WHITE); b1.setBackground(new Color(123,217,108));b1.addActionListener(this);  
	    b2 = new JButton(" Précedent");b2.setForeground(Color.WHITE); b2.setBackground(new Color(123,217,108));b2.addActionListener(this);
	    b3 = new JButton(" Valider ");b3.setForeground(Color.WHITE); b3.setBackground(new Color(123,217,108));b3.addActionListener(this);
	    l1 = new JLabel(new ImageIcon("Media\\I1.png"));
	    p.add(b1); p.add(b2);p.add(b3);
	    c.add(p, BorderLayout.EAST);
	    c.add(l1, BorderLayout.WEST);
	    c.setBackground(new Color(173,217,108));
    }
    
    public void actionPerformed(ActionEvent e)
    {
		Object source = e.getSource();	
		if(source == b1) 
		{
			i++;
			if (i == 4) i = 1;
			l1.setIcon(new ImageIcon("Media\\I"+i+".png"));
		}
		else if (source == b2) 
		{
			i--;
			if(i==0 ) i = 3;
			l1.setIcon(new ImageIcon("Media\\I"+i+".png"));
		}
		else if (source == b3)
		{
			if(!entre1.getText().equals(""))
			{
				this.dispose();
				LeMain.setPartie(entre1.getText(),i);				
			}
			else JOptionPane.showMessageDialog(new Frame(),
						"Veuillez entrer un nom !",
						"Erreur",
						JOptionPane.ERROR_MESSAGE);
		}
    }
}