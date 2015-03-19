package klassen;


public class SpielTest {

	

	public static void main(String[] args) {
		
		Spieler spieler1 = new Spieler("Kathi", Farben.BLAU);
		
		Spielbrett spielbrett1 = new Spielbrett();
		
		Spielfeld spielfeld1 = new Spielfeld(FeldTyp.Startfeld, null);
		Spielfeld spielfeld2 = new Spielfeld(FeldTyp.Zielfeld, null);
		
		
		Spielfigur sfigur1 = new Spielfigur(spieler1, Farben.BLAU, spielfeld1.getID(), spielfeld1);
		Spielfigur sfigur2 = new Spielfigur(spieler1, Farben.BLAU, spielfeld2.getID(), spielfeld2);
		
		
		spielfeld1.addSpielfigur(sfigur1);
		spielfeld2.addSpielfigur(sfigur2);
		
		System.out.println(spielfeld1.getSfigur());
		System.out.println(spielfeld2.getID());
		
		
		
	}

}

