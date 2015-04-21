package klassen;

import interfaces.iBediener;

import javax.xml.stream.events.StartElement;





public class SpielTest {

	public static void main(String[] args) {
		
		iBediener bediener = new Spiel();
		bediener.starteSpiel(4);

		bediener.addSpieler("kathi",eFarben.ROT, false,(Spiel) bediener);
		bediener.addSpieler("stefo", null, false,(Spiel)bediener);
		bediener.addSpieler("akin",eFarben.GRUEN, false,(Spiel)bediener);
		bediener.addSpieler("yunus",null, false,(Spiel)bediener);
//		bediener.addSpieler(null, null, true, (Spiel)bediener);

//		bediener.zeigeSpieler();
		
		bediener.wuerfeln();
		bediener.wuerfeln();

	}

	
}

