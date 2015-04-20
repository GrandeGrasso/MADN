package klassen;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Klasse Spieler, Definiert den Spieler
 * @author  Gruppe B-5
 * @version 1.1
 */


public class Spieler implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public Wuerfel w;
	private static final int spielfigurMax =4 ;
	private ArrayList <Spielfigur> spielfiguren = new ArrayList<Spielfigur>();
	private int spielfigurAnz=0;
	private eFarben farbe;
	private static final int anzahlKIMax=3;
	private ArrayList<KI> KI = new ArrayList<KI>();
//	private boolean gewonnen = false;
	
	/**
	 * Konstruktor
	 * 
	 * Erzeugt für jeden Spieler einen Wuerfel.
	 * 
	 * @param name Name des Spielers Typ String
	 * @param farbe Farbe des Spielers aus einem enum
	 * 
	 */
	
	public Spieler(String name, eFarben farbe){
		setName(name);
		setFarbe(farbe);
		for(int i=0;i<anzahlKIMax;i++){
			KI.add(new KI_Aggressiv(this));
		}
		for(int i=0;i<anzahlKIMax;i++){
			KI.add(new KI_Defensiv(this));
		}
		w = new Wuerfel();
		
	}
	
	/**
	 * Fuegt einem Array spielfigur Spielfiguren hinzu
	 * 	
	 */
	
	public void figurHinzufuegen(Spielfigur sf){
			
		if (spielfigurAnz > spielfigurMax)
			throw new RuntimeException("figurHinzufügen: Maximale Anzahl bereits erreicht!");
		
		spielfiguren.add(sf);
	  spielfigurAnz++;
	}
	
	/**
	 * Setter
	 *
	 * @param name Spielername Typ String
	 */
	
	public void setName(String name) {
		
		if ((name==null)||(name.length()<2)){
			throw new RuntimeException("Falsche Eingabe!");
			
		}
		this.name=name;
	}  	
	
	/**
	 * Setter
	 * 
	 * @param farbe Uebergabewert aus dem enum eFarben
	 */
	
	public void setFarbe(eFarben farbe) {
		if( farbe == eFarben.ROT || farbe == eFarben.GRUEN || farbe == eFarben.GELB || farbe == eFarben.BLAU)
		this.farbe = farbe;
		else throw new RuntimeException ("Falsche Eingabe!");
	} 
	
	/**
	 * Getter
	 * 
	 * @return Name des Spielers
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt die Farbe der Spielfigur zurueck
	 */
	
	public eFarben getFarbe() {
		return this.farbe;
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt die Anzahl der Spielfiguren im Spiefiguren Array zurueck
	 */
	
	public int getAnzahlFiguren() {
		return spielfigurAnz;
	}
	
//	public void setzeSpielfigur(){
//		
//	}
	public ArrayList<Spielfigur> getFiguren(){
		return spielfiguren;
	}
	
	/**
	* toString
	*  
	* @return Gibt Spielername und -farbe zurueck
	*/
	
	@Override
	public String toString(){
		return "Spieler "+ getName();
	}
	
	/**
	* equals
	* 
	* @param o Das Objekt, mit dem verglichen werden soll.
	* @return false Gibt false zurueck, wenn Objekt nicht instance of Spieler ist
	* @return true Gibt true zurueck, wenn Objekt den gleichen Namen hat wie das Vergleichsobjekt 
	*/
	
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
