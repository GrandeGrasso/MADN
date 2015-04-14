package klassen;

import interfaces.iBediener;

import javax.xml.stream.events.StartElement;



public class SpielTest {

	public static void main(String[] args) {
		
		iBediener x = new Spiel();
		x.addSpieler("kathi", eFarben.BLAU);
		x.addSpieler("akin", eFarben.ROT);
		x.addSpieler("yunus", eFarben.GELB);
		x.addSpieler("stefano", eFarben.GRUEN);

		
		x.starteSpiel();
		x.wuerfeln();
		System.out.println(x.werIstAmZug());
		x.wuerfeln();
		System.out.println(x.werIstAmZug());
		x.wuerfeln();
		System.out.println(x.werIstAmZug());
		x.setzeFigurAufPos(x.werIstAmZug().getFiguren().get(0), 1);
		System.out.println(x.werIstAmZug());
		x.wuerfeln();
		System.out.println(x.werIstAmZug());
		x.wuerfeln();
		
		
		
	}
}

