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
	 * @param spielbrett Verkettete Liste aus Spielfeldern, ergibt das Spielbrett
	 */
	
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
	 * Spielbrett wird erzeugt
	 * 
	 * @param spielbrett
	 * @param befülleSpielbret();
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
	 * Setzt Spielfelder auf das Spielbrett
	 * 
	 */
	
	private void befuelleSpielbrett(){
		
		for(int i=0;i<=40;i++){
			
			if( (i==1) || (i==11) || (i==21) || (i==31)){
				
				spielbrett.add(new Spielfeld(FeldTyp.Startfeld));
				
			}
			
			if( ((i>1) && (i<11)) || ((i>11) && (i<21)) || ((i>21) && (i<31)) || ((i>31)) ){
				
				spielbrett.add(new Spielfeld(FeldTyp.Lauffeld));
				
			}
			
		}		
		
	}
	
	/**
	 * 
	 * Methode befuelleZiel()
	 * 
	 * Befüllt die Arrays der Zielfelder, der einzelnen Farben mit Spielfeldern vom Typ Zielfeld.
	 * 
	 */
	
	private void befuelleZiel(){
		
		for(int i=0;i<zielrot.length;i++){
			
			zielrot[i]=new Spielfeld(FeldTyp.Zielfeld);
		
			zielblau[i]=new Spielfeld(FeldTyp.Zielfeld);
	
			zielgruen[i]=new Spielfeld(FeldTyp.Zielfeld);

			zielgelb[i]=new Spielfeld(FeldTyp.Zielfeld);
	}
	
}
	
	/**
	 * 
	 * Methode befuelleHome()
	 * 
	 * Befuellt die Arrays der Homefelder, der einzelnen Farben, mit Spielfeldern vom Typ Homefeld
	 * 
	 */
	
	private void befuelleHome(){
		
		//if abfragen für das Setzen der Spielfiguren in der richtigen Farbe
		
		for(int i=0;i<homerot.length;i++){
			
			homerot[i]=new Spielfeld(FeldTyp.Homefeld);
		
			homeblau[i]=new Spielfeld(FeldTyp.Homefeld);

			homegruen[i]=new Spielfeld(FeldTyp.Homefeld);

			homegelb[i]=new Spielfeld(FeldTyp.Homefeld);
	}
	
}
	
	/**
	 * 
	 * Methode getSpielbrett()
	 * 
	 * Gibt das gesamte Spielbrett zurück
	 * 
	 * @return String des Spielbretts
	 */
	
public String getSpielbrett(){
	
		return spielbrett.toString();
	
}
	
	
	
}