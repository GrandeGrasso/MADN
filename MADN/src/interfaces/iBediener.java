package interfaces;

import klassen.Spiel;
import klassen.Spieler;
import klassen.Spielfigur;
import klassen.eFarben;

public interface iBediener {



			public void starteSpiel(int AnzSpieler);
			public void addSpieler(String name, eFarben farbe, boolean ki, Object o);
			public void wuerfeln();
			public void ziehen(int id);
			public void zeigeSpieler();
			public void zeigeFigur();
			public void speichernCSV(String string);
			public void speichernSerial(String string);

}
