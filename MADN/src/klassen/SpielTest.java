package klassen;

import javax.xml.stream.events.StartElement;



public class SpielTest {

	public static void main(String[] args) {
		//Spieler
		Spieler spieler1 = new Spieler("Kathi", eFarben.BLAU);
		Spieler spieler2 = new Spieler("Akin", eFarben.GRUEN);
		Spieler spieler3 = new Spieler("Stefano", eFarben.ROT);
		Spieler spieler4 = new Spieler("Yunus", eFarben.GELB);
		//Spiel
		Spiel s1 = new Spiel();
		//Füge die Spieler ins Spiel hinzu
		s1.addSpieler(spieler1);
		s1.addSpieler(spieler2);
		s1.addSpieler(spieler3);
		s1.addSpieler(spieler4);
		
		//Spielbrett
		Spielbrett spielbrett1 = new Spielbrett();
		//Spielfeld
		Spielfeld spielfeld1 = new Spielfeld(eFeldTyp.Startfeld);
		Spielfeld spielfeld2 = new Spielfeld(eFeldTyp.Zielfeld);
		Spielfeld spielfeld3 = new Spielfeld(eFeldTyp.Homefeld);
		//Spielfiguren
		Spielfigur sfigurRo1 = new Spielfigur(eFarben.ROT);
		Spielfigur sfigurRo2 = new Spielfigur(eFarben.ROT);
		Spielfigur sfigurRo3 = new Spielfigur(eFarben.ROT);
		Spielfigur sfigurRo4 = new Spielfigur(eFarben.ROT);
		
		Spielfigur sfigurBl1 = new Spielfigur(eFarben.BLAU);
		Spielfigur sfigurBl2 = new Spielfigur(eFarben.BLAU);
		Spielfigur sfigurBl3 = new Spielfigur(eFarben.BLAU);
		Spielfigur sfigurBl4 = new Spielfigur(eFarben.BLAU);
		
		Spielfigur sfigurGr1 = new Spielfigur(eFarben.GRUEN);
		Spielfigur sfigurGr2 = new Spielfigur(eFarben.GRUEN);
		Spielfigur sfigurGr3 = new Spielfigur(eFarben.GRUEN);
		Spielfigur sfigurGr4 = new Spielfigur(eFarben.GRUEN);
		
		Spielfigur sfigurGe1 = new Spielfigur(eFarben.GELB);
		Spielfigur sfigurGe2 = new Spielfigur(eFarben.GELB);
		Spielfigur sfigurGe3 = new Spielfigur(eFarben.GELB);
		Spielfigur sfigurGe4 = new Spielfigur(eFarben.GELB);
		
		//Befülle alle Homefelder des Spielbrettes mit den entsprechenden Spielfiguren
		//der entsprechenden Farbe
		System.out.println(spielbrett1.getSpielbrett());

		//Spieler bekommt seine Spielfiguren
		spieler1.figurHinzufuegen(sfigurRo1);
		spieler1.figurHinzufuegen(sfigurRo2);
		spieler1.figurHinzufuegen(sfigurRo3);
		spieler1.figurHinzufuegen(sfigurRo4);
		
		spieler2.figurHinzufuegen(sfigurBl1);
		spieler2.figurHinzufuegen(sfigurBl2);
		spieler2.figurHinzufuegen(sfigurBl3);
		spieler2.figurHinzufuegen(sfigurBl4);
		
		spieler3.figurHinzufuegen(sfigurGr1);
		spieler3.figurHinzufuegen(sfigurGr2);
		spieler3.figurHinzufuegen(sfigurGr3);
		spieler3.figurHinzufuegen(sfigurGr4);
		
		spieler4.figurHinzufuegen(sfigurGe1);
		spieler4.figurHinzufuegen(sfigurGe2);
		spieler4.figurHinzufuegen(sfigurGe3);
		spieler4.figurHinzufuegen(sfigurGe4);
		
		//Wer ist alles im Spiel?
		System.out.println(s1);
		
		//Wieviele Spielfiguren gehören dem Spieler?
		System.out.println(spieler1.getAnzahlFiguren());
		System.out.println(spieler2.getAnzahlFiguren());
		
		//Weitere Ausgaben
		System.out.println(spieler1);
		System.out.println(sfigurBl1);
		System.out.println(spielfeld2.getID());
		System.out.println(spielfeld1.getID());
		
		//Starte Spiel
		s1.starteSpiel();
		
		System.out.println(spieler1.w.werfen());
		sfigurRo1.setPos(1);
		System.out.println(spielfeld1.istFeldBelegt());
		spielfeld1.removeSpielfigur();
		System.out.println(spielfeld1.istFeldBelegt());
		s1.werIstAmZug();
		System.out.println(Wuerfel.werfen());
		sfigurBl1.setPos(11);
		s1.werIstAmZug();
		System.out.println(Wuerfel.werfen());
		s1.werIstAmZug();
		System.out.println(Wuerfel.werfen());
		s1.werIstAmZug();
		System.out.println(Wuerfel.werfen());
		s1.werIstAmZug();
		System.out.println(spielfeld1.getSpielfigur());
		System.out.println(spieler1.getFiguren());
		System.out.println(spielfeld1.istFeldBelegt());
		spielfeld1.setSpielfigur(sfigurRo1);
		spielfeld1.removeSpielfigur();
		System.out.println(spielfeld1.istFeldBelegt());
		spielfeld1.setSpielfigur(sfigurRo1);
		s1.beendeSpiel();
		//System.out.println(s1); Spiel kennt die Spieler nicht mehr!  Exception in thread "main" java.lang.NullPointerException 
		
		
	}
}

