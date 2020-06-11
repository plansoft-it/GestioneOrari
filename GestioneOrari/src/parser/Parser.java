package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import errors.WrongFormatException;
import processed.ProcessedFile;
import row.Row;

public class Parser {

	private String filePath;
	private ProcessedFile processedFile;

	public Parser(String file, ProcessedFile processedFile) {
		this.filePath = file;
		this.processedFile = processedFile;
	}

	// esegue il parse del file e inizializza elaborato
	public void parse() throws IOException {
		int lineNumber = 0;
		File file = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String rawRow = br.readLine();
			while (rawRow != null) {
				lineNumber++;
				String[] subStrings = rawRow.split(" *\\| *");
				Date date = FormatChecker.checkDate(subStrings[0]);
				String startHour = FormatChecker.checkTime(subStrings[1]);
				String endHour = FormatChecker.checkTime(subStrings[2]);
				String order = subStrings[3];
				String note = (subStrings.length == 5) ? subStrings[4] : "";
				processedFile.updateData(new Row(date, startHour, endHour, order, note));
				rawRow = br.readLine();
			}
		} catch (WrongFormatException | ParseException e) {
			throw new WrongFormatException("Error in line: " + lineNumber, e);
		}
	}

	// restituire il numero di ore del giorno
	public float getDailyWorkHours(Date date) {
		return processedFile.getDailyHours().get(date);
	}

	// restituire il numero di ore della commessa
	public float getOrderWorkHours(String commessa) {
		return processedFile.getOrderHours().get(commessa);
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() {
		return processedFile.getTotalWorkOurs();
	}

}
