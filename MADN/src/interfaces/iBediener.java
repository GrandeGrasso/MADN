package interfaces;

import klassen.Spieler;
import klassen.Spielfigur;
import klassen.eFarben;

public interface iBediener {

	public void addSpieler(String name, eFarben farbe);
	public void sortiere(Spieler[] a); 
	public void starteSpiel();
	public void wuerfeln();
	public void setzeFigurAufPos(Spielfigur sf, int ID);
	public void werIstAmZug();
	public void FigurAnSpieler(Spieler spieler);
	public void beendeSpiel();
	
}
