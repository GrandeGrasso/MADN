package klassen;

import java.util.LinkedList;

/**
 * Spielbrett Klasse, Definiert das Spielbrett
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Spielbrett {
	
	private static LinkedList<Spielfeld> spielbrett;
	private static Spielfeld homerot[];
	private static Spielfeld zielrot[];
	private static Spielfeld homeblau[];
	private static Spielfeld zielblau[];
  private static Spielfeld homegruen[];
  private static Spielfeld zielgruen[];
  private static Spielfeld homegelb[];
  private static Spielfeld zielgelb[];
	
  /**
   * Konstruktor
   * 
   * Erzeugt das Spielbrett als LinkedList und Haus- und Zielfelder als Arrays
   * 
   */
	
	public Spielbrett(){	
		
		spielbrett = new LinkedList<Spielfeld>();
		homerot = new Spielfeld[4];
		zielrot = new Spielfeld[4];
		homeblau = new Spielfeld[4];
		zielblau = new Spielfeld[4];
		homegruen = new Spielfeld[4];
		zielgruen = new Spielfeld[4];
		homegelb = new Spielfeld[4];
		zielgelb = new Spielfeld[4];
		
		
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
		for(int i=0;i<zielrot.length;i++){
			
			zielrot[i]=new Spielfeld(eFeldTyp.Zielfeld);		
			zielblau[i]=new Spielfeld(eFeldTyp.Zielfeld);	
			zielgruen[i]=new Spielfeld(eFeldTyp.Zielfeld);
			zielgelb[i]=new Spielfeld(eFeldTyp.Zielfeld);
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
		for(int i=0;i<homerot.length;i++){
			
			homerot[i]=new Spielfeld(eFeldTyp.Homefeld);	
			homeblau[i]=new Spielfeld(eFeldTyp.Homefeld);
			homegruen[i]=new Spielfeld(eFeldTyp.Homefeld);
			homegelb[i]=new Spielfeld(eFeldTyp.Homefeld);
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
	
	public String getSpielbrett(){	
			return spielbrett.toString();
	
	}	
	
}