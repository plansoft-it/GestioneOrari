import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import parser.Parser;
import processed.ProcessedFile;

public class GestioneOrari {

	public static void main(String[] args) {

		String commessa = new String();
		Date data = new Date();
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			String filePath = "/home/ant/Desktop/test.txt";
			Parser parser = new Parser(filePath);
			ProcessedFile processedFile = new ProcessedFile(parser);
			processedFile.updateData();

			float numeroOreLavoroGiorno = processedFile.getDailyWorkHours(data);
			float numeroOreLavoroCommessa = processedFile.getOrderWorkHours(commessa);
			float numeroOreLavoroTotali = processedFile.getTotalWorkHours();

			System.out.println("Progetto di gestione orari lavorativi");
			System.out.println("ore lavoro giorno " + numeroOreLavoroGiorno);
			System.out.println("ore lavoro commessa " + numeroOreLavoroCommessa);
			System.out.println("ore lavoro totali " + numeroOreLavoroTotali);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
