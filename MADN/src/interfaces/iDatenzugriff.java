package interfaces;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Allgemeingueltiges Interface iDatenzugriff 
 * @author Gruppe B-5
 * @version 1.0
 *
 */

public interface iDatenzugriff {
	
	public void oeffnen(Properties p) throws IOException;
    
	public void schreiben(Object object) throws IOException;

	/**
	 * Methode zum Laden der Datei
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public Object laden(File f) throws IOException;
	/**
	 * Methode zum speichern der Datei
	 * @param f
	 * @param o
	 * @throws IOException
	 */
	
	public void speichern(File f,Object o) throws IOException;
	
	/**
	 * Methode zum oeffnen der Datei
	 * @param f
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void oeffnen(File f) throws IOException,FileNotFoundException;
	/**
	 * Methode zum schliessen der Datei
	 * @param f
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	
	public void schliessen(File f) throws IOException,FileNotFoundException;
}
