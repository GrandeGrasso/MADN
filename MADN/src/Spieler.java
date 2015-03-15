
public class Spieler {

	
	private String name;
	private Wuerfel wuerfel;
	private static final int spielfigurMax =4 ;
	private static Spielfigur[] spielfigur = new Spielfigur[spielfigurMax];
	private static int spielfigurAnz=0;
	private Farben farbeFigur;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {

	  	if ((name==null)||(name.length()<2)){
	  	throw new IllegalArgumentException("setName:ungültige Eingabe");
		
	  	}
	  	this.name=name;
	}  	
	
	
	public Farben getFarbeFigur() {
		return farbeFigur;
	}

	public void setFarbeFigur(Farben farbeFigur) {
		this.farbeFigur=farbeFigur;


	}  
	
	public Spieler(String name, Farben farbeFigur){
		setName(name);
		setFarbeFigur(farbeFigur);
		
	}
	
	
	public static void figurHinzufuegen(Spielfigur sf){
		
		if(spielfigurAnz < spielfigurMax){
			 spielfigur [spielfigurAnz++]=sf;
		}
	}
	

	public static int getAnzahlFiguren() {
		return spielfigurAnz;
	}
	
	@Override
	public String toString(){
		return "SpielerName "+getName()+", "+getName()+" mit der Farbe "+getFarbeFigur();
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Spieler)) return false;
		Spieler s=(Spieler)o;
		return (s.getName()==this.getName());
	}

	
	
	
}
