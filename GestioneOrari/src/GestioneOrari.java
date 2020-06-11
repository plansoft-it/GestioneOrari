import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import parser.Parser;
import processed.ProcessedFile;

public class GestioneOrari {

	public static void main(String[] args) throws ParseException, IOException {
		
		String file = new String();
		String data = new String();
		String commessa = new String();
		
		Parser parser = new Parser(file, new ProcessedFile());
		
		parser.parse();
		
		float numeroOreLavoroGiorno = parser.getDailyWorkHours(new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-1") );
		float numeroOreLavoroCommessa = parser.getOrderWorkHours(commessa);
		float numeroOreLavoroTotali = parser.getTotalWorkHours();
		
		System.out.println("Progetto di gestione orari lavorativi");
		System.out.println("ore lavoro giorno " + numeroOreLavoroGiorno);
		System.out.println("ore lavoro commessa " + numeroOreLavoroCommessa);
		System.out.println("ore lavoro totali " + numeroOreLavoroCommessa);

	}

}
