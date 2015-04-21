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

	public Object lesen() throws IOException;
    
	public void schliessen(Object object)throws IOException;
	
	
}