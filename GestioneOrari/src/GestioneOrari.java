import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import parser.Parser;
import processed.ProcessedFile;

public class GestioneOrari {

	public static void main(String[] args) throws ParseException, IOException {
		
		String file = "test.txt";
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-1");
		String commessa = "conad";
		
		Parser parser = new Parser(file);
		ProcessedFile pf = new ProcessedFile(parser);
		pf.updateData();
		
		float numeroOreLavoroGiorno = pf.getDailyWorkHours(data);
		float numeroOreLavoroCommessa = pf.getOrderWorkHours(commessa);
		float numeroOreLavoroTotali = pf.getTotalWorkHours();
		
		System.out.println("Progetto di gestione orari lavorativi");
		System.out.println("ore lavoro giorno " + numeroOreLavoroGiorno);
		System.out.println("ore lavoro commessa " + numeroOreLavoroCommessa);
		System.out.println("ore lavoro totali " + numeroOreLavoroTotali);

	}

}
