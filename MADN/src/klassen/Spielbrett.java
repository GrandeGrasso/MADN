package klassen;

import java.io.Serializable;
import java.util.LinkedList;



/**
 * Spielbrett Klasse
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielbrett implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Attribute
	 * 
	 * @param spielbrett
	 * @param startBox
	 * @param zielBox
	 */

	private Spielfeld[] spielbrett;
	private Spielfeld[] homeRot;
	private Spielfeld[] homeBlau;
	private Spielfeld[] homeGruen;
	private Spielfeld[] homeGelb;

	private LinkedList<Spielfeld> zielRot;
	private LinkedList<Spielfeld> zielBlau;
	private LinkedList<Spielfeld> zielGruen;
	private LinkedList<Spielfeld> zielGelb;

	private Spielfeld spielfeld;
	private Spielfigur spielfigur;

	private int figurenAnzahl = 0;

	/**
	 * Konstruktor erstellt das Spielbrett mit allen Spielfeldern
	 * 
	 * @param feld
	 */
	public Spielbrett() {
		spielbrett = new Spielfeld[41];
		for (int i = 1; i <= 40; i++) {
			spielbrett[i] = new Spielfeld(i);
		}
		homeRot = new Spielfeld[4];
		homeBlau = new Spielfeld[4];
		homeGruen = new Spielfeld[4];
		homeGelb = new Spielfeld[4];
		zielRot = new LinkedList<Spielfeld>();
		zielBlau = new LinkedList<Spielfeld>();
		zielGruen = new LinkedList<Spielfeld>();
		zielGelb = new LinkedList<Spielfeld>();

	}

	public Spielfeld[] getSpielfigurBox(eFarben farbe) {

		switch (farbe) {
		case ROT:
			for (int i = 0; i < 4; i++) {
				if (this.homeRot[i] != null) {
					this.homeRot[i].getFigur();
					setFigurenAnzahl(i);
				}
			}
			return this.getStartBoxRot();
		case BLAU:
			for (int i = 0; i < 4; i++) {
				if (this.homeBlau[i] != null) {
					this.homeBlau[i].getFigur();
					setFigurenAnzahl(i);
				}
			}
			return this.getStartBoxBlau();
		case GRUEN:
			for (int i = 0; i < 4; i++) {
				if (this.homeGruen[i] != null) {
					this.homeGruen[i].getFigur();
					setFigurenAnzahl(i);
				}
			}
			return this.getStartBoxGruen();
		case GELB:
			for (int i = 0; i < 4; i++) {
				if (this.homeGelb[i] != null) {
					this.homeGelb[i].getFigur();
					setFigurenAnzahl(i);
				}
			}
			return this.getStartBoxGelb();
		}
		return spielbrett;
	}

	public int getFigurenAnzahl() {
		return figurenAnzahl;
	}

	public void setFigurenAnzahl(int figurenAnzahl) {
		this.figurenAnzahl = figurenAnzahl;
	}

	public void besetzeSBmitFiguren(Spielfigur[] figuren, eFarben farbe) {
		switch (farbe) {
		case ROT:
			this.setStartBoxRot(figuren);
			break;
		case BLAU:
			this.setStartBoxBlau(figuren);
			break;
		case GRUEN:
			this.setStartBoxGruen(figuren);
			break;
		case GELB:
			this.setStartBoxGelb(figuren);
			break;
		}
	}

	public Spielfeld[] getStartBoxRot() {
		return homeRot;
	}

	public Spielfeld[] getStartBoxBlau() {
		return homeBlau;
	}

	public Spielfeld[] getStartBoxGruen() {
		return homeGruen;
	}

	public Spielfeld[] getStartBoxGelb() {
		return homeGelb;
	}

	private void setStartBoxRot(Spielfigur[] sp) {
		for (int i = 0; i < 4; i++) {
			if (this.homeRot[i] == null) {
				this.homeRot[i] = new Spielfeld(i, sp[i]);
			}
		}
	}

	private void setStartBoxBlau(Spielfigur[] sp) {
		for (int i = 0; i < 4; i++) {
			if (this.homeBlau[i] == null) {
				this.homeBlau[i] = new Spielfeld(i, sp[i]);
			}
		}
	}

	private void setStartBoxGruen(Spielfigur[] sp) {
		for (int i = 0; i < 4; i++) {
			if (this.homeGruen[i] == null) {
				this.homeGruen[i] = new Spielfeld(i, sp[i]);
			}
		}
	}

	private void setStartBoxGelb(Spielfigur[] sp) {
		for (int i = 0; i < 4; i++) {
			if (this.homeGelb[i] == null) {
				this.homeGelb[i] = new Spielfeld(i, sp[i]);
			}
		}
	}

	public Spielfeld getSpielfeld(int id) {
		if (id > 40) {
			id = id - 40;
		}
		return spielbrett[id];
	}

	public void setzeSpielfeld(int id, Spielfigur figur) {
		this.spielbrett[id] = new Spielfeld(id, figur);
	}

	public LinkedList<Spielfeld> getZielBoxRot() {
		return zielRot;
	}

	public LinkedList<Spielfeld> getZielBoxBlau() {
		return zielBlau;
	}

	public LinkedList<Spielfeld> getZielBoxGruen() {
		return zielGruen;
	}

	public LinkedList<Spielfeld> getZielBoxGelb() {
		return zielGelb;
	}

	private void setZielBoxRot(int id, Spielfigur figur) {
		for (int i = 0; i < 4; i++) {
			zielRot.add(new Spielfeld(id, figur));
			this.zielRot.set(id, spielfeld);
		}
	}

	private void setZielBoxBlau(int id, Spielfigur figur) {
		for (int i = 0; i < 4; i++) {
			zielBlau.add(new Spielfeld(id, figur));
			this.zielBlau.set(id, spielfeld);
		}
	}

	private void setZielBoxGruen(int id, Spielfigur figur) {
		for (int i = 0; i < 4; i++) {
			zielGruen.add(new Spielfeld(id, figur));
			this.zielGruen.set(id, spielfeld);
		}
	}

	private void setZielBoxGelb(int id, Spielfigur figur) {
		for (int i = 0; i < 4; i++) {
			zielGelb.add(new Spielfeld(id, figur));
			this.zielGelb.set(id, spielfeld);
		}
	}

	public LinkedList<Spielfeld> getZielBox(eFarben farbe) {

		switch (farbe) {
		case ROT:
			return this.getZielBoxRot();
		case BLAU:
			return this.getZielBoxBlau();
		case GRUEN:
			return this.getZielBoxGruen();
		case GELB:
			return this.getZielBoxGelb();
		}
		return getZielBoxRot();
	}

	public void getSpielbrett() {

		for (int i = 1; i <= 40; i++) {
			System.out.println("Spielfeld: "
					+ spielbrett[i].getid() + " hat  Figur "
					+ spielbrett[i].getFigur());
		}

		for (int i = 0; i < 4; i++) {
			if (this.homeGelb[i] != null) {
				System.out.println("HomeGelb und  "
						+ homeGelb[i].getid() + " hat  Figur "
						+ homeGelb[i].getFigur());
			}
		}

		for (int i = 0; i < 4; i++) {
			if (this.homeRot[i] != null)
				System.out.println("HomeRot "
						+ homeRot[i].getid() + " hat Figur "
						+ homeRot[i].getFigur());
		}

		for (int i = 0; i < 4; i++) {
			if (this.homeGruen[i] != null)
				System.out.println("HomeGruen "
						+ homeGruen[i].getid() + " hat Figur "
						+ homeGruen[i].getFigur());
		}

		for (int i = 0; i < 4; i++) {
			if (this.homeBlau[i] != null)
				System.out.println("HomeBlau "
						+ homeBlau[i].getid() + " hat Figur? "
						+ homeBlau[i].getFigur());
		}

	}

	public void FigurZurueck(eFarben farbe, Spielfigur figur) {
		getSpielfigurBox(farbe);
		for (int i = 0; i < 4; i++) {
			if (getSpielfigurBox(farbe)[i] == null) {
				figur.setPosition(0);
				figur.setCounter(0);
				getSpielfigurBox(farbe)[i].setFigur(figur);
			}
		}
	}
	

	
}