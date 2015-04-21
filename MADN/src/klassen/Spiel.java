package klassen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import Datenaustausch.DatenzugriffCSV;
import Datenaustausch.DatenzugriffSerialisiert;
import interfaces.iBediener;
import interfaces.iDatenzugriff;

public class Spiel implements iBediener, Serializable {

	
	
	private static final long serialVersionUID = 1L;
	private static iDatenzugriff daten;
	
	
	public Spielbrett sb;
	private ArrayList<Spieler> spielerliste = new ArrayList<Spieler>();
	private int countRunde = 0;
	private int AnzSpieler = 0;
	private int SpielerAmZug = 0;
	private KI Ki;

	private int zielPos = 0;
	private int gewuerfelt = 0;
	private int wuerfler = 0;

	private ArrayList<eFarben> tmp = new ArrayList<eFarben>();
	private ArrayList<eFarben> max = new ArrayList<eFarben>();
	public ArrayList<Integer> FigurenId = new ArrayList<Integer>();

	Scanner s = new Scanner(System.in);

	public Spiel() {
	}

	public static String readString() {
		String Eingabe = new String();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			Eingabe = in.readLine();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return Eingabe;
	}


	/**
	 * Methode StartSpiel
	 * 
	 * @param AnzSpieler
	 *            Es koennen sich nur 1-4 Spieler anmelden ArrayList aus
	 *            Spielern wird bei jedem Start geleert ArrayList mit allen
	 *            Farben wird angelegt
	 */
	@Override
	public void starteSpiel(int AnzSpieler) {

		if (AnzSpieler < 5 && AnzSpieler >= 1) {
			sb = new Spielbrett();
			this.setAnzSpieler(AnzSpieler);
			spielerliste.clear();

			max.add(eFarben.BLAU);
			max.add(eFarben.GRUEN);
			max.add(eFarben.GELB);
			max.add(eFarben.ROT);
			
			
		}
	}

	/**
	 * Methode SpielerHinzufuegen
	 * 
	 * @param spieler
	 *            Es koennen sich nur so viele Spieler anmelden, wie bei
	 *            Spielstart angegeben wurde Spielern, die keine Farbe
	 *            ausgewaehlt haben, wird eine verfuegbare Farbe zugewiesen
	 *            Spieler die dieselbe Farbe gewaehlt haben, muessen eine andere
	 *            waehlen Alle Spieler werden mit hinzugefuegt und bekommen vier
	 *            Spielfiguren ihrer jeweiligen Farbe
	 */
	@Override
	public void addSpieler(String name, eFarben farbe, boolean ki, Object o) {
		if (spielerliste.size() < getAnzSpieler()) {
			Spieler sp  = new Spieler(name, farbe, ki, (Spiel) this);
			if (sp.getFarbe() == null) {
				for (Spieler spieler : spielerliste) {
					if (spieler.getFarbe() != null) {
						tmp.add(spieler.getFarbe());
					}
				}
				for (eFarben f : max) {
					// hier werden die maximalen farben mit den schon
					// ausgesuchten farben verglichen
					if (!tmp.contains(f)) {
						sp.setFarbe(f);

					}
				}
			}
			// ist meine Spielerliste leer? Füge Spieler hinzu
			if (spielerliste.isEmpty()) {
				spielerliste.add(sp);
			} else {
				for (Spieler spieler : spielerliste) {
					// falls ein Spieler die gleiche Farbe gewählt hat
					if (spieler.getFarbe().equals(sp.getFarbe())) {
						System.out
								.println(sp.getName()
										+ " Die Farbe "
										+ sp.getFarbe()
										+ " wurde schon gewählt! ");
					}
				}
				spielerliste.add(sp);
				if (sp.getKI() != null) {
					this.setKI(Ki);
				}
			}

			for (Spieler spl : spielerliste) {

				spl.setFarbe(spl.getFarbe());

				sb.besetzeSBmitFiguren(spl.getSpielfigur(), spl.getFarbe());
			}

		} else

			System.out.println("Maximale spieleranzahl erreicht");
	}

