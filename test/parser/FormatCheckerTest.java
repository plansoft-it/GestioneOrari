package parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import org.junit.Test;

import errors.WrongFormatException;

// https://assertj.github.io/doc/
// https://jar-download.com/artifacts/org.assertj/assertj-core

public class FormatCheckerTest {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	// test for checkOrderTime()
	
	@Test
	public void testCheckOrderTimeOk() throws WrongFormatException {
		LocalTime early = LocalTime.parse("08:00");
		LocalTime later = LocalTime.parse("10:00");
		FormatChecker.checkOrderTime(early, later);
	}

	@Test
	public void testCheckOrderTimeThrows() {
		LocalTime early = LocalTime.parse("08:00");
		LocalTime later = LocalTime.parse("10:00");
		assertThatThrownBy(() -> FormatChecker.checkOrderTime(later, early))
			.isInstanceOf(WrongFormatException.class)
				.hasMessage("Start time must be earlier than end time. start: " + later + " end: " + early);
	}

	@Test
	public void testCheckOrderTimeEqualsTimeThrows() {
		LocalTime early = LocalTime.parse("10:00");
		LocalTime later = LocalTime.parse("10:00");
		assertThatThrownBy(() -> FormatChecker.checkOrderTime(early, later))
			.isInstanceOf(WrongFormatException.class)
				.hasMessage("Start time must be earlier than end time. start: " + early + " end: " + later);
	}

	// test for checkDate()

	@Test
	public void testCheckDateStandardFormatOk() throws Exception {
		String date = "2030-01-01";
		assertThat(FormatChecker.checkDate(date))
			.isEqualTo(new SimpleDateFormat(DATE_FORMAT)
				.parse("2030-01-01"));
	}

	@Test
	public void testCheckDateYearModThrow() throws Exception {
		String date = "30-01-01";
		assertThatThrownBy(() -> FormatChecker.checkDate(date))
			.isInstanceOf(ParseException.class)
				.hasMessage("Wrong date: " + date);
	}

	@Test
	public void testCheckDateMonthModOk() throws Exception {
		String date = "2030-1-01";
		assertThat(FormatChecker.checkDate(date))
			.isEqualTo(new SimpleDateFormat(DATE_FORMAT)
				.parse("2030-01-01"));
	}

	@Test
	public void testCheckDateDayModOk() throws Exception {
		String date = "2030-01-1";
		assertThat(FormatChecker.checkDate(date))
			.isEqualTo(new SimpleDateFormat(DATE_FORMAT)
				.parse("2030-01-01"));
	}

	@Test
	public void testCheckDateInvalidSeparatorThrow() {
		String date = "2030:01:01";
		assertThatThrownBy(() -> FormatChecker.checkDate(date))
			.isInstanceOf(ParseException.class)
				.hasMessage("Wrong date: " + date);
	}
	
	@Test
	public void testCheckDateInvalidMothThrow() {
		String date = "2030-13-01";
		assertThatThrownBy(() -> FormatChecker.checkDate(date))
			.isInstanceOf(ParseException.class)
				.hasMessage("Wrong date: " + date);
	}
	
	@Test
	public void testCheckDateInvalidDayThrow() {
		String date = "2030-01-32";
		assertThatThrownBy(() -> FormatChecker.checkDate(date))
			.isInstanceOf(ParseException.class)
				.hasMessage("Wrong date: " + date);
	}
	
	@Test
	public void testCheckDateInvalidYearThrow() {
		String date = "2100-01-01";
		assertThatThrownBy(() -> FormatChecker.checkDate(date))
			.isInstanceOf(ParseException.class)
				.hasMessage("Wrong date: " + date);
	}

}
