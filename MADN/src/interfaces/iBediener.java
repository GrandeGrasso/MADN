package interfaces;

import klassen.Spieler;

public interface iBediener {

	public void addSpieler(Spieler sp);
	public void sortiere(Spieler[] a); 
	public void starteSpiel();
	public void werIstAmZug();
	public void beendeSpiel();
	
}