	/**
	 * Methode Wuerfeln ueberpruefung welcher Spieler momentan am Zug ist wenn
	 * der letzte Spieler am Zug war, ist der erste wieder dran ueberprufen ob
	 * alle Spielfiguren noch in der Startbox sind, dann Aufruf der Methode
	 * dreiMalWuerfeln Ansonsten wird gewuerfelt und Methode
	 * FigurenDieBewegtWerdenDuerfen wird aufgerufen SpielerAmZug wird
	 * hochgezaehlt
	 */
	@Override
	public void wuerfeln() {
		if (SpielerAmZug == getAnzSpieler()) {
			SpielerAmZug = 0;
		}

		zeigeSpielbrett();

		if (this.alleFigurenAufStartPosition(SpielerAmZug)) {
			dreimalWuerfeln();
			
		} else {
			einmalWuerfeln();
		}
		SpielerAmZug++;
	}

	public void einmalWuerfeln() {
		zielPos = spielerliste.get(SpielerAmZug).werfen();
		
		if (spielerliste.get(SpielerAmZug).getKI() != null) {
			
			return;
		}

		if (zielPos == 6) {// willst du eine aus der startbox oder welche figur
							// auf dem feld bewegen
			fragenBeiSechs();
			if (sechsGewuerfelt(zielPos)) {
				einmalWuerfeln();
			}
		} else {
			fragen();

		}

	}


	/**
	 * Methode DreiMalWuerfeln
	 * 
	 * @return true Spieler wuerfelt drei Mal wenn er eine 6 wuerfelt, darf er
	 *         auf seine Startposition und nochmal wuerfeln jede Farbe hat eine
	 *         andere Startposition nach dem zweiten wuerfeln, darf der spieler
	 *         seine Figur auf dem Spielfeld bewegen Methode ziehen wird
	 *         aufgerufen
	 */
	private boolean dreimalWuerfeln() {
		wuerfler = 0;
		// überprüfung wenn man eine 6 gewürfelt hat break
		for (int i = 0; i < 3; i++) {
			if (wuerfler != 6) {

				wuerfler = spielerliste.get(SpielerAmZug).werfen();

				if (wuerfler == 6) {

					zielPos = spielerliste.get(SpielerAmZug).werfen();

					figurAusSBholen(0);
					ziehen(0);
				}
			}
		}
		return false;
	}

	private boolean figurDarfBewegtWerden() {
		if (!alleFigurenAufStartPosition(SpielerAmZug)) {
			for (Spielfigur figur : spielerliste.get(SpielerAmZug)
					.getSpielfigur()) {
				if (figur.getPosition() != 0) {
					// if (spielerliste.get(SpielerAmZug).getSpielfigur()[i]
					// .getPosition() != 0) {

					System.out.println(spielerliste.get(SpielerAmZug).getName()
							+ " figur mit der id : "
							+ figur.getID() + " bewegen");
					FigurenId.add(figur.getID());
				}
				return true;
			}
		}
		return false;
	}

	public int figurenAufFeld() {
		int tmpfiguren = 0;
		for (int i = 0; i < 4; i++) {
			if (spielerliste.get(SpielerAmZug).getSpielfigur()[i].getPosition() != 0) {
				tmpfiguren++;
				FigurenId.add(i);
			}
		}
		return tmpfiguren;
	}

