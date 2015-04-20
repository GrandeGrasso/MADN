package interfaces;

import klassen.Spieler;
import klassen.Spielfigur;
import klassen.eFarben;

public interface iBediener {

	public void addSpieler(String name, eFarben farbe);
	public void sortiere(Object[] o); 
	public void starteSpiel();
	public void wuerfeln();
	public void setzeFigurAufPos(Object o, int ID);
	public Spieler werIstAmZug();
	public void FigurAnSpieler(Object o);
	public void beendeSpiel();

	
}
