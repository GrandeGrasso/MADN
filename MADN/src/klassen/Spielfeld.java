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
	private Spielfigur sfigur;
	
	
	/**
	 *  Konstruktor
	 *  
	 *  @param feldtyp Gibt dem Feld einen Typ (Start-, Ziel-,Lauf-, Homefeld)
	 *  @param ID Weißt dem Feld eine ID zu
	 *  @param sfigur Weißt dem Spielfeld eine Spielfigur zu
	 */

	
	public Spielfeld(FeldTyp feldtyp, Spielfigur sfigur){ 
		
		setFeldTyp(feldtyp);
		setSfigur(sfigur);
		
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
	 * Setter ID
	 * 
	 * @param ID Spielfeld ID, Integer
	 */
	
	private void setID(int ID){
		
		this.ID = ID;
		
	}
	
	/**
	 * Setter Spielfigur
	 * 
	 * @param sfigur Spielfigur
	 */
	
	private void setSfigur(Spielfigur sfigur){
		
		this.sfigur = sfigur;
		
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
	
	/**
	 * Getter Spielfigur
	 * 
	 * @return Gibt die auf dem Spielfeld vorhandene Spielfigur zurück
	 */
	
	public Spielfigur getSfigur(){
		
		return this.sfigur;
		
	}

	@Override
	public String toString(){
		
		return "SpielfeldID: "+this.getID()+" SpielfeldTyp: "+this.getFeldTyp()+" Spielfigur: "+this.getSfigur()+" | ";
	}

	
	
}