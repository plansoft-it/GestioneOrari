import java.io.IOException;
import java.text.ParseException;

import errors.WrongFormatException;
import parser.Parser;
import processed.ProcessedFile;

public class GestioneOrari {

	public static void main(String[] args) {
		
		String file = new String();
		String data = new String();
		String commessa = new String();
		
		Parser parser = new Parser(file, new ProcessedFile());
		
		try {
			parser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		float numeroOreLavoroGiorno = 0;
		float numeroOreLavoroCommessa = 0;
		float numeroOreLavoroTotali = 0;
		
		try {
			numeroOreLavoroGiorno = parser.getDailyWorkHours(data);
			numeroOreLavoroCommessa = parser.getOrderWorkHours(commessa);
			numeroOreLavoroTotali = parser.getTotalWorkHours();
		} 
		catch (WrongFormatException | ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Progetto di gestione orari lavorativi");
		System.out.println("ore lavoro giorno " + numeroOreLavoroGiorno);
		System.out.println("ore lavoro commessa " + numeroOreLavoroCommessa);
		System.out.println("ore lavoro totali " + numeroOreLavoroTotali);

	}

}
