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
	private static LinkedList<Spielfeld> spielbrett;
	private static LinkedList<Spielfeld> startrot;
	private static LinkedList<Spielfeld> zielrot ;
	private static LinkedList<Spielfeld> startgruen;
	private static LinkedList<Spielfeld> zielgruen;
	private static LinkedList<Spielfeld> startblau;
	private static LinkedList<Spielfeld> zielblau;
	private static LinkedList<Spielfeld> startgelb;
	private static LinkedList<Spielfeld> zielgelb;
	
	/**
	 * Konstruktor
	 * Spielfelder werden erzeugt
	 * 
	 * @param sfeld Spielfeld wird an Konstruktor übergeben
	 */
	
	public Spielbrett(Spielfeld sfeld){	
		
		spielbrett = new LinkedList<Spielfeld>();
		startrot = new LinkedList<Spielfeld>();
		zielrot = new LinkedList<Spielfeld>();
		startgruen = new LinkedList<Spielfeld>();
		zielgruen = new LinkedList<Spielfeld>();
		startblau = new LinkedList<Spielfeld>();
		zielblau = new LinkedList<Spielfeld>();
		startgelb = new LinkedList<Spielfeld>();
		zielgelb = new LinkedList<Spielfeld>();
		
		
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
