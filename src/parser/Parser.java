package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import errors.WrongFormatException;
import row.Row;

public class Parser implements IParser {

	private String filePath;

	public Parser(String file) {
		this.filePath = file;
	}

	// esegue il parse del file e inizializza elaborato
	public List<Row> parse() throws IOException {
		int lineNumber = 0;
		List<Row> rows = new ArrayList<Row>();
		File file = new File(filePath);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String rawRow = br.readLine();
			while (rawRow != null) {
				lineNumber++;
				String[] subStrings = rawRow.split(" *\\| *");
				Date date = FormatChecker.checkDate(subStrings[0]);
				LocalTime startHour = FormatChecker.checkTimeLocalTimeFormat(subStrings[1]);
				LocalTime endHour = FormatChecker.checkTimeLocalTimeFormat(subStrings[2]);
				FormatChecker.checkOrderTime(startHour, endHour);
				String order = subStrings[3];
				String note = (subStrings.length == 5) ? subStrings[4] : "";
				Row tmp = new Row(date, startHour, endHour, order, note);
				if (!rows.contains(tmp))
					rows.add(tmp);
				rawRow = br.readLine();
			}
		} catch (ParseException | DateTimeParseException | WrongFormatException e) {
			throw new WrongFormatException("Error in line: " + lineNumber, e);
		}
		return rows;
	}
}
