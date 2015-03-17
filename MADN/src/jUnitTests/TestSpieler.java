package jUnitTests;

import static org.junit.Assert.*;
import klassen.Spieler;
import klassen.Farben;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSpieler {

	protected Spieler s1;
	
    @BeforeClass
	 public  void create() {
	      // Test-Objekt erschaffen mit den Testwerten (Name: Jan und Farbe: Blau)
	
	      System.out.println("Start!");
	   }
    
	@Before
	public void vor() {
           System.out.println("vor Test");
		   }
	
	
	@Test
	public void testName() {
		try{
			new Spieler (null,null);
			Assert.fail("fehlt Exception");
		}catch (IllegalArgumentException e){
			
		}
	}
	@Test
	public void testName2() {
		try{
			new Spieler ("hi",null);
			Assert.fail("fehlt Exception");
		}catch (IllegalArgumentException e){
			
		}
	}
	
	

}
