package klassen;

import java.util.ArrayList;

/**
 * Klasse Spieler wird erstellt 
 * @author  Gruppe B-5
 * @version 1.1
 */


public class Spieler {
 
	/**
	 * Deklaration des Namens des Spielers, und seinen Wuerfel
	 * Anzahl der maximalen Spielfiguren
	 * 
	 */
	
	private String name;
	private Wuerfel w;
	private static final int spielfigurMax =4 ;
	private static Spielfigur[] spielfigur = new Spielfigur[spielfigurMax];
	private static int spielfigurAnz=0;
	private Farben farbeFigur;
//	private boolean gewonnen = false;
//	private static final int anzahlKIMax=3;
//	private static KI[] ki=new KI[anzahlKIMax];
//	private int anzahlKI=0;
//	static ArrayList<KI>KI = new ArrayList<KI>();
	
	/**
	 * Konstruktor fuer die Klasse Spieler
	 * @param name des Spielers
	 * @param farbeFigur auswahl der Farbe
	 * Ausgabe des Spielernamen und die entsprechende Wurfzahl
	 * Objekt der Klasse KI erstellt
	 * 
	 */
	
	public Spieler(String name, Farben farbeFigur){
		setName(name);
		setFarbeFigur(farbeFigur);
		System.out.println("Der Spieler mit dem Namen " +
				getName() + " hat eine " +  Wuerfel.werfen()  + " geworfen");
	}
	
	/**
	 * Setzt den Namen des Spielers
	 * @param   name
	 * @throws Exception  Ueberpruefung der Laenge des Namens 
	 */
	
	public void setName(String name) {
		
		if ((name==null)||(name.length()<2)){
			throw new IllegalArgumentException("setName:ungueltige Eingabe");
			
		}
		this.name=name;
	}  	
	
	 /**
     * Liefert den Namen eines Spielers zurueck
     * @return    Name des Spielers
     */
	
	public String getName() {
		return name;
	}
	
	public void setFarbeFigur(Farben farbeFigur) {
		this.farbeFigur=farbeFigur;
	} 
	
	public Farben getFarbeFigur() {
		return farbeFigur;
	}
	
	/**
	 * Anzahl der Spielfiguren wird erhoeht, bis max erreicht
	 * @param sf Anzahl wird  sf zugewiesen
	 */

	public void figurHinzufuegen(){
		
		if(spielfigurAnz < spielfigurMax){
			for(int i = 0; i<spielfigurMax;i++) {
			 spielfigur[i] = new Spielfigur(this.farbeFigur);
			}
			spielfigurAnz++;
		}
		else throw new RuntimeException("Maximale Anzahl an Spielfiguren erreicht!");
	}
	
	public int getAnzahlFiguren() {
		return spielfigurAnz;
	}
	
//	public void setzeSpielfigur(){
//		
//	}
	
	
	/**
	* @return einen String, der das Objekt verdeutlicht
	* @see Object#toString()
	*/
	
	@Override
	public String toString(){
		return "Spieler: "+ getName()+" mit der Farbe: "+getFarbeFigur();
	}
	
	/**
	* @param o
	* das Objekt, mit dem verglichen werden soll.
	* ueberpruefung ob Klasse object keine instanz 
	* der klasse spieler ist
	* @return false falls o keine instanz von Spieler
	* @return name eines Objektes des Spielers
	*/
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Spieler)) return false;
		Spieler s=(Spieler)o;
		return (s.getName()==this.getName());
	}
	
	

	
	
	
}
