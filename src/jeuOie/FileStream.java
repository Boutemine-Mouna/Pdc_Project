package jeuOie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

public class FileStream implements IStream {
	
	
	public void ReadStream(String path,int i,TreeSet sco,int end)
	{
	BufferedReader in =null;	
	String ligneLue=null;
	try 
	{
		in = new BufferedReader(new FileReader(path));
	    while(i<=end)
	    {
			ligneLue = in.readLine();
			if(ligneLue == null)
				break;
			if(sco.add(Integer.parseInt(ligneLue)))
			{
				i++;
			}
		}
	}catch(FileNotFoundException e){e.printStackTrace();}
	catch(IOException e){e.printStackTrace();}
	catch(NumberFormatException e){e.printStackTrace();}
	finally
	{
		if (in != null)
		try 
		{
			in.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
		
	};
	
	
	
	
	public void whriteStream(String path,TreeSet sco)
	{
		BufferedWriter fich = null;
		try
		{	
			Object[] tabSco= sco.toArray();
			fich = new BufferedWriter (new FileWriter(path,false));	
			for(int l =0;l<tabSco.length;l++)
			{
				fich.write(Integer.toString((int) tabSco[l]));
				fich.newLine();
			}
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException e){e.printStackTrace();}
		finally
		{
			if (fich != null)
			try 
			{
				fich.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	};
	
	
	
	public void sauvgarder(String path,Object d) {
		try {d=(Data)d;
		    FileOutputStream fichier = new FileOutputStream(path);
		    ObjectOutputStream oos = new ObjectOutputStream(fichier);
		    oos.writeObject(d);
		    oos.flush();
		    oos.close();
		}catch (java.io.IOException e1) {
		    e1.printStackTrace();
		}
	};
	
	
	public Object Restaurer(String path)
	{
		ObjectInputStream ois=null;
		Data d=null;
		
		try 
		{
			ois = new ObjectInputStream(new FileInputStream( new File(path)));
			d = (Data)ois.readObject();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return d;
	};

  
}
