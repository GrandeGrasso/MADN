package klassen;

import java.io.Serializable;

/**
 * Wuerfel Klasse, Definiert den Wuerfel
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public class Wuerfel implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	private static byte festezahl = 0;

	public static void main(String[] args) {
			werfen();
	}

	public static int werfen() {
			if (festezahl==0){
			int anzAugen = (int) (6 * Math.random() + 1);
			System.out.println("Es wurde eine  " + anzAugen + " gewuerfelt!");
			return anzAugen;
			}
			return festezahl;
	}
	public void zufallsZahl(){
			festezahl = 0;
				
			}
	public  void festeZahl(byte zahl){
			this.festezahl = zahl;
			
	}
}
	

