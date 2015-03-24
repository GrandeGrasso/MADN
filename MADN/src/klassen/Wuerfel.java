package klassen;

/**
 * Wuerfel Klasse, Definiert den Wuerfel
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Wuerfel {
	
	private Spieler sp;

	
	/**
	 * Konstruktor
	 * 
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
	
	/**
	 * 
	 * Öffentlicher Setter für Spieler
	 * 
	 * @param spieler Übergabewert vom Typ Spieler
	 */
	
	public void setSpieler(Spieler spieler){
		this.sp = spieler;	
	}
	
	/**
	 * Getter für Spieler
	 * 
	 * @return Gibt den Spieler des Würfels zurück
	 */
	
	public Spieler getSpieler(){
		return this.sp;
	}
	
}
	

