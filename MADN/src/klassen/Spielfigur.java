package klassen;

/**
 * Klasse Spielfigur wird erstellt 
 * @author  Gruppe B-5
 * @version 1.1
 */

public class Spielfigur {

	
	private Spieler spieler;
	private Spielfeld sfeld;
	private eFarben farbeFigur;
	private int pos;

	/**
	 * Konstruktor
	 * 
	 * @param farbeFigur Übergabewert der die Farbe der Spielfigur bestimmt
	 */
	
	public Spielfigur(eFarben farbeFigur){
		setFarbe(farbeFigur);			
	}
	
	/**
	 * Setter 
	 * 
	 * @param sfeld Übergabewert vom Typ Spielfeld
	 */

	public void setSpielfeld(Spielfeld sfeld) {	
		this.sfeld = sfeld;		
	}
	
	/**
	 * Setter
	 * 
	 * @param pos Übergabewert vom Typ Integer
	 */

	public void setPos(int pos) {	
		this.pos = pos;	
	}
	
	/**
	 * Setter
	 * 
	 * @param farbeFigur Übergabewert aus dem Enum eFarben
	 */
	
	private void setFarbe(eFarben farbeFigur) {	
		this.farbeFigur = farbeFigur;		
	}
	
	/**
	 * Setter
	 * 
	 * @param spieler Übergabewert vom Typ Spieler
	 */
	
	public void setSpieler(Spieler spieler) {		
		this.spieler = spieler;		
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt den Spieler der Spielfigur zurück
	 */
	
	public Spieler getSpieler() {		
		return spieler;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das Spielfeld, auf dem die Figur steht zurück
	 */
	
	public Spielfeld getSfeld() {
		return sfeld;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Farbe der Spielfigur zurück
	 */
	
	public eFarben getFarbeFigur() {
		return farbeFigur;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die aktuelle Position der Spielfigur zurück
	 */
	
	public int getPos() {
		return pos;
	}
	
	/**
	 * toString
	 * 
	 * Gibt den Spieler, die Farbe und die aktuelle Position der Spielfigur zurück
	 */
	@Override
	public String toString() {
		return "Spielfigur von: "+this.getSpieler()+" Farbe: "+this.getFarbeFigur()+" Position: "+this.getPos();	
	}
	
}
