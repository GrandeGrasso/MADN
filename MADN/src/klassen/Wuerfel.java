package klassen;

import java.io.Serializable;

/**
 * Wuerfel Klasse, Definiert den Wuerfel
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Wuerfel implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spieler sp;
	
	/**
	 * Konstruktor
	 * 
	 */
	
	public Wuerfel(){
		
	}
	
	/**
	 * Methode werfen()
	 * 
	 * @return Gibt einen Integer zwischen 1 und 6 zurueck
	 */
	
	public static String werfen(){		
		int augenzahl = (int)((Math.random()*6)+1);
		 String s="";
		 if(augenzahl==6){
			 s+= "Glueckwunsch du hast eine " + augenzahl + " gewuerfelt & darfst nochmal wuerfeln :) ...";
		 	 Spiel.counter--;
		 }
		 else 
			 s+= "Du hast eine " + augenzahl + " gewuerfelt...";
		 	 Spiel.counter++;
		 return s;
  }
	
	public static void getWuerfelErg(){
		System.out.println(werfen());;
	}
	/**
	 * 
	 * Oeffentlicher Setter fuer Spieler
	 * 
	 * @param spieler Uebergabewert vom Typ Spieler
	 */
	
	public void setSpieler(Spieler spieler){
		this.sp = spieler;	
	}
	
	/**
	 * Getter fuer Spieler
	 * 
	 * @return Gibt den Spieler des Wuerfels zurueck
	 */
	
	public Spieler getSpieler(){
		return this.sp;
	}
	
}
	

