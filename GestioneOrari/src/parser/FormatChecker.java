package parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import errors.WrongFormatException;

public class FormatChecker {
	public static Date checkDate(String date) throws WrongFormatException, ParseException {
		if (date.matches("(20[2-9][0-9]|[2-9][0-9])-([1-9]|0[1-9]|1[0-2])-([0-2][0-9]|3[0-1]|[1-9])"))
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		throw new WrongFormatException("Wrong date: " + date);
	}

	public static String checkTime(String time) throws WrongFormatException {
		if (time.matches("(0[0-9]|1[0-9]|2[0-3]|[0-9]):([0-5][0-9]|[0-9])"))
			return time;
		throw new WrongFormatException("Wrong time: " + time);
	}
}
