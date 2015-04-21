package klassen;

import java.io.Serializable;



/**
 * Klasse Spielfigur, Definiert die Spielfigur 
 * @author  Gruppe B-5
 * @version 1.1
 */

public class Spielfigur implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	private Spieler sp;
	private int zaehler = 0;
	private eFarben farbe;
	private int pos;
	private int id;

	

	public Spielfigur() {

	}

	/**
	 * Konstruktor
	 * 
	 * @param id
	 * @param farbe
	 * @param position
	 *            dem Konstruktor wird die ID, die Farbe und die Position
	 *            übergeben
	 */
	public Spielfigur(int id, eFarben farbe, int position) {

		this.setFarbe(farbe);
		this.setPosition(position);
		this.setID(id);
	}

	/**
	 * @return farbe Getter fuer die Farbe
	 */

	public eFarben getFarbe() {
		return farbe;
	}

	/**
	 * @param farbe
	 *            setter fuer die Farbe
	 */

	public void setFarbe(eFarben farbe) {
		this.farbe = farbe;
	}

	/**
	 * @return Position getter fuer die Position
	 */

	public int getPosition() {
		if (pos > 40) {
			pos = pos - 40;
		}
		return pos;
	}

	/**
	 * @param position
	 *            setter fuer die Position
	 */

	public void setPosition(int position) {

		if (position > 40) {
			position = position - 40;
		}
		this.pos = position;
	}

	/**
	 * @returnID getter fuer die ID
	 */

	public int getID() {
		return id;
	}

	/**
	 * @param ID
	 *            setter fuer die ID
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return Counter Getter fuer den Counter
	 */

	public int getCounter() {

		return zaehler;
	}

	/**
	 * @param count
	 *            setter fuer den Counter
	 */
	public void setCounter(int count) {
		this.zaehler += count;
	}

	public String getSpielerName() {
		if (sp.getFarbe().equals(this.getFarbe())) {
			return sp.getName();
		}
		return "";
	}

	/**
	 * ueberschriebene toString
	 * 
	 * @return SpielfigurID
	 * @return position
	 * @return farbe
	 */

	@Override
	public String toString() {
		return "SpielfigurID " + this.getID() + "Position "
				+ this.getPosition() + "Farbe" + this.getFarbe();
	}
	
}
