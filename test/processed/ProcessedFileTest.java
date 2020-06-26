package processed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parser.IParser;
import row.Row;

// https://site.mockito.org/
// https://mvnrepository.com/artifact/org.mockito/mockito-core/3.3.3

public class ProcessedFileTest {

	private IParser parser;
	private ProcessedFile processedFile;

	@Before
	public void setup() {
		parser = mock(IParser.class);
		processedFile = new ProcessedFile(parser);
	}

	// tests for getDailyWorkHours()

	@Test
	public void testGetDailyWorkHoursNotFound() throws IOException {
		assertThat(processedFile.getDailyWorkHours(new Date())).isEqualTo(0f);
	}

	// tests for getDailyWorkHours()

	@Test
	public void testGetOrderWorkHoursNotFound() throws IOException {
		assertThat(processedFile.getOrderWorkHours("test")).isEqualTo(0f);
	}

	// tests for updateData()

	@Test
	public void testUpdateDataNoDuplicateInOrderHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order = "conad";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<String, Float> orderHours = processedFile.getOrderHours();
		assertThat(orderHours.size()).isEqualTo(1);
		assertThat(orderHours.get(order)).isEqualTo(60);
	}

	@Test
	public void testUpdateDataNoDuplicateInDailyHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order = "conad";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<Date, Float> dailyHours = processedFile.getDailyHours();
		assertThat(dailyHours.size()).isEqualTo(1);
		assertThat(dailyHours.get(date)).isEqualTo(60);
	}

	@Test
	public void testUpdateDataDuplicateInOrderHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order = "conad";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));
		rows.add(new Row(date, LocalTime.parse("11:00"), LocalTime.parse("13:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<String, Float> orderHours = processedFile.getOrderHours();
		assertThat(orderHours.size()).isEqualTo(1);
		assertThat(orderHours.get(order)).isEqualTo(180);
	}

	@Test
	public void testUpdateDataDuplicateInDailyHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order = "conad";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));
		rows.add(new Row(date, LocalTime.parse("11:00"), LocalTime.parse("13:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<Date, Float> dailyHours = processedFile.getDailyHours();
		assertThat(dailyHours.size()).isEqualTo(1);
		assertThat(dailyHours.get(date)).isEqualTo(180);
	}

	@Test
	public void testUpdateDataTwoDifferentInOrderHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order1 = "conad";
		String order2 = "esselunga";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order1, ""));
		rows.add(new Row(date, LocalTime.parse("11:00"), LocalTime.parse("13:00"), order2, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<String, Float> orderHours = processedFile.getOrderHours();
		assertThat(orderHours.size()).isEqualTo(2);
		assertThat(orderHours.get(order1)).isEqualTo(60);
		assertThat(orderHours.get(order2)).isEqualTo(120);
	}

	@Test
	public void testUpdateDataTwoDifferentInDailyHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date1 = new Date(10000);
		Date date2 = new Date(1000000);
		String order = "conad";
		rows.add(new Row(date1, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));
		rows.add(new Row(date2, LocalTime.parse("11:00"), LocalTime.parse("13:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		HashMap<Date, Float> dailyHours = processedFile.getDailyHours();
		assertThat(dailyHours.size()).isEqualTo(2);
		assertThat(dailyHours.get(date1)).isEqualTo(60);
		assertThat(dailyHours.get(date2)).isEqualTo(120);
	}
	
	@Test
	public void testUpdateDataTotalHours() throws IOException {
		List<Row> rows = new ArrayList<>();
		Date date = new Date();
		String order = "conad";
		rows.add(new Row(date, LocalTime.parse("10:00"), LocalTime.parse("11:00"), order, ""));
		rows.add(new Row(date, LocalTime.parse("11:00"), LocalTime.parse("13:00"), order, ""));

		when(parser.parse()).thenReturn(rows);
		processedFile.updateData();

		float totalHours = processedFile.getTotalHours();
		assertThat(totalHours).isEqualTo(180);
	}
}
