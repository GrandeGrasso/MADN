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
	private eFarben farbeFigur;
	private int pos;

	public Spielfigur(eFarben farbeFigur){
		
		setFarbe(farbeFigur);
			
	}

	public void setSpielfeld(Spielfeld sfeld) {	
		this.sfeld = sfeld;
		
	}

	public void setPos(int pos) {	
		this.pos = pos;
		
	}

	private void setFarbe(eFarben farbeFigur) {	
		this.farbeFigur = farbeFigur;
		
	}

	public void setSpieler(Spieler spieler) {		
		this.spieler = spieler;		
	}

	public Spieler getSpieler() {		
		return spieler;
	}

	public Spielfeld getSfeld() {
		return sfeld;
	}

	public eFarben getFarbeFigur() {
		return farbeFigur;
	}

	public int getPos() {
		return pos;
	}
	
	@Override
	public String toString() {
		return "Spielfigur von: "+this.getSpieler()+" Farbe: "+this.getFarbeFigur()+" Position: "+this.getPos();	
	}
	
}
