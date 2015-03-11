
public class Würfel {

	private Spieler sp;
	private int min = 1;
	private int max = 7;
	
	public Würfel(){
		
	}
	
	private int wuerfeln(){
		

		return (int)(Math.random() * (max - min) + min);
		
					}
		
	public static void main(String[] args){
		
		Würfel wue = new Würfel();
		System.out.println(wue.wuerfeln());
		
	}
	
	}
	

