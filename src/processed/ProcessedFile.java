package processed;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static java.time.temporal.ChronoUnit.MINUTES;

import lombok.Getter;
import parser.IParser;
import row.Row;

public class ProcessedFile {
	private IParser parser;

	private HashMap<String, Float> orderHours;
	private HashMap<Date, Float> dailyHours;
	private float totalHours;
	private @Getter List<Row> rows;

	public ProcessedFile(IParser parser) {
		this.parser = parser;
		orderHours = new HashMap<String, Float>();
		dailyHours = new HashMap<Date, Float>();
		totalHours = 0;
	}

	public void updateData() throws IOException {
		rows = parser.parse();
		for (Row row : rows) {
			float hours = getHoursAmmount(row.getStartHour(), row.getEndHour());
			updateOrderHours(row.getOrder(), hours);
			updateDailyHours(row.getDate(), hours);
			updateTotalHours(hours);
		}
	}

	private void updateOrderHours(String order, float hours) {
		orderHours.put(order, orderHours.getOrDefault(order, Float.valueOf(0)) + hours);
	}

	private void updateDailyHours(Date date, float hours) {
		dailyHours.put(date, dailyHours.getOrDefault(date, Float.valueOf(0)) + hours);
	}

	private void updateTotalHours(float hours) {
		totalHours += hours;
	}

	private float getHoursAmmount(LocalTime startHour, LocalTime endHour) {
		return MINUTES.between(startHour, endHour);
	}

	// TODO Bad Practice: package-private getter for testing purpose
	HashMap<String, Float> getOrderHours() {
		return orderHours;
	}

	// TODO Bad Practice: package-private getter for testing purpose
	HashMap<Date, Float> getDailyHours() {
		return dailyHours;
	}

	// TODO Bad Practice: package-private getter for testing purpose
	float getTotalHours() {
		return totalHours;
	}

	// restituire il numero di ore del giorno
	public float getDailyWorkHours(Date date) {
		return dailyHours.getOrDefault(date, 0f);
	}

	// restituire il numero di ore della commessa
	public float getOrderWorkHours(String order) {
		return orderHours.getOrDefault(order, 0f);
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() {
		return totalHours;
	}

}