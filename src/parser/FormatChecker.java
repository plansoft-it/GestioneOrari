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

	public static LocalTime checkTimeLocalTimeFormat(String time) throws DateTimeParseException {
		return LocalTime.parse(time);
	}

	public static LocalTime checkTimeCustomFormat(String time) throws WrongFormatException {
		// TODO Bug: Edit String time in a format acceptable for LocalTime (HH:mm). Write tests!
		if (time.matches("(0[0-9]|1[0-9]|2[0-3]|[0-9]):([0-5][0-9]|[0-9])"))
			return LocalTime.parse(time);
		throw new WrongFormatException("Wrong time: " + time);
	}

	public static void checkOrderTime(LocalTime start, LocalTime end) throws WrongFormatException {
		if (!start.isBefore(end))
			throw new WrongFormatException("Start time must be earlier than end time. start: " + start + " end: " + end);
	}
}