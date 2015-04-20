package Datenaustausch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import klassen.Spiel;
import klassen.Spieler;
import klassen.eFarben;

public class SpielTestSpeichern {
	
	public static void main(String[] args) throws IOException {
		
	
		Spiel spiel = new Spiel();
		

		spiel.addSpieler("spieler1", eFarben.ROT);
		spiel.addSpieler("spieler2", eFarben.BLAU);
		spiel.addSpieler("spieler3", eFarben.GELB);
		spiel.addSpieler("spieler4", eFarben.GRUEN);
		
	
		
		
		spiel.starteSpiel();
		spiel.getSpielbrett();
	
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Spielstand wird gespeichert !");
		
		String line=reader.readLine();
		
		if("savecsv".equals(line)){
			spiel.speichernCVS("menschAergereDichNicht.csv");
		}
		
		if("save".equals(line)){
			spiel.speichernSerial("menschAergereDichNicht.ser");
		}
		
		spiel.werIstAmZug();
		spiel.getSpielbrett();
	}
	
	

		
		



	


		
		
		
		
		
		
		
		
		
		
		
		
		
	}


