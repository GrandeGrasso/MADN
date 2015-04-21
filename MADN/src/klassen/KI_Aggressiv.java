package klassen;

/**
 * Klasse KI_Aggressiv 
 * Erbt von der Subklasse KI
 * @author  Gruppe B-5
 * @version 1.1
 */

public class KI_Aggressiv extends KI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Konstruktor
	 * 
	 * @param spieler
	 * @param sp
	 */
	public KI_Aggressiv(Spieler spieler, Spiel sp) {
		super(spieler, sp);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode startKI() ruft die Methoden der oberklasse auf
	 * @return 
	 */
	public void starteKI(int augenAnzahl) {
		if (!schlagen(augenAnzahl)) {
			if (!start(augenAnzahl)) {
				if (!ziel(augenAnzahl)) {
					ziehen(augenAnzahl);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "KI_Aggressiv";
	}
}
