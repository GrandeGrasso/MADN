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
	 * @param position
	 */
	
	private Spieler spieler;
	private Spielfeld sfeld;
	private Farben farbeFigur;
	private int pos;

	public Spielfigur(Spieler spieler, Farben farbeFigur, int pos, Spielfeld sfeld){
		
		setSpieler(spieler);
		setFarbe(farbeFigur);
		setPos(pos);
		setSpielfeld(sfeld);
			
	}

	private void setSpielfeld(Spielfeld sfeld) {	
		this.sfeld = sfeld;
		
	}

	private void setPos(int pos) {	
		this.pos = pos;
		
	}

	private void setFarbe(Farben farbeFigur) {	
		this.farbeFigur = farbeFigur;
		
	}

	private void setSpieler(Spieler spieler) {		
		this.spieler = spieler;		
	}

	public Spieler getSpieler() {		
		return spieler;
	}

	public Spielfeld getSfeld() {
		return sfeld;
	}

	public Farben getFarbeFigur() {
		return farbeFigur;
	}

	public int getPos() {
		return pos;
	}
	
	@Override
	public String toString() {
		return "";	
	}
	
}
