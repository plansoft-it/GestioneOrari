package Parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Elaborato.ProcessedFile;
import errors.WrongFormatException;

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
	public float getTotalWorkHours() throws WrongFormatException, ParseException {
		float oreLavorate = 0;
		for (int i = 0; i <processedFile.getRows().size(); i++) {
					
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		    	Date date1 = format.parse(processedFile.getRows().get(i).getStartHour());
		    	Date date2 = format.parse(processedFile.getRows().get(i).getEndHour());
		    	float difference = TimeUnit.MILLISECONDS.toMinutes(date2.getTime() - date1.getTime()); 			    	
		    	oreLavorate = oreLavorate + difference;
			
			
		}
		return oreLavorate/60;
	}

}
