package klassen;

import java.util.ArrayList;

/**
 * Klasse Spieler wird erstellt 
 * @author  Gruppe B-5
 * @version 1.1
 */


public class Spieler {
 
	private String name;
	private Wuerfel w;
	private static final int spielfigurMax =4 ;
	private static Spielfigur[] spielfigur = new Spielfigur[spielfigurMax];
	private static int spielfigurAnz=0;
	private eFarben farbe;
//	private boolean gewonnen = false;
//	private static final int anzahlKIMax=3;
//	private static KI[] ki=new KI[anzahlKIMax];
//	private int anzahlKI=0;
//	static ArrayList<KI>KI = new ArrayList<KI>();
	
	/**
	 * Konstruktor
	 * 
	 * Erzeugt für jeden Spieler einen Würfel.
	 * 
	 * @param name Name des Spielers Typ String
	 * @param farbeFigur Farbe des Spielers aus einem enum
	 * 
	 */
	
	public Spieler(String name, eFarben farbe){
		setName(name);
		setFarbeFigur(farbe);
		w = new Wuerfel();
		System.out.println("Spieler " +
				this.getName() + " hat eine " +  w.werfen() + " gewürfelt.");
	}
	
	/**
	 * Fügt einem Array spielfigur Spielfiguren hinzu
	 * 	
	 * @throws Wirft eine Fehlermeldung, wenn das Array voll ist und zusätzliche Spielfiguren hinzugefügt werden
	 */
	
	public void figurHinzufuegen(){
		
		if(spielfigurAnz < spielfigurMax){
			for(int i = 0; i<spielfigurMax;i++) {
				spielfigur[i] = new Spielfigur(this.farbe);
			}
			spielfigurAnz++;
		}
		else throw new RuntimeException("Maximale Anzahl an Spielfiguren erreicht!");
	}
	
	/**
	 * Setter
	 *
	 * @param name Spielername Typ String
	 * @throws Exception  Ueberpruefung der Laenge des Namens 
	 */
	
	public void setName(String name) {
		
		if ((name==null)||(name.length()<2)){
			throw new IllegalArgumentException("Falsche Eingabe!");
			
		}
		this.name=name;
	}  	
	
	/**
	 * Setter
	 * 
	 * @param farbeFigur Übergabewert der aus dem enum eFarben
	 */
	
	public void setFarbeFigur(eFarben farbe) {
		this.farbe = farbe;
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
	 * @return Gibt die Farbe der Spielfigur zurück
	 */
	
	public eFarben getFarbe() {
		return this.farbe;
	}
	
	/**
	 * Getter
	 * 
	 * @return Gibt die Anzahl der Spielfiguren im Spiefiguren Array zurück
	 */
	
	public int getAnzahlFiguren() {
		return spielfigurAnz;
	}
	
//	public void setzeSpielfigur(){
//		
//	}
	
	
	/**
	* toString
	*  
	* @return Gibt Spielername und -farbe zurück
	*/
	
	@Override
	public String toString(){
		return "Spieler: "+ getName()+" mit der Farbe: "+getFarbe();
	}
	
	/**
	* equals
	* 
	* @param o Das Objekt, mit dem verglichen werden soll.
	* @return false Gibt false zurück, wenn Objekt nicht instance of Spieler ist
	* @return true Gibt true zurück, wenn Objekt den gleichen Namen hat wie das Vergleichsobjekt 
	*/
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Spieler)) return false;
		Spieler s=(Spieler)o;
		return (s.getName()==this.getName());
	}
	
	

	
	
	
}
