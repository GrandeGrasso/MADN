package klassen;

public class KI {

	private Spieler s;
	public KI(Spieler s){
		if(s==null){
			throw new RuntimeException(""+ "KI existiert nicht ohne den Spieler");
		}
		this.s=s;
	}
	public Spieler getSpieler(){
		return this.s;
	}
}
