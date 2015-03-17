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
	 * @param sfigur Spielbrett kennt Spielfigur
	 * @param sfeld Spielbrett kennt Spielfeld
	 * @param spielbrett Verkettete Liste aus Spielfeldern, ergibt das Spielbrett
	 * @param homerot Verkettete Liste aus Spielfeldern, Startfelder für Farbe Rot
	 * @param zielrot Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Rot
	 * @param homegruen Verkettete Liste aus Spielfeldern, Startfelder für Farbe Grün
	 * @param zielgruen Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Grün
	 * @param homeblau Verkettete Liste aus Spielfeldern, Startfelder für Farbe Blau
	 * @param zielblau Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Blau
	 * @param homegelb Verkettete Liste aus Spielfeldern, Startfelder für Farbe Gelb
	 * @param zielgelb Verkettete Liste aus Spielfeldern, Zielfelder für Farbe Gelb
	 */

	private Spielfigur sfigur;
	private Spielfeld sfeld;
	
	private static LinkedList<Spielfeld> spielbrett;
	private static LinkedList<Spielfeld> homerot;
	private static LinkedList<Spielfeld> zielrot;
	private static LinkedList<Spielfeld> homeblau;
	private static LinkedList<Spielfeld> zielblau;
	private static LinkedList<Spielfeld> homegruen;
	private static LinkedList<Spielfeld> zielgruen;
	private static LinkedList<Spielfeld> homegelb;
	private static LinkedList<Spielfeld> zielgelb;
	
	/**
	 * Konstruktor
	 * Spielbrett wird erzeugt
	 * 
	 * @param spielbrett
	 * @param homerot
	 * @param zielrot
	 * @param homegruen
	 * @param zielgruen
	 * @param homeblau
	 * @param zielblau
	 * @param homegelb
	 * @param zielgelb
	 * @param befülleSpielbret();
	 */
	
	public Spielbrett(){	
		
		spielbrett = new LinkedList<Spielfeld>();
		homerot = new LinkedList<Spielfeld>();
		zielrot = new LinkedList<Spielfeld>();
		homegruen = new LinkedList<Spielfeld>();
		zielgruen = new LinkedList<Spielfeld>();
		homeblau = new LinkedList<Spielfeld>();
	  zielblau = new LinkedList<Spielfeld>();
		homegelb = new LinkedList<Spielfeld>();
		zielgelb = new LinkedList<Spielfeld>();
		
		befuelleSpielbrett();
		
	}
	
	/**
	 * 
	 * Methode befuelleSpielbrett 
	 * 
	 * Setzt Spielfelder auf das Spielbrett
	 * 
	 */
	
	private void befuelleSpielbrett(){
		
		
		
	}
	
	
	
	
	
}