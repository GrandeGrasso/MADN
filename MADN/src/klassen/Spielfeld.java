package klassen;

public class Spielfeld {
	
	/**
	 *  Die ID beschreibt den eindeutigen Namen eines Spielfeldes
	 */
	int id; 
	

	/**
	 *  Konstruktor
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
		
		if (id<0){
	  	throw new IllegalArgumentException("Ungültige ID");
		
	  	}
		this.id=id;
	}
	
	
	/**
	 * Überprüfung ob ein Feld eine Figur hat
	 */
	public boolean hatFigur(){
		return true;
	}
	
	
	
	
	
	/**
	 *  Mit der toString Methode wird die ID übergeben
	 */
	public String toString(){
		return "Das Spielfeld hat die ID: " + id;
	}
	
	
}

