package processed;

import java.util.ArrayList;
import java.util.List;

import row.Row;

public class ProcessedFile {
	private List<Row> rows;
	
	public ProcessedFile() {
		rows = new ArrayList<>();
	}
	
	public void addRowToRows(Row row) {
		rows.add(row);
	}
	
	public List<Row> getRows(){
		return rows;
	}
}
