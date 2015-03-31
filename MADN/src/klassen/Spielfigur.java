package klassen;

/**
 * Klasse Spielfigur, Definiert die Spielfigur 
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
	 * @param farbeFigur Uebergabewert der die Farbe der Spielfigur bestimmt
	 */
	
	public Spielfigur(eFarben farbeFigur){
		setFarbe(farbeFigur);			
	}
	
	/**
	 * Setter 
	 * 
	 * @param sfeld Uebergabewert vom Typ Spielfeld
	 */

	public void setSpielfeld(Spielfeld sfeld) {	
		this.sfeld = sfeld;		
	}
	
	/**
	 * Setter
	 * 
	 * @param pos Uebergabewert vom Typ Integer
	 */

	public void setPos(int pos) {	
		if(Spielfeld.hatSpielfigur==true)
			System.out.println("Es befindet sich eine Figur auf diesem Spielfeld. Kicken?");
		else{
			this.pos = pos;
			Spielfeld.hatSpielfigur =true;
			System.out.println(""+this +" wurde auf Position: " + pos + " gelegt.");
			sfeld.setSpielfigur(this);
			}
		/*
		if(Spielbrett.zielblau[0].getSpielfigur().getFarbeFigur()==eFarben.BLAU && Spielbrett.zielblau[1].getSpielfigur().getFarbeFigur()==eFarben.BLAU && Spielbrett.zielblau[2].getSpielfigur().getFarbeFigur()==eFarben.BLAU&& Spielbrett.zielblau[3].getSpielfigur().getFarbeFigur()==eFarben.BLAU)
			System.out.println("Der Spieler mit der Farbe blau hat gewonnen!");		
		if(Spielbrett.zielrot[0].getSpielfigur().getFarbeFigur()==eFarben.ROT && Spielbrett.zielrot[1].getSpielfigur().getFarbeFigur()==eFarben.ROT && Spielbrett.zielrot[2].getSpielfigur().getFarbeFigur()==eFarben.ROT && Spielbrett.zielrot[3].getSpielfigur().getFarbeFigur()==eFarben.ROT)
			System.out.println("Der Spieler mit der Farbe rot hat gewonnen!");
		if(Spielbrett.zielgelb[0].getSpielfigur().getFarbeFigur()==eFarben.GELB && Spielbrett.zielgelb[1].getSpielfigur().getFarbeFigur()==eFarben.GELB && Spielbrett.zielgelb[2].getSpielfigur().getFarbeFigur()==eFarben.GELB && Spielbrett.zielgelb[3].getSpielfigur().getFarbeFigur()==eFarben.GELB)
			System.out.println("Der Spieler mit der Farbe gelb hat gewonnen!");	
		if(Spielbrett.zielgruen[0].getSpielfigur().getFarbeFigur()==eFarben.GRUEN && Spielbrett.zielgruen[1].getSpielfigur().getFarbeFigur()==eFarben.GRUEN && Spielbrett.zielgruen[2].getSpielfigur().getFarbeFigur()==eFarben.GRUEN && Spielbrett.zielgruen[3].getSpielfigur().getFarbeFigur()==eFarben.GRUEN)
			System.out.println("Der Spieler mit der Farbe blau hat gewonnen!");		
		*/
	}
	
	/**
	 * Setter
	 * 
	 * @param farbeFigur Uebergabewert aus dem Enum eFarben
	 */
	
	private void setFarbe(eFarben farbeFigur) {	
		this.farbeFigur = farbeFigur;		
	}
	
	/**
	 * Setter
	 * 
	 * @param spieler Uebergabewert vom Typ Spieler
	 */
	
	public void setSpieler(Spieler spieler) {		
		this.spieler = spieler;		
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt den Spieler der Spielfigur zurueck
	 */
	
	public Spieler getSpieler() {		
		return spieler;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das Spielfeld, auf dem die Figur steht zurueck
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
	 * @return Gibt die aktuelle Position der Spielfigur zurueck
	 */
	
	public int getPos() {
		return pos;
	}
	
	/**
	 * toString
	 * 
	 * Gibt den Spieler, die Farbe und die aktuelle Position der Spielfigur zurueck
	 */
	@Override
	public String toString() {
		return "Spielfigur von: "+this.getSpieler()+" Farbe: "+this.getFarbeFigur();	
	}
	
}
