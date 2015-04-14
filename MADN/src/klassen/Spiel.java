package klassen;

import interfaces.iBediener;

public class Spiel implements iBediener {

	private static int spielerAnz=0;
	private final static int spielerMax =4;
	public static Spieler []spI = new Spieler[spielerMax];
	static int counter=0;
	private static int spcounter=0;
	private Spielfigur sf;
	private Spielbrett sb;
	private Spielfeld sfeld;
	private Spieler sp;
	
	public Spiel(){
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
			spI[spcounter]=new Spieler(name, farbe);
			for (int i = 0; i<=spcounter; i++){
			//(spI[i].getFarbe().equals(spI[i+].getFarbe())){ throw new RuntimeException("deine mudda is schwul!");}
			}
			spcounter++;
	}
	
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
		sb=new Spielbrett();
		for(int i=0;i<spI.length;i++){
		FigurAnSpieler(spI[i]);}
		sortiere(spI);
		System.out.println(this.toString());
		/*
		String s="";
		s+= "Es sind folgende Spieler im Spiel: \n";
		for(int i=0;i<spI.length;i++){
			s+= spI[i].getName() + " | ";
		}
		System.out.println(s);
		*/
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
	 * Methode FigurAnSpieler()
	 * 
	 * Uebergibt den Spielern ihre Figuren und befuellt gleichzeitig deren Homefelder.
	 * @param spieler Ein Objekt der Klasse Spieler
	 */
	@Override
	public void FigurAnSpieler(Spieler spieler){
		
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
	 * Methode wuerfeln()
	 * 
	 * Ruft die Methode getWuerfelErg() in der Klasse Wuerfel auf.
	 * 
	 */	
	@Override
	public void wuerfeln(){
		Wuerfel.getWuerfelErg();
	}
		
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
			spieler = spI[0];
			break;
		case 1:
			spieler = spI[1];
			break;
		case 2:
			spieler = spI[2];
			break;
		case 3:
			spieler = spI[3];
			break;
		}
		return spieler;
		
	}
	
	public Spieler getSpieler(Spieler spieler){
		
		return spI[0];
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
