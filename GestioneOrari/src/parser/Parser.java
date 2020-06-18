package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import processed.ProcessedFile;
import errors.WrongFormatException;

public class Parser {

	private final String filePath;
	private final ProcessedFile processedFile;

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
		//U
		public float getOrderWorkHours(String commessa) throws WrongFormatException, ParseException {
			float oreLavorate = 0;
			for (int i = 0; i <processedFile.getRows().size(); i++) {
				if (processedFile.getRows().get(i).getOrder().equals(commessa)) {
					
					SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			    	Date date1 = format.parse(processedFile.getRows().get(i).getStartHour());
			    	Date date2 = format.parse(processedFile.getRows().get(i).getEndHour());
			    	float difference = TimeUnit.MILLISECONDS.toMinutes(date2.getTime() - date1.getTime()); 			    	
			    	oreLavorate = oreLavorate + difference;
				}
				
			}
			return oreLavorate/60;
		}
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() {
		return 0;
	}

}
