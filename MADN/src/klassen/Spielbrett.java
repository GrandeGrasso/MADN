package klassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Spielbrett Klasse, Definiert das Spielbrett
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielbrett implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Spielfeld> spielbrett;
	private ArrayList<Spielfeld> homerot;
	private ArrayList<Spielfeld> zielrot;
	private ArrayList<Spielfeld> homeblau;
	private ArrayList<Spielfeld> zielblau;
	private ArrayList<Spielfeld> homegruen;
	private ArrayList<Spielfeld> zielgruen;
	private ArrayList<Spielfeld> homegelb;
	private ArrayList<Spielfeld> zielgelb;
	
  /**
   * Konstruktor
   * 
   * Erzeugt das Spielbrett als LinkedList und Haus- und Zielfelder als Arrays
   * 
   */
	
	public Spielbrett(){	
		
		spielbrett = new LinkedList<Spielfeld>();
		homerot = new ArrayList<Spielfeld>();
		zielrot = new ArrayList<Spielfeld>();
		homeblau = new ArrayList<Spielfeld>();
		zielblau = new ArrayList<Spielfeld>();
		homegruen = new ArrayList<Spielfeld>();
		zielgruen = new ArrayList<Spielfeld>();
		homegelb = new ArrayList<Spielfeld>();
		zielgelb = new ArrayList<Spielfeld>();
		
		befuelleSpielbrett();
		befuelleZiel();
		befuelleHome();	
	}

	/**
	 * 
	 * Methode befuelleSpielbrett()
	 * 
	 * Setzt Start- und Lauffelder vom gleichnamigen Typ auf das Spielbrett.
	 * 
	 */
	
	private void befuelleSpielbrett(){	
		for(int i=0;i<=40;i++){
			
			if( (i==1) || (i==11) || (i==21) || (i==31)){				
				spielbrett.add(new Spielfeld(eFeldTyp.Startfeld));				
			}
			
			if( ((i>1) && (i<11)) || ((i>11) && (i<21)) || ((i>21) && (i<31)) || ((i>31)) ){				
				spielbrett.add(new Spielfeld(eFeldTyp.Lauffeld));				
			}			
		}				
	}
	
	/**
	 * 
	 * Methode befuelleZiel()
	 * 
	 * Befuellt die Arrays der Zielfelder Spielfeldern vom Typ Zielfeld.
	 * 
	 */
	
	private void befuelleZiel(){		
		for(int i=0;i<4;i++){
			
			zielrot.add(new Spielfeld(eFeldTyp.Zielfeld));		
			zielblau.add(new Spielfeld(eFeldTyp.Zielfeld));	
			zielgruen.add(new Spielfeld(eFeldTyp.Zielfeld));
			zielgelb.add(new Spielfeld(eFeldTyp.Zielfeld));
	}	
}
	
	/**
	 * 
	 * Methode befuelleHome()
	 * 
	 * Befuellt die Arrays der Homefelder mit Spielfeldern vom Typ Homefeld.
	 * 
	 */
	
	private void befuelleHome(){		
		for(int i=0;i<4;i++){
			
			homerot.add(new Spielfeld(eFeldTyp.Homefeld));	
			homeblau.add(new Spielfeld(eFeldTyp.Homefeld));
			homegruen.add(new Spielfeld(eFeldTyp.Homefeld));
			homegelb.add(new Spielfeld(eFeldTyp.Homefeld));
	}	
}
	
	/**
	 * 
	 * Methode getSpielbrett()
	 * 
	 * Gibt das gesamte Spielbrett zurueck.
	 * 
	 * @return String des Spielbretts
	 */
	
	public LinkedList<Spielfeld> getSpielbrett(){	
			return spielbrett;
	
	}
	
	/**
	 * 
	 * Getter der Home und Ziellisten
	 * 
	 * @return ArrayList ArrayList der Home und Zielfelder
	 */
	
	public ArrayList<Spielfeld> getHomerot() {
		return homerot;
	}

	public ArrayList<Spielfeld> getZielrot() {
		return zielrot;
	}

	public ArrayList<Spielfeld> getHomeblau() {
		return homeblau;
	}

	public ArrayList<Spielfeld> getZielblau() {
		return zielblau;
	}

	public  ArrayList<Spielfeld> getHomegruen() {
		return homegruen;
	}

	public ArrayList<Spielfeld> getZielgruen() {
		return zielgruen;
	}
	
	public ArrayList<Spielfeld> getHomegelb() {
		return homegelb;
	}
	
	public ArrayList<Spielfeld> getZielgelb() {
		return zielgelb;
	}
	
}