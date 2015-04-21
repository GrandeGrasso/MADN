package Datenaustausch;

import interfaces.iBediener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import klassen.Spiel;
import klassen.Spieler;
import klassen.eFarben;

public class SpielTestLaden {
	


	public static void main(String[] args) throws IOException {
		
		iBediener bediener = new Spiel();


		
		bediener.addSpieler("kathi",eFarben.GELB, false,(Spiel) bediener);
		bediener .addSpieler("yunus", null, false,(Spiel)bediener);
		bediener .addSpieler("stefo",eFarben.GRUEN, false,(Spiel)bediener);
		bediener .addSpieler(null, null, true, (Spiel)bediener);
		bediener .zeigeSpieler();
				
				bediener.wuerfeln();
				bediener.wuerfeln();
				bediener.wuerfeln();
				bediener.wuerfeln();
				bediener.speichernCSV("s");
				bediener.speichernSerial("s");
		
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Spielstand wird geladen !");
			
			String line=reader.readLine();
			
			if("loadcsv".equals(line)){
				Spiel.ladenCSV("menschAergereDichNicht.csv");
			}
			
			if("load".equals(line)){
				Spiel.ladenSerial("menschAergereDichNicht.ser");
			}

		}


}
