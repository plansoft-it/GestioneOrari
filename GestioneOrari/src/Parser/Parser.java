package Parser;

import Elaborato.Elaborato;

public class Parser {

	private String file;
	private Elaborato elaborato;

	public Parser(String file) {
		this.file = file;
		elaborato = new Elaborato();
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
