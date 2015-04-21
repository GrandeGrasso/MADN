package klassen;

/**
 * Klasse KI_Defensiv 
 * Erbt von der Subklasse KI
 * @author  Gruppe B-5
 * @version 1.1
 */

public class KI_Defensiv extends KI {


	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 * @param spieler
	 * @param sp
	 */
	public KI_Defensiv(Spieler spieler, Spiel sp) {
		super(spieler, sp);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Methode starteKI()
	 * ruft Methoden aus der Oberklasse auf
	 */
	public void starteKI(int augenAnzahl){
		if (!ziel(augenAnzahl)) {
			if (!start(augenAnzahl)) {
				if(!schlagen(augenAnzahl)){
					ziehen(augenAnzahl);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "KI_Defensiv";
	}

}
