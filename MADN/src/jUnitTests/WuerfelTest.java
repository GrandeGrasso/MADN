package jUnitTests;

import static org.junit.Assert.*;
import klassen.Wuerfel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
*
* @author Gruppe B-5
*/
public class WuerfelTest {

   /**
    * Haupttest zu Wuerfel
    */
   public WuerfelTest() {
   }

   /**
    *
    * @throws java.lang.Exception Fehlermeldung
    */
   @BeforeClass
   public static void setUpClass() throws Exception {
   }

   /**
    *
    * @throws java.lang.Exception Fehlermeldung
    */
   @AfterClass
   public static void tearDownClass() throws Exception {
   }

   /**
    * Test werfen Methode aus der Wuerfel Klasse
    */
   @Test
   public void werfen()
   {
       Wuerfel wuerfel = new Wuerfel();
   
      
       //Wuerfeln
       int number = wuerfel.werfen();
      
  
      
       //& bei erneutem Wuerfeln die selbe zahl zeigen
       assertEquals(number, wuerfel.werfen());
      
   }

   
	
	

}
