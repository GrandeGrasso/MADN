package klassen;


public class Spielfigur {

	private Spieler spieler;
	private Spielbrett spielbrett;
	private Farben farbeFigur;
	private int figurID;
	private int position;

	
	
	
	public Spielbrett getSpielbrett() {
		return spielbrett;
	}

	public void setSpielbrett(Spielbrett spielbrett)  {
		this.spielbrett = spielbrett;
	}
	

	public Farben getFarbeFigur() {
		return farbeFigur;
	}

	public void setFarbeFigur(Farben farbeFigur) {
		this.farbeFigur = farbeFigur;
	}
	
	public Spielfigur(Farben farbe){
	setFarbeFigur(farbeFigur);
}
	
	
}
