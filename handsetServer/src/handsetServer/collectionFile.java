package handsetServer;

import java.io.FileReader;
import java.io.LineNumberReader;

public class collectionFile {
	
	private String  filename;
	private int 	isLoaded;
	private int 	numRecs;
	
	public collectionFile( String infile ){
	
		filename = infile;

		try {
				LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
			    String lineRead = "";
			    while ((lineRead = reader.readLine()) != null) {}
			    numRecs = reader.getLineNumber(); 
			    reader.close();
		}
		catch( Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int getNumRecs() {
		
		return numRecs;
	}
	
}
