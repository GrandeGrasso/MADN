import java.util.Random;


public enum Farben {
	
	ROT, BLAU, GELB, GRUEN;
	
	
	//Methode f�r die zuf�llige Ausgabe
	public static Farben waehleFarbe(){
	    Farben[] farben = Farben.values();
	    Random generator = new Random();
	    return farben[generator.nextInt(farben.length)];
	    }

// Test ob Ausgabe stimmt
public static void main(String[] args) {
	System.out.println(waehleFarbe());
}


}


