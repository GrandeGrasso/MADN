package klassen;

import java.io.Serializable;

/**
 * Klasse KI, Definiert die KI
 * @author  Gruppe B-5
 * @version 1.1
 */

public abstract class KI implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spieler s;
	
	/**
	 * Konstruktor
	 * 
	 * @param s Uebergabewert vom Typ Spieler
	 */
	
	public KI(Spieler s){
		if(s==null){
			throw new RuntimeException("" + "KI existiert nicht ohne den Spieler");
		}
		this.s=s;
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt einen Wert vom Typ Spieler zurueck
	 */
	public Spieler getSpieler(){
		return this.s;
	}
}
