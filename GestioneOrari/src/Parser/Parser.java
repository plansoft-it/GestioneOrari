package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import Elaborato.Elaborato;

public class Parser {

	private String filePath;
	private Elaborato elaborato;

	public Parser(String file) {
		this.filePath = file;
	}

	// esegue il parse del file e inizializza elaborato
	public void parse() {
		try {
			File file = new File(filePath);
			int lineNumber = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String rawRow = br.readLine();
			while (rawRow != null) {
				lineNumber++;
				
				String [] subStrings = rawRow.split(" *\\| *");
				
				rawRow = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	

	// restituire il numero di ore del giorno
	public float getDailyWorkHours(String data) {
		return 0;
	}

	// restituire il numero di ore della commessa
	public float getOrderWorkHours(String commessa) {
		return 0;
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() {
		return 0;
	}

}
