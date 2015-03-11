
public class Wuerfel {

	private Spieler sp;
	private int min = 1;
	private int max = 7;
	
	public Wuerfel(){
		
	}
	
	private int wuerfeln(){
		

		return (int)(Math.random() * (max - min) + min);
		
					}
		
	public static void main(String[] args){
		
		Wuerfel wue = new Wuerfel();
		System.out.println(wue.wuerfeln());
		
	}
	
	}
	

