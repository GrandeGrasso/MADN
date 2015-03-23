package klassen;


public class Wuerfel {

	/**
	* Spielbrett Klasse, Definiert das Spielbrett
	* @author Gruppe B-5
	* @version 1.0
	*
	*/
	
	/**
	 * Attribute
	 * @param Spieler Wuerfel kennt den Spieler
	 * @param Zahl des Wuerfels
	 */
	
	private Spieler sp;

	
	/**
	 * Konstruktor
	 * 
	 * @param Defaultkonstruktor
	 */
	
	public Wuerfel(){
		
	}
	
	/**
	 * Methode werfen()
	 * 
	 * @return Gibt einen Integer zwischen 1 und 6 zurück
	 */
	
	public int werfen(){		
		 int augenzahl = (int)((Math.random()*6)+1);
		 
			return augenzahl;
					}
	
	public void setSpieler(Spieler spieler){
		this.sp = spieler;
		
	}
	
	public Spieler getSpieler(){
		return this.sp;
	}
	
	}
	