	private boolean alleFigurenAufStartPosition(int spielerId) {
		for (Spielfigur figur : spielerliste.get(spielerId).getSpielfigur()) {
			if (figur.getPosition() == 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	public void ziehen(int id) {
		sb.setzeSpielfeld(spielerliste.get(SpielerAmZug).getSpielfigur()[id]
				.getPosition(), null);// alte position wird gelöscht bevor neue
										// berechnet wird --> sonst doppelt auf
										// spielbrett
		if (figurenAufFeld() == 1) {
			figurDarfBewegtWerden();

		}
		System.out.println("Diese Zahl wurde gewürfelt " + zielPos);
		gewuerfelt = zielPos;

		int endPos = spielerliste.get(SpielerAmZug).getSpielfigur()[id]
				.getCounter() + zielPos;

		zielPos += spielerliste.get(SpielerAmZug).getSpielfigur()[id]
				.getPosition();
		
		if (zielPos > 40) {
			zielPos -= 40;
		}
		// kann man schon ins ziel?
		if (!insZiel(endPos, id)) {
			// nein? dann ziehe weiter

			if (sb.getSpielfeld(zielPos).getFigur() == null) {

				zieheWeiter(id, zielPos);
			}
		} else {
			spielfeldBelegt(
					spielerliste.get(SpielerAmZug).getSpielfigur()[id].getID(),
					zielPos);
		}

		if (sechsGewuerfelt(gewuerfelt)) {
			einmalWuerfeln();
		}
	}

	public void zieheWeiter(int id, int zielPos) {
		spielerliste.get(SpielerAmZug).getSpielfigur()[id].setPosition(zielPos);

		sb.setzeSpielfeld(spielerliste.get(SpielerAmZug).getSpielfigur()[id]
				.getPosition(),
				spielerliste.get(SpielerAmZug).getSpielfigur()[id]);

		System.out.println("Das ist die Zielposition " + zielPos);

		spielerliste.get(SpielerAmZug).getSpielfigur()[id]
				.setCounter(gewuerfelt);

	}

	public boolean figurAusSBholen(int id) {

		switch (spielerliste.get(SpielerAmZug).getFarbe()) {
		// bei Spieler rot ist die Startposition = 1
		case ROT:
			if (sb.getSpielfeld(1).getFigur() != null) {
				spielfeldBelegt(
						spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getID(),
						1);
			} else {
				spielerliste.get(SpielerAmZug).getSpielfigur()[id]
						.setPosition(1);

				sb.setzeSpielfeld(1, spielerliste.get(SpielerAmZug)
						.getSpielfigur()[id]);

				sb.getSpielfigurBox(spielerliste.get(SpielerAmZug).getFarbe())[id]
						.setFigur(null);

				System.out.println("Das ist die Startposition der Figur rot: "
						+ spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getPosition());
			}
			return true;

			// bei Spieler blau ist die Startposition = 11
		case BLAU:
			if (sb.getSpielfeld(11).getFigur() != null) {
				spielfeldBelegt(
						spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getID(),
						11);
			} else {
				spielerliste.get(SpielerAmZug).getSpielfigur()[id]
						.setPosition(11);

				sb.setzeSpielfeld(11, spielerliste.get(SpielerAmZug)
						.getSpielfigur()[id]);

				sb.getSpielfigurBox(spielerliste.get(SpielerAmZug).getFarbe())[id]
						.setFigur(null);
				System.out.println("Das ist die Startposition der Figur blau: "
						+ spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getPosition());
			}
			return true;

			// bei Spieler gruen ist die Startposition = 21
		case GRUEN:
			if (sb.getSpielfeld(21).getFigur() != null) {
				spielfeldBelegt(
						spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getID(),
						21);
			} else {
				spielerliste.get(SpielerAmZug).getSpielfigur()[id]
						.setPosition(21);

				sb.setzeSpielfeld(21, spielerliste.get(SpielerAmZug)
						.getSpielfigur()[id]);

				sb.getSpielfigurBox(spielerliste.get(SpielerAmZug).getFarbe())[id]
						.setFigur(null);
				System.out
						.println("Das ist die Startposition der Figur gruen: "
								+ spielerliste.get(SpielerAmZug)
										.getSpielfigur()[id].getPosition());
			}
			return true;

			// bei Spieler gelb ist die Startposition = 31
		case GELB:
			if (sb.getSpielfeld(31).getFigur() != null) {
				spielfeldBelegt(
						spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getID(),
						31);
			} else {
				spielerliste.get(SpielerAmZug).getSpielfigur()[id]
						.setPosition(31);

				sb.setzeSpielfeld(31, spielerliste.get(SpielerAmZug)
						.getSpielfigur()[id]);

				sb.getSpielfigurBox(spielerliste.get(SpielerAmZug).getFarbe())[id]
						.setFigur(null);
				System.out.println("Das ist die Startposition der Figur gelb: "
						+ spielerliste.get(SpielerAmZug).getSpielfigur()[id]
								.getPosition());
			}
			return true;

		}
		return false;
	}

	/**
	 * Methode zeigeSpieler Gibt alle Spieler in der ArrayList spielerliste mit
	 * Name und Farbe aus
	 */
	@Override
	public void zeigeSpieler() {
		for (int i = 0; i < spielerliste.size(); i++) {
			System.out.println("Name: " + spielerliste.get(i).getName()
					+ ", Farbe: " + spielerliste.get(i).getFarbe());
		}
	}

	/**
	 * Methode zeigeFigur Gibt alle Spielfiguren des jeweiligen Spielers mit Id,
	 * Farbe und Position aus
	 */
	@Override
	public void zeigeFigur() {
		if (SpielerAmZug == getAnzSpieler()) {
			SpielerAmZug = 0;
		}
		spielerliste.get(SpielerAmZug).alleSpielfiguren();
	}

	public void fragenBeiSechs() {
		if (figurenAufFeld() >= 2) {// mehr als eine auf feld
			System.out.println("Mit welcher Figur möchtest du ziehen "
					+ spielerliste.get(SpielerAmZug).getName() + " ?");
			System.out.println(" Du kannst diese Figuren bewegen  \n");
			for (Spielfigur figur : spielerliste.get(SpielerAmZug)
					.getSpielfigur()) {
				if (figur.getPosition() != 0) {
					System.out.println("FigurID " + figur.getID()
							+ " ist auf dem Spielbrett und kann bewegt werden");
				}
			}
			System.out.println("Figur aus Home nehmen? ");

			for (Spielfigur figur : spielerliste.get(SpielerAmZug)
					.getSpielfigur()) {
				if (figur.getPosition() == 0) {
					System.out.println("Die Figur mit der ID " + figur.getID()
							+ "befindet sich in deiner Startbox");
				}
			}

		} else {
			if (figurenAufFeld() == 1) {// nur eine auf feld
				figurDarfBewegtWerden();
			}
			System.out.println("Figur aus Home nehmen? ");

			for (Spielfigur figur : spielerliste.get(SpielerAmZug)
					.getSpielfigur()) {
				if (figur.getPosition() == 0) {
					System.out.println("Die Figur mit der ID " + figur.getID()
							+ "befindet sich im Home");
				}

			}

			try {
				int eingabe = s.nextInt();

				if (eingabe >= 0 && eingabe <= 3) {
					figurAusSBholen(eingabe);
					figurenAufFeld();
					fragen();
				} else if (eingabe == 0 && eingabe <= 3) {
					ziehen(eingabe);
				}
			} catch (Exception e) {
				System.out
						.println("bitte index beachten");
				this.fragenBeiSechs();
			}
		}

	}

	public void fragen() {
		if (figurenAufFeld() >= 2) {
			System.out.println("Mit welcher Figur möchtest du ziehen "
					+ spielerliste.get(SpielerAmZug).getName() + " ?");
			for (Spielfigur figur : spielerliste.get(SpielerAmZug)
					.getSpielfigur()) {
				if (figur.getPosition() != 0) {
					System.out.println("FigurID " + figur.getID()
							+ " ist auf dem SB und kann bewegt werden");
				}
			}
			try {
				int andereEingabe = s.nextInt();
				if (andereEingabe >= 0 && andereEingabe <= 3) {
					ziehen(andereEingabe);
				}
			} catch (Exception e) {

				System.out
						.println("beachte index");
				this.fragenBeiSechs();
			}
		} else {
			ziehen(0);
		}
	}

	/**
	 * Diese Methode ueberprueft ob eine spielfigur auf der zielpos steht, wenn
	 * ja, wird ueberprueft, ob sie dieselbe farbe hat, wenn nein, wird die
	 * figur geschlagen
	 * 
	 * @param id
	 */
	public void spielfeldBelegt(int id, int zielPos) {
		// ist eine eigene figur auf der zielpos? bleibe auf deiner position
		if (spielerliste.get(SpielerAmZug).getFarbe()
				.equals(sb.getSpielfeld(zielPos).getFigur().getFarbe())) {
			spielerliste.get(SpielerAmZug).getSpielfigur()[id]
					.setPosition(spielerliste.get(SpielerAmZug).getSpielfigur()[id]
							.getPosition());
			System.out.println("Position ist mit eigener Figur belegt \n "
					+ "wähle eine andere Figur");
			fragen();

		} else {
			// Figur wird geschlagen
			sb.FigurZurueck(sb.getSpielfeld(zielPos).getFigur().getFarbe(), sb
					.getSpielfeld(zielPos).getFigur());

			System.out.println("Du hast "
					+ sb.getSpielfeld(zielPos).getFigur().getSpielerName()
					+ "'s Figur geschlagen\n" + " Ziel"
					+ zielPos);
			spielerliste.get(SpielerAmZug).getSpielfigur()[id]
					.setPosition(zielPos);

			sb.setzeSpielfeld(
					spielerliste.get(SpielerAmZug).getSpielfigur()[id]
							.getPosition(), spielerliste.get(SpielerAmZug)
							.getSpielfigur()[id]);

			spielerliste.get(SpielerAmZug).getSpielfigur()[id]
					.setCounter(zielPos);
		}
	}

	public boolean insZiel(int endPos, int id) {
		if (endPos > 40 && endPos < 45) {
			endPos -= 40;
			sb.getZielBox(spielerliste.get(SpielerAmZug).getFarbe()).add(new Spielfeld(endPos, spielerliste.get(SpielerAmZug).getSpielfigur()[id]));
			spielerliste.get(SpielerAmZug).getSpielfigur()[id].setPosition(sb.getZielBox(spielerliste.get(SpielerAmZug).getFarbe()).get(endPos).getid());
			
														
			return true;
		}
		return false;
	}

	private boolean sechsGewuerfelt(int gewuerfelt) {
		if (gewuerfelt == 6) {
			System.out.println(spielerliste.get(SpielerAmZug).getName()
					+ ", du darfst nochmal würfeln");
			return true;
		}
		return false;
	}

	public void zeigeSpielbrett() {
		System.out.println(spielerliste.get(SpielerAmZug).getName()
				+ " ist am Zug!");
		sb.getSpielbrett();
	}

	private void setAnzSpieler(int AnzSpieler) {
		this.AnzSpieler = AnzSpieler;
	}

	public int getAnzSpieler() {
		return AnzSpieler;
	}

	private void setKI(KI Ki) {
		for (Spieler spieler : spielerliste) {
			if (spieler.getKI() != null)
				;
			this.Ki = spieler.getKI();
		}
	}

	public Spielbrett getSB() {
		return sb;
	}

	public Spiel getSpiel() {
		return this;
	}
	
	public String writeTo() {
		return this.spielerliste.get(AnzSpieler).getName();
	}

	
	
	
	public void speichernSerial(String s){
		try{
			daten = new DatenzugriffSerialisiert();
			Properties p = new Properties();
			p.setProperty("datei", s +".ser");
			daten.oeffnen(p);
			daten.schreiben(this);
			System.out.println("Das Spiel wurde gespeichert: "+p.getProperty("datei"));
			daten.schliessen(p);
		}catch (Exception e){
			System.out.println("Speichern serialisiert fehlgeschlagen!");
		}
	}
	
	public static Spiel ladenSerial(String s) {
		try {
			daten = new DatenzugriffSerialisiert();
			Properties p = new Properties();
			daten.oeffnen(p);
			Spiel spiel = (Spiel) daten.lesen();
			System.out.println("Das Spiel wurde erfolgreich geladen.");
			daten.schliessen(p);
			return spiel;
		} catch (Exception e) {
			System.out.println("Laden serialisiert fehlgeschlagen!");
			return null;
		}

	}

	public static Spiel ladenCSV(String s) {
		try {
			daten = new DatenzugriffCSV();
			Properties p = new Properties();
			daten.oeffnen(p);
			Spiel spiel = (Spiel) daten.lesen();
			System.out.println("Das Spiel wird geladen.");
			daten.schliessen(p);
			return spiel;
		}catch(Exception e){
			System.err.println("Laden CSV fehlgeschlagen!");
			return null;
		}

	}
	public void speichernCSV(String dateiname) {
		try {
		daten = new DatenzugriffCSV();
		Properties p = new Properties();
		p.setProperty("Dateiname", dateiname + ".csv");
		p.setProperty("Modus", "s");
			daten.oeffnen(p);
				daten.schreiben(sb.getStartBoxRot()+ "\n");
				daten.schreiben(sb.getStartBoxGruen()+ "\n");
				daten.schreiben(sb.getStartBoxGelb()+ "\n");
				daten.schreiben(sb.getStartBoxBlau()+ "\n");
				for(int i=1;i<=40;i++){
					daten.schreiben(sb.getSpielfeld(i)
							+ "\n");
				}
				daten.schreiben(sb.getZielBoxRot()+ "\n");
				daten.schreiben(sb.getZielBoxGruen()+ "\n");
				daten.schreiben(sb.getZielBoxGelb()+ "\n");
				daten.schreiben(sb.getZielBoxBlau()+ "\n");

		} catch (Exception e) {
			System.err.println("Speichern CSV fehlgeschlagen!");
		} finally {

			try {
				daten.schliessen(dateiname);
			} catch (IOException fehler) {
				System.out.println(fehler.getMessage());
			}

		}

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	public static void setdZugriff(iDatenzugriff dZugriff) {
		Spiel.daten = dZugriff;
	}
/**
 * Getter fuer dZugriff
 * gibt datenzugriff zuruek
 * @return dZugriff
 */
	public static iDatenzugriff getdZugriff() {
		return daten;
	}
	
	
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
	

	






	

	
	
}
