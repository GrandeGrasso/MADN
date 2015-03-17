package klassen;

public class Spielfeld {
	
	/**
	* Spielfeld Klasse, Definiert das Spielfeld
	* @author Gruppe B-5
	* @version 1.0
	*
	*/
	
	
	/**
	 *  Die ID beschreibt den eindeutigen Namen eines Spielfeldes
	 */
	int id; 
	
	 /**
	 * Konstruktor
	 * ID wird erzeugt
	 * 
	 * @param id wird an Konstruktor übergeben
	 */
	public Spielfeld(){ 
		this.id=id;	
	}
	
	/**
	 * Getter
	 */

	public int getId() {
		return id;
	}
	/**
	 * Setter ist privat damit die ID nicht veändert werden kann
	 */
	private void setId(int id){
		
		this.id=id;
	}
	
	
	/**
	 * Überprüfung ob ein Feld eine Figur hat 
	 * @return gibt true oder false
	 */
//	public boolean hatFigur(){
//		
//		if (id != null)
//		
//		return true;
//	}
	
	
	
	
	
	/**
	 *  Mit der toString Methode wird die ID übergeben
	 */
	public String toString(){
		return "Das Spielfeld hat die ID: " + id;
	}
	
	
}

