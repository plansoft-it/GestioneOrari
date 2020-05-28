package Elaborato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import row.Row;

public class Elaborato {
	private List<Row> rows;
	
	public Elaborato() {
		rowsList = new ArrayList<>();
	}
	
	public void addRowToRows(Date date, String startHour, String endHour, String order, String note) {
		rowsList.add(new Row(date, startHour, endHour, order, note));
	}
	
	public List<Row> getRowsList(){
		return rowsList;
	}
}
