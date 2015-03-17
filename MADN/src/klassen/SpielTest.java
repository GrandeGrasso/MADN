package klassen;


public class SpielTest {

	

	public static void main(String[] args) {
		
		Spieler s1 = new Spieler("kathi", Farben.BLAU);
		
		Spielfeld sf1 = new Spielfeld(FeldTyp.Startfeld, 1);
		
		Spielbrett sb1 = new Spielbrett();
		
		
		System.out.println(sb1.getSpielbrett());
		
		
	}

}

