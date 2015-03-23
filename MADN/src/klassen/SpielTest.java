package klassen;


public class SpielTest {

	

	public static void main(String[] args) {
		
		Spieler spieler1 = new Spieler("Kathi", eFarben.BLAU);
		
		Spielbrett spielbrett1 = new Spielbrett();
		
		Spielfeld spielfeld1 = new Spielfeld(eFeldTyp.Startfeld);
		Spielfeld spielfeld2 = new Spielfeld(eFeldTyp.Zielfeld);
		
		
		Spielfigur sfigur1 = new Spielfigur(eFarben.BLAU);
		Spielfigur sfigur2 = new Spielfigur(eFarben.BLAU);
		
		
		System.out.println(spielbrett1.getSpielbrett());
		
		System.out.println(spieler1.getAnzahlFiguren());
		
		System.out.println(spieler1.getAnzahlFiguren());
		
	}

}

