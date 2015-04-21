package klassen;

import java.io.Serializable;
import java.util.ArrayList;



/**
 * Klasse Spieler, Definiert den Spieler
 * @author  Gruppe B-5
 * @version 1.1
 */


public class Spieler implements Serializable {
 
	
	private static final long serialVersionUID = 1L;
	
	private static final int spielfigurMax =4 ;
	private static Spielfigur []figur = new Spielfigur[spielfigurMax];
	
	
	private String name;
	private eFarben farbe;

	private Wuerfel wuerfel;
	private KI ki;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param farbe
	 */

	public Spieler(String name, eFarben farbe, boolean ki,Spiel spiel) {
		try {
			if (this.getName() == null && this.getFarbe() == null && ki == true) {
				this.setKI(randomKI(spiel));;
				this.setName(this.getKI().toString());
				this.setFarbe(farbe);
				for (int i = 0; i < 4; i++) {
					figur[i] = new Spielfigur(i, farbe, 0);
				}
			} else {
				this.setName(name);
				this.setFarbe(farbe);
				for (int i = 0; i < 4; i++) {
					figur[i] = new Spielfigur(i, farbe, 0);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Setter für Name
	 * 
	 * @param name
	 */

	private void setName(String name) {
		if ((name == null) || (name.length() < 2)) {
			throw new RuntimeException("Falsch");
		}
		this.name = name;
	}

	/**
	 * Getter fuer Spielfigur
	 * 
	 * @return figur
	 */

	public Spielfigur[] getSpielfigur() {
		return figur;
	}

	/**
	 * Getter fuer Name
	 * 
	 * @return name
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * Setter fuer Farbe
	 * 
	 * @param farbe
	 */
	public void setFarbe(eFarben farbe) {
		this.farbe = farbe;
		this.setSpielfiguren(farbe);
	}

	/**
	 * Methode Werfen
	 * 
	 * @return wuerfel.werfen(); Der Spieler benutzt den Wuerfel
	 */

	public int werfen() {
		return wuerfel.werfen();
	}

	/**
	 * Getter fuer Farbe
	 * 
	 * @return farbe
	 */

	public eFarben getFarbe() {
		return farbe;
	}

	public KI getKI() {
		return ki;
	}

	private void setKI(KI ki) {
		this.ki = ki;
	}

	private KI randomKI(Spiel spiel) {
		int zufallszahl = myRandom(1, 4);
		
		if (zufallszahl == 1) {
			return new KI_Aggressiv(this,spiel);
		} else {
			return new KI_Defensiv(this,spiel);
		}
	}

	public static int myRandom(int low, int high) {
		return (int) (Math.random() * (high - low) + low);
	}

	/**
	 * Methode gibt ID, Farbe und Position der jeweiligen Spielfiguren wieder
	 * 
	 * /** Methode alleSpielfiguren gibt alle Spielfiguren des jeweiligen
	 * Spielers aus
	 */
	public void alleSpielfiguren() {
		for (int i = 0; i < 4; i++) {
			System.out.println("ID : " + figur[i].getID() + " Farbe : "
					+ figur[i].getFarbe() + " Position : "
					+ figur[i].getPosition());
		}
	}

	/**
	 * setzt die Spielfigur
	 * 
	 * @param farbe
	 */
	private void setSpielfiguren(eFarben farbe) {

		for (int i = 0; i < 4; i++) {
			figur[i] = new Spielfigur(i, farbe, 0);
		}
	}
	
	
	
	
	

	@Override
	public boolean equals(Object o){
		if (!(o instanceof Spieler)) return false;
		Spieler s=(Spieler)o;
		return (s.getName()==this.getName());
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
