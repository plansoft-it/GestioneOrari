package processed;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import row.Row;

public class ProcessedFile {
	private @Getter HashMap<String, Float> orderHours;
	private @Getter HashMap<Date, Float> dailyHours;
	private @Getter float totalWorkOurs;
	
	private @Getter List<Row> rows;

	public ProcessedFile() {
		orderHours = new HashMap<String, Float>();
		dailyHours = new HashMap<Date, Float>();
		totalWorkOurs = 0;
		
		rows = new ArrayList<Row>();
	}


	public void updateData(Row row) {
		float hours = getHoursAmmount(row.getStartHour(), row.getEndHour());
		updateOrderHours(row.getOrder(), hours);
		updateDailyHours(row.getDate(), hours);
		updateTotalHours(hours);
		
		if (!rows.contains(row)) rows.add(row);
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
}