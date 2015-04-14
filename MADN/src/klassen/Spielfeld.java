package klassen;


/**
 * Spielfeld, Definiert ein Spielfeld
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielfeld {
	
  private eFeldTyp feldtyp;
	private static int counter = 0;
	private int ID;
	private boolean hatSpielfigur = false;
	private Spielfigur sfigur;	
	
	
	/**
	 *  Konstruktor
	 *  
	 *  @param feldtyp Uebergabewert aus dem enum eFeldTyp, definiert die Spielfeldart
	 */
	
	public Spielfeld(eFeldTyp feldtyp){ 	
		setFeldTyp(feldtyp);		
		
		counter++;
		ID = counter;				
	}

	/**
	 * Setter Feldtyp
	 * 
	 * @param feldtyp Uebergabewert aus enum eFeldTyp (Starfeld, Zielfeld, Lauffeld, Homefeld)
	 */
	
	private void setFeldTyp(eFeldTyp feldtyp){		
		this.feldtyp = feldtyp;
	}
	
	/**
	 * Getter FeldTyp
	 * 
	 * @return Gibt den FeldTyp zurueck (Start-, Ziel-, Lauf-, Homefeld)
	 */
	
	public eFeldTyp getFeldTyp() {		
		return feldtyp;
	}
	
	/**
	 * 
	 * Getter ID
	 * 
	 * @return Gibt die SpielfeldID zurueck
	 */
	
	public int getID() {	
		return this.ID;
	}
	
	/**
	 * Setzt eine Spielfigur auf ein Spielfeld
	 * 
	 * @param sfigur Uebergabewert vom Typ Spielfigur
	 */
	
	public void setSpielfigur(Spielfigur sfigur) {
		if(this.hatSpielfigur==false){
			this.sfigur = sfigur;
			this.hatSpielfigur = true;
			}
		else System.out.println("Es befindet sich eine Figur auf dem Feld, kicken?");
		
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt die Spielfigur auf dem Spielfeld zurueck
	 */
	
	public Spielfigur getSpielfigur(){
		return sfigur;
	}
	
	/**
	 * Entfernt die Spielfigur vom Spielfeld
	 * 
	 */
	
	public void removeSpielfigur(){
		if (this.hatSpielfigur == true){
			sfigur = null;
			System.out.println("Die Figur auf dem " +this +" wurde entfernt!");
			this.hatSpielfigur = false;
		}
			else throw new RuntimeException("Keine Figur auf dem Feld!");		
	}
	
	/**
	* istFeldBelegt()
	* 
	* @return false Gibt false zurueck, wenn Spielfeld nicht belegt ist.
	* @return true Gibt true zurueck, wenn auf einem Spielfeld bereits eine Figur steht.
	*/
	public boolean istFeldBelegt(){
		if(this.hatSpielfigur==true){
			return true;
			}
		return false;
	}
	/**
	 * toString
	 * 
	 * Gibt die SpielfeldID und den Spielfeldtyp als String zurueck
	 *  
	 */
	@Override
	public String toString(){	
		return "SpielfeldID: "+this.getID()+" SpielfeldTyp: "+this.getFeldTyp()+" Spielfigur: "+this.getSpielfigur();
	}
	
}