package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import errors.WrongFormatException;
import processed.ProcessedFile;
import row.Row;

public class Parser {

	private final String filePath;
	private ProcessedFile processedFile;

	public Parser(String filePath, ProcessedFile processedFile) {
		this.filePath = filePath;
		this.processedFile = processedFile;
	}

	// esegue il parse del file e inizializza elaborato
	public void parse() throws IOException {
		int lineNumber = 0;
		final File file = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String rawRow = br.readLine();
			while (rawRow != null) {
				lineNumber++;
				String[] subStrings = rawRow.split(" *\\| *");
				Date date = checkDate(subStrings[0]);
				String startHour = checkTime(subStrings[1]);
				String endHour = checkTime(subStrings[2]);
				String order = subStrings[3];
				String note = (subStrings.length == 5) ? subStrings[4] : "";
				processedFile.addRowToRows(new Row(date, startHour, endHour, order, note));
				rawRow = br.readLine();
			}
		} catch (WrongFormatException | ParseException e) {
			throw new WrongFormatException("Error in line: " + lineNumber, e);
		}
	}

	private Date checkDate(String date) throws WrongFormatException, ParseException {
		if (date.matches("(20[2-9][0-9]|[2-9][0-9])-([1-9]|0[1-9]|1[0-2])-([0-2][0-9]|3[0-1]|[1-9])"))
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		throw new WrongFormatException("Wrong date: " + date);
	}

	private String checkTime(String time) throws WrongFormatException {
		if (time.matches("(0[0-9]|1[0-9]|2[0-3]|[0-9]):([0-5][0-9]|[0-9])")) 
			return time;
		throw new WrongFormatException("Wrong time: " + time);
	}

	// restituire il numero di ore del giorno
	public float getDailyWorkHours(String data) throws WrongFormatException, ParseException {  
		float oreLavorate = 0;
		try {
			final Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);

			for (int i = 0; i < processedFile.getRows().size(); i++) {
				if (processedFile.getRows().get(i).getDate().equals(date)) {
					final SimpleDateFormat format = new SimpleDateFormat("HH:mm");
					final Date date1 = format.parse(processedFile.getRows().get(i).getStartHour());
					final Date date2 = format.parse(processedFile.getRows().get(i).getEndHour());
					final float difference = TimeUnit.MILLISECONDS.toMinutes(date2.getTime() - date1.getTime());
					oreLavorate = oreLavorate + difference;
				}
			}
		} catch (final ParseException e) {
			throw new WrongFormatException("Error: ",e);
		}
		return oreLavorate / 60;
	}/* getDailyWorkHours */

	// restituire il numero di ore della commessa
	public float getOrderWorkHours(String commessa) throws WrongFormatException, ParseException {
		float oreLavorate = 0;
		for (int i = 0; i < processedFile.getRows().size(); i++) {
			if (processedFile.getRows().get(i).getOrder().equals(commessa)) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				Date date1 = format.parse(processedFile.getRows().get(i).getStartHour());
				Date date2 = format.parse(processedFile.getRows().get(i).getEndHour());
				float difference = TimeUnit.MILLISECONDS.toMinutes(date2.getTime() - date1.getTime());
				oreLavorate = oreLavorate + difference;
			}

		}
		return oreLavorate / 60;
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() throws WrongFormatException, ParseException {
		float oreLavorate = 0;
		for (int i = 0; i < processedFile.getRows().size(); i++) {

			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			Date date1 = format.parse(processedFile.getRows().get(i).getStartHour());
			Date date2 = format.parse(processedFile.getRows().get(i).getEndHour());
			float difference = TimeUnit.MILLISECONDS.toMinutes(date2.getTime() - date1.getTime());
			oreLavorate = oreLavorate + difference;

		}
		return oreLavorate / 60;
	}
}
