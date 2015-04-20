package klassen;

import java.util.ArrayList;

import interfaces.iBediener;

public class Spiel implements iBediener {

	private static int spielerAnz=0;
	private final static int spielerMax =4;
	public static Spieler []spielerliste = new Spieler[spielerMax];
	private ArrayList<eFarben> spielerfarbe = new ArrayList<eFarben>();
	static int counter=0;
	private static int spcounter=0;
	private Spielfigur sf;
	private Spielbrett sb;
	
	
	public Spiel(){
		
		sb=new Spielbrett();
		
	}

	/**
	 * 
	 * Methode addSpieler()
	 * 
	 * Fuegt die jeweiligen Spieler ins Spiel hinzu.
	 * @param name Name des Spielers.
	 * @param farbe Farbe des Spielers
	 */
	
	@Override
	public void addSpieler(String name, eFarben farbe) {
		
		if(spielerAnz==spielerMax || spcounter == spielerMax)
			throw new RuntimeException("Maximale Spieleranzahl bereits erreicht!");
		else  {
			if (spielerfarbe.contains(farbe)){
				throw new RuntimeException("Diese Farbe ist vergeben!");
			}
			if (!spielerfarbe.contains(farbe))
			spielerliste[spcounter]=new Spieler(name, farbe);
			spielerfarbe.add(farbe);
			spcounter++;
			
			}
	
	}
	
	/**
	 * 
	 * Methode sortiere()
	 * 
	 * Sortiert das Objectarray nach den Farben(rot,blau,gruen,gelb).
	 * @param o Das Objektarray der Klasse Spieler, das nach den Farben
	 * Rot, Blau, Gruen, Gelb sortiert werden soll.
	 */
	
	@Override
	public void sortiere(Object o[]) {
		Spieler []tmp = (Spieler[]) o;
		Spieler []sortiert = new Spieler[spielerMax];
		for(int i=0;i<spielerliste.length;i++){
			if((tmp[i]).getFarbe()==eFarben.ROT)
				sortiert[0]=tmp[i];
			if((tmp[i]).getFarbe()==eFarben.BLAU)
				sortiert[1]=tmp[i];
			if((tmp[i]).getFarbe()==eFarben.GRUEN)
				sortiert[2]=tmp[i];
			if((tmp[i]).getFarbe()==eFarben.GELB)
				sortiert[3]=tmp[i];
		}
		spielerliste=sortiert;
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
		
		for(int i=0;i<spielerliste.length;i++){
		FigurAnSpieler(spielerliste[i]);}
		sortiere(spielerliste);
		

		for(int i=0;i<spielerliste.length;i++){
			if(spielerliste[i].getFarbe()==eFarben.ROT){
				System.out.println("--- Das Spiel beginnt! ---");
				System.out.println(this.toString());
				System.out.println("Spieler: " + spielerliste[i].getName() + " darf wuerfeln...");
				
			}
		}
	}
	
	/**
	 * 
	 * Methode FigurAnSpieler()
	 * 
	 * Uebergibt den Spielern ihre Figuren und befuellt gleichzeitig deren Homefelder.
	 * @param spieler Ein Objekt der Klasse Spieler
	 */
	@Override
	public void FigurAnSpieler(Object  o){
		
		Spieler spieler = (Spieler) o;
		
		for(int i = 0; i<4;i++){
			sf = new Spielfigur(spieler.getFarbe(), spieler);
			spieler.figurHinzufuegen(sf);}
			
			switch (spieler.getFarbe()){				

			case ROT:
				int j=41;
				do{
					int r = 0;
					sf.setSpielfeld(sb.getHomerot().get(r));
					sf.setPos(j);
					j++;
					r++;
				}while(j<45);
					break;
			case BLAU:
				int k=49;
				do{
					int b = 0;
					sf.setSpielfeld(sb.getHomeblau().get(b));
					sf.setPos(k);
					k++;
					b++;
				}while(k<53);
				  break;
			case GRUEN:
				int l=57;
				do{
					int gr = 0;
					sf.setSpielfeld(sb.getHomegruen().get(gr));
					sf.setPos(l);
					l++;
					gr++;
				}while(l<61);
				  break;
			case GELB:
				int m=65;
				do{
					int g = 0;
					sf.setSpielfeld(sb.getHomegelb().get(g));
					sf.setPos(m);
					m++;
					g++;
				}while(m<69);
				  break;
			
			
		}		
		
	}
	
	/**
	 * 
	 * Methode setzeFigurAufPos()
	 * 
	 * Setzt eine Figur auf eine Position auf dem Spielbrett
	 * 
	 */
	
	@Override
	public void setzeFigurAufPos(Object o, int ID) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * Methode wuerfeln()
	 * 
	 * Ruft die Methode getWuerfelErg() in der Klasse Wuerfel auf.
	 * 
	 */	
	@Override
	public void wuerfeln(){
		Wuerfel.getWuerfelErg();
	}
		
	/**
	 * 
	 * Methode setzeFigurAufPos()
	 * 
	 * Setzt eine Figur auf eine Spielfeldposition
	 * 
	 */
	
	public void setzeFigurAufPos(Spielfigur sf, int ID){
		
		int getID = ID;
		sf.setSpielfeld(sb.getSpielbrett().get(getID));
		sf.setPos(getID);
		
	}
	/**
	 * 
	 * Methode werIstAmZug()
	 * 
	 * Ermittelt den Spieler, der als nächster wuerfeln darf.
	 * 
	 */
	@Override
	public Spieler werIstAmZug() {
		
		Spieler spieler = null;
		
		if(counter>3)
			counter=0;
		
		switch(counter){
		case 0: 
			spieler = spielerliste[0];
			break;
		case 1:
			spieler = spielerliste[1];
			break;
		case 2:
			spieler = spielerliste[2];
			break;
		case 3:
			spieler = spielerliste[3];
			break;
		}
		return spieler;
		
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
			spielerliste = null;
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
		for(int i=0;i<spielerliste.length;i++){
			s+= spielerliste[i].getName() + " | ";
		}
		return s;
	}

	
	
}
