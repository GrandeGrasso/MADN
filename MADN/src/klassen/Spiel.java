package klassen;

import java.io.File;
import java.io.Serializable;

import Datenaustausch.DatenzugriffCSV;
import Datenaustausch.DatenzugriffSerialisiert;
import interfaces.iBediener;
import interfaces.iDatenzugriff;

public class Spiel implements iBediener, Serializable {

	private static int spielerAnz=0;
	private final static int spielerMax =4;
	public static Spieler []spI = new Spieler[spielerMax];
	static int counter=0;
	private static int spcounter=0;
	private Spielfigur sf;
	private Spielbrett sb;
	private Spielfeld sfeld;
	private Spieler spielerAmZug;
	
	private static iDatenzugriff dZugriff;
	private static final long serialVersionUID = 1L;

	
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
		
	public void setzeFigurAufPos(Spielfigur sf , int ID){
		
		int getID = ID;
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
	
	
	public static void setdZugriff(iDatenzugriff dZugriff) {
		Spiel.dZugriff = dZugriff;
	}
/**
 * Getter fuer dZugriff
 * gibt datenzugriff zuruek
 * @return dZugriff
 */
	public static iDatenzugriff getdZugriff() {
		return dZugriff;
	}
	
	/**
	 * Methode speichernSerial
	 * das Spiel wird serialisiert gespeichert
	 * @param s
	 */
	
	public void speichernSerial(String dateiname) {
		try {
			setdZugriff(new DatenzugriffSerialisiert());
			File p = new File(dateiname + ".ser");
			if (p.length() > 0) {
				p.delete();
				p = new File(dateiname + ".ser");
			}
			getdZugriff().oeffnen(p);
			getdZugriff().speichern(p, this);
			System.out.println("Das Spiel wurde gespeichert: " + p.getName());
			getdZugriff().schliessen(p);
		} catch (Exception e) {
			System.out.println("Speichern Serialisiert fehlgeschlagen!");
		}
	}
	
	
	
	/**
	 * Methode ladenSerial
	 * Spiel wird serial geladen
	 * @param string
	 * @return null
	 */
	
	
	public static Spiel ladenSerial(String dateiname) {
		try {
			setdZugriff(new DatenzugriffSerialisiert());
			File f = new File(dateiname);
			getdZugriff().oeffnen(f);
			Spiel s = (Spiel) getdZugriff().laden(f);
			System.out.println("Das Spiel " + f.getName() + " wurde geladen.");
			getdZugriff().schliessen(f);
			return s;
		} catch (Exception e) {
			System.out.println("Laden Serialisiert fehlgeschlagen!");
			return null;
		}

	}
	

	   /**
	    * Getter fuer SpielerAmZug
	    * git den aktuellen Spieler zurueck
	    * @return spielerAmZug
	    */
		public Spieler getSpielerAmZug() {
			return spielerAmZug;
		}
		
		
		//ToDo--- Laden und speichern der CSV-Datei vervollstaendigen
		/**
		 * Methode speichernCSV
		 * speichert das Spiel als CSV-Datei
		 * Ueber das interface iDatenzugriff
		 * @param dateiname
		 */
		public void speichernCVS(String dateiname){
			
			setdZugriff(new DatenzugriffCSV());
			
			File f= new File(dateiname + " .txt");
			File p = new File(f.getAbsolutePath());
			
			if(f.length() > 0){
				p=new File(f.getAbsolutePath());
				f.delete();
			}
	}
		
		
		/**
		 * Methode ladenCSV
		 * laedt das Spiel als CSV-Datei
		 * Ueber das interface iDatenzugriff
		 * @param dateiname
		 * @return spiel
		 */
		
		
		public static Spiel ladenCSV(String dateiname){
			
			try{
				
				setdZugriff(new DatenzugriffCSV());
				File f = new File(dateiname);
				
				getdZugriff().oeffnen(f);
				System.out.println(" Das Spiel" + f.getName() + " wird geladen.");
				
				Spiel spiel = new Spiel();
				
		
				return spiel;
				
			}
			catch(Exception e ){
				System.out.println(" Laden der CSV-Datei ist fehlgeschlagen! ");
				
				
			
				
				return null;
				
			}
	
			
			
		
		}

		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		public Spielbrett getSpielbrett(){
			return sb;
		}

	






	

	
	
}
