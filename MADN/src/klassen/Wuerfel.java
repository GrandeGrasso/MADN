package klassen;


public class Wuerfel {

	/**
	* Spielbrett Klasse, Definiert das Spielbrett
	* @author Stefano Grasso
	* @version 1.0
	*
	*/
	
	/**
	 * Attribute
	 * @param Spieler Würfel kennt den Spieler
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
	
	public static int werfen(){
		
		return (int)((Math.random()*6)+1);
		
					}
	
	}
	

