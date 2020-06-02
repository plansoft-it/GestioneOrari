package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Elaborato.Elaborato;
import errors.WrongFormatException;

public class Parser {

	private String filePath;
	private Elaborato elaborato;

	public Parser(String file) {
		this.filePath = file;
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
				Date date = checkDate(subStrings[0]);
				String startHour = checkTime(subStrings[1]);
				String endHour = checkTime(subStrings[2]);
				String order = subStrings[3];
				String note = (subStrings.length == 5) ? subStrings[4] : "";
				// 
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
		if (time.matches("([0-9]|1[0-9]|2[0-3]):([0-5][0-9]|[0-9])"))
			return time;
		throw new WrongFormatException("Wrong time: " + time);
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
