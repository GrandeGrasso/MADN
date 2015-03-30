package klassen;

import interfaces.iBediener;

public class Spiel implements iBediener {

	private static int spielerAnz=0;
	private final static int spielerMax =4;
	public static Spieler []spI = new Spieler[spielerMax];
	static int counter=0;
	
	public Spiel(){
	}

	/**
	 * 
	 * Methode addSpieler()
	 * 
	 * Fügt die jeweiligen Spieler ins Spiel hinzu.
	 * @param sp Das Objekt das hinzugefuegt werden soll.
	 */
	@Override
	public void addSpieler(Spieler sp) {
		if(spielerAnz==spielerMax)
			throw new RuntimeException("Maximale Spieleranzahl bereits erreicht!");
		spI[spielerAnz++]=sp;
	}
	
	/**
	 * 
	 * Methode sortiere()
	 * 
	 * Sortiert das Objectarray nach den Farben(rot,blau,gruen,gelb).
	 * @param a Das Objektarray der Klasse Spieler, das nach den Farben
	 * Rot, Blau, Gruen, Gelb sortiert werden soll.
	 */
	@Override
	public void sortiere(Spieler a[]) {
		Spieler []sortiert = new Spieler[spielerMax];
		for(int i=0;i<spI.length;i++){
			if((a[i]).getFarbe()==eFarben.ROT)
				sortiert[0]=a[i];
			if((a[i]).getFarbe()==eFarben.BLAU)
				sortiert[1]=a[i];
			if((a[i]).getFarbe()==eFarben.GRUEN)
				sortiert[2]=a[i];
			if((a[i]).getFarbe()==eFarben.GELB)
				sortiert[3]=a[i];
		}
		spI=sortiert;
	}
	
	/**
	 * 
	 * Methode starteSpiel()
	 * 
	 * Startet das Spiel und laesst den Spieler mit den roten Spielfiguren anfangen.
	 * Falls rot nicht gewaehlt wurde geht es im Uhrzeigersinn weiter.
	 */
	@Override
	public void starteSpiel() {
		sortiere(spI);
		for(int i=0;i<spI.length;i++){
			if(spI[i].getFarbe()==eFarben.ROT){
				System.out.println("--- Das Spiel beginnt! ---");
				System.out.println("Spieler: " + spI[i].getName() + " darf wuerfeln...");
				break;
			}
		}
	}
		
		
	/**
	 * 
	 * Methode werIstAmZug()
	 * 
	 * Ermittelt den Spieler, der als nächster wuerfeln darf.
	 * 
	 */
	@Override
	public void werIstAmZug() {
		if(counter>3)
			counter=0;
		switch(counter){
		case 0: 
			System.out.println("Spieler: " +spI[0].getName() + " ist an der Reihe...");
			break;
		case 1:
			System.out.println("Spieler: " +spI[1].getName() + " ist an der Reihe...");
			break;
		case 2:
			System.out.println("Spieler: " +spI[2].getName() + " ist an der Reihe...");
			break;
		case 3:
			System.out.println("Spieler: " +spI[3].getName() + " ist an der Reihe...");
			break;
		}
	}
	
	/**
	 * 
	 * Methode beendeSpiel()
	 * 
	 * Die Spieler werden aus dem Spiel entfernt.
	 * 
	 */
	@Override
	public void beendeSpiel() {
			spI = null;
			System.out.println("--- Das Spiel wurde beendet! ---");
		
	}
	
	/**
	 * 
	 * Methode toString()
	 * 
	 * Gibt das Object als String aus.
	 * 
	 */
	@Override
	public String toString(){
		String s="";
		s+= "Es sind folgende Spieler im Spiel: \n";
		for(int i=0;i<spI.length;i++){
			s+= spI[i].getName() + " | ";
		}
		return s;
	}
	
	
}
