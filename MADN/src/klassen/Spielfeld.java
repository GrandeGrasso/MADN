package klassen;

import java.io.Serializable;




/**
 * Klasse Spielfeld
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielfeld implements Serializable {
	
 
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attribute
	 * 
	 * @param id
	 * @param hatSpielfigur
	 * 
	 */
	private int id;
	private Spielfigur figur;
	
	public Spielfeld(int id){
		this.setid(id);
	}

	/**
	 * Konstruktor. Setzt die werte für ID und hatSpielfigur
	 */

	public Spielfeld(int id, Spielfigur figur) {
		this.setid(id);
		this.setFigur(figur);
	}

	/**
	 * 
	 * @return Gibt die Id des Spielfeldes zurück.
	 */

	public int getid() {
		return id;
	}

	/**
	 * Setzt die Id des Spielfeldes.
	 * 
	 * @param id
	 */

	private void setid(int id) {
		if (id <= 0 && id > 41) {
			throw new RuntimeException("Bitte gültige Id eingeben!");
		}
		this.id = id;
	}

	/**
	 * Getter fuer hatSpielfigur
	 * 
	 * @return hatSpielfigur
	 */

	public Spielfigur getFigur() {
		return this.figur;
	}

	/**
	 * Setter fuer hatSpielfigur
	 * 
	 * @param hatSpielfigu
	 */

	public void setFigur(Spielfigur figur) {
		this.figur = figur;
	}
	
}