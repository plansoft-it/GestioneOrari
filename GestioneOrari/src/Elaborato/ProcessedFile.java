package Elaborato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import row.Row;

public class ProcessedFile {
	private List<Row> rows;
	
	public ProcessedFile() {
		rows = new ArrayList<>();
	}
	
	public void addRowToRows(Date date, String startHour, String endHour, String order, String note) {
		rows.add(new Row(date, startHour, endHour, order, note));
	}
	
	public List<Row> getRows(){
		return rows;
	}
}
