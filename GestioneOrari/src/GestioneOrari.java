import java.io.IOException;

import parser.Parser;

public class GestioneOrari {

	public static void main(String[] args) {
		
		String file = new String();
		String data = new String();
		String commessa = new String();
		
		Parser parser = new Parser(file);
		
		try {
			parser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		float numeroOreLavoroGiorno = parser.getDailyWorkHours(data);
		float numeroOreLavoroCommessa = parser.getOrderWorkHours(commessa);
		float numeroOreLavoroTotali = parser.getTotalWorkHours();
		
		System.out.println("Progetto di gestione orari lavorativi");
		System.out.println("ore lavoro giorno " + numeroOreLavoroGiorno);
		System.out.println("ore lavoro commessa " + numeroOreLavoroCommessa);
		System.out.println("ore lavoro totali " + numeroOreLavoroTotali);

	}

}
