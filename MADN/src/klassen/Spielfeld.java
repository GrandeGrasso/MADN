package klassen;

public class Spielfeld {


	/**
	* Spielfeld, Definiert ein Spielfeld
	* @author Gruppe B-5
	* @version 1.0
	*
	*/
	
	private FeldTyp feldtyp = null;
	private int ID;
	private Spielfigur sfigur;
	
	
	/**
	 *  Konstruktor
	 *  
	 *  @param feldtyp Gibt dem Feld einen Typ (Start-, Ziel-,Lauffeld)
	 *  @param ID Weißt dem Feld eine ID zu
	 */

	
	public Spielfeld(FeldTyp feldtyp, int ID){ 
		
		setFeldTyp(feldtyp);
		setID(ID);
		
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
	 * @param ID Setzt Integer als ID
	 */
	
	private void setID(int ID){
		
		this.ID = ID;
		
	}
	
	public FeldTyp getFeldTyp() {
		
		return this.feldtyp;
	}
	
	
	public int getID() {
		
		return this.ID;
	}

	@Override
	public String toString(){
		
		return "SpielfeldID: "+this.getID()+" SpielfeldTyp: "+this.getFeldTyp();
	}

	
	
}