package Datenaustausch;

import interfaces.iDatenzugriff;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Klasse DatenzugriffCSV -in eine CSV-Datei
 * implementiert das Interface iDatenzugriff
 * @author Gruppe B-5
 * @version 1.0
 *
 */


public class DatenzugriffCSV implements iDatenzugriff {

	/**
	 * Attribtut reader vom Typ BufferdReader
	 * dient zum lesen
	 */
	private BufferedReader reader=null;
	/**
	 * Attribut writer vom Typ PrintWriter
	 * dient zum schreiben
	 */
	private PrintWriter writer=null;
	
	/**
	 * Ueberschriebene Methode oeffnen
	 * vom Interface iDatenzugriff 
	 * zum oeffnen der Datei
	 * @param f
	 */
	@Override
	public void oeffnen(File f) throws IOException, FileNotFoundException {
	
		try{
			boolean zumLesen=(f.length()!=0);
			
			if(zumLesen){
				reader=new BufferedReader(new FileReader(f));
			}
			else 
				writer=new PrintWriter(new FileWriter(f));
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	/**
	 * Ueberschriebene Methode laden vom
	 * Interface iDatenzugriff zum laden der Datei
	 * @param f
	 * @return null
	 */
	
	
	@Override
	public Object laden(File f) throws IOException {
		
		if(reader==null){
			throw new RuntimeException("Reader ist nicht offen");
		}
		try{
			return reader.readLine();
		}
		catch (IOException e){
			System.out.println("Fehler bei der Ein/- und Ausgabe: "+e);
			
			return null;
		}
	}
	
	/**
	 * Ueberschriebene Methode speichern 
	 * vom Interface iDatenzugriff zum speicher der Datei
	 * @param f
	 * @param o
	 */
	
	
	@Override
	public void speichern(File f, Object o) throws IOException {
		
		if(writer==null){
			throw new RuntimeException(" Reader ist nicht offen");
		}
		writer.println(o);
		
	}
	
	/**
	 * Ueberschriebene Methode vom 
	 * Interface iDatenzugriff zum schliessen der Datei
	 * @param f
	 */

	@Override
	public void schliessen(File f) throws IOException, FileNotFoundException {
		
		try{
			if(reader != null){
				reader.close();
			}
		}
		catch(IOException e){
			System.out.println(" Fehler bei der Ein-/und Ausgabe: " +e);
		}
		if(writer!=null){
			writer.close();
		}
		
	}



	
	
	
	
	
	
	
	
}
