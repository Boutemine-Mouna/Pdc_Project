package jeuOie;

import java.util.TreeSet;

public interface IStream {
	public void ReadStream(String path,int i,TreeSet sco,int end);
	public void whriteStream(String path,TreeSet sco);
	public void sauvgarder(String path,Object d);
	public Object Restaurer(String path);

}
