
public class Wuerfel {

	private Spieler sp;

	
	public Wuerfel(){
		
	}
	
	private int wuerfeln(){
		

		return (int)((Math.random()*6)+1);
		
					}
		
	public static void main(String[] args){
		
		Wuerfel wue = new Wuerfel();
		System.out.println(wue.wuerfeln());
		
	}
	
	}
	

