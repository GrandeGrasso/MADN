package interfaces;

import klassen.Spieler;

public interface iBediener {

	public void addSpieler();
	public void sortiere(Spieler[] a); 
	public void starteSpiel();
	public void wuerfeln();
	public void setzeFigurAufPos(int ID);
	public void werIstAmZug();
	
	public void beendeSpiel();
	
}
