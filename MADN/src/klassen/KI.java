package klassen;

import java.io.Serializable;



/**
 * Klasse KI, Definiert die KI
 * @author  Gruppe B-5
 * @version 1.1
 */

public abstract class KI implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Attribute
	 *
	 * @param spielbrett
	 * @param spiel
	 * @param spieler
	 * @param augenAnzahl
	 */

	private Spielbrett sb;
	private Spiel sp;
	private Spieler spieler;

	/**
	 * Konstruktor
	 * 
	 * @param spieler
	 * @param spiel
	 */

	public KI(Spieler spieler, Spiel spiel) {
		this.setSpieler(spieler);
		this.sp = spiel;
		sb = sp.getSB();
	}

	/**
	 * Getter fuer Spieler
	 * @return spieler
	 */
	public Spieler getSpieler() {
		return spieler;
	}
	
	/**
	 * Getter fuer Spiel
	 * @return spiel
	 */
	public Spiel getSpiel() {
		return sp;
	}

	/**
	 * Setter fuer Spieler
	 * @param spieler
	 */
	private void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}

	

	/**
	 * Methode schlage()
	 * ueberprueft fuer jede figur der ki, ob eine Gegnerfigur
	 * geschlagen werden kann
	 * @return true
	 */
	public boolean schlagen(int augenAnzahl) {
		for (Spielfigur figur : spieler.getSpielfigur()) {
			int zielPos = augenAnzahl + figur.getPosition();
			if (sb.getSpielfeld(zielPos).getFigur() != null) {
				sp.spielfeldBelegt(figur.getID(), zielPos);
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode ziel()
	 * ueberprueft fuer jede figur der ki, ob diese ins ziel kann
	 * @return true
	 */
	public boolean ziel(int augenAnzahl) {
		for (Spielfigur figur : spieler.getSpielfigur()) {
			int endPos = augenAnzahl + figur.getCounter();
			if (sp.insZiel(endPos, figur.getID())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode start()
	 * ueberprueft bei einer 6 gewuerfelt, 
	 * ob eine neue figur aus der startbox geholt werden kann
	 * @return true
	 */
	public boolean start(int augenAnzahl) {
		for (Spielfigur figur : spieler.getSpielfigur()) {
			if (augenAnzahl == 6 && sp.figurenAufFeld() < 4) {
				sp.figurAusSBholen(figur.getID());
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode ziehen()
	 * gibt aus welche zahl gewuerfelt wurde und zieht mit einer figur,
	 * die auf dem spielbrett steht
	 * @return true
	 */
	public boolean ziehen(int augenAnzahl) {
		System.out.println("Diese Zahl wurde gewürfelt " + augenAnzahl);
		for (Spielfigur figur : spieler.getSpielfigur()) {
			if (sp.FigurenId.contains(figur.getID())) {
				augenAnzahl += figur.getPosition();
				if (augenAnzahl > 40) {
					augenAnzahl -= 40;
				}
				sp.zieheWeiter(figur.getID(), augenAnzahl);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
