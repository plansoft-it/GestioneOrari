package processed;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import parser.Parser;
import row.Row;

public class ProcessedFile {
	private Parser parser;

	private @Getter HashMap<String, Float> orderHours;
	private @Getter HashMap<Date, Float> dailyHours;
	private @Getter float totalWorkOurs;
	private @Getter List<Row> rows;

	public ProcessedFile(Parser parser) {
		this.parser = parser;
		orderHours = new HashMap<String, Float>();
		dailyHours = new HashMap<Date, Float>();
		totalWorkOurs = 0;
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
		totalWorkOurs += hours;
	}

	private float getHoursAmmount(String startHour, String endHour) {
		// TODO
		// Calcolare la differenza in ore e minuti tra startHours e end Hours
		return 1;
	}
	
	// restituire il numero di ore del giorno
	public float getDailyWorkHours(Date date) {
		return dailyHours.get(date);
	}

	// restituire il numero di ore della commessa
	public float getOrderWorkHours(String commessa) {
		return orderHours.get(commessa);
	}

	// restituire il numero di ore totali del file
	public float getTotalWorkHours() {
		return totalWorkOurs;
	}
}