package Parser;

import Elaborato.ProcessedFile;

public class Parser {

	private String filePath;
	private ProcessedFile processedFile;

	public Parser(String filePath) {
		this.filePath = filePath;
		processedFile = new ProcessedFile();
	}

	// esegue il parse del file e inizializza elaborato
	public void parse() {
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
