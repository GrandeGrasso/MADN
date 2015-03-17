package klassen;
/**
 * Klasse Spielfigur wird erstellt 
 * @author  Gruppe B-5
 * @version 1.1
 */


public class Spielfigur {
	
	/**
	 * Attribute
	 * 
	 * @param Spieler Instanz
	 * @param Spielbrett Instanz
	 * @param Spieler hat eine Farbe aus Enum
	 * @param figurID
	 * @param position
	 */
	
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
	
	/**
	 * Methode setzen der Figur aufs Spielfeld
	 * @return aktuelle position
	 */
	
	public int setzen(){
		return position;
			
	}
	
}
