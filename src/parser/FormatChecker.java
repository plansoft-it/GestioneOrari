package parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

import errors.WrongFormatException;

public class FormatChecker {

	public static Date checkDate(String date) throws ParseException {
		if (date.matches("(20[2-9][0-9])-([1-9]|0[1-9]|1[0-2])-([0-2][0-9]|3[0-1]|[1-9])"))
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		throw new ParseException("Wrong date: " + date, 0);
	}

	public static LocalTime checkTime(String time) throws DateTimeParseException{
		return LocalTime.parse(time);
	}

	public static void checkOrderTime(LocalTime start, LocalTime end) throws WrongFormatException {
		if (!start.isBefore(end))
			throw new WrongFormatException("Start time must be earlier than end time. start: " + start + " end: " + end);
	}
}