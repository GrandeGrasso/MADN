package klassen;


public class SpielTest {

	

	public static void main(String[] args) {
		
		Spieler s1 = new Spieler("Kathi", Farben.BLAU);
		
		Spielfeld sf1 = new Spielfeld(FeldTyp.Startfeld, null);
		
		Spielbrett sb1 = new Spielbrett();
		
		Spielfigur sfigur1 = new Spielfigur(s1, Farben.BLAU, 1, sf1);
		Spielfigur sfigur2 = new Spielfigur(s1, Farben.BLAU, 2, sf1);
		
		
		//system.out.println(sb1.getSpielbrett());
		
		
	}

}

