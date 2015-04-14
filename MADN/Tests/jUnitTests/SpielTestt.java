package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import klassen.Spiel;
import klassen.Spieler;
import klassen.Wuerfel;
import klassen.eFarben;

public class SpielTestt {

	@Test
	public void addSpieler(){
		Spiel s= new Spiel();
		int zaheler = 0;
		s.addSpieler("Yunus", eFarben.ROT);
		zaheler=+1;
		s.addSpieler("Kathi", eFarben.BLAU);
		zaheler=+1;
		s.addSpieler("Steff", eFarben.GRUEN);
		zaheler=+1;
		s.addSpieler("Akin", eFarben.GELB);
		zaheler=+1;
		assertTrue(zaheler<4);
		
	}
	
	@Test
	public void starteSpiel() {
		Spiel sb = new Spiel();
		assertTrue(sb != null);	
		}

}
