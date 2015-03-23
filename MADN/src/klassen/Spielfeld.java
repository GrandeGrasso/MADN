package klassen;

public class Spielfeld {


	/**
	* Spielfeld, Definiert ein Spielfeld
	* @author Gruppe B-5
	* @version 1.0
	*
	*/
	
	private FeldTyp feldtyp = null;
	private static int counter = 0;
	private int ID;
	private boolean hatSpielfigur = false;
	private Spielfigur sfigur;
	
	
	/**
	 *  Konstruktor
	 *  
	 *  @param feldtyp Gibt dem Feld einen Typ (Start-, Ziel-,Lauf-, Homefeld)
	 *  @param ID Weißt dem Feld eine ID zu
	 *  @param sfigur Weißt dem Spielfeld eine Spielfigur zu
	 */

	
	public Spielfeld(FeldTyp feldtyp){ 
		
		setFeldTyp(feldtyp);		
		
		counter++;
		ID = counter;
		
		
	}

	/**
	 * Setter Feldtyp
	 * 
	 * @param feldtyp Gibt dem Feld einen Typ (Starfeld, Zielfeld, Lauffeld)
	 */
	
	private void setFeldTyp(FeldTyp feldtyp){
		
		this.feldtyp = feldtyp;

	}
	
	/**
	 * Getter FeldTyp
	 * 
	 * @return Gibt den FeldTyp zurück (Start-, Ziel-, Lauf-, Homefeld)
	 */
	
	public FeldTyp getFeldTyp() {
		
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
	
	public void setSpielfigur(Spielfigur sfigur) {
		this.sfigur = sfigur;
		
	}
	
	public Spielfigur getSpielfigur(){
		return this.sfigur;
		
	}
	
	public void removeSpielfigur(){
		if (this.hatSpielfigur == true){
			sfigur = null;
			this.hatSpielfigur = false;
		}
			else throw new RuntimeException("Keine Figur auf dem Feld!");
		
	}
	

	@Override
	public String toString(){
		
		return "SpielfeldID: "+this.getID()+" SpielfeldTyp: "+this.getFeldTyp();
	}

	
	
}