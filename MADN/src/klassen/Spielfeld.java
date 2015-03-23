package klassen;

/**
 * Spielfeld, Definiert ein Spielfeld
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielfeld {
	
	private eFeldTyp feldtyp = null;
	private static int counter = 0;
	private int ID;
	private boolean hatSpielfigur = false;
	private Spielfigur sfigur;	
	
	/**
	 *  Konstruktor
	 *  
	 *  @param feldtyp Übergabewert aus dem enum eFeldTyp, definiert die Spielfeldart
	 */
	
	public Spielfeld(eFeldTyp feldtyp){ 	
		setFeldTyp(feldtyp);		
		
		counter++;
		ID = counter;				
	}

	/**
	 * Setter Feldtyp
	 * 
	 * @param feldtyp Übergabewert aus enum eFeldTyp (Starfeld, Zielfeld, Lauffeld, Homefeld)
	 */
	
	private void setFeldTyp(eFeldTyp feldtyp){		
		this.feldtyp = feldtyp;
	}
	
	/**
	 * Getter FeldTyp
	 * 
	 * @return Gibt den FeldTyp zurück (Start-, Ziel-, Lauf-, Homefeld)
	 */
	
	public eFeldTyp getFeldTyp() {		
		return this.feldtyp;
	}
	
	/**
	 * 
	 * Getter ID
	 * 
	 * @return Gibt die SpielfeldID zurück
	 */
	
	public int getID() {	
		return this.ID;
	}
	
	/**
	 * Setzt eine Spielfigur auf ein Spielfeld
	 * 
	 * @param sfigur Übergabewert vom Typ Spielfigur
	 */
	
	public void setSpielfigur(Spielfigur sfigur) {
		if(this.hatSpielfigur==false){
		this.sfigur = sfigur;
			}
		else throw new RuntimeException("Es befindet sich eine Figur auf dem Feld!");		
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt die Spielfigur auf dem Spielfeld zurück
	 */
	
	public Spielfigur getSpielfigur(){
		return this.sfigur;		
	}
	
	/**
	 * Entfernt die Spielfigur vom Spielfeld
	 * 
	 */
	
	public void removeSpielfigur(){
		if (this.hatSpielfigur == true){
			sfigur = null;
			this.hatSpielfigur = false;
		}
			else throw new RuntimeException("Keine Figur auf dem Feld!");		
	}
	
	/**
	 * toString
	 * 
	 * Gibt die SpielfeldID und den Spielfeldtyp als String zurück
	 *  
	 */
	@Override
	public String toString(){	
		return "SpielfeldID: "+this.getID()+" SpielfeldTyp: "+this.getFeldTyp();
	}

	
	
}