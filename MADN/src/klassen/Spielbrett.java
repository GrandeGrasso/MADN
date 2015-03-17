package klassen;

import java.util.LinkedList;


public class Spielbrett {
	
	/**
	* Spielbrett Klasse, Definiert das Spielbrett
	* @author Gruppe B-5
	* @version 1.0
	*
	*/
	
	/**
	 * Attribute
	 * 
	 * @param Spielfigur Spielbrett kennt Spielfigur
	 * @param Spielfeld Spielbrett kennt Spielfeld
	 * @param spielbrett Verkettete Liste aus Spielfeldern, ergibt das Spielbrett
	 * @param startrot Verkettete Liste aus Spielfeldern, Startfelder für Farbe Rot
	 * @param zielrot Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Rot
	 * @param startgruen Verkettete Liste aus Spielfeldern, Startfelder für Farbe Grün
	 * @param zielgruen Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Grün
	 * @param startblau Verkettete Liste aus Spielfeldern, Startfelder für Farbe Blau
	 * @param zielblau Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Blau
	 * @param startgelb Verkettete Liste aus Spielfeldern, Startfelder für Farbe Gelb
	 * @param zielgelb Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Gelb
	 */

	private Spielfigur sfigur;
	private Spielfeld sfeld;
	private static final LinkedList<Spielfeld> spielbrett = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> startrot = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> zielrot = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> startgruen = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> zielgruen = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> startblau = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> zielblau = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> startgelb = new LinkedList<Spielfeld>();
	private static final LinkedList<Spielfeld> zielgelb = new LinkedList<Spielfeld>();
	
	/**
	 * Konstruktor
	 * 
	 * @param sfeld Spielfeld wird an Konstruktor übergeben
	 */
	
	public Spielbrett(Spielfeld sfeld){	
		
		for (int i = 0; i<40; i++){
			spielbrett.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			startrot.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			zielrot.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			startgruen.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			zielgruen.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			startblau.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			zielblau.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			startgelb.add(sfeld);
		}
		for (int i = 0; i<4; i++){
			zielgelb.add(sfeld);
		}
		
		
		
		
	}
	
	
	
	
	
}
