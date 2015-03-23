package klassen;


public class SpielTest {

	

	public static void main(String[] args) {
		
		Spieler spieler1 = new Spieler("Kathi", Farben.BLAU);
		
		Spielbrett spielbrett1 = new Spielbrett();
		
		Spielfeld spielfeld1 = new Spielfeld(FeldTyp.Startfeld);
		Spielfeld spielfeld2 = new Spielfeld(FeldTyp.Zielfeld);
		
		
		Spielfigur sfigur1 = new Spielfigur(Farben.BLAU);
		Spielfigur sfigur2 = new Spielfigur(Farben.BLAU);
		
		
		System.out.println(spielfeld2.getID());
		
		System.out.println(spieler1.getAnzahlFiguren());
		
		System.out.println(spieler1.getAnzahlFiguren());
		
	}

}

